package lab3_2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Turner turner  = new Turner();
        Foreman foreman = new Foreman("Сечко", "Роман",
                "Александрович", "мужской", "09/03/2001");
        FactoryDirector factoryDirector = new FactoryDirector("Третьяк",
                "Егор", "Дмитриевич", "мужской",
                "12/03/2001", 5, 4340, 5);

        turner.employee();
        turner.print();
        foreman.employee();
        foreman.print();
        factoryDirector.employee();
        factoryDirector.print();
    }
}
