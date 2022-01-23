import java.util.Arrays;

public class C20211227_로또의_최고순위_최저순위 {
    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int zero = 0;
            int min_win = 0;
            for (int n : lottos) {
                if (Arrays.stream(win_nums).anyMatch(i-> i == n)) {
                    min_win++;
                }
                if (n == 0) {
                    zero++;
                }
            }
            int[] answer = new int[2];
            answer[0] = score(min_win + zero);
            answer[1] = score(min_win);
            return answer;
        }

        public int score(int num) {
            int score;
            switch (num) {
                case 6:
                    score = 1;
                    break;
                case 5:
                    score = 2;
                    break;
                case 4:
                    score = 3;
                    break;
                case 3:
                    score = 4;
                    break;
                case 2:
                    score = 5;
                    break;
                default:
                    score = 6;
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }
}
