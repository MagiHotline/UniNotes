"""
Gestione semplice tabella Spese su PostgreSQL .
Manca la gestione delle eccezioni !
"""
from datetime import date
from decimal import Decimal

import psycopg2

# Il seguente import definisce delle variabili con dati sensibili come le password
# Metodo semplice per isolare in un solo file tali parametri
from myAppConfig import myHost, myDatabase, myUser, myPas

connessione = psycopg2.connect(host = myHost,
    database = myDatabase, user=myUser, password=myPas)

with connessione:
    with connessione.cursor() as cur:
        cur.execute(
            """
                CREATE TABLE IF NOT EXISTS Spese (
                    id SERIAL PRIMARY KEY,
                    data DATE NOT NULL,
                    voce VARCHAR NOT NULL,
                    importo NUMERIC NOT NULL
                )
            """
        )

print("Esito della creazione della tabella spese: {:s}\n Eventuali notifiche: {:s}"
    .format(cur.statusmessage, connessione.notices[-1]))
