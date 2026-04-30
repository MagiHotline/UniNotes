# Laboratorio Basi di Dati LEZIONE 2

Eseguire i seguenti esercizi usando la propria base di dati dove sono state inserite [le tabelle relative ai musei, opere e mostre.](<lezione1#Esercizio 2>)

## Esercizio 1 

Visualizzare tutti i musei della città di Verona con il loro giorno di chiusura.

```sql 
SELECT nome, giornochiusura
FROM MUSEO  
WHERE città = 'Verona';
```

## Esercizio 2  

Visualizzare per ogni mostra che inizia con la lettera ’R’, una stringa composta dal titolo e dalla città in cui
si svolge.

```sql
SELECT titolo || ', ' || cittamuseo AS info_mostra
FROM MOSTRA
WHERE titolo LIKE 'R%';
```

## Esercizio 3

Visualizzare il titolo di ogni mostra ancora in corso e quanti giorni rimane ancora aperta a partire dalla data
corrente. Usare la costante CURRENT_DATE per avere la data corrente.

```sql
SELECT titolo, (fine - CURRENT_DATE) as giorni_rimanenti
FROM MOSTRA
WHERE CURRENT_DATE < fine;
```

## Esercizio 4 

Visualizzare per ogni museo l’orario di apertura e chiusura il martedì. 
Se per un museo il martedì è giorno di chiusura, non mostrare nulla.

```sql
SELECT orarioapertura, orariochiusura 
FROM ORARIO AS O JOIN MUSEO AS M 
ON (M.nome = O.nomemuseo AND M.città = O.cittamuseo)
WHERE O.giorno = 'Martedì' AND M.giornochiusura <> 'Martedì';
```

## Esercizio 5
Assicurarsi che almeno una mostra abbia il prezzo ridotto non valorizzato (NULL) usando eventualmente il
comando UPDATE per modificare almeno una riga.
Visualizzare tutte le mostre che hanno prezzo ridotto non valorizzato usando prima l’espressione ERRATA
’prezzoRidotto = NULL’ e poi l’espressione corretta prezzoRidotto IS NULL.

```sql
UPDATE Mostra
SET prezzoRidotto = NULL 
WHERE titolo = 'Rococo Veneziano';

SELECT * FROM Mostra
WHERE prezzoRidotto = NULL;

SELECT * FROM Mostra
WHERE prezzoRidotto IS NULL;
```

## Esercizio 6

Visualizzare tutte le mostre non terminate in ordine di data inizio e, in caso di pari data inizio, data fine.

```sql
SELECT * FROM Mostra
WHERE fine > CURRENT_DATE
ORDER BY inizio, fine;
```

## Esercizio 7

Visualizzare il numero totale di giorni di apertura del museo "Arena" di "Verona".

```sql
SELECT COUNT(*) as giorniApertura
FROM Orario JOIN Museo ON (Orario.nomemuseo = Museo.nome AND Orario.cittamuseo = Museo.città)
WHERE Museo.nome = 'Arena' AND Museo.città = 'Verona' AND Orario.giorno != Museo.giornochiusura;
```

## Esercizio 8

Visualizzare le ore medie di apertura del museo ’Arena’ di ’Verona’.
Suggerimento: convertire orarioapertura e orariochiusura usando ’::time’.

```sql
SELECT AVG(orariochiusura::time - orarioapertura::time) AS media_ore_apertura
FROM Orario
WHERE nomeMuseo = 'Arena' AND cittaMuseo = 'Verona';
```

## Esercizio 9

Indicare il numero di autori distinti presenti in tutti i musei.

```sql
SELECT DISTINCT cognomeautore, COUNT(cognomeautore) AS NumeroAutori
FROM Opera
GROUP BY cognomeautore;
```
