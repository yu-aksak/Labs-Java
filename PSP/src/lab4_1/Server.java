package lab4_1;

import java.io.*;
import java.net.*;

public class Server {

    static double Raschet(double a, double b, String znak){

        switch (znak){
            case "\\+":
                return a+b;
            case "-":
                return a-b;
            case "\\*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 1;
        }
    }

    public static void main(String[] args) throws IOException{
        int count = 1;
        double A, B;
        String Massage;
        String OutMass;
        String Pool[];
        String znak = "";

        ServerSocket serversocket = new ServerSocket(8000);
        while(true){
            Socket clientsocket = serversocket.accept();

            System.out.println("Client accepted " + (count++));

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            OutputStreamWriter writer = new OutputStreamWriter(clientsocket.getOutputStream());

            Massage = reader.readLine();
            System.out.println("I accepted " + Massage);
            char res[] = Massage.toCharArray();
            for(int i = 0; i < res.length; i++){
                if(res[i] == '+') {
                    znak = "\\+";
                    break;
                }
                if(res[i] == '*') {
                    znak = "\\*";
                    break;
                }
                if(res[i] == '-' || res[i] == '/') {
                    znak = Character.toString(res[i]);
                    break;
                }
            }
            Pool = Massage.split(znak);
            A = Double.parseDouble(Pool[0]);
            B = Double.parseDouble(Pool[1]);

            OutMass = Double.toString(Raschet(A, B, znak));
            System.out.println("I send " + OutMass);

            writer.write(OutMass + '\n');
            writer.flush();

            writer.close();
            reader.close();

            clientsocket.close();
        }
    }
}
