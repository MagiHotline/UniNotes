package stefano.project;
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // server's address
        int port = 12345;                   // server's port

        try (
                Socket socket = new Socket(serverAddress, port);
                // Legge dal sever
                BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Scrive sul server
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // Legge da tastiera
                BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // Thread che legge constantemente dal server
            Thread readerThread = new Thread(() -> {
                String line;
                try {
                    while ((line = serverIn.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnesso dal server.");
                }
            });
            readerThread.start();

            // Thread principale che legge l'input dell'utente e lo manda al server
            String userMessage;
            while ((userMessage = userIn.readLine()) != null) {
                out.println(userMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
