# Lezione 5

Base di dati personale con tabelle importate dalla base di dati did2014small.
Dopo aver eseguito il dump e il successivo restore di did2014small, eseguire i seguenti esercizi.
Si considerino le seguenti tabelle:

- CorsoStudi(id, nome, codice, abbreviazione, durataAnni, sede, informativa, id_segreteria)
- Insegn(id, nomeins, codiceins)
- Discriminante(id, nome, descrizione)
- InsErogato(id, annoaccademico, id_insegn, id_corsostudi, id_discriminante, modulo,
discriminantemodulo, nomemodulo, crediti, programma, id_facolta, hamoduli,
id_inserogato_padre, nomeunità, annierogazione)

Scrivere in SQL le seguenti interrogazioni, creare gli opportuni indici e dimostrare il guadagno, in
termini di numero di pagine disco, che si ottiene con gli indici proposti (prima di ogni query, le
tabelle coinvolte NON devono avere indici). 
Quindi la risposta all’esercizio deve essere la
dichiarazione degli indici che sono necessari e sufficienti per migliorare le prestazioni della query
e di quanti accessi al disco diminuisce il costo della query con il contenuto attuale della base di
dati.

## Esercizio 1

Visualizzare in nomi dei corsi di studio che finiscono con la stringa ’informatica’ senza
considerare maiuscole/minuscole.

```sql
EXPLAIN ANALYZE SELECT CS.nome
FROM CorsoStudi as CS
WHERE
    CS.nome ILIKE '%informatica';
    
CREATE INDEX cs_index ON CorsoStudi ( nome );
ANALYZE CorsoStudi;

EXPLAIN ANALYZE SELECT CS.nome
FROM CorsoStudi as CS
WHERE
    CS.nome ILIKE '%informatica';
    
DROP INDEX cs_index;
ANALYZE CorsoStudi;
```
- Costo: invariato
- Tempo di esecuzione SENZA INDICE: 5.503 ms 
- Tempo di esecuzione CON INDICE: 3.478 ms

## Esercizio 2 

Visualizzare i nomi degli insegnamenti che iniziano per ’Teoria...’

```sql
EXPLAIN ANALYZE SELECT I.nomeins
FROM Insegn as I
WHERE
    I.nomeins ILIKE 'Teoria%';

CREATE INDEX insegn_index ON Insegn ( nomeins );
ANALYZE Insegn;

EXPLAIN ANALYZE SELECT I.nomeins
FROM Insegn as I
WHERE
    I.nomeins ILIKE 'Teoria%';

DROP INDEX insegn_index;
ANALYZE Insegn;
```
- Costo: invariato
- Tempo di esecuzione SENZA INDICE: 43.669 ms
- Tempo di esecuzione CON INDICE: 13.810 ms

## Esercizio 3

Trovare, per ogni insegnamento erogato dell’a.a. 2013/2014, il suo nome e id della facoltà che lo
gestisce usando la relazione assorbita con facoltà.

```sql
EXPLAIN ANALYZE SELECT DISTINCT I.nomeins, IE.id_facolta 
FROM InsErogato as IE
JOIN Insegn as I on IE.id_insegn = I.id
WHERE
    IE.annoaccademico = '2013/2014';

CREATE INDEX ie_aa ON InsErogato (annoaccademico);
CREATE INDEX ie_id_insegn ON InsErogato (id_insegn);
ANALYZE InsErogato;

EXPLAIN ANALYZE SELECT DISTINCT I.nomeins, IE.id_facolta 
FROM InsErogato as IE
JOIN Insegn as I on IE.id_insegn = I.id
WHERE
    IE.annoaccademico = '2013/2014';
    
DROP INDEX ie_aa;
DROP INDEX ie_id_insegn;
ANALYZE InsErogato;
```
- Costo SENZA INDICE: 6396.86
- Costo CON INDICE: 5843.34
- Tempo di esecuzione SENZA INDICE: 36.408 ms
- Tempo di esecuzione CON INDICE: 20.493 ms

