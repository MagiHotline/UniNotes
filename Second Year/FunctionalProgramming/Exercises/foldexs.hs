-- ex1
sumsq :: Integral a => a -> a
sumsq n = foldr op 0 [1..n]
    where op x y = x*x + y

-- ex2
lengthr :: Num a => [a] -> a
lengthr = foldr (\_ acc -> acc+1) 0
-- The "don't care" refer to the array

-- ex3
minList :: Ord a => [a] -> a
minList = foldr1 (\xs -> min xs)

myRev :: [a] -> [a]
myRev = foldr (\x xs -> xs ++ [x]) []

remove :: Eq a => [a] -> [a] -> [a]
remove = foldr (\x ys -> filter (/= x) ys)
-- this filters every elements of x in ys

-- this has to filters every elements
-- of x in ys only when xs are adjacent
removeAdj :: Eq a => [a] -> [a]
removeAdj = foldr (\x listToBuild -> if listToBuild /= []
    && x == head listToBuild then listToBuild else x : listToBuild) []
-- if the list is not empty and the element we are iterating is equal  to the last element
-- then add it if not keep it like that
