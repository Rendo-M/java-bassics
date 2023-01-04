package comp_shop;

public class HDD {
    String vendor;
    String type;
    int size;
    

    HDD(String vendor, String type, int size){
    this.vendor = vendor;
    this.type = type;
    this.size = size;

    }
    HDD(String[] params){
        this.vendor = params[0];
        this.type = params[1];
        this.size = Integer.parseInt(params[2]);
    
    }
    public String card(){
        return "HDD Vendor: " + this.vendor + "\n" +"HDD type: " + this.type + "\n" + "HDD size, Gb: " + this.size + "\n";
    }

    public boolean compare(HDD disk){
        return this.size == disk.size && this.type.equals(disk.type);
    }
    
    public boolean checkSize(int size){
        return this.size >= size;
    }
    public boolean filter(HDD filterDisk){

        return this.checkSize(filterDisk.size);
    }

    public boolean checkType(String type){
        return this.type.equals(type);
}

}