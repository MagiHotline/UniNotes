# Laboratorio Basi di Dati LEZIONE 1

## Esericizio 1

Scrivere il codice PostgreSQL che generi tutte le tabelle. Per gli attributi di cui non è
stato specificato il tipo, scegliere quello opportuno. Specificare tutti i vincoli possibili,
sia intra- sia inter-relazionali.

Creare un dominio per i giorni della settimana:

```sql
CREATE DOMAIN giorniSettimana AS CHARACTER VARYING (10) 
CHECK (VALUE IN ('Lunedì', 'Martedì', 'Mercoledì', 'Giovedì', 'Venerdì', 'Sabato', 'Domenica'));

CREATE DOMAIN GIORNO_MESE AS SMALLINT 
DEFAULT NULL CHECK (VALUE >= 1 AND VALUE <= 31);
```
Ora creiamo la tabella di Museo

```sql
CREATE TABLE Museo (
    nome CHARACTER VARYING(30),
    città CHARACTER VARYING(20),
    indirizzo CHARACTER VARYING(30), 
    numeroTelefono CHARACTER(10),
    giornoChiusura giorniSettimana, 
    prezzo NUMERIC(5,2),
    PRIMARY KEY(nome, città)
);
```
Creiamo la tabella Mostra:

```sql
CREATE TABLE Mostra (
    titolo CHARACTER VARYING (30),
    inizio DATE, 
    fine DATE,
    nomeMuseo CHARACTER VARYING(30),
    cittaMuseo CHARACTER VARYING(20),
    FOREIGN KEY(nomeMuseo, cittaMuseo) 
    REFERENCES Museo(nome, città),
    PRIMARY KEY(titolo, inizio)
);
```

Creiamo la tabella Opera:

```sql
CREATE TABLE Opera (
    nome CHARACTER VARYING (30),
    cognomeAutore CHARACTER VARYING (20),
    nomeAutore CHARACTER VARYING (20),
    nomeMuseo CHARACTER VARYING(30),
    cittaMuseo CHARACTER VARYING(20),
    epoca CHARACTER VARYING (30),
    anno SMALLINT,
    FOREIGN KEY(nomeMuseo, cittaMuseo) 
    REFERENCES Museo(nome, città),
    PRIMARY KEY(nome, cognomeAutore, nomeAutore)
);
```
Ora creiamo la tabella per Orario: 

```sql
CREATE TABLE Orario (
    progressivo INTEGER PRIMARY KEY,  
    nomeMuseo CHARACTER VARYING(30),
    cittaMuseo CHARACTER VARYING(20),
    giorno GIORNO_MESE,
    orarioApertura TIME WITH TIME ZONE, 
    orarioChiusura TIME WITH TIME ZONE,
    FOREIGN KEY(nomeMuseo, cittaMuseo) 
    REFERENCES Museo(nome, città)
);
```


## Esercizio 2

Inserire nell’entità Museo le seguenti tuple:

(Arena, Verona, piazza Bra, 045 8003204, martedì, 20),
(CastelVecchio, Verona, Corso Castelvecchio, 045 594734, lunedì, 15);

```sql
INSERT INTO Museo (nome, città, indirizzo, numeroTelefono, giornoChiusura, prezzo)
VALUES ('Arena', 'Verona', 'Piazza Bra', '0458003204', 'Martedì', 20), 
       ('CastelVecchio', 'Verona', 'Corso Castelvecchio', '045594734', 'Lunedì', 15);
```

## Esercizio 3 

Popolare le tabelle Opera e Mostra con almeno altre tre tuple ciascuna.

```sql
INSERT INTO Mostra (titolo, inizio, fine, nomemuseo, cittamuseo)
VALUES ('Van Gogh Notte', '2024-05-10', '2024-08-15', 'Arena', 'Verona'),
    ('Egitto Antico', '2024-01-20', '2024-04-30', 'CastelVecchio', 'Verona'),
    ('Bansky', '2025-01-01', '2025-01-02', 'Arena', 'Verona');
```

