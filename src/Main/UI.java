package Main;

import Objects.ObjectAmmo;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Graphics.Assets.ammo;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    BufferedImage AmmoImage;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.BOLD, 40);
        ObjectAmmo Ammo = new ObjectAmmo();
        AmmoImage = ammo;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(new Font("Arial", Font.BOLD, 40));
        g2.setColor(Color.white);
        g2.drawImage(AmmoImage, gp.tileSize*13+3, gp.tileSize/2-20,gp.tileSize,gp.tileSize, null);
        g2.drawString(" = "+gp.player.hasAmmo,48*14+3 ,45);

        if(gp.gameState == gp.playState)
        {

        }
        if(gp.gameState == gp.pauseState)
        {
             drawPauseScreen();
        }
    }

    public void drawPauseScreen()
    {
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
