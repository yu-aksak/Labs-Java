package lab4_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends JFrame {
    Socket clientSocket;
    BufferedReader reader;
    OutputStreamWriter writer;
    String massage;


    JButton connectButton;
    JButton sendButton;
    JTextField ipText;
    JTextField portText;
    JTextField firstNum;
    JTextField secondNum;
    JTextField operationText;
    JTextField resultText;

    public Client() throws IOException {
        super("Лабараторная работа №4.3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        connectButton = new JButton("Connect");
        sendButton = new JButton("Send");
        ipText = new JTextField("127.0.0.1");
        portText = new JTextField("8000");
        firstNum = new JTextField();
        secondNum = new JTextField();
        operationText = new JTextField();
        resultText = new JTextField();


        connectButton.setSize(100, 50);
        connectButton.setLocation(10, 50);

        sendButton.setSize(100, 50);
        sendButton.setLocation(10, 200);

        ipText.setSize(100, 50);
        ipText.setLocation(120, 50);

        portText.setSize(100, 50);
        portText.setLocation(300, 50);

        firstNum.setSize(100, 50);
        firstNum.setLocation(120, 200);

        operationText.setSize(100, 50);
        operationText.setLocation(220, 200);

        secondNum.setSize(100, 50);
        secondNum.setLocation(320, 200);

        resultText.setSize(100, 100);
        resultText.setLocation(100, 300);

        setLayout(null);

        add(connectButton);
        add(sendButton);
        add(ipText);
        add(portText);
        add(firstNum);
        add(operationText);
        add(secondNum);
        add(resultText);

        connectButton.addActionListener(new ButtonActionLisener());
        sendButton.addActionListener(new ButtonActionLisener());

    }

    public class ButtonActionLisener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sendButton) {
                if(clientSocket.isConnected() && firstNum.getText() != null && operationText.getText() != null && secondNum.getText() != null){
                    try {
                        writer.write(firstNum.getText() + '\n');
                        writer.flush();
                        writer.write(operationText.getText() + '\n');
                        writer.flush();
                        writer.write(secondNum.getText() + '\n');
                        writer.flush();
                        massage = reader.readLine();
                        resultText.setText(massage);

                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
            if (e.getSource() == connectButton) {
                try {
                    clientSocket = new Socket("127.0.0.1", 8000);
                    reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    writer = new OutputStreamWriter(clientSocket.getOutputStream());
                }
                catch (IOException ex){
                }
            }
        }
    }

}
