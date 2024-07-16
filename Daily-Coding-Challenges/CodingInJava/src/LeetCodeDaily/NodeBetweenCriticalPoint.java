package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class NodeBetweenCriticalPoint {
    public static void main(String[] args) {
        ListNode he = new ListNode(5,new ListNode(3,new ListNode(1,new ListNode(2,new ListNode(5,new ListNode(1,new ListNode(2)))))));
        System.out.println(nodesBetweenCriticalPoints(he));
    }
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[]{-1,-1};
        int idx = 1;
        ListNode prev = head;
        ListNode cur = head.next;
        List<Integer> idxs = new ArrayList<>();

        while(cur.next != null){
            int curIdx = idx;
            if( cur.val < prev.val && cur.val < cur.next.val ){
//                calc idx
                res[0]=Math.min(Math.abs(curIdx-res[0]), res[0]);
                idxs.add(curIdx);
            } else if( cur.val > prev.val && cur.val > cur.next.val ){
                res[1]=Math.max(Math.abs(curIdx-res[1]), res[1]);
                idxs.add(curIdx);
            }
            prev = cur;
            cur = cur.next;
            idx++;
        }
        res[0] = idxs.get(idxs.size()-1) - idxs.get(idxs.size()-2);
        res[1] = idxs.get(idxs.size()-1) - idxs.get(0);
        System.out.println(Arrays.toString(res));
        return res;
    }
}
