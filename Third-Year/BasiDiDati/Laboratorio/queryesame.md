# Esercizi aggiuntivi QUERY ESAME

## Tabelle

STUDENTE(_Matricola_, nome, dataNascita, CorsoDiLaurea)
APPELLO(_CodCorso_, _AnnoAccademico_, DataEsame, Aula)
ESITO(_CodCorso_, _AnnoAccademico_, _Matricola_, Docente, VotoFinale, Superato, CFU)

### Q1

Trovare studenti che hanno superato almeno 3 esami da 12 CFU

```sql
SELECT S.Matricola, S.nome
FROM STUDENTE S
JOIN ESITO E ON E.Matricola = S.Matricola
WHERE
    E.superato = True AND
    E.CFU = 12
GROUP BY S.Matricola, S.nome
HAVING COUNT(*) >= 3
```

### Q2

Trovare studenti che hanno preso 30 sia in BdD in aula T.01, sia in programmazione in aula Lab1

```sql
SELECT S.Matricola, S.nome
FROM Studente S
JOIN Esito E On E.Matricola = S.Matricola
JOIN Appello A ON (E.CodCorso = S.CodCorso AND E.AnnoAccademico = S.AnnoAccademico)
WHERE
    E.VotoFinale = 30 AND
    CodCorso = 'BdD' AND
    A.aula = 'T.01'

INTERSECT

SELECT S.Matricola, S.nome
FROM Studente S
JOIN Esito E On E.Matricola = S.Matricola
JOIN Appello A ON (E.CodCorso = S.CodCorso)
WHERE
    E.VotoFinale = 30 AND
    E.CodCorso = 'Programmazione' AND
    A.aula = 'Lab1'
```

### Q3

Trovare gli studenti che NON hanno sostenuto esami in corsi per i quali si sono tenuti
appelli in almeno 2 anni diversi

```sql
SELECT Matricola, Nome
FROM Studente
WHERE
    Matricola NOT IN
        (
            SELECT E.Matricola
            FROM Appello A
            JOIN Appello B ON (A.CodCorso = B.CodCorso AND A.AnnoAccademico = B.AnnoAccademico)
            JOIN Esito E ON E.CodCorso = A.CodCorso
        )
```

### Q4

Per ogni corso di laurea , estrarre lo studente che ha eseguito il maggior numero
totale di CFU ordinando il risultato in modo decrescente

```sql
CREATE VIEW Totali AS
    SELECT Matricola, SUM(CFU) AS CFUTotali
    FROM Esito
    WHERE Superato = 'True'
    GROUP BY Matricola

```

```sql
SELECT S.CorsoLaurea, S.Matricola, S.nome, T.CFUTotali
FROM Studente AS S
JOIN CFUTotali AS T ON (T.Matricola = S.Matricola)
WHERE CFUTotali = (SELECT MAX(CFUTotali
        FROM Studente AS S1
        JOIN Totali AS T1 ON (S1.Matricola = T1.Matricola
        WHERE S1.CorsoLaurea = S.CorsoLaurea)
ORDER BY T.CFUTotali DESC
```

### Q5

Trovare CodCorso/i che ha registrato il maggior numero di esiti falliti (superato = false)
in assoluto tra tutti gli anni A.A

```sql
MAX -> SUM(COUNT(*))

CREATE VIEW FallimentiPerCorso AS
    SELECT CodCorso, COUNT(*) AS NEsamiFalliti
    FROM Esito E
    WHERE
        Superato = False
    GROUP BY CodCorso

Linguaggi | 10
BasiDiDati | 13 ...

SELECT CodCorso
FROM FallimentiPerCorso
WHERE
    NEsamiFalliti = (SELECT MAX(NEsamiFalliti) FROM FallimentiPerCorso)
```

## Tabelle extra

AUTO(_Targa_, marca, modello, posti, inclinata)
NOLEGGIO(_Targa_, _cliente_, _inizio_, fine\*)
CLIENTE(_nPatente_, cognome, nome, paeseProvenienza, NInfrazioni)

### Q

Determinare marche d'auto che hanno il maggior numero di
noleggi conclusi. Visualizzare marca, num tot auto di quella marca,
num noleggi con auto di quella marca utilizzata.

```sql
CREATE VIEW NumeroDiParcheggiConclusi AS
    SELECT A.Marca, COUNT(DISTINCT A.Targa) AS NUMAUTO, COUNT(*) as TotNoleggiConclusi
    FROM NOLEGGIO N
    JOIN AUTO A ON (N.Targa = A.Targa)
    WHERE
        fine IS NOT NULL
    GROUP BY A.Marca
```

```sql
SELECT marca, numAuto, TotNoleggiConclusi
FROM NumeroDiParcheggiConclusi
WHERE
    TotNoleggiConclusi = (SELECT MAX(TotNoleggiConclusi) FROM NumeroDiParcheggiConclusi)
```

## Tabelle extra

```
DOCENTE(_matricola_, codice_fiscale, nome, cognome, data_nascita, posizione)
LEZIONE(_docente_, _insegnamento_, _data_ora_inizio_, data_ora_fine, aula)
INSEGNAMENTO(_codice_, titolo, CFU, anno_corso)
```

### Q1

Trovare num lezione x docente e insegnamento, riportando nome, cognome del docente,
num di lezione, data prima e ultima lezione, titolo dell'insegnamento,

```sql
SELECT D.nome, D.cognome, COUNT(*) as NUM_LEZIONI, MIN(L.data_ora_inizio), MAX(L.data_ora_inizio), I.codice
FROM Lezione L
JOIN Docente D ON (D.matricola = L.docente)
JOIN Insegnamento I ON (I.codice = L.insegnamento)
GROUP BY D.matricola, I.codice
```

Self-evaluation: Corretta al primo colpo

### Q2

Trovare tutti i docenti con posizione 'PO' che NON hanno
effettuato lezioni in aprile e maggio 2023 riportando
matricola, CF, nome, cognome, e data prima lezione da loro tenuta

```sql
SELECT D.matricola, D.cf, D.nome, D.cognome, MIN(data_ora_inizio)
FROM Docente D
JOIN Lezione L ON (D.matricola = L.docente)
WHERE
    D.posizione = 'Professore Ordinario' AND
    D.matricola NOT IN
        (SELECT L1.matricola
            FROM Lezione L1
            WHERE
                L1.data_ora_inizio BETWEEN '01/04/2023 00:00' AND '31/05/2026 23:59')
GROUP BY D.matricola
```
