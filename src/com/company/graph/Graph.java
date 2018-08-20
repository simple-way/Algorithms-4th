package com.company.graph;

import com.company.base.Bag;

import java.io.InputStream;
import java.util.Scanner;

public class Graph {
    private final int V;            //������Ŀ
    private int E;                  //�ߵ���Ŀ
    private Bag<Integer>[] adj;     //�ڽӱ�
    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }
    public Graph(InputStream in){
        Scanner scanner = new Scanner(in);
        V = scanner.nextInt();
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<>();
        int E = scanner.nextInt();
        for(int i = 0; i < E; i++){
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(v,w);
        }
    }
    public int V(){return V;}
    public int E(){return E;}
    public void addEdge(int v,int w){
        adj[v].add(w);      //��w��ӵ�v��������
        adj[w].add(v);      //��v��ӵ�w��������
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
