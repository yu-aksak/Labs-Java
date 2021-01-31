package lab1;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        WriterInfo.printInfo(new Stock());
        WriterInfo.printInfo(new Stock("Платье", 75.60, "да", 15));
        WriterInfo.printInfo(new Stock("Брюки", 45.20, "нет"));
    }
}
