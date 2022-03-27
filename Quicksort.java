import java.util.Arrays;

class Quicksort{

    public static void main(String[] args) {
        int[] data = {5, 1, 2, 9, 12, 8, 22, 7, 8, 19, 8};
        System.out.println("Original: " + Arrays.toString(data));
        int pivot = partition( data, 0, data.length-1);
        System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
        System.out.println("Modified: "+Arrays.toString(data));
        System.out.println();
    }
    public static int partition(int[] data, int low, int high){
        int randInd = (int)((Math.random() * (float)(high - low))+low); //random index between low and high
        int place = data[low]; //placeholder to swithch the random index and the first index
        int pivotV = data[randInd]; //pivot value

        boolean dupRight = false;
        System.out.println("low: " + low + "\nhigh: " + high);
        data[low] = pivotV; //why the fuck are we switching
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
            //System.out.println(Arrays.toString(data) + " high:" + high + " i:" + i);
        }
        //System.out.println(Arrays.toString(data) + " high:" + high);
        //move pivot to whereever high is
        //System.out.println("move time");
        int placeH = data[low];
        //int test = high % 2 == 0 ? high : high - 1;
        int test = high;
        if(data[test] > data[low]) test--;
        for(int j = low + 1; j <= test; j++){
            data[j-1] = data[j];
            //System.out.println(Arrays.toString(data));
        }
        data[test] = placeH;

        return test;
    }
}