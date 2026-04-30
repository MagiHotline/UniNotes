-- Exercise 1: What are the types of the following values?

characterList :: [Char]
characterList = ['a', 'b', 'c']

charTuple :: (Char, Char, Char)
charTuple = ('a','b','c')

arrayTuple :: [(Bool, Char)]
arrayTuple = [(False,'0'),(True,'1')]

tupleArray :: ([Char], [Char])
tupleArray = (['1', '0'], ['0', '1'])

listOfFunctions :: [[a] -> [a]] -- where a is a type variable
listOfFunctions = [tail, init, reverse]

-- Exercise 2: Write down definitions that have the following types

bools :: [Bool]
bools = [True, False]

nums :: [[Int]]
nums = [[1,2,3], [4,5,6], [7,8,9]]

add :: Int -> Int -> Int -> Int
add x y z = x + y + z

copy :: a -> (a,a)
copy x = (x,x)

-- Exercise 3: What are the types of the following functions?

copia :: a -> (a,a)
copia x = (x, x)

second :: [a] -> a
second xs = head (tail xs)

swap :: (a, a) -> (a, a)
swap (x, y) = (y, x)

pair :: a -> a -> (a, a)
pair x y = (x, y)

-- A function where a is whatever number and gives the double of it
double :: Num a => a -> a
double x = x * 2

-- A function where a satisfies the equal and returns bool
palindrome :: Eq a => [a] -> Bool
palindrome xs = reverse xs == xs

twice :: (a -> a) -> a -> a
twice f x = f (f x)
