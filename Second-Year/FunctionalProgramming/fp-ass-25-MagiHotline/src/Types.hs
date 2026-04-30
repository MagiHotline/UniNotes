module Types where

data ValidationResult a
  = Valid a
  | Invalid [String]
  deriving (Show)
-- this can be used throughout the project to validate data

-- I want to create an applicative for the validationResult
-- We need to define a functor first
instance Functor ValidationResult where
  fmap f (Valid a)    = Valid (f a)
  fmap _ (Invalid e)  = Invalid e

-- If both validations succeed, it applies the function.
-- If one or more validations fail, it collects all the errors
instance Applicative ValidationResult where
  pure = Valid
  Valid f <*> Valid x = Valid (f x)
  Invalid e1 <*> Invalid e2 = Invalid (e1 ++ e2)
  Invalid e <*> _ = Invalid e
  _ <*> Invalid e = Invalid e
