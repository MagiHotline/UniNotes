-- recursive functions

insert :: Ord a => a -> [a] -> [a]
insert x [] = [x]
insert x (y:ys)
    | x <= y    = x : y : ys
    | otherwise = y : insert x ys

isort :: Ord a => [a] -> [a]
isort [] = []
isort (x:xs) = insert x (isort xs)

myzip :: [a] -> [b] -> [(a,b)]
myzip [] _ = []
myzip _ [] = []
myzip (x:xs) (y:ys) = (x,y) : zip xs ys

mydrop :: Int -> [a] -> [a]
mydrop 0 xs = xs
mydrop _ [] = []
mydrop n (_:xs) = drop (n-1) xs

qsort :: Ord a => [a] -> [a]
qsort [] = []
qsort (x:xs) = qsort smaller ++ [x] ++ qsort larger
    where smaller = [a | a <- xs, a <= x]
          larger  = [b | b <- xs, b > x]

-- Tail Recursion
funcTailRec :: Int -> Int
funcTailRec n = aux n 1
    where aux 0 acc = acc
          aux n acc = aux (n-1) (acc*n)

-- Sum of integer in a list with tail recursion
sumInts :: [Int] -> Int
sumInts n = aux n 0
    where aux [] acc = acc
          aux (x:xs) acc = aux xs (acc+x)

-- Function that takes two integers and returns theirs sum with tail recursion
myAdd :: Int -> Int -> Int
myAdd m 0 = m
myAdd 0 n = n
myAdd m n = myAdd (m-1) (n+1)
-- In computer science, a tail call is a
-- subroutine call performed as the final
-- action of a procedure.
-- If the target of a tail is the same subroutine,
-- the subroutine is said to be tail recursive, which
--  is a special case of direct recursion.

-- High Order Function
twice :: (a -> a) -> a -> a
twice f x = f $ f x
-- map takes a function that takes an a and gives b.
-- apply this function to the list of a so that I can have a list of b
-- map :: (a -> b) -> [a] -> [b]

mymap :: (a -> b) -> [a] -> [b]
mymap f [] = []
mymap f (x:xs) = f x : map f xs

mymap2 :: (a -> b) -> [a] -> [b]
mymap2 f xs = [f x | x <- xs]

mydropWhile :: (a -> Bool) -> [a] -> [a]
mydropWhile p [] = []
mydropWhile p (x:xs)
    | p x       = mydropWhile p xs
    | otherwise = x:xs
