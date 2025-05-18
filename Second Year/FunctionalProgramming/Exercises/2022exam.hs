myand :: [Bool] -> Bool
myand [True] = True
myand (x:xs)
    | x == False = False
    | otherwise = myand xs


myrep :: Int -> a -> [a]
myrep times obj
    | times > 0      = obj : myrep (times-1) obj
    | otherwise      = []

myfilter :: (a -> Bool) -> [a] -> [a]
myfilter test [] = []
myfilter test (x:xs)
    | test x    = x : myfilter test xs
    | otherwise = myfilter test xs

e1 :: [[Integer]]
e1 = [[1,2],[3,4]]

e2 :: Int -> Int -> Int
e2 7 6 = 13

-- e3 :: a -> (a,a)
-- e3 3 = (3,6)

e4 :: [a] -> [a] -> [a]
e4 xs ys = xs ++ ys

{-
Define the following functions using list comprehension, stating the type of each of the four
functions that you define:
inc – add one to every number in a list of integers
evens – return the even numbers in a list of integers
sorted – decide if a list of integers is sorted
-}

inc :: Num a => [a] -> [a]
inc xs = [x+1 | x <- xs]


squares :: Num a => [a] -> [a]
squares xs = [x | x <- xs]

evens :: [Int] -> [Int]
evens xs = [x | x <- xs, even x]

sorted :: Ord a => [a] -> Bool
sorted [x] = True
sorted (x:y:xs) = x <= y && sorted (y:xs)

{- capitialise :: String -> String
capitialise = map toUpper
-}
qsort :: [Int] -> [Int]
qsort [] = []
-- qsort (n:ns) = qsort (smaller n ns) ++ [n] ++ qsort (larger n ns)

data Result a = Succeed a | Fail deriving (Eq, Show)
{-
instance Functor Result where
fmap f (Succeed x) = Succeed (f x)
fmap _ _ = Fail

instance Applicative Result where
pure = Succeed
Fail <*> _ = Fail
(Succeed f) <*> something = fmap f something

instance Monad where
return = Succeed
Succeed x >>= f = f x
Fail >>= _ = Fail
-}

divides :: Int -> Int -> Bool
divides n m = n `mod` m == 0

divisors :: Int -> [Int]
divisors n = [y | y <- [1..n], divides n y]

data Tree a = EmptyTree | Node (Tree a) a (Tree a) deriving (Show, Read, Eq)

flatten :: Tree a -> [a]
flatten EmptyTree = []
flatten (Node l x r) = flatten l ++ [x] ++ flatten r

occurs :: Eq a => a -> Tree a -> Bool
occurs _ EmptyTree = False
occurs x (Node l y r)
    | x == y = True
    | otherwise = occurs x l || occurs x r

-- Define lengthr, which returns the number of elements in a list,
-- using the higherorder function foldr and a lambda function.
lengthr :: [a] -> Int
lengthr = foldr (\_ x -> 1 + x) 0
