package TCPSocket;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final Socket socket;
    private final int serverPort;

    public Client(Socket socket, int serverPort) {
        this.socket = socket;
        this.serverPort = serverPort;
    }

    public void sendMessage(String message) throws IOException {
        System.out.println("Client: " + message);
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write(message + "\n"); // Aggiunge un terminatore di linea
        bw.flush(); // Assicura che il messaggio venga inviato
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Apertura connessione...");
        Socket s = new Socket("127.0.0.1", 7777);

        Client client = new Client(s, 7777);
        System.out.println("Benvenuto nel server!");
        String msg = "";
        Scanner sc = new Scanner(System.in);
        do {
            client.sendMessage(sc.nextLine());
        }while(!msg.equals("exit"));


        // Leggi la risposta del server
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String response = br.readLine();
        System.out.println("Risposta dal server: " + response);

        s.close();
        System.out.println("Chiusura connessione effettuata");
    }

}
