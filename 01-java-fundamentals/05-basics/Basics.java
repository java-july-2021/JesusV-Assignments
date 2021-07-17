import java.util.ArrayList;

public class Basics{
    public static void oneTo255(){
        for(int a = 0; i<=255, a++){
        System.out.println(a);
        }
    }

    public static void printOdds(){
        for(int b = 0, b<=255, b++){
            if(b%2=1){
                System.out.println(b);
            }
        }
    }

    public static void printSum(){
        int sum = 0;
        for(int c = 0, c <= 255, c++){
            sum = sum + c;
            System.out.println("New Number: " + c + " Sum: " + sum);
        }
    }

    public static void iteratingArray(){
        int arr[] = {1, 3, 5, 7, 9, 13}
        for(int d = 0, d < arr.length, d++){
            System.out.println(d);
        }
    }

    public static void maxValue(){
        int arr[] = {-3, -5, -7, -1, 0};

         int largest = largeArray[0]; 

         for (int e = 0; e < arr.length; e++){
             if (largeArray[e] > largest) {
                 largest = largeArray[e];
             }
        
         System.out.println(largest);
         }
    }

    public static void getAverage(){
        int arr[] = {2, 10, 3};
         int f, sum, avg;
         sum = 0;
         for (f = 0; f < arr.length; f++){
             sum += arr[f];
         }

         avg = sum / arr.length;
         System.out.println(avg);
    }

    public static void arrayOddNumbers(){
        ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int g = 0; g <= 255; g++) {
			if(g % 2 = 1)
				nums.add(g);
		}
		return nums;
	}
    
    public static void greaterThanY(int[] arr, int y){
        int count = 0;
		for(int num: arr) {
			if(num > y)
				count++;
		}
		return count;
    }

    public static void squareArray(int[] nums) {
		for(int h = 0; h < nums.length; h++) {
			nums[h] = nums[h] * nums[h];	
		}
	}

    public static void eliminateNegativeNumbers(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < 0)
				nums[i] = 0;
		}
	}

    public static void MaxMinAverage(int[] nums) {
		int min = FindMin(nums);
		int max = FindMax(nums);
		double avg = GetAverage(nums);
		System.out.println(String.format("Max: %d, Min: %d, Average: %f", max, min, avg));
	}

    public static void ShiftArrayValues(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			arr[j-1] = arr[j];
		}
		arr[arr.length-1] = 0;
	}
}