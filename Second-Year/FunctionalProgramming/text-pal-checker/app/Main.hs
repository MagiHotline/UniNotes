module Main (main) where

import Palindrome (isPalindrome)

main :: IO ()
main = do
    putStrLn "Text Palindrome Checker: "
    input <- getLine
    if isPalindrome input
    then putStrLn "Palindrome!"
    else putStrLn "Not Palindrome!"
