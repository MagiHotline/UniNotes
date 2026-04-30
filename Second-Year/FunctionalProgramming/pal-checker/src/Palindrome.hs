module Palindrome (isPalindrome) where

isPalindrome :: Eq a => [a] -> Bool
isPalindrome [] = True
isPalindrome s = s == reverse s
