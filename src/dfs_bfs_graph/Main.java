/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dfs_bfs_graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author DiepTCNN
 */
class Queue<T> {
    private LinkedList<T> data;
    private int count;
    
}
class Graph {
    static public int INF = Integer.MAX_VALUE;
    int[][] adj;
    int n;
    boolean[] visited;
    public Graph() {
        n = 7;
        adj = new int[][] {
            {}, //dòng 0, bỏ qua
            {-1, 0, 1, 1, 1, 0, 0, 1},
            {-1, 1, 0, 1, 0, 1, 0, 0},
            {-1, 1, 1, 0, 0, 1, 0, 0},
            {-1, 1, 0, 0, 0, 0, 1, 0},
            {-1, 0, 1, 1, 0, 0, 1, 1},
            {-1, 0, 0, 0, 1, 1, 0, 0},
            {-1, 1, 0, 0, 0, 1, 0, 0}
        };
    }
    void display() {
        System.out.printf("%3c", '\\');
        for (int i = 1; i <= n; i++) 
            System.out.printf("%3c", (char) (i-1 + 'a'));
        System.out.println("");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3c", (char) (i-1 + 'a'));
            for(int j = 1; j <= n; j++)
                if (adj[i][j] != INF)
                    System.out.printf("%3d", adj[i][j]);
                else
                    System.out.printf("%3d", "inf");
            System.out.println("");
        }        
    }
    int degree(int u) {
        int s = 0;
        for (int i = 1; i <= n; i++)
            s += adj[u][i];
        return s;
    }
    int num_edges() {
        int s = 0;
        for (int i = 1; i <= n; i++) 
            s += degree(i);
        return s/2;
    }
    int count = 0;
    char intToChar(int i) {
        return (char) (i - 1 + 'a');
    }
    boolean connected() {
        visited = new boolean[n];
        count = 0;
        dfsRecursion(1);
        return (count == n);
    }
    void dfsRecursion(int start) {
        visited[start] = true;
        count++;
        System.out.print(" ---> " + intToChar(start));
        for(int i = 1; i <= n; i++)
            if(adj[start][i] != INF && !visited[i])
                dfsRecursion(i);
    }
    void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] mark = new boolean[n + 1];
        for (int i = 1; i <= n; i++) 
            mark[i] = false;
        stack.push(start);
        while(!stack.isEmpty()) {
            int current = stack.pop();
            mark[current] = true;
            for (int j = n; j >=1; j--)
                if(!mark[j] && adj[current][j] == 1)
                    stack.push(j);
            System.out.println(" ---> " + current);
        }
    }
    void bfsRecursion(int start) {
        
    }
    void bfs(int start) {
        Queue<Integer> queue = new Queue<>();   
        boolean[] mark = new boolean[n + 1];
        for (int i = 1; i <= n; i++) 
            mark[i] = false;
        queue.enqueue();
        while (!queue.isEmpty()) {
            
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Graph G2 = new Graph();
        G2.display();
        for (int i = 1; i <= G2.n; i++)
            System.out.println("Bac dinh " + i + " la: " + G2.degree(i));
        System.out.println("So canh la: " + G2.num_edges());    
    }
    
}
