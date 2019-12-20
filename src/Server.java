import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(80)){
            System.out.println("Witing for a connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to the client...");
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            DataInputStream reader = new DataInputStream(inputStream);
            PrintWriter writer = new PrintWriter(outputStream,true);

            String fromClient = reader.readLine();
            System.out.println("Client : " + fromClient);

            writer.println("What is your name ? ");

            fromClient = reader.readLine();
            System.out.println("Client name : " + fromClient);

            writer.println("What is your family name ? ");

            fromClient = reader.readLine();
            System.out.println("Client familyName : " + fromClient);
        }
    }
}