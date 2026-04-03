# Lezione 3

- [Esercizi](#esercizi)
  - [Esercizio 1](#esercizio-1)
  - [Esercizio 2](#esercizio-2)
  - [Esercizio 3](#esercizio-3)
  - [Esercizio 4](#esercizio-4)
  - [Esercizio 5](#esercizio-5)
  - [Esercizio 6](#esercizio-6)
  - [Esercizio 7](#esercizio-7)
  - [Esercizio 8](#esercizio-8)
  - [Esercizio 9](#esercizio-9)
  - [Esercizio 10](#esercizio-10)
  - [Esercizio 11](#esercizio-11)
  - [Esercizio 12](#esercizio-12)
  - [Esercizio 13](#esercizio-13)
  - [Esercizio 14](#esercizio-14)
  - [Esercizio 15](#esercizio-15)
  - [Esercizio 16](#esercizio-16)
  - [Esercizio 17](#esercizio-17)
  - [Esercizio 18](#esercizio-18)

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

Visualizzare il numero di corso studi presenti nella base di dati.
Soluzione: ci sono 635 corsi di studio.

```sql
SELECT COUNT(*)
FROM corsostudi
GROUP BY id;
```

## Esercizio 2 

Visualizzare il nome, il codice, l’indirizzo e l’identificatore del preside di tutte le facoltà.

```sql 
SELECT P.nome, F.codice, F.indirizzo, P.id
FROM Facolta as F JOIN Persona as P ON (F.id_persona_preside = P.id);
```

Soluzione: ci sono 8 facoltà.

## Esercizio 3 

Trovare per ogni corso di studi che ha erogato insegnamenti nel 2010/2011 il suo nome e il nome delle facoltà che lo gestiscono (si noti che un corso può essere gestito da più facoltà). Non usare la relazione diretta tra InsErogato e Facoltà. Porre i risultati in ordine di nome corso studi.

Soluzione: ci sono 211 righe. Le 5 righe dalla X posizione sono:

| nome | nome |
| :--- | :--- |
| Corso di Perfezionamento IN Traumatologia dentale | Medicina e Chirurgia |
| Laurea IN Beni culturali | Lettere e filosofia |
| Laurea IN Bioinformatica | Scienze matematiche fisiche e naturali |
| Laurea IN Bioinformatica (ordinamento fino ALL’a.a. 2008/09) | Scienze matematiche fisiche e naturali |
| Laurea IN Biotecnologie | Scienze matematiche fisiche e naturali |

```sql
SELECT C.nome, F.nome 
FROM InsErogato as I 
JOIN CorsoInFacolta as CF ON (I.id_corsostudi = CF.id_corsostudi) 
JOIN CorsoStudi as C ON (I.id_corsostudi = C.id)
JOIN Facolta as F ON (CF.id_facolta = F.id)
WHERE I.annoaccademico = '2010/2011'
GROUP BY (C.nome, F.nome);
```

## Esercizio 4

Visualizzare il nome, il codice e l’abbreviazione di tutti i corsi di studio gestiti dalla facoltà di Medicina e Chirurgia.

Soluzione: ci sono 236 righe.

```sql
SELECT C.nome, C.codice, C.abbreviazione
FROM CorsoInFacolta as CF
JOIN Facolta as F ON (CF.id_facolta = F.id)
JOIN CorsoStudi as C ON (CF.id_corsostudi = C.id)
WHERE F.nome = 'Medicina e Chirurgia';
```

## Esercizio 5

Visualizzare il codice, il nome e l’abbreviazione di tutti corsi di studio che nel nome contengono la
sottostringa ’lingue’ (eseguire il confronto usando ILIKE invece di LIKE: in questo modo i caratteri
maiuscolo e minuscolo non sono diversi).
Soluzione: ci sono 16 righe.

```sql
SELECT C.codice, C.nome, C.abbreviazione 
FROM CorsoStudi as C
WHERE nome ILIKE '%lingue%';
```

## Esercizio 6

Visualizzare le sedi dei corsi di studi in un elenco senza duplicati.
Soluzione: ci sono 48 righe.

```sql
SELECT DISTINCT C.sede 
FROM CorsoStudi;
```

## Esercizio 7 

Visualizzare solo i moduli degli insegnamenti erogati nel 2010/2011 nei corsi di studi della facoltà di
Economia.
Si visualizzi il nome dell’insegnamento, il discriminante (attributo descrizione della tabella Discriminante),
il nome del modulo e l’attributo modulo.

Soluzione: ci sono 27 righe.

```sql
SELECT I.nomeins, D.descrizione, InsErogato.nomemodulo, InsErogato.modulo
FROM InsErogato
JOIN Insegn as I ON (InsErogato.id_insegn = I.id)
JOIN Discriminante as D ON (InsErogato.id_discriminante = D.id)
JOIN CorsoFacolta as CF
ON (CF.id_corsostudi = InsErogato.id_corsostudi)
JOIN Facolta AS F 
ON (CF.id_facolta = F.id)
WHERE F.nome = 'Economia' AND InsErogato.annoaccademico = '2010/2011'
AND InsErogato.modulo > 0; -- Questo perché i moduli > 0 descrivono i singoli moduli
```

## Esercizio 8

Visualizzare il nome e il discriminante (attributo descrizione della tabella Discriminante) degli
insegnamenti erogati nel 2009/2010 che non sono moduli e che hanno 3, 5 o 12 crediti. Si ordini il
risultato per discriminante.

Soluzione: ci sono 724 righe distinte. Le ultime 5 righe sono:

| nomeins | discriminante |
| :--- | :--- |
| Prova finale | CInt | 
| Laboratorio di composizione italiana | Cognomi A-K |
| Biologia | Cognomi A-L
| Laboratorio di composizione italiana | Cognomi L-Z | 
| Biologia | Cognomi M-Z

```sql
SELECT DISTINCT I.nomeins, D.descrizione 
FROM InsErogato as IE
JOIN Discriminante as D
ON (IE.id_discriminante = D.id)
JOIN Insegn as I
ON (IE.id_insegn = I.id)
WHERE IE.annoaccademico = '2009/2010'
AND IE.crediti IN (3,5,12)
AND IE.modulo = 0
ORDER BY D.descrizione;
```

## Esercizio 9 

Visualizzare l’identificatore, il nome e il discriminante degli insegnamenti erogati nel 2008/2009 che non
sono moduli o unità logistiche e con peso maggiore di 9 crediti. Ordinare per nome.
Soluzione: ci sono 1218 righe. 

Le 5 righe dalla MXXIII riga sono:

| id | nomeins | discriminante |
| :--- | :--- | :--- |
| 39872 | Storia del diritto medievale e moderno | Matricole pari |
| 44440 | Storia del diritto medievale e moderno | Matricole dispari |
| 39724 | Storia del diritto medievale e moderno | Matricole pari |
| 44428 | Storia del diritto medievale e moderno | Matricole dispari |
| 44441 | Storia del diritto medievale e moderno | Matricole dispari |

```sql
SELECT I.id, I.nomeins, D.descrizione
FROM InsErogato as IE 
JOIN Insegn AS I 
ON (IE.id_insegn = I.id)
JOIN Discriminante AS D
ON (IE.id_discriminante = D.id)
WHERE IE.annoaccademico = '2008/2009'
AND IE.crediti > 9
AND IE.modulo = 0 
ORDER BY I.nomeins;
```

## Esercizio 10 

Visualizzare in ordine alfabetico di nome degli insegnamenti (esclusi i moduli e le unità logistiche) erogati
nel 2010/2011 nel corso di studi in Informatica, riportando il nome, il discriminante, i crediti e gli anni di
erogazione.

Soluzione: ci sono 26 righe.

```sql
SELECT I.nomeins, D.descrizione, IE.crediti, IE.annierogazione
FROM InsErogato AS IE
JOIN Insegn AS I ON (IE.id_insegn = I.id)
JOIN Discriminante AS D ON (IE.id_discriminante = D.id)
JOIN CorsoInFacolta as CF ON (CF.id_corsostudi = IE.id_corsostudi)
JOIN CorsoStudi as C ON (CF.id_corsostudi = C.id)
WHERE 
    IE.annoaccademico = '2010/2011' AND
    C.nome = 'Laurea in Informatica' AND
    IE.modulo = 0
ORDER BY I.nomeins;
```

## Esercizio 11

Trovare il massimo numero di crediti associato a un insegnamento fra quelli erogati nel 2010/2011.

Soluzione: 180

```sql
SELECT MAX(IE.crediti)
FROM InsErogato AS IE 
WHERE IE.annoaccademico = '2010/2011';
```

## Esercizio 12 

Trovare, per ogni anno accademico, il massimo e il minimo numero di crediti erogati tra gli insegnamenti
dell’anno.

Soluzione: ci sono 16 righe.

```sql
SELECT IE.annoaccademico, MAX(IE.crediti) as MaxCrediti, MIN(IE.crediti) as MinCrediti
FROM InsErogato as IE
GROUP BY IE.annoaccademico;
```

## Esercizio 13

Trovare, per ogni anno accademico e per ogni corso di studi la somma dei crediti erogati (esclusi i moduli e
le unità logistiche: vedi nota sopra) e il massimo e minimo numero di crediti degli insegnamenti erogati
sempre escludendo i moduli e le unità logistiche.


Soluzione: ci sono 1587 righe. Le riga relativa alla "Scuola di Specializzazione in Urologia (Vecchio
ordinamento)" nell’anno 2011/2012 ha valori 52.00, 10.00 e 162.00.

```sql
SELECT 
    IE.annoaccademico, C.nome, 
    MAX(IE.crediti) as MaxCrediti, 
    MIN(IE.crediti) as MinCrediti,
    SUM(IE.crediti) as SommaCrediti
FROM InsErogato AS IE
JOIN CorsoStudi AS C ON (IE.id_corsostudi = C.id)
WHERE IE.modulo = 0
GROUP BY (IE.annoaccademico, C.nome);
```

## Esercizio 14

Trovare per ogni corso di studi della facoltà di Scienze Matematiche Fisiche e Naturali il numero di
insegnamenti (esclusi i moduli e le unità logistiche) erogati nel 2009/2010.

Soluzione: ci sono 19 righe.

```sql
SELECT C.nome, COUNT(*) AS NumeroInsegnamenti
FROM InsErogato AS IE
JOIN CorsoInFacolta AS CF ON (CF.id_corsostudi = IE.id_corsostudi)
JOIN Facolta AS F ON (CF.id_facolta = F.id)
JOIN CorsoStudi AS C ON (CF.id_corsostudi = C.id)
WHERE 
    IE.annoaccademico = '2009/2010' AND
    IE.modulo = 0 AND
    F.nome = 'Scienze matematiche fisiche e naturali'
GROUP BY C.nome;
```

## Esercizio 15
Trovare i corsi di studi che nel 2010/2011 hanno erogato insegnamenti con un numero di crediti pari a 4 o
6 o 8 o 10 o 12 o un numero di crediti di laboratorio tra 10 e 15 escluso, riportando il nome del corso di
studi e la sua durata. Si ricorda che i crediti di laboratorio sono rappresentati dall’attributo creditilab della
tabella InsErogato.

Soluzione: ci sono 197 righe.

```sql
SELECT DISTINCT C.nome, C.durataAnni
FROM InsErogato AS IE 
JOIN CorsoStudi AS C
ON (IE.id_corsostudi = C.id)
WHERE
    (IE.crediti IN (4,6,8,10,12) OR
    IE.creditilab BETWEEN 10 AND 14) AND
    IE.annoaccademico = '2010/2011';
```

## Esercizio 16

Trovare nome, cognome dei docenti che nell’anno accademico 2010/2011 erano docenti in almeno due
corsi di studio (vale a dire erano docenti in almeno due insegnamenti o moduli A e B dove A è del corso C1
e B è del corso C2 con C1 <> C2).

La soluzione ha 839 righe. Se si ordina la risposta per un opportuno attributo, le 5 righe a partire dalla 50-
esima sono:

| id | nome | cognome |
| :--- | :--- | :--- |
| 268 | Paolo | Roffia |
| 269 | Andrea | Lionzo | 
| 270 | Corrado | Corsi |
| 278 | Alessandro | Lai |
| 280 | Giuseppe | Ceriani |

```sql
SELECT DISTINCT P.id, P.nome, P.cognome
FROM InsErogato as IE 
JOIN Docenza as D ON D.id_inserogato = IE.id
JOIN Persona as P ON D.id_persona = P.id 
WHERE 
    IE.annoaccademico = '2010/2011'
GROUP BY P.id, P.nome, P.cognome
HAVING COUNT(DISTINCT D.id_inserogato) > 1 AND
    COUNT(DISTINCT IE.id_corsostudi) > 1
ORDER BY P.id;
```

## Esercizio 17

Trovare per ogni periodo di lezione del 2010/2011 la cui descrizione inizia con ’I semestre’ o ’Primo
semestre’ il numero di occorrenze di insegnamento allocate in quel periodo. Si visualizzi quindi:
l’abbreviazione, il discriminante, inizio, fine e il conteggio richiesto ordinati rispetto all’inizio e fine.

La soluzione ha 3 righe:

| abbreviazione | discriminante | inizio | fine | insprimosem |
| :--- | :--- | :--- | :--- | :--- |
| Primo semestre | eco | 2010 -10 -04 | 2010 -12 -22 | 104 |
| Primo semestre | Primo semestre | 2010 -10 -04 | 2011 -01 -22 | 124 |
| I semestre | I semestre | 2010 -10 -04 | 2011 -01 -31 | 159 |

```sql
SELECT PL.abbreviazione, PD.discriminante,
    PD.inizio, PD.fine, COUNT(IE.id) as insprimosem
FROM PeriodoDid as PD
JOIN PeriodoLez as PL ON PD.id = PL.id
JOIN InsInPeriodo as IP ON PL.id = IP.id_periodolez
JOIN InsErogato as IE ON IE.id = IP.id_inserogato
WHERE
    PD.annoaccademico = '2010/2011' AND 
    (PD.descrizione LIKE 'I semestre' OR 
    PD.descrizione LIKE 'Primo semestre')
GROUP BY (
    PL.abbreviazione, 
    PD.discriminante, 
    PD.inizio, 
    PD.fine
)    
ORDER BY PD.inizio, PD.fine;
```

## Esercizio 18

Trovare per ogni segreteria che serve almeno un corso di studi il numero di corsi di
studi serviti, riportando il nome della struttura, il suo numero di fax e il conteggio
richiesto.

La soluzione ha 42 righe.

```sql
SELECT SS.nomestruttura, SS.fax, COUNT(CS.id) as NumCorsi
FROM StrutturaServizio as SS 
JOIN CorsoStudi as CS ON SS.id = CS.id_segreteria
GROUP BY (
    SS.nomestruttura,
    SS.fax
)
```
