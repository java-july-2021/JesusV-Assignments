import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class PuzzlingJava{
    public ArrayList<Interger> sumNumbers(int[] myArr){
        ArrayList<Interger> values = new ArrayList<Interger>();
        int sum = 0;
        for(int num: myArr){
            if(int num > 10){
                values.add(num);
            }
        sum +=num;
        }
        System.out.println(String.format("Sum of values in array: %d", sum));
        System.out.println("Numbers > 10 in array: " + values);
    }

    public ArrayList<String> namesOver5(String[] myArr){
        ArrayList<String> names = new ArrayList<String>();
        shuffle(myArr);
        for(String name: myArr){
            if(name.length() > 5){
                names.add(name);
            }
        }
        System.out.println(Arrays.toString(myArr));
        return names;       
    }

    public void alphabetScrable(String[] alphabet){
        ArrayList<Character> alphabet = new ArrayList<Character>();
        shuffle(alphabet);
        System.out.println(alphabet[(alphabet.length -1)]);
        System.out.println(alphabet[0]);
        String[] vowels = {"a", "e", "i", "o", "u"};
        ArrayList<String> vowelList = new ArrayList<>(Arrays.asList(vowels));
        if(vowelList.contains(myArr[0])){
            System.out.println(String.format("%s is a vowel", myArr[0]));
        }
    }

    public void shuffleNumbers(Object[] myArr){
        Random rand = new Random();
        for(int i = 0; i < myArr.length/2; i++){
            Object memo = myArr[i];
            int ranIndex = rand.nextInt(myArr.length);
            myArr[i] = myArr[ranIndex];
            myArr[ranIndex] = memo;
        }
    }

    public ArrayList<Integer> randomObj(int min, int max, int length){
        Random rand = new Random();
        ArrayList<Integer> range = new ArrayList<Integer>();
        for(int i = 1; i <= length; i++){
            int val = rand.nextInt(max-min) + min;
            if(range.contains(val)){
                i--;
            }
            else{
                range.add(val);
            }
        }
        return range;
    }
    public ArrayList<Integer> sortedArr(ArrayList<Integer> myArr){
        Collections.sort(myArr);
        return myArr;
    }

    public String randomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        return generatedString;
    }

}