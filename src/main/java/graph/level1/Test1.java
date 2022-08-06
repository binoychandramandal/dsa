package graph.level1;

import java.util.*;

public class Test1 {

    static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        System.out.println(hasPath(graph, 0, 6, new boolean[vertices]));
        System.out.println(hasPath(graph, 0, 60, new boolean[vertices]));
        printAllPaths(graph, 0, 6, new boolean[vertices], 0 + "");
        System.out.println("=============================");
        int criteria = 40;
        int k = 3;
        multiSolver(graph, 0, 6, new boolean[vertices], criteria, 3, 0 + "", 0);
        System.out.println("Smallest Path-> " + sPath + "@" + sPathWt);
        System.out.println("Largest Path-> " + lPath + "@" + lPathWt);
        System.out.println("Just larger  Path than -> " + criteria + "=" + cPath + "@" + cPathWt);
        System.out.println("Just Smaller  Path than -> " + criteria + "=" + fPath + "@" + fPathWt);
        System.out.println(k + "th largest  Path = " + pq.peek().psf + "@" + pq.peek().wsf);


        System.out.println("Get all connected component");
        getConnectedComponent(graph, vertices, new boolean[vertices]);
        System.out.println("Is graph connected-> " + isGraphConnected(graph, vertices));
        System.out.println("Is graph bipartite-> " + isBiPartite(graph));


        int[][] gr = {
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };

        System.out.println("Count island-> " + countIsland(gr));

        hamiltonionPath(graph, 0);


        //printKnightTour(new int[8][8],0,0,1);

        System.out.println("BFS");
        bfs(graph, 0);

