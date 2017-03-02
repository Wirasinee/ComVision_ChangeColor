# ComVision_ChangeColor
❄️️Change the color of a picture
import imageutil.Util;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;



public class ImageBinarization {
    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    BufferedImage img = null;
    
    File file = new File(in.nextLine());
    File fileNew = new File(in.nextLine());//รับที่อยู่ไฟล์ภาพใหม่   
    System.out.println("T:");
    int T = in.nextInt();
        try {
            img = ImageIO.read(file);
        } catch (IOException ex) {
            System.err.println("err");
            return;
        }
    
    int width = img.getWidth();
    int height = img.getHeight();
    int[] pixelBuffer = new int[1];
    WritableRaster wraster = img.getRaster();
    for(int row = 0; row < height; ++row) {

        for(int col = 0; col < width; ++col) {

            wraster.getPixel(col, row, pixelBuffer);

            if (pixelBuffer[0] < T) {
                    pixelBuffer[0] = 0;
                } else {
                    pixelBuffer[0] = 255;
                    
                }
            wraster.setPixel(col, row, pixelBuffer);

    }
        
        try{
            
            ImageIO.write(img, "png", fileNew);
        }catch (IOException ex) {
            System.err.println("Cannot write file");
            return;
        }

    }
    }
}
