package lab4_3;

import java.io.*;
import java.net.*;

public class Server {

    static double Raschet(double a, double b, String znak){

        switch (znak){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 1;
        }
    }

    public static void main(String[] args) throws IOException{
        int count = 1;
        String massage1, massage2, massage3;
        String OutMass;

        ServerSocket serversocket = new ServerSocket(8000);
        while(true){
            Socket clientsocket = serversocket.accept();

            System.out.println("Client accepted " + (count++));

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            OutputStreamWriter writer = new OutputStreamWriter(clientsocket.getOutputStream());

            massage1 = reader.readLine();
            massage2 = reader.readLine();
            massage3 = reader.readLine();
            System.out.println("I accepted " + massage1 + " " + massage2 + " " + massage3);


            OutMass = Double.toString(Raschet(Double.parseDouble(massage1), Double.parseDouble(massage3), massage2));

            System.out.println("I send " + OutMass);

            writer.write(OutMass + '\n');
            writer.flush();

            writer.close();
            reader.close();

            clientsocket.close();
        }
    }
}
