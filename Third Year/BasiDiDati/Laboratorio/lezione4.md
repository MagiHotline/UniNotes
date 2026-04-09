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

```sql
SELECT *
FROM InsErogato AS IE 
JOIN CorsoStudi AS CS ON (IE.id_corsostudi = CS.id)
WHERE
    CS.id = 4 AND
    IE.modulo = 0 AND 
    NOT EXISTS (
        SELECT 1 
        FROM InsErogato AS IE_IN
        JOIN CorsoStudi AS CS_IN ON (IE_IN.id_corsostudi = CS_IN.id)
        WHERE
            CS_IN.id = 4 AND
            CS_IN.abbreviazione LIKE '2%'
    );
```
