import java.util.ArrayList;
import java.util.Arrays;

public class CyclicRotation {
    static class Solution {
        public int[] solution(int[] A, int K) {
            int[] result = A;
            for(int i=0; i<K; i++){
                ArrayList<Integer> arr = new ArrayList();
                for(int j=0; j<result.length-1; j++){
                    if(j == 0){
                        arr.add(result[result.length-1]);
                        arr.add(result[j]);
                    }else{
                        arr.add(result[j]);
                    }
                }
                result = arr.stream().mapToInt(Integer::intValue).toArray();
            }
            return result;
        }
    }

    static class Solution_2 {
        public int[] solution(int[] A, int K) {
            int [] arr = new int[A.length];
            for(int i=0; i<A.length; i++){
                arr[(i+K)%A.length] = A[i];
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(new Solution().solution(new int[]{0, 0, 0},1)));

        System.out.println(Arrays.toString(new Solution_2().solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(new Solution_2().solution(new int[]{0, 0, 0},1)));
    }
}
