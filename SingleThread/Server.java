package SingleThread;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;

public class Server {
    public void run() throws Exception {
        int port = 8010;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            try (Socket acceptedConnection = serverSocket.accept();
                 PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
                 BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()))) {

                System.out.println("Connection accepted from Client " + acceptedConnection.getRemoteSocketAddress());
                toClient.println("Hello from the server");
                System.out.println("Message sent to client: Hello from the server");

                String clientMessage = fromClient.readLine();
                if (clientMessage != null) {
                    System.out.println("Client says: " + clientMessage);
                } else {
                    System.out.println("Client disconnected");
                }
                toClient.close();
                fromClient.close();
                acceptedConnection.close();

            } catch (IOException e) {
                System.err.println("Error handling client connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
