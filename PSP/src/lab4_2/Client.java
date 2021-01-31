package lab4_2;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");

        System.out.println("Connected to " + clientSocket.getLocalAddress() + "(" + clientSocket.getInetAddress() + "):" + clientSocket.getLocalPort());
        byte[] sendData = new byte[256];
        byte[] receiveData = new byte[256];

        System.out.println("Введите x, y, z через пробел: ");
        String sentence = input.readLine();
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7000);

        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("Ответ:" + modifiedSentence);
        FileUtil.readFile();
        clientSocket.close();
    }
}
