package lab7_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Window extends  JFrame{

    private static JButton selectButt;
    private static JButton insertButt;
    private static JButton deleteButt;
    private static JButton updateButt;

    private static JLabel exLable;
    private static JLabel id;
    private static JLabel autor;
    private static JLabel year;
    private static JLabel title;
    private static JLabel genre;

    private static JList listId;
    private static JList listAuthor;
    private static JList listYear;
    private static JList listTitle;
    private static JList listGenre;

    private static JTextField FieldId;
    private static JTextField FieldAuthor;
    private static JTextField FieldYear;
    private static JTextField FieldTitle;
    private static JTextField FieldGenre;

    private static JTable tableDB;
    DefaultListModel<String> modelID = new DefaultListModel<String>();
    DefaultListModel<String> modelAuthor = new DefaultListModel<String>();
    DefaultListModel<String> modelYear = new DefaultListModel<String>();
    DefaultListModel<String> modelTitle = new DefaultListModel<String>();
    DefaultListModel<String> modelGenre = new DefaultListModel<String>();

    private ArrayList<Book> bookDBS = new ArrayList<Book>();

    DefaultTableModel tmodel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return true;
        };
    };


    Window () {
        super("Лабораторная работа №7.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);

        //таблица
        tmodel.addColumn("ID");
        tmodel.addColumn("Author");
        tmodel.addColumn("Year");
        tmodel.addColumn("Title");
        tmodel.addColumn("Genre");

        //поля
        FieldId = new JTextField();
        FieldId.setSize(100, 50);
        FieldId.setLocation(10, 250);

        FieldAuthor = new JTextField();
        FieldAuthor.setSize(100, 50);
        FieldAuthor.setLocation(120, 250);

        FieldYear = new JTextField();
        FieldYear.setSize(100, 50);
        FieldYear.setLocation(230, 250);

        FieldTitle = new JTextField();
        FieldTitle.setSize(100, 50);
        FieldTitle.setLocation(340, 250);

        FieldGenre = new JTextField();
        FieldGenre.setSize(100, 50);
        FieldGenre.setLocation(450, 250);

        //кнопки
        updateButt = new JButton("Update");
        updateButt.setSize(100, 50);
        updateButt.setLocation(10, 400);

        insertButt = new JButton("Insert");
        insertButt.setSize(100, 50);
        insertButt.setLocation(120, 320);

        deleteButt = new JButton("Delete id");
        deleteButt.setSize(100, 50);
        deleteButt.setLocation(10, 320);
        deleteButt.setEnabled(false);

        selectButt = new JButton("Select all");
        selectButt.setSize(100, 50);
        selectButt.setLocation(120, 400);

        //текст
        exLable = new JLabel("here");
        exLable.setSize(150,50);
        exLable.setLocation(420, 10);

        id = new JLabel("ID");
        id.setSize(50,20);
        id.setLocation(10, 230);

        autor = new JLabel("Author");
        autor.setSize(50,20);
        autor.setLocation(120, 230);

        year = new JLabel("Year");
        year.setSize(50,20);
        year.setLocation(230, 230);

        title = new JLabel("Title");
        title.setSize(50,20);
        title.setLocation(340, 230);

        genre = new JLabel("Genre");
        genre.setSize(50,20);
        genre.setLocation(450, 230);

        //
        tableDB = new JTable(tmodel);
        tableDB.setBounds(10, 10, 400, 200);
        tableDB.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tableDB);
        scrollPane.setBounds(10, 10, 400, 200);




        setLayout(null);

        add(scrollPane);

        add(exLable);
        add(id);
        add(autor);
        add(year);
        add(title);
        add(genre);

        add(FieldId);
        add(FieldAuthor);
        add(FieldYear);
        add(FieldTitle);
        add(FieldGenre);

        add(selectButt);
        add(insertButt);
        add(deleteButt);
        add(updateButt);


        selectButt.addActionListener(new ButtonActionLisener());
        insertButt.addActionListener(new ButtonActionLisener());
        deleteButt.addActionListener(new ButtonActionLisener());
        updateButt.addActionListener(new ButtonActionLisener());
        tableDB.addMouseListener(new MouseLis());
    }


    public class ButtonActionLisener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == selectButt){
                bookDBS = bookDB.select();
                tmodel.setRowCount(0);
                for (Book a: bookDBS) {
                    tmodel.addRow(new Object[]{Integer.toString(a.getID()), a.getAuthor(),Integer.toString(a.getYear()), a.getTitle(), a.getGenre() });
                }
                deleteButt.doClick();
            }
            else if(e.getSource() == insertButt){
                try {
                    bookDB.insert(new Book(Integer.parseInt(FieldId.getText()), FieldAuthor.getText(), Integer.parseInt(FieldYear.getText()), FieldTitle.getText(), FieldGenre.getText()));
                }
                catch (Exception exception){
                    exLable.setText("Write data in text field");
                }
                selectButt.doClick();
                deleteButt.setEnabled(false);
            }
            else if(e.getSource() == deleteButt){
                deleteButt.setEnabled(false);
                try {
                    Object a = tmodel.getValueAt(tableDB.getSelectedRow(), 0);
                    bookDB.delete(Integer.parseInt(a.toString()));
                }
                catch (Exception exception) {
                    exLable.setText("Chose some fiedl");
                }
                selectButt.doClick();
            }
            else if(e.getSource() == updateButt){
                try {
                    bookDB.update(new Book(Integer.parseInt(FieldId.getText()), FieldAuthor.getText(), Integer.parseInt(FieldYear.getText()), FieldTitle.getText(), FieldGenre.getText()));
                }
                catch (Exception exception){
                    exLable.setText("Write data in text field");
                }
                selectButt.doClick();
            }
        }
    }


    public class MouseLis implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(tableDB.isCursorSet()){
                deleteButt.setEnabled(false);
            }
            else{
                System.out.println(tableDB.getSelectedRow());
                deleteButt.setEnabled(true);
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

