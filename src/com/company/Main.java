package com.company;

import com.company.base.Queue;
import com.company.graph.DepthFirstPaths;
import com.company.graph.Graph;
import com.company.sort.*;
import com.company.tree.BST;
import com.company.tree.LinearProbingHashST;

import java.util.*;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addEdge(0,5);
        graph.addEdge(4,3);
        graph.addEdge(0,1);
        graph.addEdge(9,12);
        graph.addEdge(6,4);
        graph.addEdge(5,4);
        graph.addEdge(0,2);
        graph.addEdge(11,12);
        graph.addEdge(9,10);
        graph.addEdge(0,6);
        graph.addEdge(7,8);
        graph.addEdge(9,11);
        graph.addEdge(5,3);
        int s = 0;
        DepthFirstPaths paths = new DepthFirstPaths(graph,s);
        for(int v = 0; v < graph.V(); v++){
            if(paths.hasPathTo(v)){
                System.out.print(s + " to " + v + ": ");
                for (int x : paths.pathTo(v)){
                    if(x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }
                System.out.println();
            }
        }
        /*Queue<Integer> queue = new Queue<>();
        List<Integer> integers = new ArrayList<>(20);2,5,5,55,6,8,9,4,56,5,5,5,5,5,58,8,45,1,3,5,78,5,5,5,9,5,13,85
        Integer[] array = {2,5,5,55,6,8,9,4,56,5,5,5,5,5,58,8,45,1,3,5,78,5,5,5,9,5,13,85};
        System.out.println(array.length);
        for (Integer anArray : array) {
            queue.enqueue(anArray);
        }
        System.out.println(queue.size());
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue() + " ");
        }
        Scanner scanner = new Scanner(System.in);
        /*BST<Integer,Integer> bst = new BST<>();
        for (Integer anArray : array) {
            bst.put(anArray, anArray);
        }
        System.out.println(Integer.compare(5, 6));*/
        /*Iterable<Integer> iterable = bst.keys(8,65);
        for(Integer integer : iterable){
            System.out.print(integer + " ");
        }
        //Shell.sort(array);
        //Insertion.sort(array);
        //Selection.sort(array);
        //Merge.sort(array);
        //MergeBu.sort(array);
        //Quick.sort(array);
        /*Heap.sort(array);
        for(int a : array)
            System.out.print(a + " ");
        /*for(int a : array)
            integers.add(a);
        integers.sort(Comparator.comparingInt(o -> o));
        integers.forEach(integer -> System.out.print(integer + " "));
        /*int[] array1 = new int[array.length];
        for(int i = 1; i < array1.length; i++){
            array1[i] = array[i-1];
        }
        /*MaxPQ<Integer> maxPQ = new MaxPQ<>(array.length + 1);
        for(int i = 0; i < array.length ; i++) {
            maxPQ.insert(array[i]);
        }*/
        /*Heap.sort(array1);
        for(int i = 1; i < array1.length; i++)
            System.out.print(array1[i] + " ");
        //maxPQ.iterator();
        /*for(int i = 0; i < array.length; i++){
            System.out.print(maxPQ.delMax() + " ");
        }*/
    }
}
