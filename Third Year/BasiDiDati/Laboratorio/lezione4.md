# Lezione 4


Si considerino le seguenti tabelle (grassetto per le chiavi primarie), presenti
nella base di dati did2014 nel database di UniVR:

- CorsoStudi(**id**, nome, codice, abbreviazione, durataAnni, sede, informativa)
- Facolta(**id**, nome, codice, indirizzo, informativa, id_preside_persona, id_segreteria)
- Insegn(**id**, nomeins, codiceins)
- Discriminante(**id**, nome, descrizione)
- InsErogato(**id**, annoaccademico, id_insegn, id_corsostudi, id_discriminante, modulo,
  discriminantemodulo, nomemodulo, crediti, programma, id_facolta, hamoduli,
  id_inserogato_padre, nomeunità, annierogazione)
- CorsoInFacolta(**id**, id_corsostudi, id_facolta)

e le seguenti indicazioni:

- Nella tabella `InsErogato` gli insegnamenti che non hanno moduli hanno l'attributo
  `hamoduli = '0'`; nella medesima tabella le righe che descrivono un insegnamento nel
  suo complesso hanno l'attributo `modulo = 0`, mentre le righe che descrivono singoli
  moduli hanno `modulo > 0`.
- L'attributo `discriminante` distingue repliche dello stesso insegnamento (ad esempio,
  tale attributo può contenere valori come: `'matricole pari'`, `'matricole dispari'`).
- Alcuni insegnamenti sono divisi in unità logistiche (teoria, laboratorio,
  esercitazioni, ecc. . . ). Tali unità sono rappresentate come entità di `InsErogato`
  in cui: il loro nome è dato dall'attributo `nomeunita`, hanno un valore `modulo < 0` e
  sono legate al padre (insegnamento erogato con `modulo = 0`) da una relazione
  esplicita implementata dall'attributo `id_inserogato_padre`. L'attributo `haunita` ha
  per le unità lo stesso significato di `hamoduli` per i moduli.
- L'attributo `annierogazione` indica gli anni a cui è offerto l'insegnamento (1°,
  1° e 2°, 3° ecc. . . ). Esso viene rappresentato da un intero che va interpretato
  come stringa di bit: `2 = 000010` indica il secondo anno, `3 = 000011` indica la
  combinazione 1° e 2° anno, `4 = 000100` indica il 3° anno, ecc. . .
  - Le tabelle `PeriodoLez` e `PeriodoDid` fanno parte di una gerarchia (`PeriodoDid`
    è padre di `PeriodoLez`) dove il padre è la tabella `PeriodoDid`, mentre la tabella
    `PeriodoLez` permete di specificare un ulteriore attributo (`abbreviazione`). Il join
    tra le due tabelle viene fatto per uguaglianza rispetto all'attributo `id`.

## Esercizio 1

Trovare identificatore, cognome e nome dei docenti che, nell’anno accademico 2010/2011, hanno tenuto
un insegnamento (l’attributo da confrontare è nomeins) che non hanno tenuto nell’anno accademico
precedente. Ordinare la soluzione per identificatore.

La soluzione ha 1031 righe. Le 5 a partire dalla XX riga sono:

| id | cognome | nome |
| :--- | :--- | :--- |
| 140 | Ferrarini | Roberto |
| 142 | Combi | Carlo |
| 168 | Rossignoli | Cecilia |
| 173 | Manca | Vincenzo | 
| 184 | Bonacina | Maria Paola | 

```sql
SELECT DISTINCT P.id, P.nome, P.cognome
FROM Persona AS P
JOIN Docenza AS D ON (P.id = D.id_persona)
JOIN InsErogato AS IE ON (D.id_inserogato = IE.id)
JOIN Insegn AS I ON (IE.id_insegn = I.id)
WHERE
    IE.annoaccademico = '2010/2011' 
    AND NOT EXISTS (
        SELECT 1 
        FROM Persona AS P_IN
        JOIN Docenza AS D_IN ON P_IN.id = D_IN.id_persona
        JOIN InsErogato AS IE_IN ON (D_IN.id_inserogato = IE_IN.id)
        JOIN Insegn AS I_IN ON (IE_IN.id_insegn = I_IN.id)
        WHERE 
            IE_IN.annoaccademico = '2009/2010' AND
            P_IN.id = P.id AND
            I_IN.nomeins = I.nomeins
    )
ORDER BY P.id;
```

