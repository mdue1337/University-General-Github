import java.util.*;

/**
 * This class implements a number of filters, i.e. methods that can be used to
 * manipulate Image objects, e.g. make the image darker or mirrored.
 * The filter methods operates on the image in the field (feltvariabel) image.
 * The filter methods change the original image and return the new image.
 *
 * @author Kurt Jensen.
 * @version 2020-08-12.
 **/
public class Filters
{
    private Image image;     // Image to operate on.
    
    /**
     * The constructor takes as input an instance of Image.
     * 
     * @param image   Image to apply filters to.
     */
    public Filters(Image image) {
        this.image = image;
    }
    
    /**
     * The constructor  creates an Image object from the file picture.png (in the project folder).
     */
    public Filters() {
        image = new Image("picture.png", true);
    }
    
    /**
     * This method brightens an image by adding some amount to the
     * value of all pixels in the image.
     * The title of the new image is prefixed 'brightenX-',
     * where X is the parametervalue.
     *
     * @param amount   Increase in value for each pixel.
     * @return   Brightened image.
     */
    public Image brighten(int amount) {
        for(Pixel p : image.getPixels()){
            int oldValue = p.getValue();
            int newValue = oldValue + amount;
            p.setValue(newValue);
        }
        
        image.setTitle("brighten" + amount + "-picture.png");
        image.updateCanvas();
        return image;
    }

    /**
     * This method darkens an image by subtracting some amount from the
     * value of all pixels in the image.
     * The title of the new image is prefixed 'darkenX-',
     * where X is the parametervalue.
     *
     * @param amount   Decrease in value for each pixel.
     * @return   Darkened image.
     */
    public Image darken(int amount) {
        for(Pixel p : image.getPixels()){
            int oldValue = p.getValue();
            int newValue = oldValue - amount;
            p.setValue(newValue);
        }
        
        image.setTitle("darken" + amount + "-picture.png");
        image.updateCanvas();
        return image;
    }  

    /**
     * This method inverts an image by mapping each pixel value 'v' to '255-v'
     * such that white turns black and vice-versa.
     * The title of the new image is prefixed 'invert-'.
     *
     * @return   Inverted image.
     */
    public Image invert() {
        for(Pixel p : image.getPixels()){
            int oldValue = p.getValue();
            int newValue = 255 - oldValue ;
            p.setValue(newValue);
        }
        
        image.setTitle("invert-picture.png");
        image.updateCanvas();
        return image;
    }

