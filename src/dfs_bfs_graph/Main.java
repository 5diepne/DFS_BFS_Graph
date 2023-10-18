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

    public Queue() {
        data = new LinkedList<>();
        count = 0;
    }
    public void enqueue(T t) {
        data.add(t);
        count++;
    }
    public T dequeue() {
        if(!isEmpty())
            count--;
        return data.remove();
    }

    public boolean isEmpty() {
        return count == 0;
    }
}

class Graph {
    static public int INF = Integer.MAX_VALUE;
    int[][] adj;
    int n; // numVert
    public Graph() {
        n = 7; // số đỉnh của graph
        adj = new int[][] { // Khởi tạo ma trận kề với giá trị cho trước
            {}, //dòng 0, bỏ qua
            {-1, 0, 1, 1, 1, 0, 0, 1}, 
            {-1, 1, 0, 1, 0, 1, 0, 0}, 
            {-1, 1, 1, 0, 0, 1, 0, 0}, 
            {-1, 1, 0, 0, 0, 0, 1, 0}, 
            {-1, 0, 1, 1, 0, 0, 1, 1},
            {-1, 0, 0, 0, 1, 1, 0, 0},
            {-1, 1, 0, 0, 0, 1, 0, 0}
        };
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++)
            visited[i] = false;
    }
    public void Display() {
        System.out.printf("%3c", '\\');
        for (int i = 1; i <= n; i++) 
            System.out.printf("%3c", (char) (i-1 + 'a')); //in ra hàng đầu tiên
        System.out.println("");
        for (int i = 1; i <= n; i++) { //duyệt từng hàng của matrix
            System.out.printf("%3c", (char) (i-1 + 'a'));
            for(int j = 1; j <= n; j++)
                if (adj[i][j] != INF) // khác inf thì in số đó
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
    
    char intToChar(int i) { //chuyển đổi một số nguyên thành một ký tự
        return (char) (i - 1 + 'a');
    }
    public boolean connected() {
        visited = new boolean[n+1];
        count = 0;
        dfsRecursion(1);
        return (count == n); 
    }

    void dfsRecursion(int start) {
        visited[start] = true;
        count++;
        System.out.print(" ---> " + intToChar(start));
        for(int i = 1; i <= n; i++)
            if(adj[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfsRecursion(i);
            }          
    }
    int count = 0;
    boolean[] visited;
    
    
void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] mark = new boolean[n + 1];
        for (int i = 1; i <= n; i++) 
            mark[i] = false;
        stack.push(start);
        mark[start] = true;
        while(!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(" ---> " + intToChar(current));
            for (int i = n; i >= 1; i--)
                if(!mark[i] && adj[current][i] == 1) {
                    mark[i] = true;
                    stack.push(i);
                }
                    
        }
        System.out.println("");
    }
    void bfsUsingRecursion(int start) {
        Queue<Integer> queue = new Queue<>();
        visited[start] = true;
        queue.enqueue(start);
        bfsRecursion(queue);
    }
    void bfsRecursion(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;
        int current = queue.dequeue();
        System.out.print(" ---> " + intToChar(current));
        for (int i = 1; i <= n; i++)
            if(!visited[i] && adj[current][i] == 1) {
                visited[i] = true;
                queue.enqueue(i);
            }
        bfsRecursion(queue);
    }
    void bfs(int start) {
        Queue<Integer> queue = new Queue<>();   
        boolean[] mark = new boolean[n + 1];
        for (int i = 1; i <= n; i++) 
            mark[i] = false;
        queue.enqueue(start);
        mark[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            for(int i = 1; i <= n; i++)
                if(!mark[i] && adj[current][i] == 1) {
                    mark[i] = true;
                    queue.enqueue(i);
                }   
            System.out.print(" ---> " + intToChar(current));
        }
        System.out.println("");
    }
}
public class Main {
    public static void main(String[] args) {
        Graph G2 = new Graph();
        G2.Display();
        if(G2.connected())
            System.out.println(" is connected");
        else
            System.out.println(" NOT connected");
//        for (int i = 1; i <= G2.n; i++)
//            System.out.println("Bac dinh " + i + " la: " + G2.degree(i));
//        System.out.println("So canh la: " + G2.num_edges());    
    }
    
}
