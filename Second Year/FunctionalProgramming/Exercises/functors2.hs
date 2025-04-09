import qualified Data.Map as Map

data RobotPart = RobotPart
   { name :: String
   , description :: String
   , cost :: Double
   , count :: Int
   } deriving Show

rightArm :: RobotPart
rightArm = RobotPart
    {
        name = "right arm",
        description = "right arm for kind hand gestures",
        cost = 1025,
        count = 5
    }

leftArm :: RobotPart
leftArm = RobotPart
    {
        name = "left arm",
        description = "left arm for face punching!",
        cost = 1000,
        count = 3
    }

robotHead :: RobotPart
robotHead = RobotPart
    { name = "robot head"
    , description = "this head looks mad"
    , cost = 5092.25
    , count = 2
    }

type Html = String

renderHtml :: RobotPart -> Html
renderHtml part = mconcat ["<h2>",partName, "</h2>"
                            ,"<p><h3>desc</h3>",partDesc
                            ,"</p><p><h3>cost</h3>"
                            ,partCost
                            ,"</p><p><h3>count</h3>"
                            ,partCount,"</p>"]
    where
        partName = name part
        partDesc = description part
        partCost = show (cost part)
        partCount = show (count part)

partsDB :: Map.Map Int RobotPart
partsDB = Map.fromList keyVals
    where
        keys = [1,2,3]
        vals = [leftArm,rightArm,robotHead]
        keyVals = zip keys vals

-- insertSnippet :: Maybe Html -> IO ()

partVal :: Maybe RobotPart
partVal = Map.lookup 1 partsDB

partHtml :: Maybe Html
partHtml = renderHtml <$> partVal

allParts :: [RobotPart]
allParts = map snd (Map.toList partsDB)

allParts2 :: [RobotPart]
allParts2 = snd <$> (Map.toList partsDB)

allPartsHtml :: [Html]
allPartsHtml = renderHtml <$> allParts

-- or
allPartsHtml2 :: [Html]
allPartsHtml2 = map renderHtml allParts

-- Instead of taking all the parts from the DB just take the parts and convert it to HTML
htmlPartsDB :: Map.Map Int Html
htmlPartsDB = renderHtml <$> partsDB

leftArmIO :: IO RobotPart
leftArmIO = return leftArm

htmlSnippet :: IO Html
htmlSnippet = renderHtml <$> leftArmIO

-----------------

data Box a = Box a deriving Show

-- so it basically says "apply the function in the box but keep it wrapped"
instance Functor Box where
    fmap f (Box val) = Box (f val)

morePresents :: Box a -> Int -> Box [a]
morePresents val n = replicate n <$> val

myBox :: Box Int
myBox = Box 1

-- take a Boxed value and unbox it
unwrap :: Box a -> a
unwrap (Box val) = val

-- Q6
-- the cost may be nothing so handle that exception
printCost :: Maybe Double -> IO ()
printCost Nothing = putStrLn "Item not found"
printCost (Just cost) = print cost

main :: IO ()
main = do
    putStrLn "Enter a number part"
    partNo <- getLine
    let part = Map.lookup (read partNo) partsDB
    printCost (cost <$> part)
