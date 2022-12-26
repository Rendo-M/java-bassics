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

    Processor(String[] params){
        this.model = params[0];
        this.core = Integer.parseInt(params[1]);
        this.freq = Integer.parseInt(params[2]);
        this.cash = Integer.parseInt(params[3]);
    }

    public String card(){
        return "CPU "+ this.model + "\n" + "Core: " + this.core + "\n";
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
