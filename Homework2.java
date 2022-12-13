
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Homework2 {
    
    
    public static void main(String[] args) {
    
    dict_input();
    }

    public static void dict_input(){
        int result = 0;
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> values = new Hashtable<String, Integer>();
        String[] variables = get_data_from_user(sc ,"Enter expression: ").split(" {0,}\\+ {0,}");
        for (String variable : variables) 
            values.put(variable, values.getOrDefault(variable, 0) + 1);
        for (String key : values.keySet()) {
            result+= values.get(key)*Integer.parseInt(get_data_from_user(sc ,"Enter vaue for " + key + ": "));
           
        }
        for (String key : values.keySet()) {
        if (values.get(key) > 1)             
            System.out.print(" " + values.get(key)+key+" +");
        else
            System.out.print(" " + key+" +");
        }
        System.out.print("\b= "+ result);        
        sc.close();


    }
    public static String get_data_from_user(Scanner sc ,String text) {
        
        System.out.println();
        System.out.print(text);
        String res =  sc.nextLine();
        
        return res;       
        
    }    
    
}
