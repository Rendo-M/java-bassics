import java.util.Scanner;

public class Seminar2 {

    public static void main(String[] args) {
        
    }

    public static int GetNumber()
	{
	    Scanner numberS = new Scanner(System.in);
	    int number;
	    while(true)
	    {
	        try {
	            System.out.print("Введите число");
	            number = numberS.nextInt();
	            break;
	        } catch(Exception e) {
	            System.out.print("Ошибка ввода");
	        }
	        
	    }
	    return number;
	}

    
}
