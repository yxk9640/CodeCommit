package LeetCodeDaily;

import java.util.LinkedList;
import java.util.Queue;

public class FindWinnerQue {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }
    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        System.out.println(queue);

        while (queue.size() > 1){
            for (int j = 0; j < k-1; j++) {
                queue.add(queue.remove());
            }
            queue.remove();

        }

        return queue.peek();
    }
}
