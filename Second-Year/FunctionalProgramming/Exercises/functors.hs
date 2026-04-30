addone :: Num a => a -> a
addone x = x + 1

addoneList :: Num a => [a] -> [a]
addoneList xs = map addone xs

-- functors unwraps wrapped values and returns the value back in the contexts
addoneFunctor :: Num a => [a] -> [a]
addoneFunctor xs = fmap addone xs

-- functors unwraps wrapped values and returns the value back in the contexts
addoneinfix :: Num a => [a] -> [a]
addoneinfix xs = addone <$> xs

-- Maybe values
square :: Num a => a -> a
square x = x*x

-- Mapping a Maybe
squareMaybe :: Num a => Maybe a -> Maybe a
squareMaybe x = square <$> x

squareAllMaybe :: Num a => [Maybe a] -> [Maybe a]
squareAllMaybe xs = map squareMaybe xs

squareAllMaybe2 :: Num a => [Maybe a] -> [Maybe a]
squareAllMaybe2 xs = fmap squareMaybe xs

squareAllMaybe3 :: Num a => [Maybe a] -> [Maybe a]
squareAllMaybe3 xs = squareMaybe <$> xs

-- Nome che è una stringa
type Name = String

-- Abbiamo una struttura Employee formata da Nome e Telefono e derivano il trait Show
data Employee = Employee { name    :: Name
                         , phone   :: String }
                deriving Show

m_name1, m_name2 :: Maybe Name
m_name1 = Nothing
m_name2 = Just "Simon"

m_phone1, m_phone2 :: Maybe String
m_phone1 = Nothing
m_phone2 = Just "(087)999"

-- applies the Employee constructor to the Maybe values using the Applicative instance of Maybe.
-- <$> (fmap) applies Employee to m_name, producing Maybe (String -> Employee).
-- <*> applies that partially constructed function to m_phone, yielding Maybe Employee.
-- If either m_name or m_phone is Nothing, the result is Nothing.
-- If both are Just, the result is Just Employee.
ex01 = Employee <$> m_name1 <*> m_phone1
ex02 = Employee <$> m_name1 <*> m_phone2
ex03 = Employee <$> m_name2 <*> m_phone1
ex04 = Employee <$> m_name2 <*> m_phone2

-- so if one of them is Nothing all of them is going to be nothing
-- ex01 is going to produce Nothing
-- ex02 is going to produce the record Nothing
-- ex03 -> Nothing
-- ex04 > Just (Simon 087999)

-------------------------------------------------------
