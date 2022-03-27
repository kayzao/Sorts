import java.util.*;
import java.io.*;

class InsertionSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        insertSort(input);
        for(int i : input) System.out.print(i + " ");
        System.out.println();
        br.close();
    }
    static int[] insertSort(int[] data) {
        for(int i = 1; i < data.length; i++){
            if(data[i-1] > data[i]){ //if prev element > current element
                int c = data[i];
                int d = 0;
                for(int j = i - 1; j >= 0; j--){
                    if(data[j] < data[i]){
                        d = j + 1;
                        break;
                    }
                }
                //move all elements in range (i-1, d) up, and put i at now-open d
                for(int j = i-1; j >= d; j--){
                    data[j+1] = data[j];
                }
                data[d] = c;
            }
        }
        return data;
    }
}
