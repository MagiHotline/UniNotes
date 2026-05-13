import csv
import re

pattern = re.compile(r"^\d{2}/\d{2}/\d{4}$")

def creaDict(data, voce, importo):
    """ Ritorna un dict formato con gli argomenti .
    Formato: {'data’: <data>, 'voce’: <voce>, 'importo’: < importo >}
    Fa il check sul formato data.
    """
    if not isinstance (data, str) or not pattern.match (data):
        print("Data non è nel formato dd/mm/aaaa")
        exit()
    return { 'data': data, 'voce': voce, 'importo': float(importo)}

# Creo la tabella e aggiungo solo i dati
tabella = list()
tabella.append( creaDict ( "24/02/2016", "Stipendio", 0.1) )
tabella.append( creaDict ( "24/02/2016", 'Stipendio "Bis"', 0.1) )
tabella.append( creaDict ( "24/02/2016", 'Stipendio "Tris"', 0.1) )
tabella.append( creaDict ( "27/02/2016", "Affitto", -0.3))

# Stampo la tabella da memoria
print ( "=" * 50 )
print("| {:10s} | {:<20} | {:>10s} |".format("Data", "Voce", "Importo"))
print( '-' * 50 )
for riga in tabella :
    print( "| {:10s} | {:<20} | {:>10.2f} |".format(riga['data'], riga['voce'], riga['importo']))
    print ('=' * 50)

# Calcolo il totale degli importi
tot = 0.0
for riga in tabella:
    tot += riga ['importo']
print("La somma è {:.20f}".format(tot))

# Salvo la tabella in un formato csv
nomefile = "tabellaSpesa.csv"
with open(nomefile, mode = 'w', encoding='utf-8') as csvFile:
    nomi_campi = ['data', 'voce', 'importo']
    writer = csv.DictWriter(csvFile, fieldnames=nomi_campi)
    writer.writeheader()
    for riga in tabella:
        writer.writerow(riga)

# Leggo dal file la tabella e la inserisco in una nuova variabilie
tab1 = list()
with open(nomefile, mode ='r', encoding='utf-8') as csvFile:
    reader = csv.DictReader(csvFile)
    for row in reader:
        tab1.append( creaDict (row['data'], row['voce'], row['importo']))

# Calcolo il totale sulla nuova tabella
tot1 = 0
for riga in tab1 :
    tot1 += riga['importo']
if tot == tot1:
    print( "I due totali sono uguali !")
else:
    print( " Ops ... la tabella letta non ha gli stessi dati !" )

if tot == 0:
    print( " Eureka !" )
else:
    print( " Ops ... il totale non è corretto perchè non è 0!" )
