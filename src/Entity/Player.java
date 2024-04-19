package Entity;

import Main.GamePanel;
import Main.KeyHandler;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Graphics.Assets.*;


public class Player extends  Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public static Player instance;



    int hasAmmo = 0;

    private Player (GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        bounds = new Rectangle();
        bounds.x = 6;
        bounds.y = 38;
        bounds.width = 24;
        bounds.height = 24;

        boundsDefaultX = 6;
        boundsDefaultY = 38;


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
            String objectName = gp.objectsMain[index].name;
            gp.objectsMain[index] = null;
            switch (objectName) {
                case "Ammo":
                    hasAmmo+=30;
                    gp.objectsMain[index] = null;
                    System.out.println("Ammo: " + hasAmmo);
                    break;
            }
        }
    }

    public void  draw(Graphics2D g2) {

        Init();

        BufferedImage image = null;
        switch (direction) {
            case "idle":
                if (spriteNum == 1)
                    image = playerIdle1;
                if (spriteNum == 2)
                    image = playerIdle2;
                if (spriteNum == 3)
                    image = playerIdle3;
                if (spriteNum == 4)
                    image = playerIdle4;
                if (spriteNum == 5)
                    image = playerIdle2;
                if (spriteNum == 6)
                    image = playerIdle3;
                break;
            case "left":
                if (spriteNum == 1)
                    image = playerLeft1;
                if (spriteNum == 2)
                    image = playerLeft2;
                if (spriteNum == 3)
                    image = playerLeft3;
                if (spriteNum == 4)
                    image = playerLeft4;
                if (spriteNum == 5)
                    image = playerLeft5;
                if (spriteNum == 6)
                    image = playerLeft6;
                break;
            case "down":
                if (spriteNum == 1)
                    image = playerDown1;
                if (spriteNum == 2)
                    image = playerDown2;
                if (spriteNum == 3)
                    image = playerDown3;
                if (spriteNum == 4)
                    image = playerDown4;
                if (spriteNum == 5)
                    image = playerDown5;
                if (spriteNum == 6)
                    image = playerDown2;
                break;
            case "right":
                if (spriteNum == 1)
                    image = playerRight1;
                if (spriteNum == 2)
                    image = playerRight2;
                if (spriteNum == 3)
                    image = playerRight3;
                if (spriteNum == 4)
                    image = playerRight4;
                if (spriteNum == 5)
                    image = playerRight5;
                if (spriteNum == 6)
                    image = playerRight6;
                break;
            case "up":
                if (spriteNum == 1)
                    image = playerUp1;
                if (spriteNum == 2)
                    image = playerUp2;
                if (spriteNum == 3)
                    image = playerUp3;
                if (spriteNum == 4)
                    image = playerUp4;
                if (spriteNum == 5)
                    image = playerUp5;
                if (spriteNum == 6)
                    image = playerUp2;
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
