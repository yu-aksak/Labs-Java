package lab2;

import lab1.Stock;

public class CountCost {
    static void countCost(Stock[] st){
        double CountCost_ = 0.0;
        int Count_ = 0, count;
        for(int i = 0; i < 3; i++){
           CountCost_ += st[i].cost * st[i].count;
            Count_ += st[i].count;
        }

        System.out.println("Общая стоимость товаров: " + CountCost_);
        System.out.println("Количество товаров: " + Count_);
    }
}
