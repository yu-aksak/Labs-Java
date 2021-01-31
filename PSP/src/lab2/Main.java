package lab2;

import lab1.Stock;
import lab1.WriterInfo;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Stock []st = new Stock[3];
        st[0] = new Stock("Платье", 75.60, "да", 15);
        st[1] = new Stock("Брюки", 82.50, "нет");
        st[2] = new Stock();

        for (int i = 0; i < 3; i++)
            WriterInfo.printInfo(st[i]);

        CountCost.countCost(st);
    }
}
