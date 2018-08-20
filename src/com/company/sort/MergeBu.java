package com.company.sort;

public class MergeBu extends Example{
    private static Comparable[] aux;//�鲢����ĸ�������
    private static int[] arr;

    public static void sort(Comparable[] a){
        //����lgN�������鲢
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N; sz = sz + sz)//sz �������С
            for(int lo = 0; lo < N-sz; lo +=sz+sz)//lo:����������
                Merge.merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
    }

    public static void sort(int[] a){
        int N = a.length;
        arr = new int[a.length];
        for(int sz = 1; sz < N; sz +=sz)
            for(int lo = 0; lo < N-sz; lo += sz+sz)
                merge(a,lo,lo + sz-1,Math.min(N-1,lo+sz+sz-1));
    }

    public static void merge(int[] a, int lo, int mid, int hi){
        System.arraycopy(a, lo, arr, lo, hi + 1 - lo);
        int i=lo,j=mid+1;
        for(int k = lo; k <= hi; k++){
            if(i > mid)                 a[k] = arr[j++];
            else if(j > hi)             a[k] = arr[i++];
            else if(arr[i] < arr[j])    a[k] = arr[i++];
            else                        a[k] = arr[j++];
        }
    }


}
