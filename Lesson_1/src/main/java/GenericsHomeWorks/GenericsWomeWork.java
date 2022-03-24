package GenericsHomeWorks;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericsWomeWork {


    public static void main(String[] args) {
        String[] arr = new String[]{"Winter", "Spring", "Summer", "Autumn"};
        changeElements(arr,1,3);
        changeToArrayList(arr);
    }

    private static <T> void changeToArrayList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println(arrayList);
    }

    public static <T> void changeElements(T[] array, int indexFirst, int indexSecond) {
        indexFirst--;
        indexSecond--;
        T test = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = test;
        for (T t : array) System.out.println(t);
    }


}
