public class UserInput {

    public static class TextInput {
        String value = "";
        public void add(char c) {
            value += c;
        }
        public String getValue() {
            return value;
        }
    }

    public static class NumericInput extends TextInput {
        public void add(char c) {
            int myInt = Character.getNumericValue(c);
            if(myInt < 10){
                value += myInt;
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}