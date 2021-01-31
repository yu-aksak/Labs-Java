package lab3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Foreman extends Employee{

    String nameWorkshop;
    int numWorkers;
    private BufferedReader input;

    public Foreman() throws IOException {
        super();
        input = new BufferedReader(new InputStreamReader(System.in));
        setNameWorkshop();
        setNumWorkers();
    }

    public Foreman(String firstName, String name, String secondName, String gender, String birthDate, int experience, double salary, String nameWorkshop, int numWorkers){
        super(firstName, name, secondName, gender, birthDate, experience, salary);
        this.nameWorkshop = nameWorkshop;
        this.numWorkers = numWorkers;
    }

    public Foreman(String firstName, String name, String secondName, String gender, String birthDate) throws IOException {
        super(firstName, name, secondName, gender, birthDate);
        input = new BufferedReader(new InputStreamReader(System.in));
        setNameWorkshop();
        setNumWorkers();
    }

    private void setNameWorkshop() throws IOException {
        System.out.println("Введите название цеха:");
        this.nameWorkshop = input.readLine();
    }


    private void setNumWorkers() throws IOException {
        System.out.println("Введите количество подчиненных:");
        this.numWorkers = Integer.parseInt(input.readLine());
    }

    public String getNameWorkshop() { return nameWorkshop; }

    public int getNumWorkers() { return numWorkers; }
}
