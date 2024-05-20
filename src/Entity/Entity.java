package Entity;

import Main.GamePanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import static Graphics.Assets.*;

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

    // Cached scaled images
    private BufferedImage[] idleImages;
    private BufferedImage[] leftImages;
    private BufferedImage[] downImages;
    private BufferedImage[] rightImages;
    private BufferedImage[] upImages;

    public Entity(GamePanel gp) {
        this.gp = gp;
        loadAndScaleImages();
    }

    private void loadAndScaleImages() {
        int targetWidth = gp.tileSize;
        int targetHeight = gp.tileSize;

        // Pre-scale and cache images
        idleImages = new BufferedImage[]{
                setup(monsterIdle1, targetWidth, targetHeight),
                setup(monsterIdle2, targetWidth, targetHeight),
                setup(monsterIdle3, targetWidth, targetHeight),
                setup(monsterIdle4, targetWidth, targetHeight),
                setup(monsterIdle5, targetWidth, targetHeight),
                setup(monsterIdle3, targetWidth, targetHeight) // Assuming this is intentional
        };
        leftImages = new BufferedImage[]{
                setup(monsterLeft1, targetWidth, targetHeight),
                setup(monsterLeft2, targetWidth, targetHeight),
                setup(monsterLeft3, targetWidth, targetHeight),
                setup(monsterLeft4, targetWidth, targetHeight),
                setup(monsterLeft5, targetWidth, targetHeight),
                setup(monsterLeft3, targetWidth, targetHeight)
        };
        downImages = new BufferedImage[]{
                setup(monsterDown1, targetWidth, targetHeight),
                setup(monsterDown2, targetWidth, targetHeight),
                setup(monsterDown3, targetWidth, targetHeight),
                setup(monsterDown4, targetWidth, targetHeight),
                setup(monsterDown5, targetWidth, targetHeight),
                setup(monsterDown2, targetWidth, targetHeight)
        };
        rightImages = new BufferedImage[]{
                setup(monsterRight1, targetWidth, targetHeight),
                setup(monsterRight2, targetWidth, targetHeight),
                setup(monsterRight3, targetWidth, targetHeight),
                setup(monsterRight4, targetWidth, targetHeight),
                setup(monsterRight5, targetWidth, targetHeight),
                setup(monsterRight2, targetWidth, targetHeight)
        };
        upImages = new BufferedImage[]{
                setup(monsterUp1, targetWidth, targetHeight),
                setup(monsterUp2, targetWidth, targetHeight),
                setup(monsterUp3, targetWidth, targetHeight),
                setup(monsterUp4, targetWidth, targetHeight),
                setup(monsterUp5, targetWidth, targetHeight),
                setup(monsterUp2, targetWidth, targetHeight)
        };
    }

    public void setAction(){}
    public void update(){}


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
                    image = idleImages[spriteNum - 1];
                    break;
                case "left":
                    image = leftImages[spriteNum - 1];
                    break;
                case "down":
                    image = downImages[spriteNum - 1];
                    break;
                case "right":
                    image = rightImages[spriteNum - 1];
                    break;
                case "up":
                    image = upImages[spriteNum - 1];
                    break;
            }

            g2.drawImage(image, screenX, screenY, null);
        }
    }
}
