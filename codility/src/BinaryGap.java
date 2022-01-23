import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class BinaryGap {

    static class Solution {
        public int solution(int N) {
            // write your code in Java SE 8
            String value = Integer.toBinaryString(N);
            value = value.replaceAll("[0]*$","");
            System.out.println("split : "+Arrays.toString(value.split("1")));
            Collection<Integer> arr = Arrays.stream(value.split("1")).map(o->o.length()).collect(Collectors.toList());
            if(!arr.isEmpty()){
                return Collections.max(arr);
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1041));
        System.out.println(new Solution().solution(32));
    }
}
