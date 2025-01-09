import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        ArrayList<Prodotto> prodotti = new ArrayList<>();

        prodotti.add(new Prodotto("Latte" , 1.50));
        prodotti.add(new Prodotto("Pane" , 0.80));
        prodotti.add(new Prodotto("Uova" , 2.50));
        prodotti.add(new Prodotto("Zucchero" , 1.20));

        for(Prodotto p : prodotti){
            System.out.println(p);
        }

        for(Prodotto p : prodotti){
            if(p.getNome().equals("Pane")){
                System.out.println("Prezzo di " + p.getNome() + " : €" + p.getPrezzo());
            }else{
                System.out.println("Prodotto non trovato");
            }
        }

        double somma = 0;
        for(Prodotto p : prodotti){
            somma = somma + p.getPrezzo();
        }

        System.out.println("Il prezzo totale e' : €" + somma);

    }
}