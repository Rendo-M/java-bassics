/**
 * hello
 */
import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalTime;

public class hello {

    public static void main(String[] args) {
        // greeting();
        // ex2();
        // power(5,3);
        // System.out.println(power(2,7));
        int[] array = new int[] {1, 6, 3, 4, 5, 6, 6, 4, 2};
        array = move_val_to_end(array, 6);
        System.out.println(Arrays.toString(array));
    }

    public static int[] move_val_to_end(int[] arr, int val) {
        int val_count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == val)
                val_count++;
            else if (val_count > 0)
                arr[i - val_count] = arr[i];
                        
        for (int i = arr.length-1; i >= arr.length - val_count; i--) 
            arr[i] = val;
        return arr;
    }

    public static double power(double a, int b) {
        if (b == 0) return 1;
        if (a == 0 || a == 1) return a;
        if (b < 0) {
            a = 1 / a;
            b = -b;
        }
        return a*power(a, b-1);       
    }

    public static void ex2() {
        int[] arr = new int[]{1,1,0,1,1,1,1};
        System.out.println(calculate_one(arr));
    }

    public static int calculate_one(int[] array) {
       int cur_max = 0;
       int max_count = 0;
       for (int i = 0; i < array.length; i++) {
            if (array[i] == 1){
                ++cur_max;
            } else {
                if (max_count < cur_max) max_count = cur_max;
                cur_max = 0;
            }   
       } 
       if (max_count < cur_max) max_count = cur_max;
       return max_count; 
    }
    public static void greeting() {
        Scanner scanner = new Scanner(System.in); 
        String name =  scanner.nextLine(); 
        String out = String.format("%s, %s, this is my first java program", greet_return(), name);
        System.out.println(out);
        scanner.close();
    }

    public static String greet_return() {
        String greeting = "Добрый вечер";
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        if (hour >= 5 && hour < 12){
            greeting = "Доброе утро";
        } else if (hour >= 12 && hour < 18){
            
            greeting = "Добрый день";
        } else if (hour >= 23 || hour < 5){
            greeting = "Доброй ночи";
        }
        return greeting;        
    }
}