package lab4_2;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args)  throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(7000);
        byte[] receiveData;
        byte[] sendData = new byte[256];
        while (true) {
            receiveData = new byte[256];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            InetAddress IPAddress = receivePacket.getAddress();
            int k = receivePacket.getLength();

            int port = receivePacket.getPort();
            System.out.println("Client's port: " + port);

            String sentence  = new String(receivePacket.getData());
            System.out.println("Получил: " + sentence);

            String[] pool = sentence.split(" ");
            double x = Double.parseDouble(pool[0]), y = Double.parseDouble(pool[1]), z = Double.parseDouble(pool[2]);

            double f = Math.log(Math.pow(y,- Math.pow(Math.abs(x), 0.5))) * (x - y / 2) +
                    Math.pow(Math.sin(Math.atan(z)), 2) + Math.exp(x + y);

            FileUtil.InFile(sentence + "    " + f);

            sentence = Double.toString(f);
            System.out.println("Отправил: " + sentence);
            sendData = sentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }

    }
}