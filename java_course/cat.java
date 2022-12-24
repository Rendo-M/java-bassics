package java_course;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.xml.crypto.Data;

class cat {
    String name;
    Integer gender;
    String sort;
    String clr;
    Float weight;
    String owner;
    String phone;
    String lastVisit;
    String nextVisit;
    String healing;
    cat father;
    cat mother;

    cat(){
        name = null;
        Random rand = new Random();
        gender = rand.nextInt(0,2);
        sort = null;
        clr = null;
        weight = ((float) (rand.nextInt(0,50)) / 10);
    }
    cat(String n, int g, String s, String c, Float i, String owner, String phone){
        name = n;
        // Random rand = new Random();
        gender = g;
        sort = s;
        clr = c;
        weight =i;
        this.owner = owner;
        this.phone = phone;
        lastVisit = null;
        nextVisit = null;
    }

    public cat(String n, int g, String s, String c, int i) {
    }
    @Override
    public String toString(){
        String str;
        str = "============================\n"  + name + "\n" +  gender +"\n" +  sort  +"\n" +  owner +"\n" +  weight.toString() + "\n" + nextVisit + "\n" ;
        return str;
    }

    public boolean comp(cat v){
        if (this.name==v.name) return true;
        else return false;
        }
    
    public void setNextVisit(String date){
        this.nextVisit = date;

    }    

    public String getNextVisit(){
        return this.nextVisit;
    }
    
    public String getLastVisit(){
        return this.lastVisit;
    }
    public void addVisit(String healing, String date){
        this.healing = healing; 
        this.lastVisit = date;
    }
    
    public void sayMew(){
        System.out.println("meew");}
}
