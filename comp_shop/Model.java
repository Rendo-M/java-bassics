package comp_shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Notebook> books;

    Model() throws IOException{
        List<String> data = this.loadCSV();
        book(data); 
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
