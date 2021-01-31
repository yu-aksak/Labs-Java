package lab3_1;

public class WriterInfo {
    public static void printInfoW(Worker worker){
        System.out.println("Фамилия: " + worker.getFirstName());
        System.out.println("Имя: " + worker.getName());
        System.out.println("Отчество: " + worker.getSecondName());
        System.out.println("Пол: " + worker.getGender());
        System.out.println("Дата рождения: " + worker.getBirthDate());
        System.out.println("Стаж работы: " + worker.getExperience());
        System.out.println("Зарплата: " + worker.getSalary());
        System.out.println("Номер цеха: " + worker.getNumWorkshop());
        System.out.println("Разряд: " + worker.getCategory());
    }

    public static void printInfoF(Foreman foreman){
        System.out.println("Фамилия: " + foreman.getFirstName());
        System.out.println("Имя: " + foreman.getName());
        System.out.println("Отчество: " + foreman.getSecondName());
        System.out.println("Пол: " + foreman.getGender());
        System.out.println("Дата рождения: " + foreman.getBirthDate());
        System.out.println("Стаж работы: " + foreman.getExperience());
        System.out.println("Зарплата: " + foreman.getSalary());
        System.out.println("Название цеха: " + foreman.getNameWorkshop());
        System.out.println("Количество подчиненных: " + foreman.getNumWorkers());
    }

    public static void printInfoFD(FactoryDirector factoryDirector){
        System.out.println("Фамилия: " + factoryDirector.getFirstName());
        System.out.println("Имя: " + factoryDirector.getName());
        System.out.println("Отчество: " + factoryDirector.getSecondName());
        System.out.println("Пол: " + factoryDirector.getGender());
        System.out.println("Дата рождения: " + factoryDirector.getBirthDate());
        System.out.println("Стаж работы: " + factoryDirector.getExperience());
        System.out.println("Зарплата: " + factoryDirector.getSalary());
        System.out.println("Срок избрания: " + factoryDirector.getPeriod());
    }

}
