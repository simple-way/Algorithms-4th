package com.company.sort;

public class Selection extends Example{
    public static void sort(Comparable[] a){
        //½«a[]°´ÉıĞòÅÅÁĞ
        int N = a.length;
        for(int i = 0; i < N; i++){
            int min = i;
            for(int j = i+1; j < N; j++){
                if(less(a[j], a[min])) min = j;
            }
            exch(a,i,min);
        }
    }

    public static void sort(int[] a){
        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[min])  min = j;
            }
            swap(a,i,min);
        }
    }

    private static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
