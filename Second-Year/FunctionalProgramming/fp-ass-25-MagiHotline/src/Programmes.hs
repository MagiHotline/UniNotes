{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE RecordWildCards #-}
{-# LANGUAGE OverloadedStrings #-}

module Programmes where
import Types (ValidationResult(..))
import GHC.Generics (Generic)
import Data.Csv (FromNamedRecord(..), ToNamedRecord, (.:))
import qualified Data.Csv as Csv
import qualified Data.ByteString.Lazy as BL
import Data.Char (isDigit, isAlpha)
import qualified Data.Text as T
import qualified Data.ByteString as BL

data Programme = Programme
    {
        progId :: !Int,
        progName :: !String
    } deriving (Show, Generic)

instance Csv.FromNamedRecord Programme where
-- apply the program constructor to the columns that contain "progId" and "progName" and create records
parseNamedRecord r = Programme <$> r .: "progId" <*> r .: "progName"

-- validate the programme
instance ToNamedRecord Programme
validateName :: String -> ValidationResult String
validateName progName
  | length progName <= 40    = Valid progName
  | otherwise                = Invalid ["id must be between 0 and 1000"]

validateId :: Int -> [Programme] -> ValidationResult Int
validateId rId programmes
    | any ((==rId) . progId) programmes = Valid rId
    | otherwise                         = Invalid ["ID must be unique"]

validateProgramme :: Programme -> [Programme] -> ValidationResult Programme
validateProgramme programme allProgrammes =
    Programme
    <$> Programmes.validateId (progId programme) allProgrammes
    <*> Programmes.validateName (progName programme)
