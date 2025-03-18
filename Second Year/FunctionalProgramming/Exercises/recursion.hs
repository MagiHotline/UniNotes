-- ex1
sundown :: Int -> Int
sundown 1 = 1
sundown n = n + sundown(n - 1)

-- ex2
exponention :: Int -> Int -> Int
exponention n 0 = 1
exponention n p = n * exponention n (p-1)

--ex3
fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-1) + fib(n-2)

-- myInit :: [a] -> [a]
-- myInit [] = []
-- myInit xs = take (length xs - 1) xs

--ex4
myInit :: [a] -> [a]
myInit [] = []
myInit [_] = []
myInit (x:xs) = x : myInit xs

--ex5
myAnd :: [Bool] -> Bool
myAnd [] = True
myAnd (x:xs)
    | x == False = False
    | x == True = myAnd xs

-- [[1,2,3], [4,5,6]]
conc :: [[a]] -> [a]
conc [] = []
conc (x:xs) = x ++ conc xs

replica :: Int -> a -> [a]
replica 0 n = []
replica m n = [n] ++ replica (m-1) n

myNth :: [a] -> Int -> a
myNth (x:xs) n
    | n == 0 = x
    | otherwise = myNth xs (n-1)

myElem :: Eq a => a -> [a] -> Bool
myElem n [] = False
myElem n (x:xs)
    | n == x = True
    | otherwise = myElem n xs

--ex6
-- sum list
-- take a given number of elements in a list
-- select the last element of a list
mySum :: Num a => [a] -> a
mySum [] = 0
mySum (x:xs) = x + mySum xs

myTake :: Int -> [a] -> [a]
myTake _ [] = []
myTake 0 xs = []
myTake n (x:xs) = [x] ++ myTake (n-1) xs

myLast :: [a] -> a
myLast [x] = x
myLast (x:xs) = myLast xs

-- [3,1,2]
-- [6,5,4]

merge :: Ord a => [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys)
    | x <= y = x : merge xs (y:ys)
    | otherwise = y : merge (x:xs) ys

msort :: Ord a => [a] -> [a]
msort [] = []
msort [x] = [x]
msort (x:xs) = merge (msort one) (msort two)
    where one = take (length (x:xs) `div` 2) (x:xs)
          two = drop (length (x:xs) `div` 2) (x:xs)

halve :: [a] -> ([a], [a])
halve xs = (one, two)
    where one = take (length xs `div` 2) xs
          two = drop (length xs `div` 2) xs
