module Split.LibSplit where

import Data.List.Split(splitOn)  -- this needs to go into dependencies.

splitOnSpace :: [String]
splitOnSpace = splitOn " " "hello there MAIREAD"

splitOnSpaceWithInput :: String -> [String]
splitOnSpaceWithInput input = splitOn " " input
