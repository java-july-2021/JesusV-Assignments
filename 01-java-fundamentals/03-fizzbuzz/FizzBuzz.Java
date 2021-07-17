public class FizzBuzz {
    public static String fizzBuzz(int number){
        if(number % 5 == 0 && number % 3 == 0){
            return "FIZZ BUZZ";
        }
        else if(number % 3 == 0){
            return "FIZZ";
        }
        else if(number % 5 == 0){
            return "BUZZ";
        }
        else if(number == 2){
            return "2";
        }
        return Integer.toString(number);
    }

    public void tester(){
        for(int i = 0; i < 100; i++) {
            String result = fizzBuzz(i);
            String output = String.format("Number: %d :: Result: %s", i, result);
            System.out.println(output);
        }
    }
}