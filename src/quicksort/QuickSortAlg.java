package quicksort;

import java.util.Random;

public class QuickSortAlg {

    public static void main(String[] args){
        int[] array = {3,2,4,6,5,1};
        printArray(array);
        array = quicksort(array,0,array.length);
        printArray(array);
    }

    public static int[] quicksort(int[] array,int begin,int end){
        PartitionResult partitionResult = null;
        if(end-begin>1) { // if the array is bigger than 1

            partitionResult = partition(array, begin, end);
            array = quicksort(partitionResult.array, begin , partitionResult.pivotIndex);
            array = quicksort(array, partitionResult.pivotIndex+1 , end);

        }
        return array;

    }


    public static PartitionResult partition(int[] array, int begin, int end){
        int pivotIndex = choosePivot(begin, end);
        int pivotValue = array[pivotIndex];
        // keep track of up to where is ordered
        int i = begin;
        for( int j= begin;j<end;j++){
            if(array[j]<pivotValue){
                // in case the pivot need to move
                if(array[i]==pivotValue){
                    pivotIndex=j;
                }
                int aux = array[j];
                array[j]=array[i];
                array[i]=aux;
                i++;
            }
        }
        int aux = array[i];
        array[i]=pivotValue;
        array[pivotIndex]=aux;

        return new PartitionResult(array,i);
    }

    public static int choosePivot(int begin, int end){
        return new Random().nextInt(end-begin)+begin;
    }

    public static void printArray(int[] array){
        StringBuilder builder = new StringBuilder("{");
        for(int val: array){
            builder.append(val).append(",");
        }
        builder.append("}");
        System.out.println(builder.toString());
    }

    static class PartitionResult{
        public int[] array;
        public int pivotIndex;

        PartitionResult(int[] array, int pivotIndex){
            this.array = array;
            this.pivotIndex = pivotIndex;
        }
    }
}
