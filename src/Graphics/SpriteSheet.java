package Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage spriteSheet;
    private static final int playerWidth = 32;
    private static final int playerHeight = 32;
    private static final int tileWidth = 48;
    private static final int tileHeight  = 48;
    private static final int objectWidth = 32;
    private static final int objectHeight = 32;



    public SpriteSheet(BufferedImage buffImg)
    {
        spriteSheet = buffImg;
    }

    public BufferedImage cropPlayer(int x, int y)
    {
        return  spriteSheet.getSubimage(x* playerWidth,y* playerHeight, playerWidth, playerHeight);
    }

    public BufferedImage cropTile(int x, int y)
    {
        return  spriteSheet.getSubimage(x* tileWidth,y* tileHeight, tileWidth, tileHeight);
    }

    public BufferedImage cropObjects(int x, int y)
    {
        return  spriteSheet.getSubimage(x* objectWidth,y* objectHeight, objectWidth, objectHeight);
    }
    public BufferedImage cropHealthBar(int x, int y)
    {
        return  spriteSheet.getSubimage(x* 383,y* 95, 383, 95);
    }
}
