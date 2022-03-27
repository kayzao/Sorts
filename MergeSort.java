import java.io.*;
import java.util.*;

class MergeSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        data = mergeSort(data);
        for (int i : data)
            System.out.print(i + " ");
        System.out.println();

        br.close();
    }

    public static int[] mergeSort(int[] data) { // Main method
        if (data.length < 2)
            return data;
        int[] temp = mergeSortSplit(data);
        data = Arrays.copyOf(temp, temp.length);
        return data;
    }

    public static int[] mergeSortSplit(int[] data) {
        // base case
        if (data.length == 1)
            return data;

        // makes the left half
        int[] left = new int[data.length / 2];
        left = Arrays.copyOf(data, left.length);

        // makes the right half
        int[] right = new int[data.length - left.length];
        for (int a = 0; a < right.length; a++) {
            right[a] = data[left.length + a];
        }

        // recursively splits
        return mergeSortCombine(mergeSortSplit(left), mergeSortSplit(right));
    }

    public static int[] mergeSortCombine(int[] left, int[] right) {
        int[] combine = new int[left.length + right.length];
        int a = 0;
        int b = 0;
        int i = 0; // indices for left, right and main

        while (a < left.length && b < right.length) { // combines the arrays in order from smallest to largest
            if (left[a] <= right[b]) {
                combine[i] = left[a];
                a++;
            } else {
                combine[i] = right[b];
                b++;
            }
            i++;
        }

        // one of the arrays is fully added to combine, add the other array
        if (a < left.length) {
            while (a < left.length) {
                combine[i] = left[a];
                a++;
                i++;
            }
        } else {
            while (b < right.length) {
                combine[i] = right[b];
                b++;
                i++;
            }
        }

        return combine;
    }
}
