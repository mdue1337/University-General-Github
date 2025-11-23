import java.util.*;

/**
 * Write a description of class Nail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nail implements Comparable<Nail>
{
    private String material;
    private int diameter;
    private int length;
    
    public Nail(String material, int diameter, int length){
        this.material = material;
        this.diameter = diameter;
        this.length = length;
    } 
    
    @Override
    public String toString(){
        return this.diameter + " mm x " + this.length + " mm of " + material;
    }
    
    public String getMaterial(){
        return this.material;
    }
    
    public int getDiameter(){
        return this.diameter;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public int compareTo(Nail n){
        if(this.length != n.getLength()){
            return n.getLength()- this.length;
        }
        return this.material.compareTo(n.getMaterial());
    }
}