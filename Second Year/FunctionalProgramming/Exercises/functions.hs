-- Exercise 1: Write a function named add1 that takes an Int and
-- returns an Int that is one greater than its input. For example, if we
-- compute add1 5, we should get 6. If you want to write a type signature for add1,
-- it would be
-- add1 :: Int-> Int
add1 :: Int -> Int
add1 x = x + 1

-- Exercise 2: return always 0
always0 :: Int -> Int
always0 x = 0

-- Exercise 3:
subtract :: Int -> Int -> Int
subtract x y = x - y

-- Exercise 4:
addmult :: Int -> Int -> Int -> Int
addmult p q r = (p+q) * r

-- Ex5:
greaterThan0 :: Int -> String
greaterThan0 x | x > 0 = "Yes!"
               | otherwise = "No!"

-- Ex6:
pushOut :: Int -> Int
pushOut x | x > 0 = x + 1
          | x < 0 = x - 1
          | x == 0 = 0

-- Ex7:
halve :: [a] -> ([a], [a])
halve list = (list1, list2)
    where list1 = take (length list `div` 2) list
          list2 = drop (length list `div` 2) list

-- Ex8:
-- third :: [a] -> a
-- third list | length list < 3 = head list
--           | otherwise = list !! 2

safetail :: [a] -> [a]
safetail list | null list = []
              | otherwise = tail list

lucky :: Integral a => a -> String
lucky x | x == 7 = "Lucky you.. Proceed directly to buy a lottery ticket."
        | x == 13 = "You, sadly are quite unlucky. Do not, under any circumstances, invest money today."
        | otherwise = "Mmmm.... Can’t really say...."

-- Ex 12
first :: (a,b,c) -> a
first (x,_,_) = x

second :: (a,b,c) -> b
second (_,x,_) = x

third :: (a,b,c) -> c
third (_,_,x) = x

-- Luhn Algorithm

-- 12 -> [1,2]
-- 350 -> 2
takeDigits :: Int -> [Int]
takeDigits 0 = [] -- Base case for 0
takeDigits x = takeDigits (x `div` 10) ++ [x `mod` 10]

doubleArray :: [Int] -> [Int]
doubleArray = map (*2)

luhnChecker :: Int -> Bool
luhnChecker x = (sum (map (\n -> if n > 9 then n - 9 else n) (doubleArray $ init $ digits))) `mod` 10 == 0
    where digits = takeDigits x
