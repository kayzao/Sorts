import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Quicksort{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("Original: " + Arrays.toString(data));
        int pivot = partition( data, 0, data.length-1);
        System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
        System.out.println("Modified: "+Arrays.toString(data));
        System.out.println();
        br.close();
    }
    public static int partition(int[] data, int low, int high){
        int randInd = (int)((Math.random() * (high - low))+low); //random index between low and high
        int place = data[low]; //placeholder to swithch the random index and the first index
        int pivotV = data[randInd]; //pivot value

        boolean dupRight = false;
        System.out.println("low: " + low + "\nhigh: " + high);
        data[low] = pivotV; 
        data[randInd] = place; //switch

        int i = low + 1;
        
        for(; i <= high; i++){
            
            if(data[i] > pivotV || (data[i] == pivotV && dupRight)){
                if(data[i] == pivotV && dupRight) dupRight = false;
                int placeK = data[high]; //switch the highest value and the value current comparing
                data[high] = data[i];
                data[i] = placeK;
                high--;
                i--;
            }
            if(data[i] == pivotV && !dupRight){
                dupRight = true;
            }
        }
        int placeH = data[low];
        int test = high;
        if(data[test] > data[low]) test--;
        for(int j = low + 1; j <= test; j++){
            data[j-1] = data[j];
        }
        data[test] = placeH;

        return test;
    }
}