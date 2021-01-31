package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stock {
    private String name, availability;
    public double cost;
    public int count;
    private BufferedReader input;

    public Stock() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));

        setName();
        setCost();
        setAvailability();
        checkCount();
    }

    public Stock(String name, double cost, String availability, int count)throws IOException{
        this.name = name;
        this.cost = cost;
        this.availability = availability;
        this.count = count;
    }

    public Stock(String name, double cost, String availability)throws IOException{
        this.name = name;
        this.cost = cost;
        this.availability = availability;
        this.count = 0;
    }

    private void setName() throws IOException {
        System.out.println("Введите наименование товара:");
        this.name = input.readLine();
    }

    private void setCost() throws IOException {
        System.out.println("Введите цену товара:");
        this.cost = Double.parseDouble(input.readLine());
    }

    private void setAvailability() throws IOException {
        System.out.println("Есть ли товар в наличии (да/нет):");
        this.availability = input.readLine();
    }

    private void checkCount() throws IOException {
        this.count = (this.availability.equals("да")) ? setCount() : 0;
    }

    private int setCount() throws IOException {
        System.out.println("Введите количество товара:");
        return  Integer.parseInt(input.readLine());
    }

    String getName() { return this.name; }

    double getCost() { return this.cost; }

    String getAvailability() { return this.availability; }

    int getCount() { return this.count; }

    void printName(){
        System.out.println("Наименование: " + getName());
    }

    void printCost(){
        System.out.println("Цена: " +  getCost());
    }

    void printAvailability(){
        System.out.println("Наличие: " + getAvailability());
    }

    void printCount(){
        System.out.println("Количество: " + getCount());
    }
}