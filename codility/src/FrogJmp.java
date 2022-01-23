

public class FrogJmp {
    static class Solution {
        public int solution(int X, int Y, int D) {
            double diff = Y - X;
            return (int) Math.ceil(diff/D);
        }
    }
    public static void main(String[] args) {
        System.out.println(new FrogJmp.Solution().solution(10,85, 30));
    }
}
