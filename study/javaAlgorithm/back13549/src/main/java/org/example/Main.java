package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Main {
    private static int su,brother, i;
    private static int[] min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        su = sc.nextInt();
        brother = sc.nextInt();
        min = new int[100000];
        i = 0;
        dfs(su,0);

        System.out.println(min[0]);
    }
    public static void dfs(int suLocation,int count){
        //종료 조건
        if (suLocation == brother){
            min[i++] = count;
            return ;
        }
        //조건
        while (true){
            dfs(suLocation + 1, count + 1);
            dfs(suLocation - 1, count + 1);
            dfs(suLocation * 2, count + 1);
        }
    }
}

public class Main {

    static int min = Integer.MAX_VALUE;
    static int n, k;
    static boolean[] visited;
    static int max = 100000;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        k = scan.nextInt();

        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;
            if(node.x == k)
                min = Math.min(min, node.time);
            if(node.x * 2 <= max && visited[node.x * 2] == false)
                q.offer(new Node(node.x * 2, node.time));
            if(node.x + 1 <= max && visited[node.x + 1] == false)
                q.offer(new Node(node.x + 1, node.time + 1));
            if(node.x - 1 >= 0 && visited[node.x - 1] == false)
                q.offer(new Node(node.x - 1, node.time + 1));
        }
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
