module StringUtilities.Anagram where

import Data.List (sort)

-- Function that given two strings, returns True if they are anagrams of each other
isAnagram :: String -> String -> Bool
isAnagram str1 str2 = sortedStr1 == sortedStr2
    where sortedStr1 = sort str1
          sortedStr2 = sort str2
