package Objects;

import Main.GamePanel;

import Graphics.*;


import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjectsMain {

    public BufferedImage image,scaledImage,image2,image3,image4,image5;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle bounds = new Rectangle(0,0,48,48);
    public int boundsDefaultX = 0;
    public int boundsDefaultY = 0;


    public void draw(Graphics2D g2, GamePanel gp) {
        if (scaledImage == null) {
            scaledImage = setup(image, gp.tileSize, gp.tileSize);
        }

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (isWithinScreenBounds(worldX, worldY, gp)) {
            g2.drawImage(scaledImage, screenX, screenY, null);
        }
    }

    private boolean isWithinScreenBounds(int worldX, int worldY, GamePanel gp) {
        int tileSize = gp.tileSize;
        int playerWorldX = gp.player.worldX;
        int playerWorldY = gp.player.worldY;
        int playerScreenX = gp.player.screenX;
        int playerScreenY = gp.player.screenY;

        return worldX + tileSize > playerWorldX - playerScreenX &&
                worldY + tileSize > playerWorldY - playerScreenY &&
                worldX - tileSize < playerWorldX + playerScreenX &&
                worldY - tileSize < playerWorldY + playerScreenY;
    }

    public BufferedImage setup(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage scaledImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g2d.dispose();
        return scaledImage;
    }

}
