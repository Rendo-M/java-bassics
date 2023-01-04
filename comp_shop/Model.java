package comp_shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
    List<Notebook> books;
    List<Notebook> filtered;
    Notebook filterBook;
    public String[] params;
    public String[] valueNames;
    public HashMap<String, Integer> filter;
    public HashMap<String,String> depend;

    Model() throws IOException{
        List<String> data = this.loadCSV();
        book(data); 
        params = new String[]{"Частота памяти: ", "Размер памяти: ", "Размер диска: ", "Число ядер CPU: ", 
                                "частота CPU: ", "видеопамять: ", "видеошина: ", "частота шины: ", "диагональ: ", "цена: "};
        valueNames = new String[]{"memFreq", "memSize", "sizeHDD", "cores", "freqCPU", 
            "memVideo", "bus", "freqVideo", "diag", "price"};
        depend = new HashMap<>();
        for (int i = 0; i < params.length; i++) {
            depend.put(valueNames[i], params[i]);
        }    
        
        filter = new HashMap<>();
        this.clearFilter();
            
        }
    
    public void clearFilter(){
        for (String val : valueNames) 
            filter.put(val, 0);
    }

    public List<String> loadCSV() throws IOException {
        List<String> res = new ArrayList<>();
        
        BufferedReader reader = new BufferedReader(new FileReader("comp_shop\\base1.csv"));
            
           
        String line = reader.readLine(); 
        while (line != null){
            res.add(line);
            line = reader.readLine();
        }
        return res;
     }


     public void filterNotebook(){
        if (this.filterBook != null){
            filtered = new ArrayList<>();
            for (Notebook notebook : books) {
                if (notebook.filter(filterBook)){
                    filtered.add(notebook);
                }
            }
        }
     }

     public void loadFilter(){
        createFilterObj(filter.get("memFreq"), filter.get("memSize"), filter.get("sizeHDD"), filter.get("cores"), 
        filter.get("freqCPU"), filter.get("memVideo"), filter.get("bus"), filter.get("freqVideo"), 
        filter.get("diag"), filter.get( "price"));
         }
     public void createFilterObj(int memFreq, int memSize, int sizeHDD, int cores, int freqCPU, 
                            int memVideo, int bus, int freqVideo, int diag, int price){
        filterBook = new Notebook(  new Operative(memSize, memFreq, 0), 
                                    new HDD(null, "", sizeHDD), 
                                    new Processor(null, cores, freqCPU, 0),
                                    new Video(null, null, 0, 0, 0), 
                                    null, diag, null, price, null, 0, 0, 0);
     }

     public void book(List<String> notebooks) {
        books = new ArrayList<>();
        for (String comp : notebooks) {
            String[] setting = comp.split(";");
            String[] splited = setting[1].split("-")[1].split(","); //operative params
            for (int i = 0; i < splited.length; i++) {
                splited[i] = splited[i].split(":")[1];
            }
            Operative mem = new Operative(splited);
            splited = setting[2].split("-")[1].split(","); // HDD
            for (int i = 0; i < splited.length; i++) {
                splited[i] = splited[i].split(":")[1];
            }
            HDD disk = new HDD(splited);
            splited = setting[3].split("-")[1].split(","); // Processor
            for (int i = 0; i < splited.length; i++) {
                splited[i] = splited[i].split(":")[1];
            }
            Processor proc = new Processor(splited);
            splited = setting[4].split("-")[1].split(","); // Video
            for (int i = 0; i < splited.length; i++) {
                splited[i] = splited[i].split(":")[1];
            }
            Video vCard = new Video(splited);
            splited = setting[0].split("-")[1].split(","); // Video
            for (int i = 0; i < splited.length; i++) {
                splited[i] = splited[i].split(":")[1];
            }
            Notebook book = new Notebook(mem, disk, proc, vCard, splited);      
            books.add(book);      
            
        }
    } 
}
