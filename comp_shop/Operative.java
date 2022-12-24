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
