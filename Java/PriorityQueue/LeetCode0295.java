import java.util.PriorityQueue;
public class LeetCode0295 {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public LeetCode0295()
    {
        maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num)
    {

        if (maxHeap.size() < minHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian()
    {
        if (minHeap.size() - maxHeap.size() == 1) {
            return (double)minHeap.peek();
        } else {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args)
    {
        LeetCode0295 leetcode = new LeetCode0295();
        leetcode.addNum(1);
        leetcode.addNum(2);
        System.out.println(leetcode.findMedian());
        leetcode.addNum(3);
        System.out.println(leetcode.findMedian());
    }
}
