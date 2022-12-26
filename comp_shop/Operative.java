package comp_shop;

public class Operative {
    int size;
    int freq;
    int planks;  

    Operative(int size, int freq, int planks){
         this.size = size;
         this.freq = freq;
         this.planks = planks;
    }
    Operative(String[] params){
        this.size = Integer.parseInt(params[0]);
        this.freq = Integer.parseInt(params[1]);
        this.planks =  Integer.parseInt(params[2]);
    }
    public String card(){
        return "Memory>>" + "\n" + "Size, Gb " + this.size  + "\n" + "Frequency: "  + this.freq + "\n" + "planks: " + this.planks + "\n"; 
    }
    public boolean compare(Operative memo){
        return this.size == memo.size && this.freq == memo.freq && this.planks == memo.planks;
    }
    public boolean checkSize(int size){
        return this.size * this.planks >= size;
    }

    public boolean checkFreq(int freq){
        return this.freq >= freq;
    }
}
