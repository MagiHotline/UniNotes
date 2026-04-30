package TCPSocket;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Crea un oggetto di tipo Server in ascolto
        // sulla porta 7777
        Server s = new Server(7777);
        s.run();
    }
}