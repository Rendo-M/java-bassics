package comp_shop;

public class Processor {
    String model;
    int core;
    int freq;
    int cash;

    Processor(String model, int core, int freq, int cash)
    {
            this.model = model;
            this.core = core;
            this.freq = freq;
            this.cash = cash;
    }    
    public boolean checkCores(int cores){
        return this.core >= cores;
    }

    public boolean checkFreq(int freq){
        return this.freq >= freq;
    }

    public boolean compare(Processor proc){
        return this.core == proc.core && this.freq == proc.freq && this.cash == proc.cash;
    }
}
