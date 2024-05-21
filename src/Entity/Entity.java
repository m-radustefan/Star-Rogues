package Entity;

import Main.GamePanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle bounds = new Rectangle(0, 0, 48, 48);
    public int boundsDefaultX, boundsDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;

    //CHARACTER STATUS
    public int maxLife;
    public int life;

    // Cached scaled images
    public BufferedImage[][] images;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    public void setAction(){}
    public void update(){
        setAction();
        collisionOn = false;
        gp.collisionCheck.checkTile(this);
        gp.collisionCheck.checkObject(this,false);
        gp.collisionCheck.checkPlayer(this);


        if(collisionOn == false){
            switch (direction)
            {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }

        spriteCounter++;
        if(spriteCounter >= 10) {
            if (direction.equals("up") || direction.equals("down")) {
                switch (spriteNum) {
                    case 1:
                        spriteNum = 2;
                        break;
                    case 2:
                        spriteNum = 3;
                        break;
                    case 3:
                        spriteNum = 4;
                        break;
                    case 4:
                        spriteNum = 5;
                        break;
                    case 5:
                        spriteNum = 1;
                        break;
                    case 6:
                        spriteNum = 2;
                        break;
                }
            } else if (direction.equals("left") || direction.equals("right")) {
                switch (spriteNum) {
                    case 1:
                        spriteNum = 2;
                        break;
                    case 2:
                        spriteNum = 3;
                        break;
                    case 3:
                        spriteNum = 4;
                        break;
                    case 4:
                        spriteNum = 5;
                        break;
                    case 5:
                        spriteNum = 6;
                        break;
                    case 6:
                        spriteNum = 1;
                        break;
                }
            }
            spriteCounter = 0;
        }
    }


    protected void loadAndScaleImages(BufferedImage[][] sourceImages) {
        int targetWidth = gp.tileSize;
        int targetHeight = gp.tileSize;
        images = new BufferedImage[sourceImages.length][];
        for (int i = 0; i < sourceImages.length; i++) {
            images[i] = new BufferedImage[sourceImages[i].length];
            for (int j = 0; j < sourceImages[i].length; j++) {
                images[i][j] = setup(sourceImages[i][j], targetWidth, targetHeight);
            }
        }
    }

    private BufferedImage setup(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage scaledImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g2d.dispose();
        return scaledImage;
    }

    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            BufferedImage image = null;
            switch (direction) {
                case "idle":
                    image = images[0][spriteNum - 1];
                    break;
                case "left":
                    image = images[1][spriteNum - 1];
                    break;
                case "down":
                    image = images[4][spriteNum - 1];
                    break;
                case "right":
                    image = images[3][spriteNum - 1];
                    break;
                case "up":
                    image = images[2][spriteNum - 1];
                    break;
            }

            g2.drawImage(image, screenX, screenY, null);
        }
    }
}
