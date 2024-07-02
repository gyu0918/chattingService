package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int[] parent;
    private static int[] visited;
    private static int N,K;
    private static int max = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new int[max + 1];
        parent = new int[max + 1];

        bfs(N,K);
        System.out.println(visited[K] - 1);
        Stack<Integer> stack = new Stack<>();
        int idx = K;
        while(idx != N){
            stack.push(idx);
            idx = parent[idx];
        }
        stack.push(idx);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }
    public static void bfs(int start,int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                visited[now + 1] = visited[now] + 1;
                parent[now + 1] = now;
                q.add(now + 1);
            }
            if (now - 1 >= 0 && visited[now - 1] == 0) {
                visited[now - 1] = visited[now] + 1;
                parent[now - 1] = now;
                q.add(now - 1);
            }
            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                visited[now * 2] = visited[now] + 1;
                parent[now * 2] = now;
                q.add(now * 2);
            }

            if (visited[end] != 0) return;
        }
    }

}