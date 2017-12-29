import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode0127 {
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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(beginWord, 1, null));

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(wordList);

        int preLevel = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (endWord.equals(node.str)) {
                Node p = node;
                return p.level;
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
        return 0;
    }

    public static void main(String[] args) {
        LeetCode0127 leetcode = new LeetCode0127();
        List<String> wordList = new ArrayList<String>(
            Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(leetcode.ladderLength("hit", "cog", wordList));
    }
}