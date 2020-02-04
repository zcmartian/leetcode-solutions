/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (47.11%)
 * Total Accepted:    73.4K
 * Total Submissions: 155.8K
 * Testcase Example:  '[ ["a","b"],["b","c"] ]\n[2.0,3.0]\n[ ["a","c"],["b","c"],["a","e"],["a","a"],["x","x"] ]'
 *
 * 
 * Equations are given in the format A / B = k, where  A and B are variables
 * represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return
 * -1.0.
 * 
 * Example:
 * Given  a / b = 2.0, b / c = 3.0. queries are:  a / c = ?,  b / a = ?, a / e
 * = ?,  a / a = ?, x / x = ? . return  [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * 
 * The input is:  vector<pair<string, string>> equations, vector<double>&
 * values, vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return  vector<double>.
 * 
 * 
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]
 * ]. 
 * 
 * 
 * 
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 * 
 */
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Pair> root = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            Pair r1 = root.get(equations[i][0]);
            Pair r2 = root.get(equations[i][1]);
            if (r1 == null && r2 == null) {
                root.put(equations[i][0], new Pair(equations[i][1], values[i]));
                root.put(equations[i][1], new Pair(equations[i][1], 1));
                rank.put(equations[i][0], 0);
                rank.put(equations[i][1], 1);
            } else if (r1 == null) {
                root.put(equations[i][0], new Pair(equations[i][1], values[i]));
                rank.put(equations[i][0], 0);
            } else if (r2 == null) {
                root.put(equations[i][1], new Pair(equations[i][0], 1 / values[i]));
                rank.put(equations[i][1], 0);
            } else {
                union(equations[i][0], equations[i][1], root, rank, values[i]);
            }

        }
        int n = queries.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            Pair r1 = find(root, queries[i][0]);
            Pair r2 = find(root, queries[i][1]);
            if (r1 == null || r2 == null) {
                res[i] = -1;
            } else if(r1.r.equals(r2.r)) {
                res[i] = r1.d / r2.d;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    private Pair find(Map<String, Pair> root, String p) {
        if (!root.containsKey(p)) {
            return null;
        }
        if (!root.get(p).r.equals(p)) {
            Pair r = find(root, root.get(p).r);
            root.put(p, new Pair(r.r, root.get(p).d * r.d));
        }
        return root.get(p);
    }
    private void union(String p1, String p2, Map<String, Pair> root, Map<String, Integer> rank, double val) {
        Pair r1 = find(root, p1);
        Pair r2 = find(root, p2);
        if (r1.r.equals(r2.r)) {
            return;
        }
        if (rank.get(r1.r) < rank.get(r2.r)) {
            root.put(r1.r, new Pair(r2.r, r2.d / r1.d * val));
        } else if (rank.get(r1.r) > rank.get(r2.r)) {
            root.put(r2.r, new Pair(r1.r, r1.d / r2.d / val));
        } else {
            root.put(r1.r, new Pair(r2.r, r2.d / r1.d * val));
            rank.put(r2.r, rank.get(r2.r) + 1);
        }

    }

    class Pair {
        String r;
        double d;
        Pair (String r, double d) {
            this.r = r;
            this.d = d;
        }
        public String toString() {
            return this.r + " " + this.d;
        }
    }
}
