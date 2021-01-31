package lab3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Worker extends Employee {

    int numWorkshop, category;
    private BufferedReader input;

    public Worker() throws IOException {
        super();
        input = new BufferedReader(new InputStreamReader(System.in));
        setNumWorkshop();
        setCategory();
    }

    public Worker (String firstName, String name, String secondName, String gender, String birthDate, int experience, double salary, int numWorkshop, int category){
        super(firstName, name, secondName, gender, birthDate, experience, salary);
        this.numWorkshop = numWorkshop;
        this.category = category;
    }

    public Worker (String firstName, String name, String secondName, String gender, String birthDate) throws IOException {
        super(firstName, name, secondName, gender, birthDate);
        input = new BufferedReader(new InputStreamReader(System.in));
        setNumWorkshop();
        setNumWorkshop();
    }

    private void setNumWorkshop() throws IOException {
        System.out.println("Введите номер цеха:");
        this.numWorkshop = Integer.parseInt(input.readLine());
    }

    private void setCategory() throws IOException {
        System.out.println("Введите разряд работника:");
        this.category = Integer.parseInt(input.readLine());
    }

    public int getNumWorkshop(){ return numWorkshop; }

    public int getCategory() { return category; }
}
