package Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageScale {

    public BufferedImage scaleImage(BufferedImage img, int Width, int Height) {
        BufferedImage scaledImage = new BufferedImage(Width,Height,img.getType());
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(img, 0, 0,Width,Height, null);
        g2d.dispose();
        return scaledImage;
    }
}