## Esercizio 4

Visualizzare il codice, il nome e l’abbreviazione di tutti corsi di studio che nel nome contengono la
sottostringa ’lingue’ (eseguire un test case-insensitive: usare ILIKE invece di LIKE).

```sql
EXPLAIN ANALYZE SELECT CS.nome, CS.codice, CS.abbreviazione
FROM CorsoStudi as CS
WHERE
    CS.nome ILIKE '%lingue%';
    
CREATE INDEX cs_nome ON CorsoStudi (nome);
ANALYZE CorsoStudi;

EXPLAIN ANALYZE SELECT CS.nome, CS.codice, CS.abbreviazione
FROM CorsoStudi as CS
WHERE
    CS.nome ILIKE '%lingue%';
    
DROP INDEX cs_nome;
ANALYZE CorsoStudi;
```
- Costo: invariato
- Tempo di esecuzione SENZA INDICE: 3.276 ms
- Tempo di esecuzione CON INDICE: 0.986 ms

## Esercizio 5
Visualizzare identificatori e numero modulo dei moduli reali (modulo>0) degli insegnamenti erogati nel 2010/2011 associati alla facoltà con id=7 tramite la relazione diretta.

```sql
EXPLAIN ANALYZE SELECT IE.id, IE.modulo
FROM InsErogato AS IE
WHERE
    IE.annoaccademico = '2010/2011' AND
    IE.id_facolta = 7 AND
    IE.modulo > 0;
    
CREATE INDEX index ON InsErogato (annoaccademico, id_facolta, modulo);
ANALYZE InsErogato;

EXPLAIN ANALYZE SELECT IE.id, IE.modulo
FROM InsErogato AS IE
WHERE
    IE.annoaccademico = '2010/2011' AND
    IE.id_facolta = 7 AND
    IE.modulo > 0;
    
DROP INDEX index;
ANALYZE InsErogato;
```
- Costo SENZA INDICE: 6305.30
- Costo CON INDICE: 2320.01
- Tempo di esecuzione SENZA INDICE: 45.095 ms
- Tempo di esecuzione CON INDICE: 11.926 ms

## Esercizio 6
Visualizzare il nome e il discriminante (attributo descrizione della tabella Discriminante) degli
insegnamenti erogati nel 2009/2010 che non sono moduli e che hanno 3, 5 o 12 crediti.

```sql
EXPLAIN ANALYZE SELECT I.nomeins, DIS.descrizione 
FROM InsErogato as IE
JOIN Insegn as I ON I.id = IE.id_insegn
JOIN Discriminante as DIS on IE.id_discriminante = DIS.id
WHERE
    IE.annoaccademico = '2009/2010' AND
    IE.modulo = 0 AND
    IE.crediti IN (3,5,12);
    
CREATE INDEX index ON InsErogato (annoaccademico, modulo, crediti, id_insegn, id_discriminante);
ANALYZE InsErogato;

EXPLAIN ANALYZE SELECT I.nomeins, DIS.descrizione 
FROM InsErogato as IE
JOIN Insegn as I ON I.id = IE.id_insegn
JOIN Discriminante as DIS on IE.id_discriminante = DIS.id
WHERE
    IE.annoaccademico = '2009/2010' AND
    IE.modulo = 0 AND
    IE.crediti IN (3,5,12);
    
DROP INDEX index;
ANALYZE InsErogato;
```
- Costo SENZA INDICE: 6696.49
- Costo CON INDICE: 371.32
- Tempo di esecuzione SENZA INDICE: 39.567 ms
- Tempo di esecuzione CON INDICE: 9.010 ms

## Esercizio 7
Visualizzare il nome e il discriminante degli insegnamenti erogati nel 2008/2009 senza moduli e con crediti maggiore di 9.

