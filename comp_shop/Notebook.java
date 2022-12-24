package comp_shop;
public class Notebook {
    Operative memory;
    HDD disk;
    Processor proc;
    Video video;
    String Model;
    int diag;
    String os;
    int price;
    int prodDate;
    int guaranty;
    int stock;
    int memSlots;

    Notebook(Operative memory, HDD disk, Processor proc,
    Video video, String Model, int diag, String os,
    int price, int prodDate, int guaranty, int stock, int memSlots){
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
    
}
