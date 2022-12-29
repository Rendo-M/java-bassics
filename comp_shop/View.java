package comp_shop;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class View {
    HashMap<Integer,String> menu;
    Scanner scan;
    View(){
        menu = new HashMap<>();
        scan = new Scanner(System.in);
        menu.put(1, "Load Base");
        menu.put(2, "Show All");
        menu.put(3, "Set Filters");
        menu.put(4, "Show Filtred");
        menu.put(5, "Exit");
    }
    
    public void showMenu(){
        for (int num : menu.keySet()) {
            System.out.println(num + " - " + menu.get(num));
        }
    }

    public String getAnswer(String prompt) {
        System.out.print(prompt);
        return scan.next();
    }

    public void showCards(List<Notebook> books){
        
        System.out.println("\n*******************");
        System.out.println("Found " + books.size() + " notebooks");
        for (Notebook nb : books) {
            System.out.println("*******************");
            System.out.println(nb.card());

        }    
    }
}
