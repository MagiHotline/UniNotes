import Lecturer
import Room
import Programmes
import Groups
import Modules
import Allocations
import Timetable
import Types (ValidationResult(..))
import Data.Csv (decodeByName)
import qualified Data.ByteString.Lazy as BL
import qualified Data.Vector as V (toList)
import Data.Either (partitionEithers)
import Data.List (groupBy, sortOn)
import Data.Function (on)

main :: IO ()
main = do
    lecsResult <- readLecturers "data/lecturers.csv"
    modulesResult <- readModules "data/modules.csv"
    groupsResult <- readGroups "data/groups.csv"
    roomsResult <- readRooms "data/rooms.csv"
    programmesResult <- readProgrammes "data/programmes.csv"
    allocResult <- readAllocations "data/allocations.csv"
    ttResult <- readTimetables "data/timetables.csv"
    case (lecsResult, modulesResult, groupsResult, roomsResult, programmesResult, allocResult, ttResult) of
        (Left e, _, _, _, _, _, _) -> putStrLn $ "Error loading lecturers: " ++ e
        (_, Left e, _, _, _, _, _) -> putStrLn $ "Error loading modules: " ++ e
        (_, _, Left e, _, _, _, _) -> putStrLn $ "Error loading groups: " ++ e
        (_, _, _, Left e, _, _, _) -> putStrLn $ "Error loading rooms: " ++ e
        (_, _, _, _, Left e, _, _) -> putStrLn $ "Error loading programmes: " ++ e
        (_, _, _, _, _, Left e, _) -> putStrLn $ "Error loading allocations: " ++ e
        (_, _, _, _, _, _, Left e) -> putStrLn $ "Error loading timetables: " ++ e
        (Right lecturers, Right modules, Right groups, Right rooms, Right programmes, Right allocs, Right tts) -> do
            validations lecturers Lecturer.validateLecturer generateValidMarkdownLec generateInvalidMarkdownLec
            validations modules Modules.validateModule generateValidMarkdownMod generateInvalidMarkdownMod
            validations programmes Programmes.validateProgramme generateValidMarkdownProg generateInvalidMarkdownProg
            validations rooms Room.validateRoom generateValidMarkdownRoom generateInvalidMarkdownRoom

            -- Validate groups
            let validGroups = map (\group -> (group, Groups.validateGroup group groups programmes)) groups
                (valids, invalids) = partitionEithers $ map toEither validGroups
            generateValidMarkdownGroup valids
            generateInvalidMarkdownGroup invalids

            -- Validate allocations
            let validAllocs = map (\alloc -> (alloc, Allocations.validateAllocation alloc allocs lecturers)) allocs
                (valids, invalids) = partitionEithers $ map toEither validAllocs
            generateValidMarkdownAlloc valids
            generateInvalidMarkdownAlloc invalids

            -- Validate and generate Timetables
            let validTimetables = map (\tt -> (tt, Timetable.validateTimetableEntry tt tts modules)) tts
                (valids, invalids) = partitionEithers $ map toEither validTimetables
            generateTimetableForLecturers valids
            generateTimetableForGroups valids
            generateTimetableForRooms valids
            generateInvalidsTT invalids

-- Functions that validates a table of date based on their validations rules
validations :: [a] -> (a -> [a] -> ValidationResult a) -> ([a] -> IO ()) -> ([a] -> IO ()) -> IO ()
validations items validator genValid genInvalid = do
    let validItems = map (\item -> (item, validator item items)) items
        (valids, invalids) = partitionEithers $ map toEither validItems
    genValid valids
    genInvalid invalids

-- function that taken a filepath returns either a string or vector of data
readLecturers :: FilePath -> IO (Either String [Lecturer])
readLecturers filePath = do
  csvData <- BL.readFile filePath
  case decodeByName csvData of
    Left err -> return $ Left err
    Right (_, result) -> return $ Right (V.toList result)

readRooms :: FilePath -> IO (Either String [Room])
readRooms filePath = do
  csvData <- BL.readFile filePath
  case decodeByName csvData of
    Left err -> return $ Left err
    Right (_, result) -> return $ Right (V.toList result)

