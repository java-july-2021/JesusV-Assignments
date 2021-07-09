public class FizzBuzz.Java{
    public void FizzBuzzTest(){
        for(int i = 1, i <= 100; i++){
            String result = FizzBuzz(i);
            System.Out.println("Number" + i + " - " + "Result" + result);

        }
    }

   public String FizzBuzz(int value){
       if(value % 3 == 0 && val % == 0){
           return "FizzBuzz"
           else if(val % 3 == 0){
               return "Fizz";
           } else if (val % 5 == 0){
               return "Buzz";
           } else {
               return Integer.toString(value);
           }
       }
   } 
}