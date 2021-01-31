package lab3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryDirector extends Employee {

    int period;     //years
    private BufferedReader input;

    public FactoryDirector() throws IOException {
        super();
        input = new BufferedReader(new InputStreamReader(System.in));
        setPeriod();
    }

    public FactoryDirector(String firstName, String name, String secondName, String gender, String birthDate, int experience, double salary, int period){
        super(firstName, name, secondName, gender, birthDate, experience, salary);
        this.period = period;
    }

    public FactoryDirector(String firstName, String name, String secondName, String gender, String birthDate) throws IOException {
        super(firstName, name, secondName, gender, birthDate);
        input = new BufferedReader(new InputStreamReader(System.in));
        setPeriod();
    }

    private void setPeriod() throws IOException {
        System.out.println("Введите срок избрания:");
        this.period = Integer.parseInt(input.readLine());
    }

    public int getPeriod() { return period; }
}
