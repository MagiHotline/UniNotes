{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE RecordWildCards #-}
{-# LANGUAGE OverloadedStrings #-}

module Groups where

import Types (ValidationResult(..))
import Programmes
import GHC.Generics (Generic)
import Data.Csv (FromNamedRecord(..), ToNamedRecord, (.:))
import qualified Data.Csv as Csv
import qualified Data.ByteString.Lazy as BL
import Data.Char (isDigit, isAlpha)
import qualified Data.Text as T
import qualified Data.ByteString as BL

data Group = Group
    {   groupId :: !String,
        progId :: !String,
        size :: !Int
    } deriving (Show, Generic)

instance Csv.FromNamedRecord Group where
  parseNamedRecord  r = Group
    <$> r .: "groupId"
    <*> r .: "progId"
    <*> r .: "size"

instance ToNamedRecord  Group
validateSize :: Int -> ValidationResult Int
validateSize size
  | size >= 0 && size <= 100 = Valid size
  | otherwise                = Invalid ["id must be between 0 and 1000"]

validateProgramme :: String -> [Programme] -> ValidationResult String
validateProgramme mId programmes
-- I just need to see if it exists once in the modules
    | any ((==mId) . Programmes.progName) programmes = Valid mId
    | otherwise                                   = Invalid ["This programme does not exist"]

validateId :: String -> [Group] -> ValidationResult String
validateId gId allGroups
    | any ((==gId) . groupId) allGroups = Valid gId
    | otherwise                         = Invalid ["ID must be unique"]

validateGroup :: Group -> [Group] -> [Programme] -> ValidationResult Group
validateGroup group groups programmes =
    Group
    <$> Groups.validateId (groupId group) groups
    <*> Groups.validateProgramme (Groups.progId group) programmes
    <*> Groups.validateSize (size group)