    /**
     * This method mirrors an image across the vertical axis.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (width-i-1, j) in the old image, where width is the width of the image.
     * The title of the new image is prefixed 'mirror-'.
     *
     * @return   Mirrored image.
     */
    public Image mirror() {
        int width = image.getWidth();
        int height = image.getHeight();
        Image mirror = new Image(width, height, "mirror-picture.png");
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                Pixel p = image.getPixel(i, j);
                Pixel mp = mirror.getPixel(width - i - 1, j);
                mp.setValue(p.getValue());
            }
        }
        
        image = mirror;
        image.updateCanvas();
        return image;
    }

    /**
     * This method flips an image across the horizontal axis.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (j, height-i-1) in the old image, where height is the height of the image.
     * The title of the new image is prefixed 'flip-'.
     *
     * @return   Flipped image.
     */
    public Image flip() {
        int width = image.getWidth();
        int height = image.getHeight();
        Image flip = new Image(width, height, "flip-picture.png");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel p = image.getPixel(j, i);
                Pixel mp = flip.getPixel(j, height - i - 1);
                mp.setValue(p.getValue());
            }
        }

        image = flip;
        image.updateCanvas();
        return image;
    }

    /**
     * This method rotates an image 90 degrees clockwise.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (j,width-i-1) in the old image, where width is the width of the new image.
     * The title of the new image is prefixed 'rotate-'.
     *
     * @return   Rotated image.
     */
    public Image rotate() {
        int height = image.getWidth(); // y
        int width = image.getHeight(); // x
        Image rotate = new Image(width, height, "rotate-picture.png");
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Pixel p = image.getPixel(j, width - i - 1);
                Pixel mp = rotate.getPixel(i, j);
                mp.setValue(p.getValue());
            }
        }

        image = rotate;
        image.updateCanvas();
        return image;
    }

    /**
     * Auxillary method for blur.
     * This method computes the average value of the (up to nine) neighbouring pixels
     * of position (i,j) -- including pixel (i,j).
     *
     * @param i   Horizontal index.
     * @param j   Vertical index.
     * @return    Average pixel value.
     */
    private int average(int i, int j) {
        ArrayList<Pixel> l = image.getNeighbours(i, j);
        int total = 0;
        
        for(Pixel p : l){
            total += p.getValue();
        }
        
        total /= l.size();
        
        return total;
    }

    /**
     * This method blurs an image.
     * Each pixel (x,y) is mapped to the average value of the neighbouring pixels. 
     * The title of the new image is prefixed 'blur-'.
     *
     * @return   Blurred image.
     */
    public Image blur() {
        int height = image.getHeight(); // y
        int width = image.getWidth(); // x
        Image blur = new Image(width, height, "blur-picture.png");
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                blur.getPixel(i, j).setValue(average(i,j));
            }
        }
        
        image = blur;
        image.updateCanvas();
        return image;
    }
   
    /**
     * This method adds noise to an image.
     * The value of pixel (i,j) is set to a random value in the interval
     * [v-amount, v+amount], where v is the old value and amount the parameter.
     * The title of the new image is prefixed 'noiseX-'.
     *
     * @param amount   Maximal amount of noise to add.
     * @return  Noisy image. 
     */  
    public Image noise(int amount) {
        Random r = new Random();
        
        for(Pixel p : image.getPixels()){
            int oldValue = p.getValue();
            // r.nextInt(max - min + 1) + min
            int newValue = oldValue + r.nextInt(amount + amount + 1) - amount ;
            p.setValue(newValue);
        }
        
        image.setTitle("noise" + amount + "-picture.png");
        image.updateCanvas();
        return image;
    }

    /**
     * This method resizes an image by some factor.
     * The size of the new image becomes with*factor x hiehgt*factor, where
     * width and heigt are the width and height of the old image.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (i/factor,j/factor) in the old image, where factor is the parameter.
     * This produces a new image of size (width*factor, height*factor).
     * The title of the new image is prefixed 'factorX-'.
     *
     * @param factor   Resize factor.
     * @return   Resized image.
     */   
    public Image resize(double factor) {
        double height = image.getHeight() * factor; // y
        double width = image.getWidth() * factor; // x
        Image resize = new Image((int)width, (int)height, ("resize" + factor + "-picture.png"));
        
        for(int i = 0; i < (int) width; i++){
            for(int j = 0; j < (int) height; j++){
                Pixel p = image.getPixel((int)(i / factor), (int)(j / factor));
                Pixel mp = resize.getPixel(i, j);
                mp.setValue(p.getValue());
            }
        }
        
        image = resize;
        image.updateCanvas();
        return image;
    }
    
    /**
     * This method rotates an image 90 degrees anti-clockwise.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * ???????? in the old image, where width is the width of the new image.
     * The title of the new image is prefixed 'rotateAC-'.
     *
     * @return   Rotated image.
     */
    public Image rotateAC() {
        int height = image.getWidth();
        int width = image.getHeight();
        Image rotate = new Image(width, height, "rotateAC-picture.png");
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel p = image.getPixel(i, j);
                Pixel mp = rotate.getPixel(j, height - i - 1);
                mp.setValue(p.getValue());
            }
        }

        image = rotate;
        image.updateCanvas();
        return image;
    }
    
    /**
     * This image increases the contrast of an image by some amount.
     * 
     * @param amount    The amount by which to increase contrast
     */
    public Image increaseContrast(double amount) {
        for(Pixel p : image.getPixels()){
            int oldValue = p.getValue();
            double x = (2.0*oldValue)/255.0 - 1.0;
            double y = Math.abs(x);
            double pow = Math.pow(y, Math.exp(-amount));
            double xPrime = Math.signum(x) * pow;
            p.setValue((int)((xPrime+1)/2.0 *255.0));
        }
        
        image.updateCanvas();
        image.setTitle("contrast" + amount + "-picture.png");
        return image;
    }

}
