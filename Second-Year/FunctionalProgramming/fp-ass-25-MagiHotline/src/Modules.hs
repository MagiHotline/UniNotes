{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE RecordWildCards #-}
{-# LANGUAGE OverloadedStrings #-}

module Modules where
import Types (ValidationResult(..))
import GHC.Generics (Generic)
import Data.Csv (FromNamedRecord(..), ToNamedRecord, (.:))
import qualified Data.Csv as Csv
import qualified Data.ByteString.Lazy as BL
import Data.Char (isDigit, isAlpha)
import qualified Data.Text as T
import qualified Data.ByteString as BL

data Module = Module
    {
        moduleId :: !String,
        moduleHours :: !Int
    } deriving (Show, Generic)

instance Csv.FromNamedRecord Module where
-- apply the program constructor to the columns that contain "progId" and "progName" and create records
parseNamedRecord r = Module <$> r .: "moduleId" <*> r .: "moduleHours"

-- validate the programme
instance ToNamedRecord Module
validateHours :: Int -> ValidationResult Int
validateHours moduleHours
  | moduleHours >= 0 && moduleHours <= 10    = Valid moduleHours
  | otherwise                                = Invalid ["hours must be between 0 and 10"]

validateId :: String -> [Module] -> ValidationResult String
validateId mId modules
    | any ((==mId) . moduleId) modules = Valid mId
    | otherwise                         = Invalid ["ID must be unique"]

validateModule :: Module -> [Module] -> ValidationResult Module
validateModule mod modules =
    Module
    <$> Modules.validateId (moduleId mod) modules
    <*> Modules.validateHours (moduleHours mod)
