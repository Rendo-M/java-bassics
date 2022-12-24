package comp_shop;

public class HDD {
    String vendor;
    String type;
    int size;
    


public boolean compare(HDD disk){
    return this.size == disk.size && this.type.equals(disk.type);
}
public boolean checkSize(int size){
    return this.size >= size;
}

public boolean checkType(String type){
    return this.type.equals(type);
}

}