package lab2_2;

public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(new Flower("Роза", "Красный", 7));
        bouquet.addFlower(new Flower("Роза", "Белый", 5));
        bouquet.print();
    }
}
