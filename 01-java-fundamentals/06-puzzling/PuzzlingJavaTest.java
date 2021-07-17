import java.util.ArrayList;
import java.util.Arrays;
public class PuzzleJavaTesting{
    
    public static void main(String[] args){
        PuzzleJava example = new PuzzleJava();
        int[] puzzle1 = {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        
        for(int val: example.firstPuzzle(puzzle1)){
            System.out.println(val);
        }

        
        String[] puzzle2 ={"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        for(String name: example.namesOver5(puzzle2)){
            System.out.println(name);
        }
        

        String[] puzzle3 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        example.alphabetScrable(puzzle3);

       
        for(int num: example.sortedArr(example.randomObj(55, 100, 10))){
            System.out.println(num);
        }
        
        System.out.println(example.randomString());

        String[] randomStrings;
        randomStrings = new String[10];
        for(int i = 0; i < 10; i++){
            randomStrings[i] = example.randomString();
        }
        System.out.println(Arrays.toString(randomStrings));
    }
}