```sql 
INSERT INTO Opera (nome, cognomeautore, nomeautore, nomemuseo, cittamuseo, epoca, anno)
VALUES ('Pippo', 'Druta', 'Valeria', 'Arena', 'Verona', 'Rinascimento', 1600),
        ('Pluto', 'Druta', 'Valeria', 'Arena', 'Verona', 'Medioevo', 1200),
        ('Paperino', 'Imbriani', 'Paolo', 'CastelVecchio', 'Verona', 'Medioevo', 1203);
```

## Esercizio 4 

Provare ad inserire nella relazione Museo tuple che violino i vincoli specificati.

```sql
INSERT INTO Museo (nome, città, indirizzo, numeroTelefono, giornoChiusura, prezzo)
VALUES ('Arena', 'Verona', 'Nuovo Indirizzo', '045123456', 'Lunedì', 10);
```

## Esercizio 5 

Nell’entità Museo, aggiungere l’attributo sitoInternet e inserire gli opportuni valori.

```sql
ALTER TABLE Museo 
ADD COLUMN sitoInternet CHARACTER VARYING(50);
```

## Esercizio 6 

Nell’entità Mostra modificare l’attributo prezzo in prezzoIntero ed aggiungere l’attributo
prezzoRidotto con valore di default 5. Aggiungere il vincolo (di tabella o di attributo?)
che garantisca che Mostra.prezzoRidotto sia minore di Mostra.prezzoIntero.

```sql
ALTER TABLE Mostra 
ADD COLUMN prezzoRidotto NUMERIC(5,2) DEFAULT 5;

ALTER TABLE Mostra
ADD CONSTRAINT check_prezzi 
CHECK (prezzoRidotto < prezzoIntero);
```

## Esercizio 7

Nell’entità Museo aggiornare il prezzo aggiungendo 1 Euro alle tuple esistenti.

```sql
UPDATE Museo
SET prezzo = prezzo + 1;
```

## Esercizio 8

Nell’entità Mostra aggiornare il prezzoRidotto aumentandolo di 1 Euro per quelle
mostre che hanno prezzoIntero inferiore a 15 Euro.

```sql
UPDATE Mostra
SET prezzoRidotto = prezzoRidotto + 1 
WHERE prezzoIntero < 15;
```

## Esercizio 9

Si assume che in ciascuna tabella della base di dati ci siano almeno 3 righe inserite.
Implementare le chiavi esportate per ciascuna delle 4 politiche di reazione presentate
nella pagina precedente (usare il comando DROP CONTRAINTS e ADD CONSTRAINTS
per effettuare il cambio di politica). Provare ad eseguire una cancellazione ed un
aggiornamento dei valori riferiti (e dei valori non riferiti) per verificare il diverso
comportamento del DBMS.

```sql
-- NO ACTION
ALTER TABLE Opera ADD CONSTRAINT fk_opera_noaction 
FOREIGN KEY (nomeMuseo, cittaMuseo) REFERENCES Museo(nome, città)
ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ON CASCADE
ALTER TABLE Opera DROP CONSTRAINT fk_opera_noaction;
ALTER TABLE Opera ADD CONSTRAINT fk_opera_cascade 
FOREIGN KEY (nomeMuseo, cittaMuseo) REFERENCES Museo(nome, città)
ON DELETE CASCADE ON UPDATE CASCADE;


-- SET NULL 
ALTER TABLE Opera DROP CONSTRAINT fk_opera_cascade;
ALTER TABLE Opera ADD CONSTRAINT fk_opera_setnull 
FOREIGN KEY (nomeMuseo, cittaMuseo) REFERENCES Museo(nome, città)
ON DELETE SET NULL;

-- SET DEFAULT
ALTER TABLE Opera ALTER COLUMN nomeMuseo SET DEFAULT 'Arena'; 
ALTER TABLE Opera ALTER COLUMN cittaMuseo SET DEFAULT 'Verona';

ALTER TABLE Opera DROP CONSTRAINT fk_opera_setnull;
ALTER TABLE Opera ADD CONSTRAINT fk_opera_setdefault 
FOREIGN KEY (nomeMuseo, cittaMuseo) REFERENCES Museo(nome, città)
ON DELETE SET DEFAULT;
```
