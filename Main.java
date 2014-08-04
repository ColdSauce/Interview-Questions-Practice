import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Stefan on 7/26/2014.
 */
public class Main {
    public static void main(String[] args){
//        int[] arrayOfInts = createRandomIntArray(20000);
        int[] arrayOfInts = createDescendingArray(80000);
        long stuff = System.currentTimeMillis();
        bubbleSort(arrayOfInts);
        System.out.println(System.currentTimeMillis() - stuff);
        System.out.println();
        for(int i :  arrayOfInts){
            System.out.print(i + ", ");
        }
    }
    public static int[] createRandomIntArray(int size){
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = new Random().nextInt(60000);
        }
        return temp;
    }

    public static int[] createDescendingArray(int size){
        int[] temp = new int[size];
        for (int i = size; i > 0 ; i--){
            temp[size-i] = i;
        }
        return temp;
    }

    public static void bubbleSort(int[] arrayInQuestion){
        boolean isFinished = false;
        int iteration = 0;
        while(!isFinished) {
            isFinished = true;
            for (int i = 0; i < arrayInQuestion.length - 1 - iteration; i++) {
                if (arrayInQuestion[i] > arrayInQuestion[i + 1]) {
                    int temp = arrayInQuestion[i];
                    arrayInQuestion[i] = arrayInQuestion[i + 1];
                    arrayInQuestion[i + 1] = temp;
                    isFinished = false;
                }

            }
           iteration++;
        }
    }

    public static void selectionSort(int[] arrayInQuestion){
        int currentMin;
        for (int i = 0; i < arrayInQuestion.length-1; i++) {
            currentMin = i;
            for (int j = i + 1 ; j < arrayInQuestion.length; j++) {
                if(arrayInQuestion[j] < arrayInQuestion[currentMin]){
                    currentMin = j;
                }
            }
            int temp;
            temp = arrayInQuestion[i];
            arrayInQuestion[i] = arrayInQuestion[currentMin];
            arrayInQuestion[currentMin] = temp;
        }
    }

    public static List<Integer> insertionSort(int[] arrayInQuestion){
        List<Integer> sortedList = new ArrayList<Integer>();
        sortedList.add(arrayInQuestion[0]);
        for(int i = 1; i < arrayInQuestion.length;i++){
            int itemToAdd = arrayInQuestion[i];
            int currentSize = sortedList.size();
            for(int j = 0; j < currentSize;j++){
                if(j != sortedList.size()-1) {

                    if (itemToAdd > sortedList.get(j) && itemToAdd < sortedList.get(j+1)){

                        sortedList.add(j,itemToAdd);
                    }
                }
                else{
                    if(itemToAdd < sortedList.get(sortedList.size()-1)){
                        sortedList.add(0, itemToAdd);
                    }
                    else{
                        sortedList.add(itemToAdd);
                    }
                }

            }
        }
        return sortedList;

    }




}
