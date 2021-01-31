package lab5_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Window  extends JFrame{

    private static JButton sendData;

    private static JLabel fL;
    private static JLabel nL;
    private static JLabel pL;
    private static JTextField f;
    private static JTextField n;
    private static JTextField p;

    private static JLabel birthDate;
    private static JComboBox date;
    private static JComboBox month;
    private static JComboBox year;

    private static JLabel gender;
    private static JRadioButton male;
    private static JRadioButton female;
    private static ButtonGroup buttonGroup;

    private static JLabel serialNumPass;
    private static JTextField pass;

    private static JCheckBox job;

    static String[] box1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    static String[] box2 = {"январь","февраль","март","апрель","май","июнь","июль","август","сентябрь","октябрь","ноябрь","декабрь"};
    static String[] box3 = {"1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
    static File file = new File("card.txt");

    Window() {
        super("Лабораторная работа №5.2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);

        fL = new JLabel("Фамилия: ");
        nL = new JLabel("Имя: ");
        pL = new JLabel("Отчество: ");

        fL.setBounds(10, 10, 70, 30);
        nL.setBounds(10, 50, 70, 30);
        pL.setBounds(10, 90, 70, 30);

        f = new JTextField();
        n = new JTextField();
        p = new JTextField();

        f.setBounds(90, 10, 150, 30);
        n.setBounds(90, 50, 150, 30);
        p.setBounds(90, 90, 150, 30);
/////
        gender = new JLabel("Пол: ");
        gender.setBounds(10, 130, 70, 30);

        male = new JRadioButton("Мужской");
        female = new JRadioButton("Женский");

        male.setBounds(90,130,90,30);
        female.setBounds(180,130,90,30);

        buttonGroup = new ButtonGroup();
/////
        birthDate = new JLabel("Дата рождения: ");
        birthDate.setBounds(10, 170, 120, 30);

        date = new JComboBox(box1);
        month = new JComboBox(box2);
        year = new JComboBox(box3);

        date.setBounds(110,170,50,30);
        month.setBounds(180,170,70,30);
        year.setBounds(260,170,60,30);

        serialNumPass = new JLabel("Серия и номер пасспорта: ");
        serialNumPass.setBounds(10, 220, 170, 30);

        pass = new JTextField();
        pass.setBounds(200,220,150,30);

        job = new JCheckBox("Для работы");
        job.setBounds(10,270,120,30);

        sendData = new JButton("Отправить");
        sendData.setBounds(120,310,120,30);

        setLayout(null);

        buttonGroup.add(male);
        buttonGroup.add(female);

        add(fL);
        add(nL);
        add(pL);
        add(f);
        add(n);
        add(p);

        add(gender);
        add(male);
        add(female);


        add(birthDate);
        add(date);
        add(month);
        add(year);
        add(serialNumPass);
        add(pass);

        add(job);
        add(sendData);

        sendData.addActionListener(new ButtonActionLisener());
    }
    public class ButtonActionLisener implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            try {
                FileWriter writer = new FileWriter(file, true);
                try {
                    writer.write(fL.getText() + f.getText() + " \n" +
                            nL.getText() + n.getText() + "\n" +
                            pL.getText() + p.getText() + " \n");

                    if (male.isSelected())
                        writer.write(gender.getText() + male.getText() + "\n");
                    else if (female.isSelected())
                        writer.write(gender.getText() + female.getText() + "\n");
                    writer.write(birthDate.getText() + date.getSelectedItem().toString() + " " +
                            month.getSelectedItem().toString() + " " + year.getSelectedItem().toString() + "\n");
                    writer.write(serialNumPass.getText() + pass.getText());
                    if (job.isSelected())
                        writer.write(job.getText() + "\n");
                    writer.flush();
                } finally {
                    writer.close();
                    System.exit(0);
                }

            }
            catch(IOException e1){

                throw new RuntimeException(e1);

            }
        }
    }
}

