import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode0126_BFS {

    class Node {
        String str;
        int level;
        Node parent;

        public Node(String str, int level, Node parent) {
            this.str = str;
            this.level = level;
            this.parent = parent;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<List<String>>();
        if (wordList == null || wordList.size() == 0) {
            return result;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(beginWord, 1, null));

        int min = wordList.size() + 1;

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(wordList);

        int preLevel = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.level > min) {
                continue;
            }

            if (endWord.equals(node.str)) {
                Node p = node;
                min = p.level;
                LinkedList<String> res = new LinkedList<String>();
                while (p != null) {
                    res.addFirst(p.str);
                    p = p.parent;
                }
                result.add(res);
                continue;
            }

            if (preLevel < node.level) {
                preLevel = node.level;
                unvisited.removeAll(visited);
            }

            char[] arr = node.str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    arr[i] = j;
                    String newStr = new String(arr);
                    if (!unvisited.contains(newStr)) {
                        continue;
                    }
                    visited.add(newStr);
                    Node newNode = new Node(newStr, node.level + 1, node);
                    queue.offer(newNode);
                }
                arr[i] = c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0126_BFS leetcode = new LeetCode0126_BFS();
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        List<List<String>> result = leetcode.findLadders("hit", "cog", wordList);
        for (int i = 0; i < result.size(); i++) {
            System.out.println((result.get(i).toString()));
        }
    }
}