package javagameproject.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    public static BufferedImage loadImage(String patch){
        try {
            return ImageIO.read(ImageLoader.class.getResource(patch));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
