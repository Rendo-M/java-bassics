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

    Video(String[] params){
        this.vendor = params[0];
        this.model = params[1];
        this.memory = Integer.parseInt(params[2]) ;
        this.bus = Integer.parseInt(params[3]) ;
        this.freq = Integer.parseInt(params[4]) ;
      }

    public boolean compare(Video video){
        return video.freq == this.freq && video.memory == this.memory && video.bus == this.bus;
    }
    public String card(){
        return "Video model: " + this.model + "\n" + "Vendor: " + this.vendor +"\n";
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
    public boolean filter(Video videoCard) {
        return this.checkBus(videoCard.bus) && this.checkFreq(videoCard.freq) && this.checkMem(videoCard.memory);
        
    }
}
