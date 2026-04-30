package TCPSocket;

import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Server {
    public ServerThread(int port) throws IOException {
        super(port);
    }

    public void run() throws IOException {
        while(true) {
            System.out.println("Server in attesa di richieste");

            Socket clientSocket = getServerSocket().accept();
            System.out.println("Si è connesso un client: " +
                    clientSocket.getInetAddress().getHostAddress()
                    + ":" + clientSocket.getPort());

            ParallelServer parallelServer = new ParallelServer(clientSocket);

            Thread thread = new Thread(parallelServer);
            thread.start();
        }
    }
}
