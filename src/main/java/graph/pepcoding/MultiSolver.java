package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class MultiSolver {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addUnDirectedEdge(0, 1, 10);
        g.addUnDirectedEdge(0, 3, 40);
        g.addUnDirectedEdge(1, 2, 10);
        g.addUnDirectedEdge(2, 3, 10);
        g.addUnDirectedEdge(3, 4, 2);
        g.addUnDirectedEdge(4, 5, 3);
        g.addUnDirectedEdge(4, 6, 8);
        g.addUnDirectedEdge(5, 6, 3);
        printAllPath(g.getGraph(), 0, 6);
    }

    static void printAllPath(List<Edge>[] g, int src, int dest) {
        Stack<Integer> s = new Stack<>();
        s.push(src);
        boolean[] visited = new boolean[g.length];
        Stats stats = new Stats();
        multiSolver(g, src, dest, s, 0, 40, 3, visited, stats);
        System.out.println("Largest Path: " + stats.largestPath + " = " + stats.largestWsf);
        System.out.println("Smallest Path: " + stats.smallestPath + " = " + stats.smallestWsf);
        System.out.println("Floor Path: " + stats.floorPath + " = " + stats.floorWsf);
        System.out.println("Ceil Path: " + stats.ceilPath + " = " + stats.ceilWsf);

        if(!stats.pq.isEmpty()) {
            Stats.Pair p=stats.pq.poll();
            System.out.println("Kth Largest Path: " + p.psf + " = " + p.weight);
        }

    }


    static void multiSolver(List<Edge>[] g, int src, int dest, Stack<Integer> visitedNode, int wsf, int criteria, int kthLargest, boolean[] visited, Stats stats) {
        if (src == dest) {
            String path = String.join("->", visitedNode.stream().map(String::valueOf).collect(Collectors.toList()));
            if (wsf > stats.largestWsf) {
                stats.setLargestPath(path);
                stats.setLargestWsf(wsf);
            }

            if (wsf < stats.smallestWsf) {
                stats.setSmallestPath(path);
                stats.setSmallestWsf(wsf);
            }

            if (wsf > criteria && wsf < stats.ceilWsf) {
                stats.setCeilPath(path);
                stats.setCeilWsf(wsf);
            }

            if (wsf < criteria && wsf > stats.floorWsf) {
                stats.setFloorPath(path);
                stats.setFloorWsf(wsf);
            }

            if (stats.pq.size() < kthLargest) {
                stats.pq.offer(new Stats.Pair(path, wsf));
            } else {
                if (stats.pq.peek().weight < wsf) {
                    stats.pq.poll();
                    stats.pq.offer(new Stats.Pair(path, wsf));
                }
            }


            return;
        }
        visited[src] = true;
        for (Edge nbr : g[src]) {
            if (visited[nbr.v] == false) {
                visitedNode.push(nbr.v);
                multiSolver(g, nbr.v, dest, visitedNode, wsf + nbr.w, criteria, kthLargest, visited, stats);
                if (!visitedNode.isEmpty()) {
                    visitedNode.pop();
                }
            }
        }
        visited[src] = false;

    }

    private static class Stats {
        private String largestPath;
        private String smallestPath;
        private String ceilPath;
        private String floorPath;
        private int largestWsf = Integer.MIN_VALUE;
        private int smallestWsf = Integer.MAX_VALUE;
        private int ceilWsf = Integer.MAX_VALUE;
        private int floorWsf = Integer.MIN_VALUE;
        private PriorityQueue<Pair> pq = new PriorityQueue<>();

        static class Pair implements Comparable<Pair> {
            String psf;
            int weight;

            public Pair(String psf, int weight) {
                this.psf = psf;
                this.weight = weight;
            }

            public String getPsf() {
                return psf;
            }

            public void setPsf(String psf) {
                this.psf = psf;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            @Override
            public int compareTo(Pair o) {
                return weight - o.weight;
            }
        }

        public String getLargestPath() {
            return largestPath;
        }

        public void setLargestPath(String largestPath) {
            this.largestPath = largestPath;
        }

        public String getSmallestPath() {
            return smallestPath;
        }

        public void setSmallestPath(String smallestPath) {
            this.smallestPath = smallestPath;
        }

        public String getCeilPath() {
            return ceilPath;
        }

        public void setCeilPath(String ceilPath) {
            this.ceilPath = ceilPath;
        }

        public String getFloorPath() {
            return floorPath;
        }

        public void setFloorPath(String floorPath) {
            this.floorPath = floorPath;
        }

        public int getLargestWsf() {
            return largestWsf;
        }

        public void setLargestWsf(int largestWsf) {
            this.largestWsf = largestWsf;
        }

        public int getSmallestWsf() {
            return smallestWsf;
        }

        public void setSmallestWsf(int smallestWsf) {
            this.smallestWsf = smallestWsf;
        }

        public int getCeilWsf() {
            return ceilWsf;
        }

        public void setCeilWsf(int ceilWsf) {
            this.ceilWsf = ceilWsf;
        }

        public int getFloorWsf() {
            return floorWsf;
        }

        public void setFloorWsf(int floorWsf) {
            this.floorWsf = floorWsf;
        }

        @Override
        public String toString() {
            return "Stats{" +
                    "largestPath='" + largestPath + '\'' +
                    ", smallestPath='" + smallestPath + '\'' +
                    ", ceilPath='" + ceilPath + '\'' +
                    ", floorPath='" + floorPath + '\'' +
                    ", largestWsf=" + largestWsf +
                    ", smallestWsf=" + smallestWsf +
                    ", ceilWsf=" + ceilWsf +
                    ", floorWsf=" + floorWsf +
                    ", pq=" + pq +
                    '}';
        }
    }
}
