package lect4;

public class MainEredit
{
    public static void main(String[] args) {
        // Dire "tipo statico" è il tipo in fase di compilazione
        // Dire "tipo dinamico" è il tipo in fase di esecuzione
        // Java è strongly typed quindi una volta dichiarato una variabile di
        // un tipo statico non potrà sicuramente cambiare
        ItalianDate d1 = new ItalianDate(17, 10, 2024);
        print(d1);
        Date d2 = new ItalianDate(13, 1, 2024);
        print(d2);
        Date d3 = new AmericanDate(17, 10, 2024);
        print(d3);
        Date d4 = new AustralianDate(17, 10, 2024);
        print(d4);
        Date d5 = new AustralianDate(17, 10, 2024);
        print(d5);
    }


    private static void print(Date date) {
        System.out.println(date + ": " + date.getSeason());
    }
}
