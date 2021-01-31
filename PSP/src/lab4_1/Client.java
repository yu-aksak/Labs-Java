package lab4_1;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String Massage;

        Socket clientSocket = new Socket("127.0.0.1", 8000);
        if(clientSocket.isConnected())
            System.out.println("Connected to " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
        else
            System.out.println("Connecting...");

        BufferedReader input = new BufferedReader (new InputStreamReader (System.in, "Cp1251"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

        System.out.println("Введите строку для вычисления");
        writer.write(input.readLine() + '\n');
        writer.flush();

        Massage = reader.readLine();
        System.out.println(Massage);

        writer.close();
        reader.close();
        clientSocket.close();
    }
}
