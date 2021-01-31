package lab3_1;

import java.io.IOException;

import static lab3_1.WriterInfo.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Worker worker = new Worker();
        Foreman foreman = new Foreman("Сечко", "Роман",
                "Александрович", "мужской", "09/03/2001");
        FactoryDirector factoryDirector = new FactoryDirector("Третьяк",
                "Егор", "Дмитриевич", "мужской",
                "12/03/2001", 5, 4340, 5);

        printInfoW(worker);
        printInfoF(foreman);
        printInfoFD(factoryDirector);
    }
}
