package lab3_2;

import java.io.IOException;

public class Turner extends Worker{

    public Turner() throws IOException {
        super();
    }

    public Turner(String firstName, String name, String secondName, String gender, String birthDate, int experience, double salary, int numWorkshop, int category) throws IOException {
        super(firstName, name, secondName, gender, birthDate, experience, salary, numWorkshop, category);
    }
    public Turner(String firstName, String name, String secondName, String gender, String birthDate) throws IOException {
        super(firstName, name, secondName, gender, birthDate);
    }

    @Override
    public void employee() {
        System.out.println("Токарь");
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
        System.out.println("Номер цеха: " + getNumWorkshop());
        System.out.println("Разряд: " + getCategory());
    }
}
