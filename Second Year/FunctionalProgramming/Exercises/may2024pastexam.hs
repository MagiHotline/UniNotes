-- Define the function
-- makeListOfStrings :: String -> [String]
-- which takes a String (which may include the newline character (\n) and returns a
-- list of Strings, one String per line (i.e. terminated by the ‘\n\ character e.g.
-- makeListOfStrings “hello\n there \n haskell”
-- will return
-- [ “hello”, “there ”, “ haskell”]
import Data.List (sort, sortBy, group, groupBy)
import qualified Data.Text as T (pack, unpack, length, strip)
import Data.Either (Either)

makeListOfStrings :: String -> [String]
makeListOfStrings s = lines s

-- Define a recursive function
-- reverse:: [a]-> [a]
-- That takes a list and returns the reverse of the list
-- e.g. reverse [3,4,5] = [5,4,3]
rev :: [a] -> [a]
rev [] = []
rev (x:xs) = rev xs ++ [x]

-- tail recursive
reverseAccum :: [a] -> [a]
reverseAccum xs = revHelper xs []
  where
    revHelper [] acc     = acc
    revHelper (x:xs) acc = revHelper xs (x:acc)

reverseFold :: [a] -> [a]
reverseFold = foldr (\x xs -> xs ++ [x]) []

-- halve
halve :: [a] -> ([a], [a])
halve xs = (one, two)
    where
        one = take (length xs `div` 2) xs
        two = drop (length xs `div` 2) xs

calcBill :: [Float] -> [Float] -> [Float]
calcBill bills tips = zipWith (\bill tip -> (bill + bill * tip) * 1.05) bills tips


isValid :: String -> Either String String
isValid s = if length (filter (/=' ') s) < 300 && T.strip (T.pack s) == T.pack s then
    Right s else
    Left "invalid input, must be less than 300 characters"

odds :: [Int] -> [Int]
odds xs = filter (\x -> x `mod` 2 /= 0) xs

sorted :: [Integer] -> Bool
sorted [] = True
sorted [x] = True
sorted (x:y:xs)
    | x < y = sorted xs
    | otherwise = False


-- Q3 b
normalDiv :: Int -> Int -> Int
normalDiv 0 _ = -1
normalDiv x y = x `div` y

safeDivMaybe :: Int -> Int -> Maybe Int
safeDivMaybe _ 0 = Nothing
safeDivMaybe x y = Just (x `div` y)

safeDivEither :: Int -> Int -> Either Int String
safeDivEither _ 0 = Right "Error! Division by 0 tempted."
safeDivEither x y = Left (x `div` y)

data Province = Munster | Leinster | Connacht
    deriving (Eq, Ord, Show)

people :: [(String, Integer, Province, String)]
people = [("Tim", 24, Munster, "Waterford")
    , ("Tom", 36, Munster, "Tipperary")
    , ("Mary", 19, Connacht, "Galway")
    , ("Zach", 41, Munster, "Tipperary")
    , ("Ann", 9, Leinster, "Wexford")
    ]

name (nm, _, _, _) = nm
age (_, ag, _, _) = ag
province (_, _, cat, _) = cat
county (_, _, _, st) = st

galwayPeople :: [String]
galwayPeople = [name p | p <- people, county p == "Galway"]

provinceCount:: [(Province,Int)]
provinceCount = [(head xs, length xs) | xs <- group (sort [province p | p <- people])]

tippPeopleAge:: [[(String,Integer)]]
tippPeopleAge = group (sortBy (\(n1, a1) (n2, a2) -> compare a1 a2) [(name p, age p) | p <- people, county p == "Tipperary"] )
