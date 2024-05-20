package Entity;

import Main.GamePanel;

import java.awt.image.BufferedImage;
import java.util.Random;

import static Graphics.Assets.*;
import static Graphics.Assets.monsterUp2;

public class NPC_Monster extends Entity{

    public NPC_Monster(GamePanel gp){
        super(gp);
        direction = "left";
        speed = 2;
        BufferedImage[][] monsterImages = {
                {monsterIdle1, monsterIdle2, monsterIdle3, monsterIdle4, monsterIdle5, monsterIdle3},
                {monsterLeft1, monsterLeft2, monsterLeft3, monsterLeft4, monsterLeft5, monsterLeft3},
                {monsterDown1, monsterDown2, monsterDown3, monsterDown4, monsterDown5, monsterDown2},
                {monsterRight1, monsterRight2, monsterRight3, monsterRight4, monsterRight5, monsterRight2},
                {monsterUp1, monsterUp2, monsterUp3, monsterUp4, monsterUp5, monsterUp2}
        };
        loadAndScaleImages(monsterImages);
    }

    public void setAction() {

        actionLockCounter++;

        if(actionLockCounter  == 120) {
            Random rand = new Random();
            int i = rand.nextInt(125) + 1;

            if (i <= 25) {
                direction = "up";
            } else if (i <= 50) {
                direction = "down";
            } else if (i <= 75) {
                direction = "left";
            } else if (i <= 100) {
                direction = "right";
            }
            else if (i <= 125) {
                direction = "idle";
            }
            actionLockCounter = 0;
        }

    }

}
