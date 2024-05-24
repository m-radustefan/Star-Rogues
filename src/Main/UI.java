package Main;

import Entity.Entity;
import Objects.ObjectAmmo;
import Objects.ObjectHealthBar;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Graphics.Assets.*;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    BufferedImage heart100,heart75,heart50,heart25,heart0;
    Font arial_40;
    BufferedImage AmmoImage;
    public int commandNum=0;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.BOLD, 40);
        ObjectAmmo Ammo = new ObjectAmmo(gp);
        AmmoImage = ammo;

        //CREATE HUD OBJECT
        Entity heart = new ObjectHealthBar(gp);
        heart100=healthBar100;
        heart75=healthBar75;
        heart50=healthBar50;
        heart25=healthBar25;
        heart0=healthBar0;

    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        //TITLESTATE
        if(gp.gameState == gp.titleState)
        {
            drawTitleScreen();
        }//PLAYSTATE
        else if(gp.gameState == gp.playState)
        {
            g2.setFont(new Font("Arial", Font.BOLD, 40));
            g2.setColor(Color.white);
            g2.drawImage(AmmoImage, gp.tileSize*13+3, gp.tileSize/2-20,gp.tileSize,gp.tileSize, null);
            g2.drawString(" = "+gp.player.hasAmmo,48*14+3 ,45);
           drawPlayerLife();

        }//PAUSESTATE
        else if(gp.gameState == gp.pauseState)
        {
             drawPauseScreen();
             //drawPlayerLife();

        }


    }

    public void drawPlayerLife(){
        int x = gp.tileSize/2-20;
        int y = gp.tileSize/2-20;
        switch(gp.player.life){
            case 1:
                g2.drawImage(healthBar0,x,y,gp.tileSize*7+24,48,null);
                break;
            case 2:
                g2.drawImage(healthBar25,x,y,gp.tileSize*7+24,48,null);
                break;
            case 3:
                g2.drawImage(healthBar50,x,y,gp.tileSize*7+24,48,null);
                break;
            case 4:
                g2.drawImage(healthBar75,x,y,gp.tileSize*7+24,48,null);
                break;
            case 5:
                g2.drawImage(healthBar100,x,y,gp.tileSize*7+24,48,null);
                break;
        }
    }


    public void drawTitleScreen()
    {
        //TITLE NAME
        g2.setFont(arial_40.deriveFont(Font.BOLD,96f));
        String Text = "STAR ROGUES";
        int x = getXforCenterText(Text);
        int y = gp.tileSize*3;
        //SHADOW
        g2.setColor(Color.gray);
        g2.drawString(Text, x+3, y+3);
        //MAINTEXT
        g2.setColor(Color.white);
        g2.drawString(Text, x, y);
        //MENU
        g2.setFont(arial_40.deriveFont(Font.BOLD,48f));
        Text= "NEW GAME";
        x = getXforCenterText(Text);
        y += gp.tileSize*4;
        g2.drawString(Text, x, y);
        if(commandNum==0){
            g2.drawString(">", x-gp.tileSize, y);
        }
        Text= "LOAD GAME";
        x = getXforCenterText(Text);
        y += gp.tileSize*1.5;
        g2.drawString(Text, x, y);
        if(commandNum==1){
            g2.drawString(">", x-gp.tileSize, y);
        }
        Text= "QUIT";
        x = getXforCenterText(Text);
        y += gp.tileSize*1.5;
        g2.drawString(Text, x, y);
        if(commandNum==2){
            g2.drawString(">", x-gp.tileSize, y);
        }

    }

    public void drawPauseScreen()
    {
        System.out.printf("PAUSE");
        String text = "PAUSED";
        int x = getXforCenterText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text,x,y);
    }

    public int getXforCenterText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