```sql
EXPLAIN ANALYZE SELECT I.nomeins, DIS.descrizione 
FROM InsErogato as IE
JOIN Insegn as I ON I.id = IE.id_insegn
JOIN Discriminante as DIS on IE.id_discriminante = DIS.id
WHERE
    IE.annoaccademico = '2008/2009' AND
    IE.crediti > 9 AND
    IE.hamoduli = '0';

CREATE INDEX index ON InsErogato (annoaccademico, crediti, hamoduli, id_insegn, id_discriminante);
ANALYZE InsErogato;

EXPLAIN ANALYZE SELECT I.nomeins, DIS.descrizione 
FROM InsErogato as IE
JOIN Insegn as I ON I.id = IE.id_insegn
JOIN Discriminante as DIS on IE.id_discriminante = DIS.id
WHERE
    IE.annoaccademico = '2008/2009' AND
    IE.crediti > 9 AND
    IE.hamoduli = '0';

DROP INDEX index;
ANALYZE InsErogato;
```
- Costo SENZA INDICE: 6603.16
- Costo CON INDICE: 337.69 
- Tempo di esecuzione SENZA INDICE: 40.922 ms
- Tempo di esecuzione CON INDICE: 4.843 ms

## Esercizio 8
Visualizzare in ordine alfabetico di nome degli insegnamenti (esclusi di moduli e le unità
logistiche) erogati nel 2013/2014 nel corso di ’Laurea in Informatica’, riportando il nome, il
discriminante, i crediti e gli anni di erogazione.

```sql
EXPLAIN ANALYZE SELECT 
    I.nomeins, DIS.descrizione, IE.crediti, IE.annierogazione
FROM InsErogato as IE
JOIN Insegn as I ON I.id = IE.id_insegn
JOIN Discriminante as DIS on IE.id_discriminante = DIS.id
JOIN CorsoStudi as CS on IE.id_corsostudi = CS.id
WHERE
    IE.annoaccademico = '2013/2014' AND
    CS.nome = 'Laurea in Informatica' AND
    IE.modulo = 0
ORDER BY nomeins;

CREATE INDEX index ON InsErogato (annoaccademico, modulo, id_insegn, id_discriminante, id_corsostudi);
CREATE INDEX index2 ON CorsoStudi (nome);
ANALYZE InsErogato, CorsoStudi;

EXPLAIN ANALYZE SELECT 
    I.nomeins, DIS.descrizione, IE.crediti, IE.annierogazione
FROM InsErogato as IE
JOIN Insegn as I ON I.id = IE.id_insegn
JOIN Discriminante as DIS on IE.id_discriminante = DIS.id
JOIN CorsoStudi as CS on IE.id_corsostudi = CS.id
WHERE
    IE.annoaccademico = '2013/2014' AND
    CS.nome = 'Laurea in Informatica' AND
    IE.modulo = 0
ORDER BY nomeins;

DROP INDEX index, index2;
ANALYZE InsErogato, CorsoStudi;
```
- Costo SENZA INDICE: 6401.89
- Costo CON INDICE: 386.63
- Tempo di esecuzione SENZA INDICE: 33.904 ms
- Tempo di esecuzione CON INDICE: 5.895 ms

## Esercizio 9
Trovare il massimo numero di crediti degli insegnamenti erogati dall’ateneo nell’a.a. 2013/2014.

```sql
EXPLAIN ANALYZE SELECT MAX(IE.crediti) 
FROM InsErogato as IE
WHERE
    IE.annoaccademico = '2013/2014';

CREATE INDEX index ON InsErogato (annoaccademico, crediti);
ANALYZE InsErogato;

EXPLAIN ANALYZE SELECT MAX(IE.crediti) 
FROM InsErogato as IE
WHERE
    IE.annoaccademico = '2013/2014';
    
DROP INDEX index;
ANALYZE InsErogato;
```

- Costo SENZA INDICE: 5978.18
- Costo CON INDICE: 0.47
- Tempo di esecuzione SENZA INDICE: 34.393 ms
- Tempo di esecuzione CON INDICE: 0.121 ms


