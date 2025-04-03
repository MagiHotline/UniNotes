-- So a binary tree could be either a Leaf or a node that goes into another two trees
data Tree a = Leaf | Node (Tree a) a (Tree a) deriving (Show, Eq)

-- The way the mapping works in a tree, is that whatever the function is
-- if it is applied at the leaf it returns the leaf
-- if it is applied to a node in the value I have to apply the function f to the value im in
-- and continue the mapping to the other left and right tree
instance Functor Tree where
    fmap _ Leaf = Leaf
    fmap f (Node left value right) = Node (fmap f left) (f value) (fmap f right)

-- The Applicative instance for tree defines how to apply a tree of function to a tree of values
instance Applicative Tree where
        pure x = let t = Node t x t in t
        (<*>) Leaf _ = Leaf
        (<*>) _ Leaf = Leaf
        (<*>) (Node lf f rf) (Node la a ra) = Node (lf <*> la) (f a) (rf <*> ra)

-- Inserts elements with the heap property where the right child is greater than the father
-- and the left child is less than the feather
insert :: (Ord a) => a -> Tree a -> Tree a
insert x Leaf = Node Leaf x Leaf
insert x (Node  left top right)
    | x == top = Node left top right
    | x > top = Node (insert x left) top right
    | x < top = Node left top (insert x right)

-- takes a list and transforms it into a list
flatten :: Tree a -> [a]
flatten Leaf = []
flatten (Node left x right) = (flatten left) ++ [x] ++ (flatten right)

-- initialize a tree from a list
initTree :: Ord a => [a] -> Tree a
initTree [] = Leaf
initTree [x] = Node Leaf x Leaf
initTree (x:xs) = insert x (initTree xs)

double :: Num a => a -> a
double x = 2*x
