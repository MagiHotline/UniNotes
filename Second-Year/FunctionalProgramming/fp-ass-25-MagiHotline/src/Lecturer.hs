{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE RecordWildCards #-}
{-# LANGUAGE OverloadedStrings #-}

module Lecturer  where
import Types (ValidationResult(..))
import GHC.Generics (Generic)
import Data.Csv (FromNamedRecord(..), ToNamedRecord, (.:))
import qualified Data.Csv as Csv
import qualified Data.ByteString.Lazy as BL
import Data.Char (isDigit, isAlpha)
import qualified Data.Text as T
import qualified Data.ByteString as BL

data Lecturer = Lecturer
    { lecturerID   :: !Int
    , name          :: !String
    , availableHours      :: !Int
    } deriving (Show, Generic)

instance Csv.FromNamedRecord Lecturer where
  parseNamedRecord  r = Lecturer
    <$> r .: "lecturerID"
    <*> r .: "name"
    <*> r .: "availableHours"

instance ToNamedRecord  Lecturer
validateName :: String -> ValidationResult String
validateName name
  | length name <= 30           = Valid name
  | otherwise                   = Invalid ["Must be 30 characters or less"]

validateHours :: Int -> ValidationResult Int
validateHours hours
    | hours >= 0 && hours <= 24 = Valid hours
    | otherwise                 = Invalid ["Must be between 0 and 24"]

validateId :: Int -> [Lecturer] -> ValidationResult Int
validateId lecId lecturers
    | any ((==lecId) . lecturerID) lecturers = Valid lecId
    | otherwise = Invalid ["ID must be unique"]

validateLecturer :: Lecturer -> [Lecturer] -> ValidationResult Lecturer
validateLecturer lecturer allLec =
    Lecturer
    <$> validateId (lecturerID lecturer) allLec
    <*> validateName (name lecturer)
    <*> validateHours (availableHours lecturer)
