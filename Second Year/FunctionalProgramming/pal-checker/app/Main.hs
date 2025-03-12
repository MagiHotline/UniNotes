module Main (main) where

import Palindrome (isPalindrome)

main :: IO ()
main = do
    putStrLn "Palindrome checker: "
    input <- getLine
    if isPalindrome input
        then putStrLn "It's a palindrome!"
        else putStrLn "It's not a palindrome!"
