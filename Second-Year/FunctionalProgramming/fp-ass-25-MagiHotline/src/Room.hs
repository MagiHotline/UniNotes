{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE RecordWildCards #-}
{-# LANGUAGE OverloadedStrings #-}

module Room where

import Types (ValidationResult(..))
import GHC.Generics (Generic)
import Data.Csv (FromNamedRecord(..), ToNamedRecord, (.:))
import qualified Data.Csv as Csv
import qualified Data.ByteString.Lazy as BL
import Data.Char (isDigit, isAlpha)
import qualified Data.Text as T
import qualified Data.ByteString as BL

-- Create a data type of Room where
data Room = Room
    {   roomId :: !String,
        capacity :: !Int
    } deriving (Show, Generic)

instance Csv.FromNamedRecord Room where
  parseNamedRecord  r = Room
    <$> r .: "roomId"
    <*> r .: "capacity"

-- Validate Room
instance ToNamedRecord Room
validateCapacity :: Int -> ValidationResult Int
validateCapacity capacity
  | capacity > 0 && capacity <= 200 = Valid capacity
  | otherwise                       = Invalid ["Id must be between 0 and 1000"]

validateId :: String -> [Room] -> ValidationResult String
validateId rId rooms
    | any ((==rId) . roomId) rooms = Valid rId
    | otherwise                    = Invalid ["ID must be unique"]

validateRoom :: Room -> [Room] -> ValidationResult Room
validateRoom room allRooms =
    Room
    <$> Room.validateId (roomId room) allRooms
    <*> validateCapacity (capacity room)
