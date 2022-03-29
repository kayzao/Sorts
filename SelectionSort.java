import java.util.*;
import java.io.*;

class SelectionSort{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        selectsort(input);
        for(int i : input) System.out.print(i + " ");
        System.out.println();
        br.close();
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
