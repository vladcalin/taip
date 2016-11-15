package ssh.scheme.naor_shamir;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by nberendea on 11/14/2016.
 */
public abstract class NaorShamirImage {
    protected int height, width;
    protected boolean pixels[];

    public NaorShamirImage() {
        width = height = 0;
        pixels = null;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean[] getPixels() {
        return pixels;
    }

    public void save(String path) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for (int i=0; i<pixels.length; ++i) {
            bi.setRGB(i%width, i/width, pixels[i] ? 1 : 0);
        }
        try {
            ImageIO.write(bi, "BMP", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String path) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(path));
            width = image.getWidth();
            height = image.getHeight();
            pixels = new boolean[width*height];
            for (int i=0; i<height; ++i) {
                for (int j=0; j<width; ++j) {
                    pixels[j*width+i] = image.getRGB(i, j)!=0 ? true : false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
