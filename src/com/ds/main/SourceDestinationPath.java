package com.ds.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class SourceDestinationPath {
    public static void main(String args[]) throws Exception {
        final List<List<Integer>> graph = prepareGraphFromConsoleInput();
        final List<List<Integer>> paths = generatePaths(graph);
        printPaths(paths);
    }

    private static List<List<Integer>> prepareGraphFromConsoleInput() {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        List<List<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        while (in.hasNextLine()) {
            final String[] split = in.nextLine().split(", ");
            int s = Integer.parseInt(split[0]);
            int t = Integer.parseInt(split[1]);

            graph.get(s).add(t);
        }

        return graph;
    }

    public static List<List<Integer>> generatePaths(List<List<Integer>> graph) {
        final Set<Integer> sourceNodes = getSourceNodes(graph);

        List<List<Integer>> paths = new ArrayList<>();

        for (int sourceNode : sourceNodes) {
            paths.addAll(Objects.requireNonNull(dfs(graph, sourceNode, new HashSet<>(), new HashMap<>())));
        }

        return paths;
    }

    private static List<List<Integer>> dfs(final List<List<Integer>> graph, final int sourceNode, final Set<Integer> visited, final Map<Integer, List<List<Integer>>> dp) {
        if (visited.contains(sourceNode)) {
            return null;
        }

        if (dp.containsKey(sourceNode)) {
            return dp.get(sourceNode);
        }

        visited.add(sourceNode);

        List<List<Integer>> currentPath = new ArrayList<>();

        if (graph.get(sourceNode).isEmpty()) {
            List<Integer> totalPath = new ArrayList<>();
            totalPath.add(sourceNode);
            currentPath.add(totalPath);
        } else {
            for (int targetNode : graph.get(sourceNode)) {

                final List<List<Integer>> nextPaths = dfs(graph, targetNode, visited, dp);
                if (nextPaths != null) {
                    for (List<Integer> nextPath : nextPaths) {
                        List<Integer> totalPath = new ArrayList<>();
                        totalPath.add(sourceNode);
                        totalPath.addAll(nextPath);
                        currentPath.add(totalPath);
                    }
                }

            }
        }
        visited.remove(sourceNode);

        dp.put(sourceNode, currentPath);
        return currentPath;
    }

    private static Set<Integer> getSourceNodes(final List<List<Integer>> graph) {
        Set<Integer> sourceNodes = new HashSet<>();

        Set<Integer> intermediateNodes = new HashSet<>();

        for (int source = 0; source < graph.size(); source++) {
            sourceNodes.add(source);
            intermediateNodes.addAll(graph.get(source));
        }

        sourceNodes.removeAll(intermediateNodes);

        return sourceNodes;
    }

    private static void printPaths(List<List<Integer>> paths) {
        if (paths != null) {
            paths.forEach(SourceDestinationPath::printPath);
        }
    }

    private static void printPath(List<Integer> path) {
        if (path != null) {
            IntStream.range(0, path.size()).forEach(i -> {
                System.out.print(path.get(i));

                if (i < path.size() - 1) {
                    System.out.print("->");
                }
            });
            System.out.println();
        }
    }
}