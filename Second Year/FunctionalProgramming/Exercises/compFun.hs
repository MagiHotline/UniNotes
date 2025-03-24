cube :: Int -> Int
cube x = x*x*x

bigCubes :: [Int] -> [Int]
bigCubes = filter (>500) . map cube

lottaBiggest :: [Int] -> [Int]
lottaBiggest = replicate 4 . maximum

powers :: Int -> [Int]
powers n = map ($ n) [(^2), (^3), (^4)]

process :: [Int] -> Int
process = sum . map double . filter (>0)

double :: Int -> Int
double x = 2*x

compute x = length . take x . filter even

calcBill :: [Float] -> [Float] -> [Float]
calcBill = (map (* 1.04) .) . zipWith (\amt pct -> amt + (amt * pct))
