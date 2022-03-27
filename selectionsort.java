import java.util.*;
import java.io.*;

class selectionsort{
    public static void main(String[] args) throws IOException{
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int[] input = new int[n];
        for(int i = 0; i < n; i++){
            input[i] = scan.nextInt();
        }
        input = selectsort(input);
        for(int i : input) System.out.print(i + " ");
        System.out.println();
        scan.close();
    }
    static int[] selectsort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = Integer.MAX_VALUE ;
            int jindex = 0;
            for(int j  = i; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    jindex = j;
                } 
                
            }
            int cache = arr[i];
            arr[i] = min;
            arr[jindex] = cache;
        }
        return arr;
    }
}