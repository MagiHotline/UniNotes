package mattia.Magazzino;

public class Magazzino {
	private Articolo[] articoli;
	private int numeroArticoli =0;
	
	Magazzino(int capacita) {
		articoli = new Articolo[capacita];
	}
	
	public void aggiungiArticolo (Articolo articolo) {
		for (int i=0;i<numeroArticoli;i++){
			if (articoli[i].getNome().equals(articolo.getNome())){
				articoli[i].aggiungiQuantita(articolo.getQuantita());
				System.out.println("SONO STATI AGGIUNTI " + articolo.getQuantita() + " " + articolo.getNome() + " IN MAGAZZINO");
				return;
			}
		}
		if (numeroArticoli<articoli.length) {
			articoli[numeroArticoli] = articolo;
			numeroArticoli++;
			System.out.println("ARTICOLO AGGIUNTO IN MAGAZZINO: " + articolo.getNome());
		}
		else {
			System.out.println("MAGAZZINO PIENO!!! IMPOSSIBILE AGGIUNGERE ALTRI ARTICOLI");
		}
	}
	
	public void togliArticolo (String nome, int quantita){
		for (int i=0;i<articoli.length;i++){
			if (articoli[i].getNome().equals(nome)){
				articoli[i].togliQuantita(quantita);
				System.out.println("RIMOSSI " + quantita + " " + articoli[i].getNome() + " DAL MAGAZZINO...");
				return;
			}
		}
	}
	
	public void visualizzaArticoli () {
		if (numeroArticoli == 0){
			System.out.println("NON SONO PRESENTI ARTICOLI IN MAGAZZINO...");
		}
		for (int i=0;i<numeroArticoli;i++){
			System.out.println("ARTICOLO " + (i+1) + ", - NOME: " + articoli[i].getNome() + " - CODICE: " + articoli[i].getCodice() + " - QUANTITA: " + articoli[i].getQuantita() + " - PREZZO ACQUISTO: " + articoli[i].getPrezzoacquisto() + " - PREZZO VENDITA: " + articoli[i].getPrezzovendita());
		}
	}
}























