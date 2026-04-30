package mattia.Magazzino;

import java.util.Scanner;

public class MenuMagazzino {
	
	private final int USCITA_MENU1 = 4;
	private final int USCITA_MENU2 = 4;
	private int uscitaMenu;
	
	public void mostramenu(){
		System.out.println("\n\n1) Inserisci Articolo");
		System.out.println("2) Visualizza Articoli magazzino");
		System.out.println("3) Togli Articoli da magazzino");
		System.out.println("4) ESCI dal programma");
	}
	public void mostramenu2(){
		System.out.println("\n\nInserisci Articolo:");
		System.out.println("1) Articolo falagnameria");
		System.out.println("2) Articolo edilizia");
		System.out.println("3) Articolo Carpenteria metallica");
		System.out.println("4) ... torna al menu precedente");
	}
	
	public int sceglinumeroinmenu(int numeromenu) {
		int numeroletto = -1;
		
		Scanner tastiera = new Scanner (System.in);
		
		do{
			switch (numeromenu){
				case 1: {
					mostramenu();
					uscitaMenu = getUscitaMenu1();
					break;
				}
				
				case 2: {
					mostramenu2();
					uscitaMenu = getUscitaMenu1();
					break;
				}
			}
			
			System.out.println("\n-> ");
			if (tastiera.hasNextInt()){
				numeroletto = tastiera.nextInt();
			}
			else {
				System.out.println("Inserisci un numero valido e non una lettera");
				tastiera.hasNextLine();
			}
		} while (numeroletto < 1 || numeroletto > uscitaMenu);
		return numeroletto;
	}
	
	public int getUscitaMenu1(){
		return USCITA_MENU1;
	}
	
	public int getUscitaMenu2(){
		return USCITA_MENU2;
	}
}








///SIGMA