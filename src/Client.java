import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("127.0.0.1",80)){
            System.out.println("connected to the server...");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream reader = new DataInputStream(inputStream);
            PrintWriter writer = new PrintWriter(outputStream,true);

            System.out.println("Your message : ");
            String message;
            Scanner scan = new Scanner(System.in);
            message = scan.nextLine();
            writer.println(message);

            String response = reader.readLine();
            System.out.println("Server : " + response);

            System.out.println("Your message : ");
            message = scan.nextLine();
            writer.println(message);

            response = reader.readLine();
            System.out.println("Server : " + response);

            System.out.println("Your message : ");
            message = scan.nextLine();
            writer.println(message);
        }
    }
}
