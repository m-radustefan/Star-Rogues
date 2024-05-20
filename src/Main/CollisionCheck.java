package Main;

import Entity.Entity;

public class CollisionCheck {

    GamePanel gp;

    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.bounds.x;
        int entityRightWorldX = entity.worldX + entity.bounds.x + entity.bounds.width;
        int entityTopWorldY = entity.worldY + entity.bounds.y;
        int entityBottomWorldY = entity.worldY + entity.bounds.y + entity.bounds.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1,tileNum2;

        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileManager.tile[tileNum1].collission == true || gp.tileManager.tile[tileNum2].collission == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collission == true || gp.tileManager.tile[tileNum2].collission == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collission == true || gp.tileManager.tile[tileNum2].collission == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collission == true || gp.tileManager.tile[tileNum2].collission == true) {
                    entity.collisionOn = true;
                }
                break;
        }

    }

    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for(int i = 0; i< gp.objectsMain.length; i++)
        {
            if(gp.objectsMain[i] != null)
            {
                entity.bounds.x = entity.worldX + entity.bounds.x;
                entity.bounds.y = entity.worldY + entity.bounds.y;

                gp.objectsMain[i].bounds.x = gp.objectsMain[i].worldX + gp.objectsMain[i].bounds.x;
                gp.objectsMain[i].bounds.y = gp.objectsMain[i].worldY + gp.objectsMain[i].bounds.y;

                switch (entity.direction) {
                    case "up":
                        entity.bounds.y -= entity.speed;
                        if (entity.bounds.intersects(gp.objectsMain[i].bounds)) {
                            if (gp.objectsMain[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.bounds.y += entity.speed;
                        if (entity.bounds.intersects(gp.objectsMain[i].bounds)) {
                            if (gp.objectsMain[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.bounds.x -= entity.speed;
                        if (entity.bounds.intersects(gp.objectsMain[i].bounds)) {
                            if (gp.objectsMain[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.bounds.x += entity.speed;
                        if (entity.bounds.intersects(gp.objectsMain[i].bounds)) {
                            if (gp.objectsMain[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;


                }
                entity.bounds.x = entity.boundsDefaultX;
                entity.bounds.y = entity.boundsDefaultY;
                gp.objectsMain[i].bounds.x = gp.objectsMain[i].boundsDefaultX;
                gp.objectsMain[i].bounds.y = gp.objectsMain[i].boundsDefaultY;
            }
        }

        return index;
    }
}