## Esercizio 2 

Trovare i corsi di studio che non sono gestiti dalla facoltà di “Medicina e Chirurgia” e che hanno
insegnamenti
erogati con moduli nel 2010/2011. Si visualizzi il nome del corso e il numero di insegnamenti erogati con
moduli nel 2010/2011.

Soluzione: ci sono 33 righe. Le prime 5 ordinate rispetto al nome sono:

nome | numinsegn
 :-- | :--- 
Laurea IN Beni culturali | 5
Laurea IN Bioinformatica | 4
Laurea IN Biotecnologie | 12
Laurea IN Filosofia | 8
Laurea IN Informatica | 2

```sql
SELECT CS.nome, COUNT(DISTINCT IE.id) as NumInsegn
FROM InsErogato AS IE
JOIN CorsoStudi AS CS ON IE.id_corsostudi = CS.id
WHERE
    IE.annoaccademico = '2010/2011' AND
    IE.hamoduli = '1' AND
    IE.modulo = 0 AND
    CS.id NOT IN (
        SELECT CS_IN.id
        FROM InsErogato as IE_IN
        JOIN CorsoStudi as CS_IN ON IE_IN.id_corsostudi = CS_IN.id
        JOIN CorsoInFacolta as CIF_IN ON CS_IN.id = CIF_IN.id_corsostudi
        JOIN Facolta as F_IN ON CIF_IN.id_facolta = F_IN.id 
        WHERE
            F_IN.nome = 'Medicina e Chirurgia'
    )
GROUP BY CS.nome
ORDER BY CS.nome;
```

## Esercizio 3 

Trovare gli insegnamenti del corso di studi con id=4 che non sono mai stati offerti al secondo
quadrimestre.
Per selezionare il secondo quadrimestre usare la condizione "abbreviazione LIKE '2%'".

La soluzione ha 14 righe.

```sql
SELECT I.nomeins
FROM InsErogato AS IE 
JOIN Insegn AS I ON (IE.id_insegn = I.id)
JOIN CorsoStudi AS CS ON (IE.id_corsostudi = CS.id)
WHERE
    CS.id = 4
    
EXCEPT 

SELECT I.nomeins
FROM InsErogato AS IE
JOIN Insegn AS I ON (IE.id_insegn = I.id)
JOIN CorsoStudi AS CS ON (IE.id_corsostudi = CS.id)
JOIN InsInPeriodo AS IP ON IE.id = IP.id_inserogato
JOIN PeriodoLez AS PL ON IP.id_periodolez = PL.id
WHERE 
    CS.id = 4 AND
    PL.abbreviazione LIKE '2%';
```

## Esercizio 4

Trovare il nome dei corsi di studio che non hanno mai erogato insegnamenti che contengono nel nome la stringa ’matematica’ (usare ILIKE invece di LIKE per rendere il test non sensibile alle
maiuscole/minuscole (case-insensitive)).

La soluzione ha 572 righe.

```sql
SELECT CS.nome 
FROM CorsoStudi AS CS

EXCEPT 

SELECT DISTINCT CS.nome 
FROM InsErogato AS IE 
JOIN CorsoStudi AS CS ON (IE.id_corsostudi = CS.id)
JOIN Insegn AS I ON (IE.id_insegn = I.id)
WHERE  
    I.nomeins ILIKE '%matematica%';
```
## Esercizio 5

Trovare nome, cognome e telefono dei docenti che hanno tenuto nel 2009/2010 un’occorrenza di
insegnamento che non sia un’unità logistica del corso di studi con id=4 ma che non hanno mai tenuto un
modulo dell’insegnamento di ’Programmazione’ del medesimo corso di studi.

La soluzione ha 5 righe:

nome | cognome | telefono
| :--- | :--- | :--- | 
Alberto | Belussi | 045 802 7980
Vincenzo | Manca | 045 802 7981
Angelo | Pica |
Graziano | Pravadelli | +39 045 802 7081
Roberto | Segala | 045 802 7997

