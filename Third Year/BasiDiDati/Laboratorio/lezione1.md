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
VALUES ('Pippo', 'Druta', 'Valeria', 'Arena', 'Verona', )
