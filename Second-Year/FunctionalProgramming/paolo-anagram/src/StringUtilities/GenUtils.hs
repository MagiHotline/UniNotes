module StringUtilities.GenUtils where

import Data.Char (toUpper)

-- Function that given a string, returns the string in uppercase
strToUpper :: String -> String
strToUpper str = map toUpper str
