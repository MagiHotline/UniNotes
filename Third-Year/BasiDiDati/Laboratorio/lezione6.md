# Lezione 6

Si considerino le tabelle create nell’esercitazione 1. Per ogni esercizio scrivere il dettaglio delle
transazioni richieste e commentare il livello d’isolamento scelto per garantire che le operazioni nelle
transazioni siano eseguite in modo corretto.

## Esercizio 1
Si assume che la tabella Museo possa essere aggiornata da applicazioni diverse, non sincronizzate fra
loro. Scrivere una transazione che aggiunga un museo e dimostrare cosa succede se due applicazioni
aggiungono lo stesso museo nello stesso istante usando lo schema della transazione proposta.

```sql
BEGIN;
INSERT INTO Museo (nome, città, indirizzo, numerotelefono, giornochiusura, prezzo, sitointernet)
VALUES ('Santamaria', 'Brescia', 'Via Caccaro 3', 
'12345678', 'lunedì', 10, 'fabio.com');
COMMIT;
```
- T1 BEGIN;
- T2 BEGIN;
- T1 
```sql
INSERT INTO Museo (nome, città, indirizzo, numerotelefono, giornochiusura, prezzo, sitointernet)
VALUES ('Santamaria', 'Brescia', 'Via Caccaro 3', 
'12345678', 'lunedì', 10, 'fabio.com');

INSERT 0 1
```
- T2 
```sql
INSERT INTO Museo (nome, città, indirizzo, numerotelefono, giornochiusura, prezzo, sitointernet)
VALUES ('Santamaria', 'Brescia', 'Via Caccaro 3', 
'12345678', 'lunedì', 10, 'fabio.com'); -- RESTA IN ATTESA

ERRORE:  un valore chiave duplicato viola il vincolo univoco "museo_pkey"
DETTAGLI: La chiave (nome, "città")=(Santamaria, Brescia) esiste già.
```
- T1 COMMIT;
- T2 COMMIT;


## Esercizio 2

Si assuma che una transazione deve visualizzare i prezzi dei musei di Verona che hanno parte
decimale diversa da 0 e, poi, aggiornare tali prezzi del 10% arrotondando alla seconda cifra decimale.
L’altra transazione (concorrente) deve aggiornare il prezzo dei musei di Verona aumentandoli del 10%
e arrotondando alla seconda cifra decimale.

```sql
BEGIN;
SELECT prezzo FROM Museo
WHERE ABS(prezzo) - ABS(FLOOR(prezzo)) <> 0;
UPDATE Museo
SET prezzo = ROUND(prezzo + prezzo * 0.10, 2)
WHERE ABS(prezzo) - ABS(FLOOR(prezzo)) <> 0;
COMMIT;
```

- T1 BEGIN;
- T2 BEGIN;
- T1
```sql
SELECT prezzo FROM Museo
WHERE ABS(prezzo) - ABS(FLOOR(prezzo)) <> 0;
```
- T2 
```sql
SELECT prezzo FROM Museo
WHERE ABS(prezzo) - ABS(FLOOR(prezzo)) <> 0;
```
- T1
```sql
UPDATE Museo
SET prezzo = ROUND(prezzo + prezzo * 0.10, 2)
WHERE ABS(prezzo) - ABS(FLOOR(prezzo)) <> 0;
COMMIT;

UPDATE 0
```
- T2 
```sql
UPDATE Museo
SET prezzo = ROUND(prezzo + prezzo * 0.10, 2)
WHERE ABS(prezzo) - ABS(FLOOR(prezzo)) <> 0;
COMMIT;

UPDATE 0
```

## Esercizio 3

In una transazione si deve inserire una nuova mostra al museo di Castelvecchio di Verona con prezzo
d’ingresso a 40 euro e prezzo ridotto a 20. Nell’altra transazione (concorrente) si deve calcolare il
prezzo medio delle mostre di Verona prima considerando solo i prezzi ordinari e, in un’interrogazione
separata, considerando solo i prezzi ridotti.

- T1 BEGIN;
- T2 BEGIN;
- T1 
```sql
INSERT INTO Mostra (titolo, inizio, fine, museo, città, prezzointero, prezzoridotto)
VALUES ('Skibibitoilet', '2022-02-02', '2027-02-02', 'Castelvecchio', 'Verona', 40, 20);

INSERT 0 1
```
- T2 
```sql
SELECT AVG(prezzointero) 
FROM Mostra 
WHERE 
    Mostra.città = 'Verona';
    
         avg         
---------------------
 10.0000000000000000
```
- T1 COMMIT;
- T2 
```sql
SELECT AVG(prezzoridotto) 
FROM Mostra 
WHERE 
    Mostra.città = 'Verona';

    avg         
---------------------
13.0000000000000000
```

## Esercizio 4

In una transazione si deve aumentare il prezzo intero di tutte le mostre di Verona del 10% mentre,
nell’altra, si devono ridurre i prezzi ridotti di tutte le mostre del 5%. In entrambi i casi, l’importo finale si
deve arrotondare alla seconda cifra decimale.

- T1 BEGIN;
- T2 BEGIN;
- T1 
```sql
UPDATE Mostra
SET prezzointero = ROUND(prezzointero + (prezzointero * 0.10),2)
WHERE 
    Mostra.città = 'Verona';
```
- T1 COMMIT;
- T2 
```sql 
UPDATE Mostra
SET prezzoridotto = ROUND(prezzoridotto - (prezzoridotto * 0.05), 2);
```
- T2 COMMIT;

## Esercizio 5

In una transazione, calcolare la media dei prezzi dei musei di Vicenza ed aggiungere un nuovo museo a
Verona (’Museo moderno’) con prezzo uguale alla media calcolata. In un’altra transazione calcolare la
media dei prezzi dei musei di Verona e aggiungere un nuovo museo a Vicenza con prezzo uguale alla
media calcolata sui musei di Verona.
Si segnala che:
1. Con SELECT si possono anche creare colonne con valori costanti.
Esempio: SELECT ’Museo Moderno’, ’Verona’, ecc FROM ...
2. INSERT accetta di inserire anche risultati ottenuti da SELECT interne.
Esempio: INSERT INTO Museo (nome, citta, ...) SELECT ’Museo Moderno’, ’Verona’, ... FROM..

- T1 BEGIN;
- T2 BEGIN;
- T1 
```sql
SELECT AVG(prezzo)
FROM Museo
WHERE
    Museo.città = 'Vicenza';

         avg         
---------------------
 10.0000000000000000
(1 riga)
```
- T2 
```sql
SELECT AVG(prezzo)
FROM Museo
WHERE
    Museo.città = 'Verona';

         avg         
---------------------
 13.0000000000000000
(1 riga)
```
- T1
```sql
INSERT INTO Museo (nome, città, indirizzo, numerotelefono, giornochiusura, prezzo, sitointernet)
SELECT 'Museo moderno', 'Veronas', 'Via Caccaro 23', 
'12345678', 'lunedì', (SELECT AVG(prezzo) FROM Museo WHERE Museo.città = 'Vicenza'), 'fabio.com';

INSERT 0 1
```
- T1 COMMIT;
- T2 
```sql
INSERT INTO Museo (nome, città, indirizzo, numerotelefono, giornochiusura, prezzo, sitointernet)
SELECT 'Laringoiatra', 'Vicenza', 'Via Caccaro 23', 
'12345678', 'lunedì', (SELECT AVG(prezzo) FROM Museo WHERE Museo.città = 'Verona'), 'fabio.com';

INSERT 0 1
```
- T2 COMMIT;
