package com.company.graph;

import com.company.base.Queue;
import com.company.base.Stack;

public class BreadFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];//����ö�������·����֪��
        edgeTo = new int[G.V()];//����ö����һ֧·���ϵ����һ������
        this.s = s;//���
        bfs(G,s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;//������
        queue.enqueue(s);//�����������
        while (!queue.isEmpty()){
            int v = queue.dequeue();//�Ӷ�����ɾȥ��һ����
            for(int w : G.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;//�������·�������һ����
                    marked[w] = true;//���������Ϊ���·����֪
                    queue.enqueue(w);//��������ӵ�������
                }
            }
        }
    }
    public boolean hasPathTo(int v){ return marked[v];}
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v;x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
