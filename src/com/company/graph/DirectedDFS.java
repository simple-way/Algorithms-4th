package com.company.graph;

public class DirectedDFS {
    private boolean[] marked;
    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    public DirectedDFS(Digraph G,int ...a){
        marked = new boolean[G.V()];
        for(int s : a)
            if(!marked[s])
                dfs(G,s);
    }
    private void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w]) dfs(G,w);
    }
    public boolean marded(int v){
        return marked[v];
    }
    public static void main(String[] args){
        Digraph G = new Digraph(13);
        G.addEdge(4,2);
        G.addEdge(2,3);
        G.addEdge(3,2);
        G.addEdge(6,0);
        G.addEdge(0,1);
        G.addEdge(2,0);
        G.addEdge(11,12);
        G.addEdge(12,9);
        G.addEdge(9,10);
        G.addEdge(9,11);
        G.addEdge(8,9);
        G.addEdge(10,12);
        G.addEdge(11,4);
        G.addEdge(4,3);
        G.addEdge(3,5);
        G.addEdge(7,8);
        G.addEdge(8,7);
        G.addEdge(5,4);
        G.addEdge(0,5);
        G.addEdge(6,4);
        G.addEdge(6,9);
        G.addEdge(7,6);
        DirectedDFS reachable = new DirectedDFS(G,1,2,6);
        for(int v = 0; v < G.V(); v++)
            if(reachable.marded(v))
                System.out.print(v + " ");
    }
}
