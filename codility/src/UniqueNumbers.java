import java.util.*;

/**
 * 입력 컬렉션에서 정확히 한 번 발생하는 모든 숫자를 사용된 시간과 관련하여 효율적으로 찾는 메서드를 작성하십시오.
 *
 * 예를 들어 findUniqueNumbers(Array.asList(1, 2, 1, 3 ))는 { 2, 3 }을 반환해야 합니다.
 */
public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        Map<Integer,Integer> obj = new HashMap<>();
        List list = Arrays.asList(numbers.toArray());
        for (int i = 0; i < list.size(); i++) {
            int value = (int) list.get(i);
            if(obj.get(value) == null){
                obj.put(value,value);
            }else{
                obj.remove(value);
            }
        }
        return obj.values();
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}