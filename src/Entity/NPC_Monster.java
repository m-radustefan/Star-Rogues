package Entity;

import Main.GamePanel;

public class NPC_Monster extends Entity{

    public NPC_Monster(GamePanel gp){
        super(gp);
        direction = "left";
        speed = 3;
    }
}
