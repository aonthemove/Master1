public class HelloWorld {
    public String camelCase(String input) {
        String[] inputArr = input.split(" ");

        for (int x = 1; x < inputArr.length; x++) {
            inputArr[x] = Character.toUpperCase(inputArr[x].charAt(0)) + inputArr[x].substring(1);
        }

        return String.join("", inputArr);
    }
}