```sql
SELECT P.nome, P.cognome, P.telefono
FROM Docenza AS D 
JOIN InsErogato AS IE ON D.id_inserogato = IE.id
JOIN Persona AS P ON D.id_persona = P.id 
JOIN CorsoStudi AS CS ON IE.id_corsostudi = CS.id
WHERE
    IE.annoaccademico = '2009/2010' AND
    IE.modulo = 0 AND 
    CS.id = 4 
    
EXCEPT 

SELECT P.nome, P.cognome, P.telefono
FROM Docenza AS D 
JOIN InsErogato AS IE ON D.id_inserogato = IE.id
JOIN Persona AS P ON D.id_persona = P.id 
JOIN CorsoStudi AS CS ON IE.id_corsostudi = CS.id
JOIN Insegn AS I ON IE.id_insegn = I.id 
WHERE
    IE.modulo = 0 AND 
    CS.id = 4 AND 
    I.nomeins = 'Programmazione';
```

## Esercizio 6

Trovare, per ogni facoltà, il numero di unità logistiche erogate (modulo < 0) e il numero corrispondente di
crediti totali erogati nel 2010/2011, riportando il nome della facoltà e i conteggi richiesti. Usare pure la relazione diretta tra InsErogato e Facolta.

La soluzione ha 8 righe. 
La riga relativa a ’Medicina e Chirurgia’ ha valori 253 e 979,50.

```sql
SELECT F.nome, COUNT(IE.id) as NumUnita, SUM(IE.crediti) as TotCrediti
FROM InsErogato AS IE 
JOIN Facolta AS F ON IE.id_facolta = F.id 
WHERE
    IE.annoaccademico = '2010/2011' AND 
    IE.modulo < 0 
GROUP BY F.nome;
```

## Esercizio 7

Trovare, per ogni facoltà, il docente che ha tenuto il numero massimo di ore di lezione nel 2009/2010,
riportando il cognome e il nome del docente e la facoltà. Per la relazione tra InsErogato e Facolta usare la
relazione diretta.

La soluzione ha 10 righe.

cognome | nome | facolta | oretot
| :--- | :--- | :--- | :--- | 
Babbi | Anna Maria | Lingue e letterature straniere | 144.000
Bartolozzi | Pietro | Medicina e Chirurgia | 411.000
Battistelli | Adalgisa | Scienze motorie | 144.000
Brunetti | Federico | Economia | 202.000
De Lotto | Cinzia | Lingue e letterature straniere | 144.000
Pedrazza Gorlero | Maurizio | Giurisprudenza | 158.000
Peruzzi | Enrico | Lettere e filosofia | 150.000
Pescatori | Sergio | Lingue e letterature straniere | 144.000
Sala | Gabriel Maria | Scienze della formazione | 245.000
Spera | Mauro | Scienze matematiche fisiche e naturali | 169.000

```sql
-- CREO UNA VISTA
CREATE TEMP VIEW SumOreDoc (cognome, nome, nomef, OreTot) AS
SELECT 
    P.cognome, 
    P.nome, 
    F.nome, 
    SUM(D.orelez) AS OreTot
FROM Docenza AS D 
JOIN Persona AS P ON D.id_persona = P.id 
JOIN InsErogato AS IE ON D.id_inserogato = IE.id 
JOIN Facolta AS F ON IE.id_facolta = F.id 
WHERE
    IE.annoaccademico = '2009/2010' AND
    IE.modulo = 0
GROUP BY P.cognome, P.nome, F.nome;

-- ESEGUO LA QUERY
SELECT 
    S.cognome, 
    S.nome, 
    S.nomef, 
    S.OreTot
FROM SumOreDoc AS S
WHERE 
    S.OreTot = (
        SELECT MAX(S_IN.OreTot) 
        FROM SumOreDoc AS S_IN
        WHERE 
            S.nomef = S_IN.nomef
    )
ORDER BY cognome, nomef;
```

## Esercizio 8 

