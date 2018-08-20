package com.company.sort;

public class Insertion extends Example{
    public static void sort(Comparable[] a){
        //将a[]按升序排列
        int N = a.length;
        for(int i = 1; i < N; i++){
            //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for(int j = i; j > 0 && less(a[j],a[j-1]); j--){
                exch(a,j,j-1);
            }
        }
    }

    public static void sort(int[] a){
        int N = a.length;
        for(int i = 0; i < N; i++){
            for (int j = i; j > 0 && a[j] < a[j-1]; j--)
                swap(a,j,j-1);
        }
    }

    private static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
