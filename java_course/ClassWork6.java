package java_course;

import java.util.HashMap;
import java.util.Map;

public class ClassWork6 {
    Map<Integer, cat> clients = new HashMap<>();
    public static void main(String[] args) {
        ClassWork6 cv = new ClassWork6();
        cat first = new cat("Vasiliy", 1, "british", "grey", (float) 4.5, "Дмитрий", "88005553535");
        first.addVisit("прививка от клещей","01.01.2023");
        cat last = new cat("Murzik", 1, "noname", "grey", (float) 4.5, "Дмитрий", "88005553535");
        first.addVisit("прививка от клещей","01.01.2023");
        cv.addCat(first);
        cv.addCat(last);
        cv.showAllCards();

    }

    public void addCat(cat cote){
        int id = clients.keySet().size() + 1;
        clients.put(id, cote);
    }

    public void showAllCards(){
        for (int id : clients.keySet()) {
            System.out.println("#"+id);
            System.out.println(clients.get(id).toString());
            
            
        }
        
    }

    
}
