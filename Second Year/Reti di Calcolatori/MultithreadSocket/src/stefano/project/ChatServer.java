package stefano.project;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/*

The ChatServer uses a ServerSocket to listen on port 12345.
La ChatServer usa Serversocket che ascolta sulla porta 12345

Ogni connessione è gestita nel proprio thread,
dove l'input è gestito con un BufferedReader e i messaggi sono
trasmessi attraverso il metodo broadcast.

l'insieme ClientWriters tiene traccia di tutti gli output stream
dei client così che ogni messaggio viene a trasmetto ad ogni client
 */

public class ChatServer {
    // Insieme che contiene tutti i flussi di output dei client connessi
    private static Set<PrintWriter> clientWriters = ConcurrentHashMap.newKeySet();
    private static Map<Socket, String> clientNames = new ConcurrentHashMap<>();
    private static int clientCounter = 0; // Tiene traccia dei numeri

    public static void main(String[] args) {
        int port = 12345;
        System.out.println("Server in attesa alla porta: " + port);

        // Proviamo a startare il serber
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // Accetta le connessioni dei client che si connettono alla porta
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);
                // Gestisci la connessione del client in un nuovo thread
                new Thread(new ClientHandler(clientSocket, clientCounter)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcasta un messaggio a tutti i client connessi e li stampa sulla console del server.
    /*
    Questo metodo itera su tutti gli flussi di output (dentro clientWriters) and manda
    un messaggio a tutti.
     */
    private static void broadcast(String message) {
        System.out.println(message);
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }


    private static class ClientHandler implements Runnable {
        private Socket socket;
        private String clientName;

        public ClientHandler(Socket socket, int clientId) {
            this.socket = socket;
            this.clientName = "Client" + clientId; // Default name
        }

        public void run() {
            try (
                    // Creiamo i flussi di input e output del client
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                // Add this client's writer so that it receives broadcast messages.
                // Aggiungere il flusso di output all'insieme
                clientWriters.add(out);

                // Chiediamo all'utente il nome
                out.println("Enter your name: ");
                String name = in.readLine();
                if (name != null && !name.trim().isEmpty()) {
                    clientName = name;
                }

                clientNames.put(socket, clientName);
                broadcast(clientName + " has joined the chat!");

                String message;
                // Legge i messaggi dal client e falli appariresu schermo
                while ((message = in.readLine()) != null) {
                    broadcast(clientName + ": " + message);
                }

            } catch (IOException e) {
                System.out.println("Error handling client: " + socket);
                e.printStackTrace();
            } finally {
                try {
                    broadcast(clientName + " has left the chat.");
                    clientWriters.removeIf(PrintWriter::checkError);
                    clientNames.remove(socket);
                    socket.close();
                } catch (IOException e) {
                    // ignora
                }
            }
        }
    }
}
