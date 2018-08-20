package com.company.sort;

public class Heap  {
    public static void sort(int[] a){
        int N = a.length;
        for(int k = N/2 - 1; k >= 0; k--)
            sink(a,k,N);
        for(int i = N-1; i > 0; i--){
            swap(a,0,i);
            sink(a,0,i);
        }
        /*while (N > 0){
            swap(a,0,--N);
            sink(a,0,N);
        }*/
    }

    private static void sink(int[] a, int k, int N){
        while (2 * k + 1< N){
            int j = 2 * k + 1;
            if(j + 1 < N && a[j] < a[j+1])
                j++;
            if(a[k] >= a[j]) break;
            swap(a,k,j);
            k = j;
        }
    }

    private static void heapSink(int[] a,int k, int N){
        int largest = k;
        int left = 2*k+1;
        int right = 2*k+2;
        if(left < N && a[left] > a[largest])
            largest = left;
        if(right < N && a[right] > a[largest])
            largest = right;
        if(largest != k){
            swap(a,k,largest);
            heapSink(a,largest,N);
        }
    }

    private static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
