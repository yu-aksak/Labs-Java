package lab3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryDirector implements Employee, Object{
    protected String firstName, name, secondName, gender, birthDate;
    protected int experience; double salary;
    int period;     //years
    private BufferedReader input;

    public FactoryDirector() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        setFirstName();
        setName();
        setSecondName();
        setGender();
        setBirthDate();
        setExperience();
        setSalary();
        setPeriod();
    }

    public FactoryDirector(String firstName, String name, String secondName, String gender, String birthDate, int experience, double salary, int period){
        this.firstName = firstName;
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.experience = experience;
        this.salary = salary;
        this.period = period;
    }

    public FactoryDirector(String firstName, String name, String secondName, String gender, String birthDate) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.firstName = firstName;
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.experience = 0;
        this.salary = 0.0;
        setPeriod();
    }

    private void setFirstName() throws IOException {
        System.out.println("Введите фамилию служашего:");
        this.firstName = input.readLine();
    }


    private void setName() throws IOException {
        System.out.println("Введите имя служащего:");
        this.name = input.readLine();
    }

    private void setSecondName() throws IOException {
        System.out.println("Введите отчество служашего:");
        this.secondName = input.readLine();
    }

    private void setGender() throws IOException {
        System.out.println("Введите пол служашего:");
        this.gender = input.readLine();
    }

    private void setBirthDate() throws IOException {
        System.out.println("Введите дату рождения служашего:");
        this.birthDate = input.readLine();
    }

    private void setExperience() throws IOException {
        System.out.println("Введите опыт работы служашего (в месяцах):");
        this.experience = Integer.parseInt(input.readLine());
    }

    private void setSalary() throws IOException {
        System.out.println("Введите зарплату служашего:");
        this.salary = Double.parseDouble(input.readLine());
    }

    private void setPeriod() throws IOException {
        System.out.println("Введите срок избрания:");
        this.period = Integer.parseInt(input.readLine());
    }

    public int getPeriod() { return period; }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getExperience() {
        return experience;
    }

    public double getSalary() {
        return salary;
    }

    public double payTaxes(){
        return salary * 0.14;
    }

    @Override
    public void employee() {
        System.out.println("Директор завода");
    }

    @Override
    public void print() {
        System.out.println("Фамилия: " + getFirstName());
        System.out.println("Имя: " + getName());
        System.out.println("Отчество: " + getSecondName());
        System.out.println("Пол: " + getGender());
        System.out.println("Дата рождения: " + getBirthDate());
        System.out.println("Стаж работы: " + getExperience());
        System.out.println("Зарплата: " + getSalary());
        System.out.println("Срок избрания: " + getPeriod());

    }
}