Trovare gli insegnamenti (esclusi i moduli e le unità logistiche) del corso di studi con id=240 erogati nel 2009/2010 e nel 2010/2011 che hanno avuto almeno un docente ma che non hanno avuto docenti di nome 'Roberto', 'Alberto', 'Massimo' o 'Luca' in entrambi gli anni accademici, riportando il nome, il discriminante dell'insegnamento, ordinati per nome insegnamento.

La soluzione ha 22 righe. Le cinque a partire dalla XV riga sono:

nomeins | discriminante
| :--- | :--- 
Medicina interna (V anno ) | -
Patologia e clinica delle endocrinopatie (IV anno ) | -
Patologia e clinica delle endocrinopatie (V anno ) | -
Patologia e clinica delle malattie del ricambio (IV anno ) | -
Patologia e clinica delle malattie del ricambio (V anno ) | -

```sql
SELECT I.nomeins, DIS.descrizione
FROM InsErogato AS IE 
JOIN Discriminante AS DIS ON IE.id_discriminante = DIS.id 
JOIN Insegn AS I ON I.id = IE.id_insegn
JOIN CorsoStudi AS CS ON IE.id_corsostudi = CS.id
JOIN Docenza AS D ON D.id_inserogato = IE.id
JOIN Persona AS P ON D.id_persona = P.id 
WHERE
    P.nome NOT IN
        ('Luca', 'Alberto', 'Massimo', 'Roberto') AND 
    CS.id = 240 AND 
    IE.modulo = 0 AND 
    IE.annoaccademico = '2009/2010'
    
INTERSECT

SELECT I.nomeins, DIS.descrizione
FROM InsErogato AS IE 
JOIN Discriminante AS DIS ON IE.id_discriminante = DIS.id
JOIN Insegn AS I ON IE.id_insegn = I.id
JOIN CorsoStudi AS CS ON IE.id_corsostudi = CS.id
JOIN Docenza AS D ON D.id_inserogato = IE.id
JOIN Persona AS P ON D.id_persona = P.id 
WHERE
    P.nome NOT IN
        ('Luca', 'Alberto', 'Massimo', 'Roberto') AND 
    CS.id = 240 AND 
    IE.modulo = 0 AND 
    IE.annoaccademico = '2010/2011'
ORDER BY nomeins;
```

## Esercizio 9

Trovare le unità logistiche del corso di studi con id=420 erogati nel 2010/2011 e che hanno lezione o
il lunedì (Lezione.giorno=2) o il martedì (Lezione.giorno=3), ma non in entrambi i giorni, riportando
il nomedell’insegnamento e il nome dell’unità ordinate per nome insegnamento.

La soluzione ha 8 righe:

nomeins | nomeunita
--- | --- 
Algoritmi | Teoria
Architettura degli elaboratori | Laboratorio
Architettura degli elaboratori | Teoria
Basi di dati | Laboratorio
Programmazione I | Laboratorio
Programmazione I | Teoria
Sistemi operativi | Laboratorio
Sistemi operativi | Teoria

```sql
-- SBAGLIATO 
SELECT I.nomeins, IE.nomeunita
FROM InsErogato as IE 
JOIN Insegn as I ON IE.id_insegn = I.id
JOIN CorsoStudi as CS ON IE.id_corsostudi = CS.id
JOIN Lezione as L ON L.id_inserogato = IE.id 
WHERE
    CS.id = 420 AND 
    IE.annoaccademico = '2010/2011' AND
    IE.modulo < 0 AND 
    L.giorno IN (2, 3)
GROUP BY IE.id, nomeins, nomeunita
    
EXCEPT 

(
SELECT I.nomeins, IE.nomeunita
FROM InsErogato as IE 
JOIN Insegn as I ON IE.id_insegn = I.id
JOIN CorsoStudi as CS ON IE.id_corsostudi = CS.id
JOIN Lezione as L ON L.id_inserogato = IE.id 
WHERE
    CS.id = 420 AND 
    IE.annoaccademico = '2010/2011' AND
    IE.modulo < 0 AND 
    L.giorno = 2 
GROUP BY IE.id, nomeins, nomeunita

INTERSECT 

SELECT I.nomeins, IE.nomeunita
FROM InsErogato as IE 
JOIN Insegn as I ON IE.id_insegn = I.id
JOIN CorsoStudi as CS ON IE.id_corsostudi = CS.id
JOIN Lezione as L ON L.id_inserogato = IE.id 
WHERE
    CS.id = 420 AND 
    IE.annoaccademico = '2010/2011' AND
    IE.modulo < 0 AND 
    L.giorno = 3
GROUP BY IE.id, nomeins, nomeunita
)
ORDER BY nomeins;
```

