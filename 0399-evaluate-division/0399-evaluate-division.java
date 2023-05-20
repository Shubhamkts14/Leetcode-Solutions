import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Create a graph and populate it with equations and values
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        // Step 2: Evaluate queries using DFS traversal on the graph
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            results[i] = evaluateQuery(queries.get(i).get(0), queries.get(i).get(1), graph, new HashMap<>());
        }
        return results;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double quotient = values[i];

            // Create entries for dividend and divisor if they don't exist
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());

            // Update values for both directions (a/b = x => b/a = 1/x)
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }

        return graph;
    }

    private double evaluateQuery(String start, String end, Map<String, Map<String, Double>> graph, Map<String, Boolean> visited) {
        // If start or end variable is not present in the graph, cannot determine the result
        if (!graph.containsKey(start) || !graph.containsKey(end))
            return -1.0;

        // If start and end variables are the same, the result is 1.0
        if (start.equals(end))
            return 1.0;

        // Mark the current variable as visited
        visited.put(start, true);

        // Get all neighbors (divisors) of the current variable (dividend)
        Map<String, Double> neighbors = graph.get(start);
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            String nextVariable = neighbor.getKey();
            double edgeWeight = neighbor.getValue();

            // If the next variable has not been visited, perform DFS traversal
            if (!visited.containsKey(nextVariable)) {
                double result = evaluateQuery(nextVariable, end, graph, visited);

                // If a valid result is found, return the calculated value
                if (result != -1.0)
                    return edgeWeight * result;
            }
        }

        // No valid result found
        return -1.0;
    }
}
