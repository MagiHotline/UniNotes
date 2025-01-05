package TCPSocket;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ParallelServer implements Runnable {
    private Socket client;

    public ParallelServer(Socket client) {
        this.client = client;
    }

    public void run() {
        try
        {
            // Creiamo il flusso di scrittura per il Server
            OutputStream serverOut = client.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(serverOut));

            // Il server invia la risposta al client
            bw.write("Benvenuto sul server!");

            // Chiude lo stream di output e la connessione
            bw.close();
            client.close();
            System.out.println("Chiusura connessione effettuata");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
