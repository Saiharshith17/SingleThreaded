package MultiThreaded;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.io.PrintWriter;
import java.io.IOException;

public class Server {

    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);  // Ensure auto-flush
                toClient.println("Hello from the Server");
                toClient.flush();  // Ensure data is sent immediately
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        int port = 8010;  // Port is 8010 for both Client and Server
        Server server = new Server();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is Listening on port " + port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
