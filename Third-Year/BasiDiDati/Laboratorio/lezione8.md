# Esercitazione 8

## Interrogazioni in MongoDB

Creare un account su Atlas e connettersi ad un cluster MongoDB, quindi creare un database
per la gestione dei musei del Veneto, equivalente a quello creato in PostgreSQL durante la
prima esercitazione di laboratorio.
Nello specifico, una volta creato il database, connettersi ad esso tramite Compass ed eseguire
i seguenti esercizi.

## Esercizio 1
Creare una collezione Museo ed inserire alcuni documenti usarndo le funzioni insertOne() o
insertMany() eventualmente facendo copia ed incolla da un file di testo (Attenzione: il
caricamento tramite file JSON richiede di specificare un ObjectId per ciascun documento, al
contrario l’inserimento tramite insertOne() o insertMany() crea tale identificatore in automatico
e lo ritorna come risultato dell’inserimento).

Usare la sueguente struttura:
Per gli attributi di tipo data usare il tipo ISODate(‘’) in modo da poter eseguire delle ricerche.

```java
Museo {
  nome: '…',
  citta: '…',
  indirizzo: '…',
  numeroTelefono: '…',
  giornoChiusura: '…',
  prezzo: …,
  opere: 
  [
    { 
      nome: '…',
      cognomeAutore: '…',
      nomeAutore: '…',
      epoca: '…',
      anno: '…',
    },
    …
  ],
  mostre: 
  [
    { 
      titolo: '…',
      inizio: '…',
      fine: '…',
      prezzo: …,
    },
    …
  ],
  orari: 
  [
    { 
      giorno: '…',
      orarioApertura: …,
      orarioChiusura: …,
    },
    …
  ]
}
```

