public class MainFruit {
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();

        Orange orange1 = new Orange(FruitConstants.ORANGE, 1);
        Apple apple = new Apple(FruitConstants.APPLE, 2);
        box1.addFruit(orange1);
        box1.addFruit(orange1);
        box1.addFruit(apple);
        box1.addFruit(orange1);

        box2.addFruit(apple);
        box2.addFruit(apple);
        box2.addFruit(orange1);
        box2.addFruit(apple);

        System.out.println(box1.getBoxWeight());
        System.out.println(box2.getBoxWeight());

        System.out.println(box1.compare(box2));

        box1.shift(box3);
    }
}