VIA CORRETTA (GEMINATO): 
```sql
SELECT I.nomeins, IE.nomeunita
FROM InsErogato as IE
JOIN Insegn as I ON IE.id_insegn = I.id
JOIN CorsoStudi as CS ON IE.id_corsostudi = CS.id
JOIN Lezione as L ON L.id_inserogato = IE.id
WHERE
    CS.id = 420 AND
    IE.annoaccademico = '2010/2011' AND
    IE.modulo < 0 AND
    L.giorno IN (2, 3)
GROUP BY IE.id, nomeins, nomeunita
HAVING COUNT(DISTINCT L.giorno) = 1
ORDER BY nomeins;
```

## Esercizio 10

Trovare gli insegnamenti in ordine alfabetico (esclusi moduli e unità logistiche) dei corsi di studi della
facoltà di ’Scienze Matematiche Fisiche e Naturali’ che sono stati tenuti dallo stesso docente per due anni
accademici consecutivi riportando id, nome dell’insegnamento e id, nome, cognome del docente. 

Per la relazione tra InsErogato e Facolta non usare la relazione diretta. Circa la condizione sull’anno
accademico, dopo aver estratto una sua opportuna parte, si può trasformare questa in un intero e, quindi,
usarlo per gli opportuni controlli. Oppure si può usarla direttamente confrontandola con un’opportuna
parte dell’altro anno accademico.

La soluzione ha 544 righe. Le ultime 5 sono:

id | - | - | - | -
--- | --- | --- | --- | --- 
321 | Viticoltura III | 119 | Claudio | Giulivo
4068 | Viticoltura e territorio | 3937 | Maurizio | Boselli 
4087 | Viticoltura generale | 3937 | Maurizio | Boselli
5648 | Web semantico | 62 | Matteo | Cristani

```sql
SELECT DISTINCT I.id, I.nomeins, P.id, P.nome, P.cognome
FROM InsErogato as IE
JOIN Insegn as I ON IE.id_insegn = I.id
JOIN Docenza as D on D.id_inserogato = IE.id
JOIN Persona as P on D.id_persona = P.id
JOIN CorsoInFacolta as CF on CF.id_corsostudi = IE.id_corsostudi
JOIN Facolta as F on CF.id_facolta = F.id
WHERE
    F.nome = 'Scienze matematiche fisiche e naturali' AND
    IE.modulo = 0 AND
    EXISTS
    (
        SELECT 1
        FROM InsErogato as IE_IN
        JOIN Insegn as I_IN ON IE_IN.id_insegn = I_IN.id
        JOIN Docenza as D_IN on D_IN.id_inserogato = IE_IN.id
        JOIN Persona as P_IN on D_IN.id_persona = P_IN.id
        JOIN CorsoInFacolta as CF_IN on CF_IN.id_corsostudi = IE_IN.id_corsostudi
        JOIN Facolta as F_IN on CF_IN.id_facolta = F_IN.id
        WHERE
            IE_IN.modulo = 0 AND
            F.id = F_IN.id AND
            P.id = P_IN.id AND
            I.id = I_IN.id AND
            CAST(SUBSTRING(IE.annoaccademico, 6, 4) as INT) = CAST(SUBSTRING(IE_IN.annoaccademico, 6, 4) as INT) + 1
    )
ORDER BY nomeins;
```

## Esercizio 11

Trovare per ogni docente il numero di insegnamenti o moduli o unità logistiche a lui assegnate come docente
nell’anno accademico 2005/2006, riportare anche coloro che non hanno assegnato alcun insegnamento.
Nel risultato si mostri identificatore, nome e cognome del docente insieme al conteggio richiesto (0 per il caso nessun insegnamento/modulo/unità insegnati).

La soluzione ha 3315 righe.
