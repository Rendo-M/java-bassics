package comp_shop;

import javax.lang.model.util.ElementScanner14;

public class Notebook {
    Operative memory;
    HDD disk;
    Processor proc;
    Video video;
    String Model;
    int diag;
    String os;
    int price;
    String prodDate;
    int guaranty;
    int stock;
    int memSlots;

    Notebook(Operative memory, HDD disk, Processor proc,
    Video video, String Model, int diag, String os,
    int price, String prodDate, int guaranty, int stock, int memSlots){
         this.memory = memory;
         this.disk = disk;
         this.proc = proc;
         this.video = video;
         this.Model = Model;
         this.diag = diag;
         this.os = os;
         this.price = price;
         this.prodDate = prodDate;
         this.guaranty = guaranty;
         this.stock = stock;
         this.memSlots = memSlots;
    }
    
    Notebook(Operative memory, HDD disk, Processor proc,
    Video video, String[] params){
         this.memory = memory;
         this.disk = disk;
         this.proc = proc;
         this.video = video;
         this.Model = params[0];
         this.diag = Integer.parseInt(params[1]);
         this.os = params[2];
         this.price = Integer.parseInt(params[3]);
         this.prodDate = params[4];
         this.guaranty = Integer.parseInt(params[5]);
         this.stock = Integer.parseInt(params[6]);
         this.memSlots = Integer.parseInt(params[7]);
    }
    public String card(){
        String cardNotebook = new String();
        cardNotebook = this.Model  + "\n" + "Price: " + this.price  + "\n" + 
        "Screen Diag inches: " + this.diag +"\n" + this.disk.card() + this.proc.card() + this.video.card()+this.memory.card();
        return cardNotebook;
    }

    public boolean compareDiag(int diag){
        return this.diag >= diag;
    }

    public boolean comparePrice(int price){
        return this.price <= price;
    }

    public boolean filterBase(Notebook book){
        if (price != 0)
            return this.compareDiag(book.diag) && this.comparePrice(book.price);
        else 
            return this.compareDiag(book.diag);    
    }

    public boolean filter(Notebook book){

        return this.filterBase(book) && this.disk.filter(book.disk) && this.memory.filter(book.memory) && this.proc.filter(book.proc) && this.video.filter(book.video);
    }
}
