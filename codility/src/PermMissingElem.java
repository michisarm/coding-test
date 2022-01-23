import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PermMissingElem {
    static class Solution {
        public int solution(int[] A) {
            Map<Integer,Integer> obj = new HashMap<>();
            IntStream.rangeClosed(1, A.length).mapToObj(i -> obj.put(i, i)).toArray();

            for(int i=0; i<A.length; i++){
                int value = A[i];
                if(obj.get(value) != null){
                    obj.remove(value);
                }
            }
            return (int) obj.values().toArray()[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2,3,1,5}));
    }
}
