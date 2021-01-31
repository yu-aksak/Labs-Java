package lab2_2;

import java.io.*;
import java.util.Objects;

public class Flower {
    private String color, name;
    private int count;
    private BufferedReader input;

    Flower() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));

        setName();
        setColor();
        setCount();
    }

    Flower (String name, String color, int count) {
        this.name = name;
        this.color = color;
        this.count = count;
    }

    void setName() throws IOException {
        System.out.println("Введите название:");
        this.name = input.readLine();
    }

    void setColor() throws IOException {
        System.out.println("Введите цвет:");
        this.color = input.readLine();
    }

    void setCount() throws IOException {
        System.out.println("Введите число:");
        this.count = Integer.parseInt(input.readLine());
    }

    void printName(){
        System.out.println("Название: " + name);
    }

    void printColor(){
        System.out.println("Цвет: " + color);
    }

    void printCount(){
        System.out.println("Количество: " + count);
    }

    public static void print(Flower fl){
        fl.printName();
        fl.printColor();
        fl.printCount();
    }

    @Override
    public String toString() {
        return "Flower{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", input=" + input +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return count == flower.count &&
                Objects.equals(color, flower.color) &&
                Objects.equals(name, flower.name) &&
                Objects.equals(input, flower.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name, count, input);
    }
}
