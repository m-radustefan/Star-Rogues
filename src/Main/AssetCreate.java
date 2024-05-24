package Main;

import Entity.NPC_Monster;
import Objects.ObjectAmmo;
import Objects.ObjectWeapon;

public class AssetCreate {

    GamePanel gp;

    public AssetCreate(GamePanel gp) {

        this.gp = gp;

    }
    public void setObjects() {

        gp.object[0] = new ObjectAmmo(gp);
        gp.object[0].worldX = 3 * gp.tileSize ;
        gp.object[0].worldY = 6 * gp.tileSize ;
        gp.object[1] = new ObjectAmmo(gp);
        gp.object[1].worldX = 20 * gp.tileSize ;
        gp.object[1].worldY = 18 * gp.tileSize ;
        gp.object[2] = new ObjectWeapon(gp);
        gp.object[2].worldX = 37 * gp.tileSize ;
        gp.object[2].worldY = 17 * gp.tileSize ;
    }
    public void setNPC(){
        gp.npc[0]= new NPC_Monster(gp);
        gp.npc[0].worldX = 21 * gp.tileSize ;
        gp.npc[0].worldY = 23 * gp.tileSize ;
    }
}
