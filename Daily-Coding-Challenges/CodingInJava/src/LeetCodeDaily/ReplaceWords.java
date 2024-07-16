package LeetCodeDaily;

import java.util.List;

public class ReplaceWords {
	public static void main(String[] args) {
		System.out.println(replaceWords(null, null));
	}
	public static String replaceWords(List<String> dictionary, String sentence) {
        String[] sentArray = sentence.split(" ");
//        System.out.println(sentArray.length);
        for (int i = 0; i < sentArray.length; i++){
            for (int j = 0; j < dictionary.size(); j++){
                String curRoot = dictionary.get(j);
                int k = curRoot.length();
                if(sentArray[i].length()>=k &&
                        curRoot.substring(0,k).equals(sentArray[i].substring(0,k))  ){
//                    System.out.println(curRoot+ " "+ i);
//                    System.out.println(derivative+ " "+ i);
                    sentArray[i] = curRoot;

                }
            }
//            System.out.println();
        }
//        System.out.println(Arrays.toString(sentArray));
        return String.join(" ", sentArray);
    }
}
