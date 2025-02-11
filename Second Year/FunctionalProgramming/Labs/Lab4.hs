-- Sorting
import Data.List ( sort, sortBy )

names :: [(String, String)]
names = [("Hugo", "Keenan"),
         ("Mack", "Hansen"),
         ("James", "Lowe"),
         ("Bundee", "Aki"),
         ("Robbie", "Henshaw"),
         ("Sam", "Prendergast"),
         ("Dan", "Sheehan"),
         ("Jack ", "Crowley")  ,
         ("Caelan", "Doris")]

-- Create your own sort
compareLastNames :: Ord a => (a, a) -> (a, a) -> Ordering
compareLastNames names1 names2
    | lastNames1 > lastNames2 = GT
    | lastNames1 < lastNames2 = LT
    | otherwise = EQ
    where lastNames1 = snd names1
          lastNames2 = snd names2

--Based on Get Programming with Haskell, Will Kurt.

data  Location = WatSETU | CarSETU | WexSETU | UCD
type Name = (String, String)

office :: Location -> String
office WatSETU = "SETU (Waterford Campus), Cork Road, Waterford, Ireland, X91 K0EK."
office CarSETU = "SETU (Carlow Campus), Dublin Road, Carlow, Ireland, R93 V960."
office WexSETU = "SETU (Wexford Campus), Summerhill Rd, Townparks, Wexford, Y35 KA07."
office UCD = "University College Dublin, Belfield, Dublin 4, Ireland, D04 V1W8"
office TCD = "Trinity College Dublin, the University of Dublin College Green Dublin 2,Ireland, D02 PN40 "


watOffice :: Name -> String
watOffice name =
if lastName < "L"
    then nametext ++ ",  Lower Floor, Main Building  " ++ office WatSETU
    else nametext ++ ",  Top Floor, Main Building  " ++ office WatSETU
where
    nametext = fst name ++ "  " ++ snd name
    lastName = snd name

carOffice :: Name -> String
carOffice name =   nametext ++ ",  " ++ office CarSETU
where
    nametext = fst name ++ "  " ++ snd name

wexOffice :: Name -> String
wexOffice name =   nametext ++ ",  " ++ (office WexSETU)
where
    nametext = snd name ++ ", " ++ fst name

ucdOffice :: Name -> String
ucdOffice name = nameText  ++ ", " ++ office UCD
    where
        nameText = snd name ++ ", " ++ fst name ++ " Esq"

tcdOffice :: Name -> String
tcdOffice name = nameText ++ ", " ++ office TCD
    where
        nameText = snd name


getLocation :: String -> (Name -> String)
getLocation location  = case location of
                "Wat(SETU)" -> watOffice
                "Car(SETU)" -> carOffice
                "Wex(SETU)" -> wexOffice
                _     -> ((\name -> fst name ++ "  " ++ snd name ++ ": Address unknown" ) )

addressLetter :: Name -> String -> String
addressLetter name location = getLocation location name
