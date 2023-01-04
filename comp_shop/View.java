package comp_shop;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class View {
    HashMap<Integer,String> menu;
    Scanner scan;
    View(){
        menu = new HashMap<>();
        scan = new Scanner(System.in);
        menu.put(1, "Show All");
        menu.put(2, "Set Filters");
        menu.put(3, "Show Filtred");
        menu.put(4, "Exit");
    }
    
    public void showMenu(){
        System.out.print("\033[H\033[2J");
        for (int num : menu.keySet()) {
            System.out.println(num + " - " + menu.get(num));
        }
    }

    public String getAnswer(String prompt) {
        System.out.print(prompt);
        return scan.next();
    }

    public void showCards(List<Notebook> books) throws IOException{
   
        System.out.println("\n*******************");
        System.out.println("Found " + books.size() + " notebooks");
        for (Notebook nb : books) {
            System.out.println("*******************");
            System.out.println(nb.card());

        }
        System.out.println("Нажмите Enter для продолжения...");
        System.in.read();
        System.in.read();           
    }
}
