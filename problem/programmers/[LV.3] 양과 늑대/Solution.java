package org.example;

import java.util.ArrayList;
import java.util.List;

public class SheepAndWolf {

    int[] I;
    int[][] tree;
    int max = 0;

    public int solution(int[] info, int[][] edges) {
        I = info;
        tree = new int[info.length][info.length];

        for (int i=0; i<edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            tree[node1][node2] = 1;
        }

        for (int i=0; i<info.length; i++) {
            for (int k=0; k<tree.length; k++) {
                if (tree[i][k] == 1) {
                    if (info[k] == 1) tree[i][k] = 2;
                }
            }
        }

        List<Integer> visitableNodes = new ArrayList<>();
        for (int a=0; a<tree[0].length; a++) {
            if (tree[0][a] != 0) {
                visitableNodes.add(a);
            }
        }
        dfs(0, visitableNodes, 1, 0, 0);
        return max;
    }

    public void dfs(int node, List<Integer> visitableNodes, int sheep, int wolf, int depth) {

        if (sheep <= wolf) {
            max = Math.max(max, sheep);
            return;
        }
        max = Math.max(sheep, max);

        for (int i=0; i<visitableNodes.size(); i++) {
            int nextNode = visitableNodes.get(i);
            List<Integer> newVisitableNodes = new ArrayList<>();

            // 다른 노드 추가
            for (Integer visitableNode : visitableNodes)
                if (nextNode != visitableNode) newVisitableNodes.add(visitableNode);

            // 다음 노드와 연결된 노드 추가
            for (int k=0; k<tree.length; k++)
                if (tree[nextNode][k] != 0) newVisitableNodes.add(k);
    
            if (I[nextNode] == 0) dfs(nextNode, newVisitableNodes, sheep+1, wolf, depth + 1); // 양인 경우
            else dfs(nextNode, newVisitableNodes, sheep, wolf+1, depth + 1); // 늑대인 경우
        }

    }

}
