import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    static class Solution {
        public int solution(int[] A) {
            Map<Integer,Integer> obj = new HashMap<>();
            for(int i=0; i<A.length; i++){
                int value = A[i];
                if(obj.get(value) == null){
                    obj.put(value,value);
                }else{
                    obj.remove(value);
                }
            }
            return (int) obj.values().toArray()[0];
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }
}
