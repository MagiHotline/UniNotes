package TCPSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int PORT;
    private ServerSocket serverSocket;

    public Server(int PORT) throws IOException {
        this.PORT = PORT;
        if(!initServer())
            System.err.println("Errore durante la creazione del Server");
    }

    private boolean initServer() throws IOException {
        // Initialize
        serverSocket = new ServerSocket(PORT);
        return true;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void run() throws IOException {



        while (true) {
            System.out.println("Server in attesa... ");

            // Accetta una connessione dal client
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Un client si è connesso!");

                // Ottieni i flussi di input e output
                try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
                ) {
                    // Leggi il messaggio dal client
                    String clientMessage = br.readLine();

                    System.out.println("Messaggio ricevuto dal client: " + clientMessage);

                    // Invia la risposta al client
                    bw.write("Server: " + clientMessage + "\n");
                    bw.flush();
                }
            }
        }
    }


}