        System.out.println("Is cyclic-> " + isGraphCyclic(graph));
        System.out.println("Is Bipartite-> " + isBiPartite(graph));
        System.out.println("Spread count-> " + countSpreadInfection(graph, 0, 3));
        dijkstraAlgo(graph, 0);
        primAlo(graph, 0);
        System.out.println("Topological sort");
        topologySort(graph);
        dfsIterative(graph,0);
    }


    /**
     * is a path  available or not between src and dest;
     *
     * @param graph
     * @param src
     * @param dest
     * @param isVisited
     * @return
     */
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] isVisited) {
        if (src == dest) {
            return true;
        }
        isVisited[src] = true;
        for (Edge edge : graph[src]) {
            if (isVisited[edge.nbr] == false) {
                boolean hasPath = hasPath(graph, edge.nbr, dest, isVisited);
                if (hasPath) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Print all the pth from source to destination
     *
     * @param graph
     * @param src
     * @param dest
     * @param isVisited
     * @param psf
     */
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] isVisited, String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }
        isVisited[src] = true;
        for (Edge edge : graph[src]) {
            if (isVisited[edge.nbr] == false) {
                printAllPaths(graph, edge.nbr, dest, isVisited, psf + " -> " + edge.nbr);
            }
        }
        isVisited[src] = false;
    }


    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        public Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    private static String sPath;
    private static int sPathWt = Integer.MAX_VALUE;
    private static String lPath;
    private static int lPathWt = Integer.MIN_VALUE;
    private static String cPath;
    private static int cPathWt = Integer.MAX_VALUE;
    private static String fPath;
    private static int fPathWt = Integer.MIN_VALUE;
    private static PriorityQueue<Pair> pq = new PriorityQueue<>();

    /**
     * Find  stats
     *
     * @param graph
     * @param src
     * @param dest
     * @param isVisited
     * @param criteria
     * @param kThLargest
     * @param psf
     * @param wsf
     */
    public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] isVisited, int criteria, int kThLargest, String psf, int wsf) {
        if (src == dest) {
            System.out.println(psf + "@" + wsf);
            if (wsf < sPathWt) {
                sPathWt = wsf;
                sPath = psf;
            }
            if (wsf > lPathWt) {
                lPathWt = wsf;
                lPath = psf;
            }
            if (wsf > criteria && wsf < cPathWt) {
                cPathWt = wsf;
                cPath = psf;
            }
            if (wsf < criteria && wsf > fPathWt) {
                fPathWt = wsf;
                fPath = psf;
            }
            if (pq.size() < kThLargest) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (!pq.isEmpty() && wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }
        isVisited[src] = true;
        for (Edge edge : graph[src]) {
            if (isVisited[edge.nbr] == false) {
                multiSolver(graph, edge.nbr, dest, isVisited, criteria, kThLargest, psf + " -> " + edge.nbr, wsf + edge.wt);
            }
        }
        isVisited[src] = false;
    }

    /**
     * Get all connected component of a graph
     *
     * @param graph
     * @param vertices
     * @param visited
     */
    public static ArrayList<ArrayList<Integer>> getConnectedComponent(ArrayList<Edge>[] graph, int vertices, boolean[] visited) {
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateCom(graph, i, comp, visited);
                components.add(comp);
            }
        }
        System.out.println(components);
        return components;
    }

    private static void drawTreeAndGenerateCom(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                drawTreeAndGenerateCom(graph, edge.nbr, comp, visited);
            }
        }
    }

    /**
     * Is graph connected.
     * we will use getConnectedComponent method solve this.
     * If it returned only graph then its connected graph.
     * Connected graph mean from any vertices , can raom any othre vertices
     *
     * @param graph
     * @param vertices
     * @return
     */
    public static boolean isGraphConnected(ArrayList<Edge>[] graph, int vertices) {
        return getConnectedComponent(graph, vertices, new boolean[vertices]).size() == 1;
    }

    /**
     * Get number of island in two d array
     *
     * @param graph
     * @return
     */
    public static int countIsland(int[][] graph) {
        boolean[][] visited = new boolean[graph.length][graph.length];
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0 && visited[i][j] == false) {
                    drawTreeForComponent(graph, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void drawTreeForComponent(int[][] graph, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= graph.length || j >= graph.length || graph[i][j] == 1 || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        drawTreeForComponent(graph, i - 1, j, visited);
        drawTreeForComponent(graph, i, j + 1, visited);
        drawTreeForComponent(graph, i, j - 1, visited);
        drawTreeForComponent(graph, i + 1, j, visited);
    }

    /**
     * Hamiltonion Path finding and if hamilton cycle then * else .
     *
     * @param graph
     * @param src
     */
    private static void hamiltonionPath(ArrayList<Edge>[] graph, int src) {
        HashSet<Integer> visited = new HashSet<>();
        hamiltonionPath(graph, src, visited, src + "", src);
    }

    private static void hamiltonionPath(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int oSrc) {
        if (visited.size() == graph.length - 1) {
            System.out.println(psf);
            boolean closingEdgeFound = false;
            for (Edge edge : graph[src]) {
                if (edge.nbr == oSrc) {
                    closingEdgeFound = true;
                    return;
                }
            }
            if (closingEdgeFound) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            return;
        }
        visited.add(src);
        for (Edge edge : graph[src]) {
            if (visited.contains(edge.nbr) == false) {
                hamiltonionPath(graph, edge.nbr, visited, psf + edge.nbr, oSrc);
            }
        }
        visited.remove(src);
    }

    /**
     * Print knight Tour
     *
     * @param chess
     * @param r
     * @param c
     * @param move
     */
    public static void printKnightTour(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0) {
            return;
        } else if (move == chess.length * chess.length) {
            chess[r][c] = move;
            displayChess(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = move;
        printKnightTour(chess, r - 2, c + 1, move + 1);
        printKnightTour(chess, r - 1, c + 2, move + 1);
        printKnightTour(chess, r + 1, c + 2, move + 1);
        printKnightTour(chess, r + 2, c + 1, move + 1);
        printKnightTour(chess, r + 2, c - 1, move + 1);
        printKnightTour(chess, r + 1, c - 2, move + 1);
        printKnightTour(chess, r - 1, c - 2, move + 1);
        printKnightTour(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;
    }

    private static void displayChess(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }

    static class BfsPair {
        int src;
        String psf;

        public BfsPair(int src, String psf) {
            this.src = src;
            this.psf = psf;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int src) {
        ArrayDeque<BfsPair> q = new ArrayDeque<>();
        q.add(new BfsPair(src, src + ""));
        boolean[] visited = new boolean[graph.length];
        while (!q.isEmpty()) {
            BfsPair rem = q.removeFirst();
            if (visited[rem.src] == true) {
                continue;
            }
            visited[rem.src] = true;
            System.out.println(rem.src + "@" + rem.psf);
            for (Edge edge : graph[rem.src]) {
                if (visited[edge.nbr] == false) {
                    q.add(new BfsPair(edge.nbr, rem.psf + edge.nbr));
                }
            }
        }

    }

    /**
     * Is graph cyclic
     *
     * @param graph
     * @return
     */
    public static boolean isGraphCyclic(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                if (isCyclic(graph, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        ArrayDeque<BfsPair> q = new ArrayDeque<>();
        q.add(new BfsPair(src, src + ""));
        while (!q.isEmpty()) {
            BfsPair rem = q.removeFirst();
            if (visited[rem.src] == true) {
                return true;
            }
            visited[rem.src] = true;
            for (Edge edge : graph[rem.src]) {
                if (visited[edge.nbr] == false) {
                    q.add(new BfsPair(edge.nbr, rem.psf + edge.nbr));
                }
            }
        }
        return false;
    }

    static class BiParTitePair {
        int v;
        int level;
        String psf;

        public BiParTitePair(int v, String psf, int level) {
            this.v = v;
            this.level = level;
            this.psf = psf;
        }
    }

    /**
     * Is bipartite
     *
     * @param graph
     * @return
     */
    public static boolean isBiPartite(ArrayList<Edge>[] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) {
                if (checkComponentForBipPartiteness(graph, i, visited) == false) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean checkComponentForBipPartiteness(ArrayList<Edge>[] graph, int src, int[] visited) {
        ArrayDeque<BiParTitePair> q = new ArrayDeque<>();
        q.add(new BiParTitePair(src, src + "", 0));
        while (!q.isEmpty()) {
            BiParTitePair rem = q.removeFirst();
            if (visited[rem.v] != -1) {
                if (rem.level != visited[rem.v])
                    return false;
            } else {
                visited[rem.v] = rem.level;
            }

            for (Edge edge : graph[rem.v]) {
                if (visited[edge.nbr] == -1) {
                    q.add(new BiParTitePair(edge.nbr, rem.psf + edge.nbr, rem.level + 1));
                }
            }
        }
        return true;
    }

    static class InfectionPair {
        int v;
        int time;

        public InfectionPair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    /**
     * Infection speraed
     *
     * @param graph
     * @param src
     * @return
     */
    public static int countSpreadInfection(ArrayList<Edge>[] graph, int src, int time) {
        ArrayDeque<InfectionPair> q = new ArrayDeque<>();
        int[] visited = new int[graph.length];
        q.add(new InfectionPair(src, 1));
        int count = 0;

        while (!q.isEmpty()) {
            InfectionPair rem = q.removeFirst();
            if (visited[rem.v] > 0) {
                continue;
            }
            visited[rem.v] = rem.time;
            if (rem.time > time) {
                break;
            }
            count++;
            for (Edge edge : graph[rem.v]) {
                if (visited[edge.nbr] == 0) {
                    q.add(new InfectionPair(edge.nbr, rem.time + 1));
                }
            }
        }
        return count;
    }

    static class DikstraPair implements Comparable<DikstraPair> {
        int v;
        int wsf;
        String psf;

        public DikstraPair(int v, String psf, int wsf) {
            this.v = v;
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(DikstraPair o) {
            return this.wsf - o.wsf;
        }
    }

    /**
     * Dijkstra algorithm
     *
     * @param graph
     * @param src
     */
    public static void dijkstraAlgo(ArrayList<Edge>[] graph, int src) {
        PriorityQueue<DikstraPair> q = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        q.add(new DikstraPair(src, src + "", 0));
        while (!q.isEmpty()) {
            DikstraPair rem = q.remove();
            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "via " + rem.psf + "@" + rem.wsf);
            for (Edge edge : graph[rem.v]) {
                if (visited[edge.nbr] == false) {
                    q.add(new DikstraPair(edge.nbr, rem.psf + edge.nbr, +rem.wsf + edge.wt));
                }
            }
        }
    }


    static class PrimPair implements Comparable<PrimPair> {
        int v;
        int av;
        int wt;

        public PrimPair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        @Override
        public int compareTo(PrimPair o) {
            return this.wt - o.wt;
        }
    }

    /**
     * Prims algorithm to find minimum spanning tree
     *
     * @param graph
     * @param src
     */
    public static void primAlo(ArrayList<Edge>[] graph, int src) {
        PriorityQueue<PrimPair> q = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        q.add(new PrimPair(src, -1, 0));
        while (!q.isEmpty()) {
            PrimPair rem = q.remove();
            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            if (rem.av != -1)
                System.out.println("[" + rem.v + "- " + rem.av + "@" + rem.wt + "]");
            for (Edge edge : graph[rem.v]) {
                if (visited[edge.nbr] == false) {
                    q.add(new PrimPair(edge.nbr, rem.v, edge.wt));
                }
            }
        }
    }

    /**
     * Topological sort
     *
     * @param graph
     */
    public static void topologySort(ArrayList<Edge>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                topologicalSort(graph, i, visited, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();

    }

    private static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> s) {
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                topologicalSort(graph, edge.nbr, visited, s);
            }
        }
        s.push(src);
    }

    static class DfsPair {
        int v;
        String psf;

        public DfsPair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    /**
     * Iterative dfs
     *
     * @param graph
     * @param src
     */
    public static void dfsIterative(ArrayList<Edge>[] graph, int src) {
        boolean[] visited = new boolean[graph.length];
        Stack<DfsPair> s = new Stack<>();
        s.push(new DfsPair(src, src + ""));
        while (!s.isEmpty()) {
            DfsPair rem = s.pop();
            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "@" + rem.psf);
            for (Edge edge : graph[rem.v]) {
                if (visited[edge.nbr] == false) {
                    s.push(new DfsPair(edge.nbr, rem.psf + edge.nbr));
                }
            }
        }
    }


}
