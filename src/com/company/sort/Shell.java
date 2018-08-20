package com.company.sort;

public class Shell extends Example {
    public static void sort(Comparable[] a) {
        //��a[]����������
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;//1,4,13,40,121,364,1093
        while (h >= 1) {
            //�������Ϊh����
            for (int i = h; i < N; i++) {
                //��a[i]���뵽a[i-h]��a[i-h]��a[i-h]...֮��
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void sort(int[] data) {
        int N = data.length;
        int h = 1;
        while (h < N) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && data[j] < data[j - h]; j -= h)
                    swap(data, j, j - h);
            h = h / 3;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
