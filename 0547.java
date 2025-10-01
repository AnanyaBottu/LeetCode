class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visits[] = new boolean[isConnected.length];
        int counter = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visits[i] == false) {
                counter++;
                bfsOfGraph(i, isConnected, visits);
            }
        }
        return counter;
    }

    public List<Integer> bfsOfGraph(int V, int[][] adj, boolean[] visits) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(V);
        visits[V] = true;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            answer.add(node);

            for (int j = 0; j < adj.length; j++) {
                if (adj[node][j] == 1 && !visits[j]) {
                    visits[j] = true;
                    q.add(j);
                }
            }

        }
        return answer;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visits[] = new boolean[isConnected.length];
        int counter = 0;

        List<List<Integer>> ajLs = new ArrayList<List<Integer>>();
        for (int i = 0; i < isConnected.length; i++) {
            ajLs.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    ajLs.get(i).add(j);
                    ajLs.get(j).add(i);
                }
            }
        }
        for (int i = 0; i < isConnected.length; i++) {
            if (visits[i] == false) {
                counter++;
                bfsOfGraph(i, ajLs, visits);
            }
        }
        return counter;
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj, boolean[] visits) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(V);
        visits[V] = true;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            answer.add(node);

            for (Integer i : adj.get(node)) {
                if (visits[i] == false) {
                    visits[i] = true;
                    q.add(i);
                }
            }
        }
        return answer;
    }
}
