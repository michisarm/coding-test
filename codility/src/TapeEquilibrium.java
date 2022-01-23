import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TapeEquilibrium {
    static class Solution {
        public int solution(int[] A) {
            int sum_first = 0;
            int sum_last = 0;

            for (int i = 0; i < A.length; i++) {
                sum_last += A[i];
            }
            int result = 0;
            for (int P = 1; P < A.length; P++) {
                sum_first += A[P-1];
                sum_last -= A[P-1];
                System.out.println(sum_first);
                int diff = Math.abs(sum_first - sum_last);
                if(result == 0){
                    result = diff;
                }
                if(result > diff){
                    result = diff;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3,1,2,4,3}));
    }
}
