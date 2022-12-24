package comp_shop;

public class Video {
   String vendor;
   String model;
   int memory;
   int bus;
   int freq; 

    Video(String vendor, String model, int memory, int bus, int freq){
     this.vendor = vendor;
     this.model = model;
     this.memory = memory;
     this.bus = bus;
     this.freq = freq;
    }
    public boolean compare(Video video){
        return video.freq == this.freq && video.memory == this.memory && video.bus == this.bus;
    }

    public boolean checkFreq(int freq) {
        return this.freq >= freq;
    }    
    public boolean checkBus(int bus) {
        return this.bus >= bus;
    }    
    public boolean checkMem(int mem) {
        return this.memory >= mem;
    }    
}
