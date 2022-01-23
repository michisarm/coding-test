import java.util.Arrays;

public class PermCheck {
    static class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            int pivot = 1;
            for (int i = 0; i < A.length; i++) {
                if(i+1 != A[i]){
                    pivot = 0;
                    break;
                }
            }
            return pivot;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermCheck.Solution().solution(new int[]{4,1,3}));
    }
}