```js

db.museo.insertMany([
  // --- 1. GALLERIA DEGLI UFFIZI ---
  {
    nome: 'Galleria degli Uffizi',
    citta: 'Firenze',
    indirizzo: 'Piazzale degli Uffizi, 6',
    numeroTelefono: '0552388651',
    giornoChiusura: 'LUN',
    prezzo: 25,
    opere: [
      { nome: 'Nascita di Venere', cognomeAutore: 'Filipepi (Botticelli)', nomeAutore: 'Sandro', epoca: 'Rinascimento', anno: '1485' },
      { nome: 'Annunciazione', cognomeAutore: 'da Vinci', nomeAutore: 'Leonardo', epoca: 'Rinascimento', anno: '1472' }
    ],
    mostre: [
      { 
        titolo: 'Capolavori su Tavola', 
        inizio: ISODate('2024-05-01'), 
        fine: ISODate('2024-10-31'), 
        prezzo: 8 
      }
    ],
    orari: [
      { giorno: 'MAR', orarioApertura: 8.15, orarioChiusura: 18.50 },
      { giorno: 'MER', orarioApertura: 8.15, orarioChiusura: 18.50 }
    ]
  },

  // --- 2. MUSEO EGIZIO ---
  {
    nome: 'Museo Egizio',
    citta: 'Torino',
    indirizzo: 'Via Accademia delle Scienze, 6',
    numeroTelefono: '0115617776',
    giornoChiusura: 'LUN',
    prezzo: 18,
    opere: [
      { nome: 'Statua di Ramesse II', cognomeAutore: 'Ignoto', nomeAutore: 'Ignoto', epoca: 'Nuovo Regno', anno: '-1279' },
      { nome: 'Papiro delle Miniere', cognomeAutore: 'Ignoto', nomeAutore: 'Ignoto', epoca: 'Nuovo Regno', anno: '-1150' }
    ],
    mostre: [
      { 
        titolo: 'I Segreti dei Faraoni', 
        inizio: ISODate('2024-01-10'), 
        fine: ISODate('2024-12-31'), 
        prezzo: 5 
      }
    ],
    orari: [
      { giorno: 'MAR', orarioApertura: 9.00, orarioChiusura: 18.30 },
      { giorno: 'MER', orarioApertura: 9.00, orarioChiusura: 18.30 }
    ]
  },

  // --- 3. PARCO ARCHEOLOGICO DEL COLOSSEO ---
  {
    nome: 'Parco Archeologico del Colosseo',
    citta: 'Roma',
    indirizzo: 'Piazza del Colosseo, 1',
    numeroTelefono: '0639967700',
    giornoChiusura: 'Nessuna',
    prezzo: 16,
    opere: [
      { nome: 'Anfiteatro Flavio', cognomeAutore: 'Ignoto', nomeAutore: 'Ignoto', epoca: 'Impero Romano', anno: '80' },
      { nome: 'Arco di Costantino', cognomeAutore: 'Ignoto', nomeAutore: 'Ignoto', epoca: 'Impero Romano', anno: '315' }
    ],
    mostre: [
      { 
        titolo: 'Gladiatori: Tra Storia e Mito', 
        inizio: ISODate('2024-04-15'), 
        fine: ISODate('2024-11-30'), 
        prezzo: 0 
      }
    ],
    orari: [
      { giorno: 'LUN', orarioApertura: 8.30, orarioChiusura: 19.00 },
      { giorno: 'MAR', orarioApertura: 8.30, orarioChiusura: 19.00 }
    ]
  },

  // --- 4. PINACOTECA DI BRERA ---
  {
    nome: 'Pinacoteca di Brera',
    citta: 'Milano',
    indirizzo: 'Via Brera, 28',
    numeroTelefono: '0272263260',
    giornoChiusura: 'LUN',
    prezzo: 15,
    opere: [
      { nome: 'Lo Sposalizio della Vergine', cognomeAutore: 'Sanzio', nomeAutore: 'Raffaello', epoca: 'Rinascimento', anno: '1504' },
      { nome: 'Il Bacio', cognomeAutore: 'Hayez', nomeAutore: 'Francesco', epoca: 'Romanticismo', anno: '1859' }
    ],
    mostre: [
      { 
        titolo: 'Il Colore del Romanticismo', 
        inizio: ISODate('2024-09-01'), 
        fine: ISODate('2025-01-15'), 
        prezzo: 3 
      }
    ],
    orari: [
      { giorno: 'MAR', orarioApertura: 8.30, orarioChiusura: 19.15 },
      { giorno: 'MER', orarioApertura: 8.30, orarioChiusura: 19.15 }
    ]
  },

  // --- 5. MUSEO DI CASTELVECCHIO ---
  {
    nome: 'Museo di Castelvecchio',
    citta: 'Verona',
    indirizzo: 'Corso Castelvecchio, 2',
    numeroTelefono: '0458062611',
    giornoChiusura: 'LUN',
    prezzo: 6,
    opere: [
      { nome: 'Statua equestre di Cangrande I della Scala', cognomeAutore: 'Ignoto', nomeAutore: 'Ignoto', epoca: 'Medioevo', anno: '1345' },
      { nome: 'Madonna della Quaglia', cognomeAutore: 'Pisano (Pisanello)', nomeAutore: 'Antonio', epoca: 'Gotico', anno: '1420' }
    ],
    mostre: [
      { 
        titolo: 'Il Medioevo a Verona', 
        inizio: ISODate('2026-06-01'), 
        fine: ISODate('2026-09-30'), 
        prezzo: 2 
      }
    ],
    orari: [
      { giorno: 'MAR', orarioApertura: 10.00, orarioChiusura: 18.00 },
      { giorno: 'MER', orarioApertura: 10.00, orarioChiusura: 18.00 }
    ]
  },

  // --- 6. MUSEO DI CAPODIMONTE ---
  {
    nome: 'Museo di Capodimonte',
    citta: 'Napoli',
    indirizzo: 'Via Miano, 2',
    numeroTelefono: '0817499111',
    giornoChiusura: 'MER',
    prezzo: 12,
    opere: [
      { nome: 'Flagellazione di Cristo', cognomeAutore: 'Merisi da Caravaggio', nomeAutore: 'Michelangelo', epoca: 'Barocco', anno: '1607' },
      { nome: 'Danae', cognomeAutore: 'Vecellio', nomeAutore: 'Tiziano', epoca: 'Rinascimento', anno: '1545' }
    ],
    mostre: [
      { 
        titolo: 'Caravaggio a Napoli', 
        inizio: ISODate('2026-09-01'), 
        fine: ISODate('2027-01-31'), 
        prezzo: 5 
      }
    ],
    orari: [
      { giorno: 'GIO', orarioApertura: 8.30, orarioChiusura: 19.30 },
      { giorno: 'VEN', orarioApertura: 8.30, orarioChiusura: 19.30 }
    ]
  },

  // --- 7. COLLEZIONE PEGGY GUGGENHEIM ---
  {
    nome: 'Collezione Peggy Guggenheim',
    citta: 'Venezia',
    indirizzo: 'Dorsoduro, 701-704',
    numeroTelefono: '0412405411',
    giornoChiusura: 'MAR',
    prezzo: 16,
    opere: [
      { nome: 'L\'impero delle luci', cognomeAutore: 'Magritte', nomeAutore: 'René', epoca: 'Surrealismo', anno: '1954' },
      { nome: 'Scatola in una valigia', cognomeAutore: 'Duchamp', nomeAutore: 'Marcel', epoca: 'Dadaismo', anno: '1941' }
    ],
    mostre: [
      { 
        titolo: 'Oltre il Surrealismo', 
        inizio: ISODate('2026-05-01'), 
        fine: ISODate('2026-11-01'), 
        prezzo: 0 
      }
    ],
    orari: [
      { giorno: 'MER', orarioApertura: 10.00, orarioChiusura: 18.00 },
      { giorno: 'GIO', orarioApertura: 10.00, orarioChiusura: 18.00 }
    ]
  }
]);
```

