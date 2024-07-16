package LeetCodeDaily;

import java.util.HashMap;

public class CardStraightHand {
	public static void main(String[] args) {
		System.out.println(isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8},3));
	}
	 public static boolean isNStraightHand(int[] hand, int groupSize) {
	        if( (hand.length % groupSize) != 0) return false;
	        
	        HashMap<Integer, Integer> cardMap = new HashMap<Integer, Integer>();
	        
	        for (int i : hand) {
				cardMap.put(i, cardMap.getOrDefault(i, 0)+1);
			}
	        
	        System.out.println(cardMap);
	        while (cardMap.size() > 0) {
	        	
	        	// min Heap or sort map to get smallest card value
	        	int curCard = cardMap.entrySet().iterator().next().getKey();
	        	//check consecutive cards of len = groupSize
	        	for (int i = 0; i < groupSize; i++) {
					if ( !cardMap.containsKey(curCard + i)) return false;
					
					cardMap.put(curCard + i, cardMap.get(curCard + i)-1);
					
					if (cardMap.get(curCard + i) == 0) {
						cardMap.remove(curCard + i);
					}
				}
				
	        	
			}
	        
	        return true;
	    }


}