readGroups :: FilePath -> IO (Either String [Group])
readGroups filePath = do
  csvData <- BL.readFile filePath
  case decodeByName csvData of
    Left err -> return $ Left err
    Right (_, result) -> return $ Right (V.toList result)

readProgrammes :: FilePath -> IO (Either String [Programme])
readProgrammes filePath = do
  csvData <- BL.readFile filePath
  case decodeByName csvData of
    Left err -> return $ Left err
    Right (_, result) -> return $ Right (V.toList result)

readModules :: FilePath -> IO (Either String [Module])
readModules filePath = do
  csvData <- BL.readFile filePath
  case decodeByName csvData of
    Left err -> return $ Left err
    Right (_, result) -> return $ Right (V.toList result)

readAllocations :: FilePath -> IO (Either String [Allocations])
readAllocations filePath = do
  csvData <- BL.readFile filePath
  case decodeByName csvData of
    Left err -> return $ Left err
    Right (_, result) -> return $ Right (V.toList result)

readTimetables :: FilePath -> IO (Either String [Timetable])
readTimetables filePath = do
  csvData <- BL.readFile filePath
  case decodeByName csvData of
    Left err -> return $ Left err
    Right (_, result) -> return $ Right (V.toList result)

-- I use this function just to separate the valid from the invalids
toEither :: (a, ValidationResult a) -> Either a a
toEither (a, Valid _) = Left a
toEither (a, Invalid _) = Right a

generateLecturer :: Lecturer -> String
generateLecturer lec = show (lecturerID lec) ++ " - " ++ name lec ++ " - " ++ show (availableHours lec)

generateRoom :: Room -> String
generateRoom room = Room.roomId room ++ " - " ++ show (capacity room)

generateProgramme :: Programme -> String
generateProgramme prog = show (Programmes.progId prog) ++ ", " ++ progName prog

generateModule :: Module -> String
generateModule mods = Modules.moduleId mods ++  " - hours: " ++ show (Modules.moduleHours mods)

generateGroup :: Group -> String
generateGroup group = Groups.groupId group ++ " " ++ Groups.progId group ++ " - size: " ++  show (size group)

generateAllocations :: Allocations -> String
generateAllocations alloc = Allocations.lecturerName alloc ++ " "  ++ Allocations.moduleId alloc ++ " - " ++ show (Allocations.moduleHours alloc) ++ " " ++ Allocations.groupId alloc

generateTimetable :: Timetable -> String
generateTimetable tt =
    "[ " ++ time tt ++ " ] | " ++ Timetable.lecturerName tt ++ " | " ++ Timetable.moduleId tt ++ " | " ++ Timetable.groupId tt ++ " | " ++ Timetable.roomId tt ++  " | "

generateTimetableForLecturers :: [Timetable] -> IO ()
generateTimetableForLecturers tts = do
    let sorted = sortOn Timetable.lecturerName tts
        grouped = groupBy ((==) `on` Timetable.lecturerName) sorted
        rendered = concatMap renderLecturer grouped
    writeFile "reportData/valid-timetable-lecturers.md" rendered

-- The pattern tts@(tt:_) is a pattern match with an alias
-- This matches a non-empty list, and binds:
-- tt to the first element of the list
-- _ to the rest of the list
-- tts to the entire list
renderLecturer :: [Timetable] -> String
renderLecturer [] = ""
renderLecturer tts@(tt:_) =
    "# Timetable for " ++ Timetable.lecturerName tt ++ "\n\n"
    ++ unlines (map generateTimetable tts) ++ "\n"

generateInvalidsTT :: [Timetable] -> IO ()
generateInvalidsTT tts = writeFile "reportData/invalid-timetables.md"
    ("# Invalid Timetables \n\n"
        ++ unlines (map generateTimetable tts) ++ "\n")

generateTimetableForGroups :: [Timetable] -> IO ()
generateTimetableForGroups tts = do
    let sorted = sortOn Timetable.groupId tts
        grouped = groupBy ((==) `on` Timetable.groupId) sorted
        rendered = concatMap renderGroup grouped
    writeFile "reportData/valid-timetable-groups.md" rendered

