package comp_shop;
import java.io.IOException;

public class Controller {

    View viewMod;
    Model modelMod;

    Controller() throws IOException{
        viewMod = new View();
        modelMod = new Model();
        this.Run();
    }

    public void Run() throws IOException{
        this.viewMod.showMenu();
        while (true){
            this.viewMod.showMenu();
            String answer = this.viewMod.getAnswer("Выберите действие >>");
            if (answer.equals("4")) break;     
            if (answer.equals("1")) this.viewMod.showCards(this.modelMod.books);      
            if (answer.equals("3")) this.viewMod.showCards(this.modelMod.filtered);   
            if (answer.equals("2")) this.getFilter();  
        }
    }

    public void getFilter(){
        for (String param : this.modelMod.filter.keySet()) {
            int value = 0;
            String input = this.viewMod.getAnswer(this.modelMod.depend.get(param));
            if (!input.isEmpty()){
                value = Integer.parseInt(input);
            }
            this.modelMod.filter.put(param, value);    
        }
        this.modelMod.loadFilter();
        this.modelMod.filterNotebook();
    }

}

