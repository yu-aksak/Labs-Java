package lab5_1;

import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame {

    JList list1;
    JList list2;
    JList list3;

    JButton from1to2;
    JButton from2to3;
    JButton from3to1;
    JButton from1to2all;
    JButton from2to3all;
    JButton from3to1all;
    JButton addButton;
    JButton deleteButton;

    JTextField text;
    JTextField addElTxt;

    DefaultListModel<String> model1 = new DefaultListModel<String>();
    DefaultListModel<String> model2 = new DefaultListModel<String>();
    DefaultListModel<String> model3 = new DefaultListModel<String>();

    Window () {
        super("Лабораторная работа №5.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550,800);

        model1.addElement("Катя");
        model1.addElement("Юля");
        model1.addElement("Вадим");
        model1.addElement("Олег");
        model1.addElement("Коля");
        model2.addElement("Оля");
        model2.addElement("Таня");
        model2.addElement("Андрей");
        model2.addElement("Саша");
        model3.addElement("Ангелина");
        model3.addElement("Юра");

        list1 = new JList(model1);
        list2 = new JList(model2);
        list3 = new JList(model3);

        from1to2 = new JButton("Во 2й");
        from2to3 = new JButton("В 3й");
        from3to1 = new JButton("В 1й");
        from1to2all = new JButton("Все во 2й");
        from2to3all = new JButton("Все в 3й");
        from3to1all = new JButton("Все в 1й");
        addButton = new JButton("Добавить");
        deleteButton = new JButton("Удалить");

        text = new JTextField("Ожидание действия...");
        addElTxt = new JTextField(null);

        list1.setSize(150, 400);
        list1.setLocation(20,20);
        list2.setSize(150, 400);
        list2.setLocation(190,20);
        list3.setSize(150, 400);
        list3.setLocation(360,20);

        from1to2.setSize(100, 25);
        from1to2.setLocation(45, 430);
        from2to3.setSize(100, 25);
        from2to3.setLocation(215,430);
        from3to1.setSize(100, 25);
        from3to1.setLocation(385, 430);
        from1to2all.setSize(100, 25);
        from1to2all.setLocation(45, 475);
        from2to3all.setSize(100, 25);
        from2to3all.setLocation(215, 475);
        from3to1all.setSize(100, 25);
        from3to1all.setLocation(385, 475);
        addButton.setSize(100, 25);
        addButton.setLocation(215, 520);
        deleteButton.setSize(100, 25);
        deleteButton.setLocation(215, 565);

        text.setSize(300, 50);
        text.setLocation(10, 655);
        addElTxt.setSize(200, 50);
        addElTxt.setLocation(320, 655);

        setLayout(null);

        add(list1);
        add(list2);
        add(list3);

        add(from1to2);
        add(from2to3);
        add(from3to1);
        add(from1to2all);
        add(from2to3all);
        add(from3to1all);
        add(addButton);
        add(deleteButton);

        add(text);
        add(addElTxt);

        list1.addMouseListener(new MouseActionLisener());
        list2.addMouseListener(new MouseActionLisener());
        list3.addMouseListener(new MouseActionLisener());

        from1to2.addActionListener(new ButtonActionLisener());
        from2to3.addActionListener(new ButtonActionLisener());
        from3to1.addActionListener(new ButtonActionLisener());
        from1to2all.addActionListener(new ButtonActionLisener());
        from2to3all.addActionListener(new ButtonActionLisener());
        from3to1all.addActionListener(new ButtonActionLisener());
        addButton.addActionListener(new ButtonActionLisener());
        deleteButton.addActionListener(new ButtonActionLisener());
    }

    public class MouseActionLisener implements MouseListener {
        // Если пользователь нажал и отпустил одну из кнопок, вызывается метод mouseClicked.
        public void mouseClicked(MouseEvent e) {
            Object text1 = null;
            if (e.getSource() == list1){
                list1 = (JList) e.getSource();
                text1 = list1.getSelectedValue();
            }
            else if (e.getSource() == list2){
                list2 = (JList) e.getSource();
                text1 = list2.getSelectedValue();
            }
            else if (e.getSource() == list3){
                list3 = (JList) e.getSource();
                text1 = list3.getSelectedValue();
            }
            text.setText("Выбран элемент: " + (String) text1);
        }

        // Навели на компонент, зажали кнопку — система вызвала mousePressed.
        public void mousePressed(MouseEvent e) {

        }

        // Отпускаем кнопку — система вызвала mouseReleased.
        public void mouseReleased(MouseEvent e) {

        }

        // mouseEntered - данный метод будет вызываться системой у слушателя каждый раз, когда курсор мыши будет оказываться над компонентом.
        public void mouseEntered(MouseEvent e) {

        }

        // mouseExited – данный метод срабатывает, когда убираем курсор мыши с компонента.
        public void mouseExited(MouseEvent e) {

        }
    }

    public class ButtonActionLisener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == from1to2){
                model2.addElement(model1.getElementAt(list1.getSelectedIndex()));
                model1.removeElementAt(list1.getSelectedIndex());
                text.setText("Успешно перенесено во второй список");
            }
            else if (e.getSource() == from1to2all){
                for (int i = 0; i < model1.size(); ) {
                    model2.addElement(model1.getElementAt(i));
                    model1.removeElementAt(i);
                }
                text.setText("Успешно перенесено все во второй список");
            }
            else if (e.getSource() == from2to3){
                model3.addElement(model2.getElementAt(list2.getSelectedIndex()));
                model2.removeElementAt(list2.getSelectedIndex());
                text.setText("Успешно перенесено в третий список");
            }
            else if (e.getSource() == from2to3all){
                for (int i = 0; i < model2.size(); ) {
                    model3.addElement(model2.getElementAt(i));
                    model2.removeElementAt(i);
                }
                text.setText("Успешно перенесено все в третий список");
            }
            else if (e.getSource() == from3to1){
                model1.addElement(model3.getElementAt(list3.getSelectedIndex()));
                model3.removeElementAt(list3.getSelectedIndex());
                text.setText("Успешно перенесено в первый список");
            }
            else if (e.getSource() == from3to1all){
                for (int i = 0; i < model3.size(); ) {
                    model1.addElement(model3.getElementAt(i));
                    model3.removeElementAt(i);
                }
                text.setText("Успешно перенесено все в первый список");
            }
            else if (e.getSource() == addButton){
                if (addElTxt.getText() != null) {
                    model2.addElement(addElTxt.getText());
                    text.setText("Успешно добавлен новый элемент во второй список");
                    addElTxt.setText(null);
                }
            }
            else if (e.getSource() == deleteButton){
                model2.removeElementAt(list2.getSelectedIndex());
                text.setText("Успешно удален элемент из второго списка");
            }
        }
    }

}
