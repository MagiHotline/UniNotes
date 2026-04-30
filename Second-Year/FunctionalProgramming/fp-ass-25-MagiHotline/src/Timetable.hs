{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE RecordWildCards #-}
{-# LANGUAGE OverloadedStrings #-}

module Timetable where

import Lecturer
import Groups
import Modules
import Types (ValidationResult(..))
import GHC.Generics (Generic)
import Data.Csv (FromNamedRecord(..), ToNamedRecord, (.:))
import qualified Data.Csv as Csv
import qualified Data.ByteString.Lazy as BL
import Data.Char (isDigit, isAlpha)
import qualified Data.Text as T
import qualified Data.ByteString as BL
import Data.List as DL


data Timetable = Timetable
    {
        time :: !String,
        moduleId :: !String,
        groupId :: !String,
        roomId :: !String,
        lecturerName :: !String
    } deriving (Show, Generic)

instance Csv.FromNamedRecord Timetable where
  parseNamedRecord  r = Timetable
    <$> r .: "time"
    <*> r .: "moduleId"
    <*> r .: "groupId"
    <*> r .: "roomId"
    <*> r .: "lecturerName"

{-
    There should be no clashes

    - For groups (students should not be timetabled to be in two places at the one time)
    - For rooms (no room should have two different groups scheduled at the same time)
    - For lecturers (no lecturers should be scheduled to be in two places at the one time)
    - A module should be fully timetabled. If a module has 5 contact hours, it should be scheduled for 5 distinct times.
-}
instance ToNamedRecord Timetable
validateGroups :: Timetable -> [Timetable] -> ValidationResult Timetable
validateGroups tt allRecords =
    let clashes = filter (\x -> Timetable.groupId x == Timetable.groupId tt && time x == time tt) allRecords
    in if length clashes > 1
        then Invalid $ ["Group " ++ Timetable.groupId tt ++ " is booked more than once at " ++ time tt]
        else Valid tt

validateRoom :: Timetable -> [Timetable] -> ValidationResult Timetable
validateRoom tt allRecords =
    let clashes = filter (\x -> time x == time tt && Timetable.roomId x == Timetable.roomId tt) allRecords
    in if length clashes > 1
        then Invalid $ ["Room " ++ Timetable.roomId tt ++ " is booked more than once at " ++ time tt]
        else Valid tt

validateLecturer :: Timetable -> [Timetable] -> ValidationResult Timetable
validateLecturer tt allRecords =
    let clashes = filter (\x -> time x == time tt && Timetable.lecturerName x == Timetable.lecturerName tt) allRecords
    in if length clashes > 1
        then Invalid $ ["Lecturer " ++ Timetable.lecturerName tt ++ " is already somewhere else at " ++ time tt]
        else Valid tt

lookUpHours :: String -> [Module] -> Maybe Int
lookUpHours name mods = moduleHours <$> find (\m -> Modules.moduleId m == name) mods

validateHoursforModule :: Timetable -> [Timetable] -> [Module] -> ValidationResult Timetable
validateHoursforModule tt allRecords mods =
    -- since LookUpHours returns a Maybe Int I have to handle it with a case
    case lookUpHours (Timetable.moduleId tt) mods of
        Nothing -> Invalid ["Module " ++ Timetable.moduleId tt ++ " not found."]
        Just allowed ->
            let scheduled = length (filter (\x -> Timetable.moduleId tt == Timetable.moduleId x) allRecords)
            in if scheduled > allowed
                then Invalid ["The module " ++ Timetable.moduleId tt ++ " it's not fully timetabled."]
                else Valid tt

validateTimetableEntry :: Timetable -> [Timetable] -> [Module] -> ValidationResult Timetable
validateTimetableEntry tt allRecords modules =
    case concatErrors
            [ validateGroups     tt allRecords
            , validateRoom       tt allRecords
            , Timetable.validateLecturer   tt allRecords
            , validateHoursforModule tt allRecords modules
            ] of
    []   -> Valid tt
    errs -> Invalid errs
    where
    concatErrors :: [ValidationResult a] -> [String]
    concatErrors = concatMap (\res -> case res of
                                        Valid _     -> []
                                        Invalid es  -> es)
