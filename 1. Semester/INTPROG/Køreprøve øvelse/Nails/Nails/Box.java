import java.util.*;

/**
 * Write a description of class Box here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Box
{  
    private String name;
    private ArrayList<Nail> box;
    
    public Box(String name){
        this.name = name;
        box = new ArrayList<>();
    }
    
    public void add(Nail n){
        box.add(n);
    }
    
    public int number(int diameter, int length){
        int sum = 0;
        for(Nail n : box){
            if(n.getDiameter() >= diameter && n.getLength() >= length){ sum++;}
        }
        return sum;
    }
    
    public ArrayList<Nail> find(String material){
        ArrayList<Nail> list = new ArrayList<>();
        for(Nail n : box){
            if(n.getMaterial().equals(material)){
                list.add(n);
            }
        }
        return list;
    }
    
    public void printBox(){ 
        System.out.println("Name: " + this.name);
        Collections.sort(box);
        for(Nail n : box){
            System.out.println(n);
        }
    }
}