package lab3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Worker implements Employee, Object{
    protected String firstName, name, secondName, gender, birthDate;
    protected int experience, numWorkshop, category; double salary;
    private BufferedReader input;

    public Worker() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        setFirstName();
        setName();
        setSecondName();
        setGender();
        setBirthDate();
        setExperience();
        setSalary();
        setNumWorkshop();
        setCategory();
    }

    public Worker(String firstName, String name, String secondName, String gender, String birthDate, int experience, double salary, int numWorkshop, int category){
        this.firstName = firstName;
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.experience = experience;
        this.salary = salary;
        this.numWorkshop = numWorkshop;
        this.category = category;
    }

    public Worker(String firstName, String name, String secondName, String gender, String birthDate) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.firstName = firstName;
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.experience = 0;
        this.salary = 0.0;
        setNumWorkshop();
        setCategory();
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

    private void setNumWorkshop() throws IOException {
        System.out.println("Введите номер цеха:");
        this.numWorkshop = Integer.parseInt(input.readLine());
    }

    private void setCategory() throws IOException {
        System.out.println("Введите разряд работника:");
        this.category = Integer.parseInt(input.readLine());
    }

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

    public int getNumWorkshop() { return numWorkshop; }

    public int getCategory() { return category; }
}
