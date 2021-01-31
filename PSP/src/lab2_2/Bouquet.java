package lab2_2;

import java.util.ArrayList;

public class Bouquet {
    ArrayList<Flower> bouquet;

    Bouquet(){
        bouquet = new ArrayList<>();
    }

    void addFlower(Flower flower) {
        bouquet.add(flower);
    }

    void print(){
        for (int i = 0; i < bouquet.size(); i++){
            Flower.print(bouquet.get(i));
        }
    }
}
