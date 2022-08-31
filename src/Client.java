import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 23444);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String number;
            while (true) {
                System.out.println("...Введите целое число либо \"end\" для завершения программы...");
                number = scanner.nextLine();
                out.println(number);
                if ("end".equals(number)) break;
                System.out.println("SERVER: " + in.readLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
//Выбран IO т.к. нет необходимости в усложнении программы через использование NIO