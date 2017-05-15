import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.lang.Object;
import java.awt.Color;

public class Color_Counter implements PlugInFilter{

	public int setup(String arg, ImagePlus im) {
        
        return DOES_RGB;
    }

	public void run(ImageProcessor ip){

		int width = ip.getWidth();
		int height = ip.getHeight();
		
		int totalRed = 0;
		int totalBlue = 0;
		int totalGreen = 0;
		int totalBlack = 0;
		int totalWhite = 0;

		for(int u = 0; u<width; u++){
			for(int v = 0; v<height; v++){	

				int[] rgb = new int[3];
				rgb = ip.getPixel(u,v,rgb);

				if(rgb[0] == 255 && rgb[1] == 0 && rgb[2] == 0){
					totalRed = totalRed + 1;
				}
				else if(rgb[0] == 0 && rgb[1] == 255 && rgb[2] == 0){
					totalGreen = totalGreen + 1;
				}
				else if(rgb[0] == 0 && rgb[1] == 0 && rgb[2] == 255){
					totalBlue = totalBlue + 1;
				}		
				else if(rgb[0] == 0 && rgb[1] == 0 && rgb[2] == 0){
					totalBlack = totalBlack + 1;
				}
				else if(rgb[0]== 255 && rgb[1] == 255 && rgb[2] == 255){
					totalWhite = totalWhite + 1;
				}

			}
		}

		IJ.showMessage("Red pixels: " + totalRed + " Green pixels: " + totalGreen + " Blue pixels: " + totalBlue + " Black pixels: " + totalBlack + " White pixels: " + totalWhite);
	}	
}