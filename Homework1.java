import java.util.Scanner;

public class Homework1 {
    
    
    public static void main(String[] args) {
    // int n = 35;    
    // System.out.println(triangle_number(n));
    // System.out.println(factor(n)); 
    // eratosfen(1000); 
    // calculator();
    // System.out.println(find_questionmarks("??"));
    solve_equation("2? + ?? = ??");
    }

    public static void solve_equation(String eq) {
/*
разобьем входящую строку на 3 числа - элемента равенста, 
найдем в каждом из них позиции знаков вопроса. 
в q_marks храним 3 числа, для каждого из 3 чисел исходного равенства 
эти числа содержат номера позиций знаков вопроса
например 235 означает, что на позициях 2, 3 и 5 в числе стоят знаки вопроса.
если это число трехначное то знаков вопроса три, и перебрать все варианты 
можно в цикле от 0 до 999
соответственно для каждого из 3 чисел будет свой цикл, 
итого чтобы перебарть и проверить все варианты понадобится 3 вложенных цикла.

*/
        String[] numbers = eq.split(" {0,}[+=] {0,}"); // сплит
        int[] q_marks = new int [3]; // находим позиции знаков вопроса в числах
        for (int i = 0; i < numbers.length; i++) 
            q_marks[i] = find_questionmarks(numbers[i]);
        int[] num1 = num_to_arr(numbers[0]);
        int[] num2 = num_to_arr(numbers[1]);      
        int[] num3 = num_to_arr(numbers[2]);      
        int n1, n2, n3;
            for (int i = 0; i <= border(q_marks[0]); i++) {
                n1 = get_number(num1, q_marks[0], i);
                
                for (int j = 0; j <= border(q_marks[1]); j++) {
                    
                    n2 = get_number(num2, q_marks[1], j);
                    for (int k = 0; k <= border(q_marks[2]); k++) {
                        n3 = get_number(num3, q_marks[2], k);
                        
                        if (n1 + n2 == n3)
                            System.out.println(n1 + " + " + n2 + " = " + n3);
                    }
                }
            }
    }

    /** побставляя в 
     * @param num
     * на позициях
     * @param q_pos
     * значения
     * @param values
     * @return возвращает число для исходного уравнения
     */
    public static int get_number(int[] num, int q_pos, int values) {
        int cur_pos = 0;
        int cur_value = 0;
        
        do{
            
            if (q_pos < 0)
                break;
            cur_pos = q_pos % 10 - 1;
            cur_value = values % 10;
            values /= 10;
            q_pos /= 10;
            num[num.length - cur_pos - 1] = cur_value;            
        }
        while (q_pos > 0);
        int res = 0;
        for (int i = num.length-1; i >= 0; i--) {
            res = res*10 + num[i];
            
        }    
        return res;
    }

    public static int border(int n) {    
        if (n < 0)
            return 0;
        int i = 0;
        do {
            i = i*10 + 9;    
        } while (i < n);
        return i;
    }

    public static int[] num_to_arr( String num) {
        int[] number = new int [num.length()];
        num = num.replace('?', '1');

        int n = Integer.parseInt(num);
        for (int i = 0; i < number.length; i++) {
            number[i] = n % 10;
            n /= 10; 
        }
        return number;
    }
   
    public static int find_questionmarks(String eq){
        int mult = 1;
        int res = -1;
        for (int i = 1; i <= eq.length(); i++) {
            if (eq.charAt(i-1) == '?'){
                if (res == -1) 
                    res = i;
                else 
                    res = res * mult + i;
                }
            mult *= 10;
            }            
        return res;
        }



    public static void eratosfen(int n) {
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0){
                System.out.print(" " + i);
                for (int j = i*2 ; j <= n ; j += i) {
                    arr[j] = -1;
                }
            }
        }
    }

    public static int triangle_number(int n) {
        return n * (n + 1) / 2;
    }    

    public static long factor(int n) {
        if (n == 1 || n == 0)
            return 1;
        return n*factor(n-1); 
    }        

    public static void calculator() {
        Scanner sc =  new Scanner(System.in);
            
        while (true){
            double num1 = Double.parseDouble(get_data_from_user(sc,"Введите первое число >>"));       
            double num2 = Double.parseDouble(get_data_from_user(sc,"Введите второе число >>"));
            String action =  get_data_from_user(sc,"Введите действие >>");
            Double res = 0.0; 
            switch (action) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
            }
            System.out.println(num1 + " " + action + " " + num2 + " = " + res);
            if (get_data_from_user(sc, "Для выхода введите q >>").equals("q")){
                
                break;    
            
            }
        }    
        sc.close();
    }

    public static String get_data_from_user(Scanner sc ,String text) {
        
        
        if (text.equals("finish")){
            sc.close();
            return null;
        }
        System.out.println();
        System.out.print(text);
        String res =  sc.nextLine();
        
        return res;       
        
    }    
    
}
