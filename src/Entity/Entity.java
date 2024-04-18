package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX,worldY;
    public int speed;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle bounds;

    public int boundsDefaultX, boundsDefaultY;
    public boolean collisionOn = false;

}
