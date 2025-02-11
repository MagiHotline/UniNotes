package mattia.Magazzino;

public class Articolo {

	private static int codicegenerale = 100;
	private int codice, quantita = 0, prezzoacquisto,prezzovendita;
	private String nome;
	
	public Articolo (String nome, int prezzoacquisto, int prezzovendita, int quantita) {
		this.codice = codicegenerale++;
		this.nome = nome;
		this.quantita = quantita;
		this.prezzoacquisto = prezzoacquisto;
		this.prezzovendita = prezzovendita;
	}
	
	public Articolo() {
		
	}
	
	public String getNome(){
		return this.nome;
	}
	public int getCodice(){
		return this.codice;
	}
	public int getQuantita(){
		return this.quantita;
	}
	public int getPrezzoacquisto(){
		return this.prezzoacquisto;
	}
	public int getPrezzovendita(){
		return this.prezzovendita;
	}

	public void aggiungiQuantita(int quantita){
		this.quantita += quantita;
	}
	
	public void togliQuantita(int quantita){
		if (this.quantita >= quantita){
			this.quantita -= quantita;
		}
		else {
			System.out.println("IMPOSSIBILE togliere la quantita' richiesta. " + " in giacenza risultano meno articoli di quelli che si richiede di togliere");
		}
	}
}






















