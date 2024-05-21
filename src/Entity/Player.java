package Entity;

import Main.GamePanel;
import Main.KeyHandler;


import java.awt.*;
import java.awt.image.BufferedImage;

import static Graphics.Assets.*;


public class Player extends  Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public static Player instance;



    public int hasAmmo = 0;

    private Player (GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        bounds = new Rectangle();
        bounds.x = 6;
        bounds.y = 6;
        bounds.width = 32;
        bounds.height = 38;

        boundsDefaultX = 6;
        boundsDefaultY = 6;


        setDefaultValues();
    }
    public static Player getInstance (GamePanel gp, KeyHandler keyH) {
        if (instance == null)
        {
            instance = new Player(gp, keyH);
        }
        return instance;
    }
    public void setDefaultValues() {
         worldX = 100;
         worldY = 100;
         speed = 4;
         direction = "left";

         maxLife=5;
         life = maxLife;

    }
    public void update() {

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){

            if(keyH.upPressed == true){
                direction="up";
            }
            else if(keyH.downPressed == true){
                direction="down";
            }
            else if (keyH.leftPressed == true) {
                direction="left";
            }
            else if (keyH.rightPressed == true) {
                direction="right";
            }

            //CHECK COLLISION
            collisionOn = false;
            gp.collisionCheck.checkTile(this);

            //CHECK OBJECT COLLISION
            int objectIndex = gp.collisionCheck.checkObject(this,true);
            pickObject(objectIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.collisionCheck.checkEntity(this,gp.npc);
            interactNPC(npcIndex);

            //IF COLLISION = FALSE, CAN MOVE
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
        else
        {
            direction = "idle";
            spriteCounter++;
            if(spriteCounter >= 18) {
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
                        spriteNum = 1;
                        break;
                    case 5:
                        spriteNum = 1;
                        break;
                    case 6:
                        spriteNum = 1;
                        break;
                }
                spriteCounter = 0;
            }
        }


    }

    public void pickObject(int index)
    {
        if(index != 999)
        {
            String objectName = gp.target[index].name;
            gp.target[index] = null;
            switch (objectName) {
                case "Ammo":
                    hasAmmo+=30;
                    gp.target[index] = null;
                    System.out.println("Ammo: " + hasAmmo);
                    break;
            }
        }
    }

    public void interactNPC(int index)
    {
        if(index != 999) {
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

        Init();

        BufferedImage image = null;
        int targetWidth = 32; // Set your target width
        int targetHeight = 32; // Set your target height

        switch (direction) {
            case "idle":
                if (spriteNum == 1)
                    image = setup(playerIdle1, targetWidth, targetHeight);
                if (spriteNum == 2)
                    image = setup(playerIdle2, targetWidth, targetHeight);
                if (spriteNum == 3)
                    image = setup(playerIdle3, targetWidth, targetHeight);
                if (spriteNum == 4)
                    image = setup(playerIdle4, targetWidth, targetHeight);
                if (spriteNum == 5)
                    image = setup(playerIdle2, targetWidth, targetHeight);
                if (spriteNum == 6)
                    image = setup(playerIdle3, targetWidth, targetHeight);
                break;
            case "left":
                if (spriteNum == 1)
                    image = setup(playerLeft1, targetWidth, targetHeight);
                if (spriteNum == 2)
                    image = setup(playerLeft2, targetWidth, targetHeight);
                if (spriteNum == 3)
                    image = setup(playerLeft3, targetWidth, targetHeight);
                if (spriteNum == 4)
                    image = setup(playerLeft4, targetWidth, targetHeight);
                if (spriteNum == 5)
                    image = setup(playerLeft5, targetWidth, targetHeight);
                if (spriteNum == 6)
                    image = setup(playerLeft6, targetWidth, targetHeight);
                break;
            case "down":
                if (spriteNum == 1)
                    image = setup(playerDown1, targetWidth, targetHeight);
                if (spriteNum == 2)
                    image = setup(playerDown2, targetWidth, targetHeight);
                if (spriteNum == 3)
                    image = setup(playerDown3, targetWidth, targetHeight);
                if (spriteNum == 4)
                    image = setup(playerDown4, targetWidth, targetHeight);
                if (spriteNum == 5)
                    image = setup(playerDown5, targetWidth, targetHeight);
                if (spriteNum == 6)
                    image = setup(playerDown2, targetWidth, targetHeight);
                break;
            case "right":
                if (spriteNum == 1)
                    image = setup(playerRight1, targetWidth, targetHeight);
                if (spriteNum == 2)
                    image = setup(playerRight2, targetWidth, targetHeight);
                if (spriteNum == 3)
                    image = setup(playerRight3, targetWidth, targetHeight);
                if (spriteNum == 4)
                    image = setup(playerRight4, targetWidth, targetHeight);
                if (spriteNum == 5)
                    image = setup(playerRight5, targetWidth, targetHeight);
                if (spriteNum == 6)
                    image = setup(playerRight6, targetWidth, targetHeight);
                break;
            case "up":
                if (spriteNum == 1)
                    image = setup(playerUp1, targetWidth, targetHeight);
                if (spriteNum == 2)
                    image = setup(playerUp2, targetWidth, targetHeight);
                if (spriteNum == 3)
                    image = setup(playerUp3, targetWidth, targetHeight);
                if (spriteNum == 4)
                    image = setup(playerUp4, targetWidth, targetHeight);
                if (spriteNum == 5)
                    image = setup(playerUp5, targetWidth, targetHeight);
                if (spriteNum == 6)
                    image = setup(playerUp2, targetWidth, targetHeight);
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
