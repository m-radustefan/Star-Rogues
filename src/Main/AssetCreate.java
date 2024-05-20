package Main;

import Entity.NPC_Monster;
import Objects.ObjectAmmo;
import Objects.ObjectWeapon;
import Objects.ObjectsMain;

public class AssetCreate {

    GamePanel gp;

    public AssetCreate(GamePanel gp) {

        this.gp = gp;

    }
    public void setObjects() {

        gp.objectsMain[0] = new ObjectAmmo();
        gp.objectsMain[0].worldX = 3 * gp.tileSize ;
        gp.objectsMain[0].worldY = 6 * gp.tileSize ;
        gp.objectsMain[1] = new ObjectAmmo();
        gp.objectsMain[1].worldX = 20 * gp.tileSize ;
        gp.objectsMain[1].worldY = 18 * gp.tileSize ;
        gp.objectsMain[2] = new ObjectWeapon();
        gp.objectsMain[2].worldX = 37 * gp.tileSize ;
        gp.objectsMain[2].worldY = 17 * gp.tileSize ;
    }
    public void setNPC(){
        gp.npc[0]= new NPC_Monster((gp));
        gp.npc[0].worldX = 21 * gp.tileSize ;
        gp.npc[0].worldY = 23 * gp.tileSize ;
    }
}
