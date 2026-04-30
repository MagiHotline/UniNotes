{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE RecordWildCards #-}
{-# LANGUAGE OverloadedStrings #-}

module Allocations where

import Lecturer
import Types (ValidationResult(..))
import GHC.Generics (Generic)
import Data.Csv (FromNamedRecord(..), ToNamedRecord, (.:))
import qualified Data.Csv as Csv
import qualified Data.ByteString.Lazy as BL
import Data.Char (isDigit, isAlpha)
import qualified Data.Text as T
import qualified Data.ByteString as BL
import Data.List as DL

-- Create a data type of Room where
data Allocations = Allocations
    {
        lecturerName :: !String,
        moduleId :: !String,
        moduleHours :: !Int,
        groupId :: !String
    } deriving (Show, Generic)

instance Csv.FromNamedRecord Allocations where
  parseNamedRecord  r = Allocations
    <$> r .: "lecturerName"
    <*> r .: "moduleId"
    <*> r .: "moduleHours"
    <*> r .: "groupId"

-- Validate allocations
instance ToNamedRecord Allocations
validateAllocation :: Allocations -> [Allocations] -> [Lecturer] -> ValidationResult Allocations
validateAllocation allocation allocations lecturers =
    case DL.find (\lec -> name lec == lecturerName allocation) lecturers of
        Nothing -> Invalid $ ["Lecturer not found: " ++ lecturerName allocation]
        Just lecturer ->
            let totalCurrentHours = sum [moduleHours a | a <- allocations, lecturerName a == lecturerName allocation]
                totalWithNew = totalCurrentHours + moduleHours allocation
            in if totalWithNew <= availableHours lecturer
               then Valid allocation
               else Invalid $ ["Allocation exceeds available hours for lecturer " ++ lecturerName allocation]
