import java.util.ArrayList;
import java.util.List;

public class Box {
    List<Fruit> fruitList;

    public Box() {
        this.fruitList = new ArrayList<>();
    }

    public  void addFruit(Fruit obj){
        if (fruitList.isEmpty()) {
            fruitList.add(obj);
        } else if (fruitList.contains(obj)){
            fruitList.add(obj);
        } else {
            System.out.println("This box with another fruit");
        }
    }

    public int getBoxWeight() {
        int weight = 0;
        for (Fruit fruit : fruitList) {
            weight = weight + fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box box){
        int weightThisBox = 0;
        for (Fruit fruit : fruitList) {
            weightThisBox = weightThisBox + fruit.getWeight();
        }
        int weightBox = 0;
        for (Fruit fruit : box.fruitList) {
            weightBox = weightBox + fruit.getWeight();
        }
        return weightBox == weightThisBox;
    }

    public void shift(Box box) {
        if (box.fruitList.isEmpty()){
            box.fruitList.addAll(fruitList);
            fruitList.clear();
        }else if (fruitList.contains(box.fruitList.get(0))) {
            box.fruitList.addAll(fruitList);
            fruitList.clear();
        } else {
            System.out.println("Can't do this operation, different fruits in boxes.");
        }
    }
}