renderGroup :: [Timetable] -> String
renderGroup [] = ""
renderGroup tts@(tt:_) =
    "# Timetable for Group " ++ Timetable.groupId tt ++ "\n\n"
    ++ unlines (map generateTimetable tts) ++ "\n"

generateTimetableForRooms :: [Timetable] -> IO ()
generateTimetableForRooms tts = do
    let sorted = sortOn Timetable.roomId tts
        grouped = groupBy ((==) `on` Timetable.roomId) sorted
        rendered = concatMap renderRoom grouped
    writeFile "reportData/valid-timetable-rooms.md" rendered

renderRoom :: [Timetable] -> String
renderRoom [] = ""
renderRoom tts@(tt:_) =
    "# Timetable for Room " ++ Timetable.roomId tt ++ "\n\n"
    ++ unlines (map generateTimetable tts) ++ "\n"

generateValidMarkdownAlloc :: [Allocations] -> IO ()
generateValidMarkdownAlloc allocs = writeFile "reportData/valid-allocs.md"
    (unlines $ ["# Valid allocations", ""] ++ map generateAllocations allocs)

generateInvalidMarkdownAlloc :: [Allocations] -> IO ()
generateInvalidMarkdownAlloc allocs = writeFile "reportData/invalid-allocs.md"
    (unlines $ ["# Invalid allocations", ""] ++ map generateAllocations allocs)

generateValidMarkdownMod :: [Module] -> IO ()
generateValidMarkdownMod validMod = writeFile "reportData/valid-mods.md"
    (unlines $ ["# Valid modules", ""] ++ map generateModule validMod)

generateInvalidMarkdownMod :: [Module] -> IO ()
generateInvalidMarkdownMod invalidmods = writeFile "reportData/invalid-mods.md"
    (unlines $ ["# Invalid modules", ""] ++ map generateModule invalidmods)

generateValidMarkdownGroup :: [Group] -> IO ()
generateValidMarkdownGroup group = writeFile "reportData/valid-group.md"
    (unlines $ ["# Valid groups", ""] ++ map generateGroup group)

generateInvalidMarkdownGroup :: [Group] -> IO ()
generateInvalidMarkdownGroup group = writeFile "reportData/invalid-group.md"
    (unlines $ ["# Invalid groups", ""] ++ map generateGroup group)

generateValidMarkdownProg :: [Programme] -> IO ()
generateValidMarkdownProg validProg = writeFile "reportData/valid-progs.md" (unlines $
    [ "# Valid programmes"
    , ""
    ] ++ map generateProgramme validProg)

generateInvalidMarkdownProg :: [Programme] -> IO ()
generateInvalidMarkdownProg validProg = writeFile "reportData/invalid-progs.md" (unlines $
    [ "# Invalid programmes"
    , ""
    ] ++ map generateProgramme validProg)

generateValidMarkdownRoom :: [Room] -> IO ()
generateValidMarkdownRoom validRoom = writeFile "reportData/valid-rooms.md" (unlines $
    [ "# Valid rooms"
    , ""
    ] ++ map generateRoom validRoom)

generateInvalidMarkdownRoom :: [Room] -> IO ()
generateInvalidMarkdownRoom room = writeFile "reportData/invalid-rooms.md"
    (unlines $ [ "# Invalid rooms"
    , ""
    ] ++ map generateRoom room)

generateValidMarkdownLec :: [Lecturer] -> IO ()
generateValidMarkdownLec validLec = writeFile "reportData/valid-lecturers.md" (unlines $
    [ "# Valid Lecturers"
    , ""
    ] ++ map generateLecturer validLec)

generateInvalidMarkdownLec :: [Lecturer] -> IO ()
generateInvalidMarkdownLec invalidLec = writeFile "reportData/invalid-lecturers.md"
    (unlines $ [ "# Invalid Lecturers"
    , ""
    ] ++ map generateLecturer invalidLec)