## Esercizio 2

Creare una collezione MuseoRef equivalente alla precedente, in cui però le proprietà opere e
mostre usano riferimenti tramite ObjectId(‘…’) a documenti presenti in altre due collezioni
Opera e Mostre con la seguente struttura.

```js
Opera {
    nome: '…',
    cognomeAutore: '…',
    nomeAutore: '…',
    epoca: '…',
    anno: '…',
}

Mostra {
    titolo: '…',
    inizio: '…',
    fine: '…',
    prezzo: ….,
}
{
  acknowledged: true,
  insertedIds: {
    '0': ObjectId('6a02fa148a8763c6b7fd89fc'),
    '1': ObjectId('6a02fa148a8763c6b7fd89fd'),
    '2': ObjectId('6a02fa148a8763c6b7fd89fe'),
    '3': ObjectId('6a02fa148a8763c6b7fd89ff'),
    '4': ObjectId('6a02fa148a8763c6b7fd8a00')
}
```

Per opere.

```js
db.opera.insertMany([
  {
    nome: 'Nascita di Venere',
    cognomeAutore: 'Filipepi (Botticelli)',
    nomeAutore: 'Sandro',
    epoca: 'Rinascimento',
    anno: '1485'
  },
  {
    nome: 'Annunciazione',
    cognomeAutore: 'da Vinci',
    nomeAutore: 'Leonardo',
    epoca: 'Rinascimento',
    anno: '1472'
  },
  {
    nome: 'Statua di Ramesse II',
    cognomeAutore: 'Ignoto',
    nomeAutore: 'Ignoto',
    epoca: 'Nuovo Regno',
    anno: '-1279'
  },
  {
    nome: 'Anfiteatro Flavio',
    cognomeAutore: 'Ignoto',
    nomeAutore: 'Ignoto',
    epoca: 'Impero Romano',
    anno: '80'
  },
  {
    nome: 'Lo Sposalizio della Vergine',
    cognomeAutore: 'Sanzio',
    nomeAutore: 'Raffaello',
    epoca: 'Rinascimento',
    anno: '1504'
  }
]);
```

Per le mostre:

```js
db.mostra.insertMany([
  {
    titolo: 'Capolavori su Tavola',
    inizio: ISODate('2024-05-01'),
    fine: ISODate('2024-10-31'),
    prezzo: 8
  },
  {
    titolo: 'I Segreti dei Faraoni',
    inizio: ISODate('2024-01-10'),
    fine: ISODate('2024-12-31'),
    prezzo: 5
  },
  {
    titolo: 'Gladiatori: Tra Storia e Mito',
    inizio: ISODate('2024-04-15'),
    fine: ISODate('2024-11-30'),
    prezzo: 0
  },
  {
    titolo: 'Il Colore del Romanticismo',
    inizio: ISODate('2024-09-01'),
    fine: ISODate('2025-01-15'),
    prezzo: 3
  },
  {
    titolo: 'Il Medioevo a Verona',
    inizio: ISODate('2026-06-01'),
    fine: ISODate('2026-09-30'),
    prezzo: 2
  }
]);

{
  acknowledged: true,
  insertedIds: {
    '0': ObjectId('6a02fa4c8a8763c6b7fd8a01'),
    '1': ObjectId('6a02fa4c8a8763c6b7fd8a02'),
    '2': ObjectId('6a02fa4c8a8763c6b7fd8a03'),
    '3': ObjectId('6a02fa4c8a8763c6b7fd8a04'),
    '4': ObjectId('6a02fa4c8a8763c6b7fd8a05')
  }
}
```

Per museo ref ora:

```js
nome: 'Pinacoteca di Brera',
  citta: 'Milano',
  indirizzo: 'Via Brera, 28',
  numeroTelefono: '0272263260',
  giornoChiusura: 'LUN',
  prezzo: 15,

```
