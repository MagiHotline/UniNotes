data MyMaybe a = MyNothing | MyJust a deriving Show


mapMay :: (a -> b) -> MyMaybe a -> MyMaybe b
mapMay _ MyNothing = MyNothing
mapMay f (MyJust x)   = MyJust (f x)

instance Functor MyMaybe where
   -- fmap :: (a -> b) -> MyMaybe a -> MyMaybe b
   fmap = mapMay


instance Applicative MyMaybe where
    pure                        = MyJust
    (MyJust f) <*> (MyJust x)   = MyJust (f x)
    _          <*> _            = MyNothing

safeHead :: [a] -> MyMaybe a
safeHead []   = MyNothing
safeHead xs   = MyJust (head xs)

safeHeads2 :: [[a]] -> [MyMaybe a]
safeHeads2 [[]] = [MyNothing]
safeHeads2 xs = safeHead <$> xs

safeLast :: [a] -> MyMaybe a
safeLast []   = MyNothing
safeLast xs   = MyJust (last xs)


safeLasts2 :: [[a]] -> [MyMaybe a]
safeLasts2 [[]] = [MyNothing]
safeLasts2 xs = safeLast <$> xs

fromMaybe :: MyMaybe Char -> Char
fromMaybe MyNothing = '-'
fromMaybe (MyJust ch) = ch

safeHeads :: [String] -> [Char]
safeHeads [] = ['-']
safeHeads xs = fromMaybe <$> (safeHead <$> xs)

safeLasts :: [String] -> [Char]
safeLasts [] = ['-']
safeLasts xs = fromMaybe <$> (safeLast <$> xs)

safeHeadChar :: [Char] -> Char
safeHeadChar []   = fromMaybe MyNothing
safeHeadChar xs   = fromMaybe $ MyJust (head xs)

safeLastChar :: [Char] -> Char
safeLastChar []   = fromMaybe MyNothing
safeLastChar xs   = fromMaybe $ MyJust (last xs)
