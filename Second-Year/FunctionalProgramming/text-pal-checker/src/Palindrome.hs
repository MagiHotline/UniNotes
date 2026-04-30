module Palindrome (isPalindrome) where

import Data.Text as T
import Data.Char (isSpace, isPunctuation)

isPalindrome :: String -> Bool
isPalindrome text = cleanText == T.reverse cleanText
  where cleanText = T.filter (\c -> not (isSpace c || isPunctuation c)) $ T.toLower $ T.pack $ text
