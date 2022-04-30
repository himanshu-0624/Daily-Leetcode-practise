class Solution {
    int[] parent;
    Map<String, Integer> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new int[40];
        map = new HashMap<>();
        int index = 0;
        for(int i=0; i<26; ++i){
            parent[i] = i;
        }
        double[][] graph = new double[40][40];
        for(double[] row: graph){
            Arrays.fill(row, -1.0);
        }
        for(int i=0; i<equations.size(); ++i){
            List<String> equa = equations.get(i);
            double val = values[i];
            map.put(equa.get(0), map.getOrDefault(equa.get(0), index++));
            map.put(equa.get(1), map.getOrDefault(equa.get(1), index++));
            int a = map.get(equa.get(0)), b = map.get(equa.get(1));
            graph[a][b] = val;
            graph[b][a] = 1/val;
            union(a, b);
        }
        double[] res = new double[queries.size()];
        int i=0;
        for(List<String> que: queries){
            String a = que.get(0), b = que.get(1);
            if(!map.containsKey(que.get(0))||!map.containsKey(que.get(1))){
                res[i++] = -1.0;
                continue;
            }
            int pa = find(map.get(que.get(0)));
            int pb = find(map.get(que.get(1)));
            if(pa != pb){
                res[i++] = -1.0;
                continue;
            }
            res[i++] = dfs(map.get(que.get(0)), map.get(que.get(1)), graph, index);
        }
        return res;
    }
    public double dfs(int s, int d, double[][] graph, int len){
        Set<Double> isVisited = new HashSet<>();
        Stack<double[]> st = new Stack<>();
        st.push(new double[]{s, 1});
        while(!st.isEmpty()){
            double[] cur = st.pop();
            if(isVisited.contains(cur[0])){
                continue;
            }
            isVisited.add(cur[0]);
            double[] weights = graph[(int)cur[0]];
            for(int i=0; i<len; ++i){
                double w = weights[i];
                if(w == -1) continue;
                if(i == d) {
                    return w*cur[1];
                }
                st.push(new double[]{i, w*cur[1]});
            }
        }
        return -1;
    }
    public void union(int a, int b){
        int pa = find(a), pb = find(b);
        if(pa < pb){
            parent[pb] = pa;
        }else{
            parent[pa] = pb;
        }
    }
    public int find(int i){
        int root = i;
        while(root != parent[root]){
            root = parent[root];
        }
        while(i != root){
            i = parent[i];
            parent[i] = root;
        }
        return root;
    }
}