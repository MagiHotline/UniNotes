"""
Gestione semplice tabella Spese su PostgreSQL .
Manca la gestione delle eccezioni !
"""
from datetime import date
from decimal import Decimal

import psycopg2

# Il seguente import definisce delle variabili con dati sensibili come le password
# Metodo semplice per isolare in un solo file tali parametri
from myAppConfig import myHost, myDatabase, myUser

conn = psycopg2.connect(host = myHost,
    database = myDatabase, user=myUser)

with conn:
    with conn.cursor() as cur:
        cur.execute(
            """
                CREATE TABLE IF NOT EXISTS Spese (
                id SERIAL PRIMARY KEY,
                data DATE NOT NULL,
                voce VARCHAR NOT NULL,
                importo NUMERIC NOT NULL )
            """
        )

        # Safely get the notice if it exists, otherwise set a default string
        ultima_notifica = conn.notices[-1] if conn.notices else "Nessuna notifica"

        print("Esito della creazione della tabella spese: {:s}\n Eventuali notifiche: {:s}"
            .format(str(cur.statusmessage), str(ultima_notifica).strip()))

        cur.execute("""SELECT count (*) FROM Spese""")
        numeroRighe = cur.fetchone()[0]
        if numeroRighe == 0:
            cur.execute(
                """
            INSERT INTO \
            Spese(data, voce, importo ) VALUES (%s, %s, %s),
            (%s, %s, %s),
            (%s, %s, %s),
            (%s, %s, %s)
            """,
                (
                    date(2016, 2, 24),
                    "Stipendio",
                    Decimal("0.1"),
                    date(2016, 2, 24),
                    "Stipendio 'Bis'",
                    Decimal("0.1"),
                    date(2016, 2, 24),
                    "Stipendio 'Tris'",
                    Decimal("0.1"),
                    date(2016, 2, 27),
                    " Affitto ",
                    Decimal(" -0.3"),
                ),
            )
            print(
                "Esito dell’ inserimento delle 4 tuple : {:s}".format(
                    cur.statusmessage
                )
            )
        else:
            print(
                "La tabella è già presente con delle tuple e quindi nessuna tupla è stata aggiunta."
            )

with conn.cursor() as cur:
    cur.execute(
        """
        SELECT id, data, voce, importo FROM Spese
        """
    )
    print(
        "Esito della selezione di tutte le tuple : {:s}".format(cur.statusmessage)
    )
    print("=" * 55)
    patternRiga = "| {:>2s} | {:10s} | {:<20s} | {:>10s} |"

    print(patternRiga.format("N", "Data", "Voce", "Importo"))
    print("-" * 55)
    tot = Decimal("0")
    patternRiga = "| {:>2d} | {:10s} | {:<20s} | {:>10.2f} |"
    for tupla in cur:
        print(patternRiga.format(tupla[0], tupla[1].isoformat(), tupla[2], tupla[3]))
        tot += tupla[3]
    print("-" * 55)

conn.close()

print("{:>40s} {:10.2f}".format("Totale", tot))
