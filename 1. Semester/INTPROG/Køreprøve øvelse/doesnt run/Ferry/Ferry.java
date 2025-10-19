
/**
 * Write a description of class Ferry here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ferry implements Comparable<Ferry>
{
    private String name;
    private int length;
    private int width;
    
    public Ferry(String name, int length, int width){
        this.name = name;
        this.length = length;
        this.width = width;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public String toString(){
        return name + " " + length + " x " + width + " meter";
    }
    
    public int compareTo(Ferry f){
        if(this.name.equals(f.getName())){
            return this.width - f.getWidth();
        }
        return this.name.compareTo(f.getName());
    }
}