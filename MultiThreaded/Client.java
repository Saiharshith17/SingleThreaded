package MultiThreaded;


import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Client {

    public Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                int port = 8010;  // Changed port to 8010
                try {
                    InetAddress address = InetAddress.getByName("localhost");
                    Socket socket = new Socket(address, port);
                    try {
                        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        toSocket.println("Hello from Client " + socket.getLocalSocketAddress());
                        String line = fromSocket.readLine();
                        System.out.println("Response from server: " + line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        socket.close();  // Ensure the socket is closed after usage
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();
        for (int i = 0; i < 10; i++) {  // Reduced number of threads to 10 for testing
            try {
                Thread thread = new Thread(client.getRunnable());
                thread.start();
                thread.join();  // Ensuring the threads are completed before starting new ones
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
