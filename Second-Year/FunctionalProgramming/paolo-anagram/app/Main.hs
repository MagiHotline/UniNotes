-- Imbriani Paolo 13-03-2025
module Main (main) where

import StringUtilities.GenUtils (strToUpper)
import StringUtilities.Anagram (isAnagram)

main :: IO ()
main = do
    putStrLn "Enter the first string: "
    str1 <- getLine
    putStrLn "Enter the second string: "
    str2 <- getLine
    if isAnagram (strToUpper str1) (strToUpper str2)
        then putStrLn "these strings are anagram of each other"
        else putStrLn "these strings are NOT anagram of each other"
