import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.*;
import ij.plugin.frame.*;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import ij.IJ;
import ij.ImagePlus;
import ij.io.*;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import ij.gui.NewImage;

public class Random_Image implements PlugIn {


	public void run(String arg) {
		
		int width = 10;
		int height = 10;
		String title = "Random";

		BufferedImage random = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		File f = null;

		for(int u = 0; u<width; u++){
			for(int v = 0; v<height; v++){	
				
				int alpha = (int) Math.floor(Math.random() * 256);
				int r = (int) Math.floor(Math.random() * 256);
				int g = (int) Math.floor(Math.random() * 256);
				int b = (int) Math.floor(Math.random() * 256);
				int p = (alpha<<24) | (r<<16) | (g<<8) | b;
				random.setRGB(u, v, p);
			}
		}

		try{
			f = new File("Random.png");
       		ImageIO.write(random, "png", f);

     	}catch(IOException e){
       		System.out.println("Error: " + e);
     	}

     	ImagePlus output = new ImagePlus(title, random);
     	output.show();
	}
}
