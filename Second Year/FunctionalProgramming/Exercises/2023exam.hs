import Data.List(sort,sortBy,group,groupBy)
import Data.Function (on)


myreplicate :: Int -> a -> [a]
myreplicate times x
    | times <= 0    = []
    | otherwise     = x : myreplicate (times - 1) x

fib :: Int -> Int
fib 0 = 1
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

fibonacciT :: Int -> Int
fibonacciT n = fibHelper n 1 1
  where
    fibHelper 0 a _ = a
    fibHelper n a b = fibHelper (n - 1) b (a + b)


double :: Num a => [a] -> [a]
double = map (*2)

evens :: [Int] -> [Int]
evens xs = [x | x <- xs, even x]

{- Define the following (Prelude) library functions using
recursion
foldr
i)  reverse :: [a] -> [a]
ii) map :: (a -> b) -> [a] -> [b] -}

mymap :: (a -> b) -> [a] -> [b]
mymap f [] = []
mymap f (x:xs) = f x : mymap f xs

myrev :: [a] -> [a]
myrev [] = []
myrev (x:xs) = myrev xs ++ [x]

mymap2 :: (a -> b) -> [a] -> [b]
mymap2 f = foldr (\x acc -> f x : acc) []

reverseFold :: [a] -> [a]
reverseFold = foldr (\x xs -> xs ++ [x]) []

-- sorted :: Ord a => [a] -> Bool
-- length :: [a] -> Int

{-
Noting the following definition of tail :
tail :: [a] -> [a]
tail [] = []
tail (_:xs) = xs
Rewrite this (using the names safetailMaybe and safetailEither) where
safetailMaybe – uses Maybe – returns Nothing when called on an empty list
safetailEither – uses Either – returns an error message when called on an empty list. Clearly
state the types of the functions in both cases.
-}
safetailMaybe :: [a] -> Maybe [a]
safetailMaybe [] = Nothing
safetailMaybe (_:xs) = Just xs

safetailEither :: [a] -> Either String [a]
safetailEither [] = Left "Tail called on empty list"
safetailEither (_:xs) = Right xs

anagram :: String -> String -> Bool
anagram s1 s2 = if sort s1 == sort s2 then True else False

data Category = Blue | Green | Orange
    deriving (Eq,Ord,Show)
people =
    [("Tim",24,Blue,"Waterford")
    ,("Tom",36,Blue,"Tipperary")
    ,("Mary",19,Orange,"Dublin")
    ,("Zach",41,Blue,"Tipperary")
    ,("Ann",9,Green,"Wexford")
    ]

name (nm,ag,cat,st) = nm
age (nm,ag,cat,st) = ag
category (nm,ag,cat,st) = cat
county (nm,ag,cat,st) = st

tippPeople :: [(String)]
tippPeople = [name x | x <- people, county x == "Tipperary"]

watPeopleAge :: [(String, Int)]
watPeopleAge = [(name x, age x) | x <- people, county x == "Waterford"]

-- The category and the count of all those with that category(catCount)
categories = [Blue, Orange, Green]

catCount :: [(Category, Int)]
catCount = [(c, length [x | x <- people, category x == c]) | c <- categories]

main :: IO ()
main = do
    putStrLn "Enter the number of integers (positive n):"
    nInput <- getLine
    let n = read nInput :: Int

    putStrLn $ "Enter " ++ show n ++ " integers separated by spaces:"
    numsLine <- getLine
    let nums = map read (words numsLine) :: [Int]

    let productResult = product nums
    putStrLn $ "The product of the entered numbers is: " ++ show productResult


data Student = Student { sname:: String , course:: Maybe Course} deriving Show

student1 = Student {sname = "student1", course = Just applied}
student2 = Student {sname = "potentialstudent1", course = Nothing}
student3 = Student {sname = "student3", course = Just forensics}

data Lecturer = Lecturer {lname :: String , roomNumber :: Maybe String} deriving Show

rob = Lecturer {lname = "Robert", roomNumber = Just "311"}
john = Lecturer { lname = "John", roomNumber = Nothing}

data Course = Course {cname:: String ,leader:: Maybe Lecturer} deriving Show

applied = Course {cname = "Applied Computing", leader = Just rob}
forensics = Course {cname = "Forensics", leader = Just john}
newCourse = Course {cname = "Brave New Course", leader = Nothing }

{-
returnLeader :: Student -> Maybe Lecturer
returnLeader s =
    case course s of
        Nothing -> Nothing
        Just course -> leader course
-}

returnLeader :: Student -> Maybe Lecturer
returnLeader s = course s >>= leader

returnRoom :: Student -> Maybe String
returnRoom s = course s >>= leader >>= roomNumber


data Tree a = Leaf a | Node (Tree a) (Tree a)

leaves :: Tree a -> Int
leaves (Leaf _) = 1
leaves (Node left right) = leaves left + leaves right

{-Define a function depth that calculates the depth of a tree, where the depth is given
by the number of nodes in the longest path from the root of the tree to a leaf in the
tree:-}
depth :: Tree a -> Int
depth (Leaf _) = 1
depth (Node left right) = 1 + max (depth left) (depth right)

balanced :: Tree a -> Bool
balanced (Leaf _) = True
balanced (Node left right) =
    abs (leaves left - leaves right) <= 1
    && balanced left
    && balanced right

{-
repeat :: IO Bool -> IO () -> IO ()
so that
repeat test oper
has the effect of repeating oper until the condition test is True.
-}

ripeti :: IO Bool -> IO () -> IO ()
ripeti test oper = do
    oper
    done <- test
    if done
        then return ()
        else ripeti test oper

merge :: Ord a => [a] -> [a] -> [a]
{- that merges two sorted lists to give a single sorted list. -}
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys)
    | x < y = x : merge xs (y:ys)
    | otherwise = y : merge (x:xs) ys