## Esercizio 10
Trovare, per ogni anno accademico, il massimo e il minimo numero di crediti erogati in un
insegnamento.

```sql
EXPLAIN ANALYZE SELECT IE.annoaccademico, MAX(IE.crediti), MIN(IE.crediti)
FROM InsErogato as IE
GROUP BY IE.annoaccademico;

CREATE INDEX index ON InsErogato (annoaccademico, crediti);
ANALYZE InsErogato;

EXPLAIN ANALYZE SELECT IE.annoaccademico, MAX(IE.crediti), MIN(IE.crediti)
FROM InsErogato as IE
GROUP BY IE.annoaccademico;
    
DROP INDEX index;
ANALYZE InsErogato;
```

- Costo SENZA INDICE: 6305.46 
- Costo CON INDICE: 2614.69
- Tempo di esecuzione SENZA INDICE: 55.176 ms
- Tempo di esecuzione CON INDICE: 32.133 ms

## Esercizio 11
Trovare il nome dei corsi di studio che non hanno mai erogato insegnamenti che contengono nel nome la stringa ’matematica’ (usare ILIKE invece di LIKE per rendere il test non sensibile alle maiuscole/minuscole).

```sql
EXPLAIN ANALYZE SELECT CS.nome
FROM CorsoStudi as CS
WHERE
    NOT EXISTS
    (
        SELECT 1
        FROM InsErogato as IE_IN 
        JOIN Insegn as I_IN on IE_IN.id_insegn = I_IN.id
        WHERE 
            IE_IN.id_corsostudi = CS.id AND
            I_IN.nomeins ILIKE '%matematica%'
    );
    
CREATE INDEX index ON InsErogato (id_insegn, id_corsostudi);
ANALYZE InsErogato;

EXPLAIN ANALYZE SELECT CS.nome
FROM CorsoStudi as CS
WHERE
    NOT EXISTS
    (
        SELECT 1
        FROM InsErogato as IE_IN 
        JOIN Insegn as I_IN on IE_IN.id_insegn = I_IN.id
        WHERE 
            IE_IN.id_corsostudi = CS.id AND
            I_IN.nomeins ILIKE '%matematica%'
    );
    
DROP INDEX index;
ANALYZE InsErogato;
```

- Costo SENZA INDICE: 6357.10
- Costo CON INDICE: 342.36
- Tempo di esecuzione SENZA INDICE: 46.342 ms
- Tempo di esecuzione CON INDICE: 18.787 ms


## Esercizio 12
Trovare, per ogni anno accademico e per ogni corso di laurea, la somma dei crediti erogati
(esclusi i moduli e le unità logistiche: vedi nota sopra) e il massimo e minimo numero di crediti
degli insegnamenti erogati sempre escludendo i moduli e le unità logistiche.

```sql
EXPLAIN ANALYZE SELECT IE.annoaccademico, CS.nome, SUM(IE.crediti), MAX(IE.crediti), MIN(IE.crediti)
FROM InsErogato as IE
JOIN CorsoStudi as CS on CS.id = IE.id_corsostudi
WHERE
    IE.modulo = 0
GROUP BY IE.annoaccademico, CS.nome;

CREATE INDEX ie ON InsErogato (modulo, id_corsostudi, annoaccademico, crediti);
ANALYZE InsErogato;

EXPLAIN ANALYZE SELECT IE.annoaccademico, CS.nome, SUM(IE.crediti), MAX(IE.crediti), MIN(IE.crediti)
FROM InsErogato as IE
JOIN CorsoStudi as CS on CS.id = IE.id_corsostudi
WHERE
    IE.modulo = 0
GROUP BY IE.annoaccademico, CS.nome;

DROP INDEX ie;
ANALYZE InsErogato;
```

- Costo SENZA INDICE: 7406.42
- Costo CON INDICE: 3209.22
- Tempo di esecuzione SENZA INDICE: 61.356 ms
- Tempo di esecuzione CON INDICE: 42.654 ms
