package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {

    private static Image background;
    private static Image human;
    private static Image car;
    private static Image tree;

    private int humanX = 0, carX = -300, treeW = 100, treeH = 125, treeX = 100, treeY = 220;

    JButton start;

    public Main(){
        setTitle("Дабораторная работа №6");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize( 960, 540);
        setContentPane(new Main.Background());              // панель
        // устанавливается как contentPane в наследнике JFrame
        Container content = getContentPane(); //теперь
        //все элементы интерфейса будут на этой панели.

        setLocationRelativeTo(null);
        setResizable(false);

        start = new JButton("Старт");
        start.setSize(100, 50);
        start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(false);
                Thread treeThread = new Thread(new Main.TreeThread());
                treeThread.start();
                Thread humanThread = new Thread(new Main.HumanThread());
                humanThread.start();
                Thread carThread = new Thread(new Main.CarThread());
                carThread.start();
            }
        });

        content.add(start);
        content.add(new Main.Picture());
    }

    private static class Background extends JPanel { //
        //отрисовка нового фона
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            try {
                background = ImageIO.read(new
                        File("/учеба/Пятый сем/ПСП/PSP/src/Lab6/background.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(background, 0, 0, 960, 540, null);
        }
    }

    private class Picture extends JPanel{

        public Picture() {
            setOpaque(false);
            setPreferredSize(new Dimension(1000, 600));
            try {
                human = ImageIO.read(new File("/учеба/Пятый сем/ПСП/PSP/src/Lab6/human.png"));
                car= ImageIO.read(new File("/учеба/Пятый сем/ПСП/PSP/src/Lab6/car.png"));
                tree =  ImageIO.read(new File("/учеба/Пятый сем/ПСП/PSP/src/Lab6/tree.png"));
            }
            catch (IOException exc) {};

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D)g;

            graphics2D.drawImage(tree,treeX ,treeY, treeW, treeH, this);
            graphics2D.drawImage(car, carX,290, 250, 145, this);
            graphics2D.drawImage(human, humanX, 340, 150, 150, this);

        }
    }

    public class TreeThread implements Runnable {
        @Override
        public void run() {
            while(treeH < 300){
                treeH *=1.015;
                treeW *=1.015;
                treeY -=2;
                repaint();
                try {
                    Thread.sleep(130);
                } catch (Exception exc) {
                }
            }

        }
    }

    public class HumanThread implements Runnable {
        @Override
        public void run() {
            while(humanX < 950){
                humanX +=10;
                repaint();
                try {
                    Thread.sleep(130);
                } catch (Exception exc) {
                }
            }

        }
    }

    public class CarThread implements Runnable {
        @Override
        public void run() {
            while(carX < 1200){
                carX +=40;
                repaint();
                try {
                    Thread.sleep(130);
                } catch (Exception exc) {
                }
            }

        }
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}