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

        for(int i = 0; i< gp.target.length; i++)
        {
            if(gp.target[i] != null)
            {
                entity.bounds.x = entity.worldX + entity.bounds.x;
                entity.bounds.y = entity.worldY + entity.bounds.y;

                gp.target[i].bounds.x = gp.target[i].worldX + gp.target[i].bounds.x;
                gp.target[i].bounds.y = gp.target[i].worldY + gp.target[i].bounds.y;

                switch (entity.direction) {
                    case "up":
                        entity.bounds.y -= entity.speed;
                        if (entity.bounds.intersects(gp.target[i].bounds)) {
                            if (gp.target[i].collision == true)
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
                        if (entity.bounds.intersects(gp.target[i].bounds)) {
                            if (gp.target[i].collision == true)
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
                        if (entity.bounds.intersects(gp.target[i].bounds)) {
                            if (gp.target[i].collision == true)
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
                        if (entity.bounds.intersects(gp.target[i].bounds)) {
                            if (gp.target[i].collision == true)
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
                gp.target[i].bounds.x = gp.target[i].boundsDefaultX;
                gp.target[i].bounds.y = gp.target[i].boundsDefaultY;
            }
        }

        return index;
    }

    public int checkEntity(Entity entity, Entity[] target){
        int index = 999;

        for(int i = 0; i< target.length; i++)
        {
            if(target[i] != null)
            {
                entity.bounds.x = entity.worldX + entity.bounds.x;
                entity.bounds.y = entity.worldY + entity.bounds.y;

                target[i].bounds.x = target[i].worldX + target[i].bounds.x;
                target[i].bounds.y = target[i].worldY + target[i].bounds.y;

                switch (entity.direction) {
                    case "up":
                        entity.bounds.y -= entity.speed;
                        if (entity.bounds.intersects(target[i].bounds)) {
                                entity.collisionOn = true;
                                index = i;

                        }
                        break;
                    case "down":
                        entity.bounds.y += entity.speed;
                        if (entity.bounds.intersects(target[i].bounds)) {
                                entity.collisionOn = true;
                                index = i;
                        }
                        break;
                    case "left":
                        entity.bounds.x -= entity.speed;
                        if (entity.bounds.intersects(target[i].bounds)) {
                                entity.collisionOn = true;
                                index = i;
                        }
                        break;
                    case "right":
                        entity.bounds.x += entity.speed;
                        if (entity.bounds.intersects(target[i].bounds)) {
                                entity.collisionOn = true;
                                index = i;
                        }
                        break;


                }
                entity.bounds.x = entity.boundsDefaultX;
                entity.bounds.y = entity.boundsDefaultY;
                target[i].bounds.x = target[i].boundsDefaultX;
                target[i].bounds.y = target[i].boundsDefaultY;
            }
        }

        return index;
    }

    public void checkPlayer(Entity entity)
    {
        entity.bounds.x = entity.worldX + entity.bounds.x;
        entity.bounds.y = entity.worldY + entity.bounds.y;

        gp.player.bounds.x = gp.player.worldX + gp.player.bounds.x;
        gp.player.bounds.y = gp.player.worldY + gp.player.bounds.y;

        switch (entity.direction) {
            case "up":
                entity.bounds.y -= entity.speed;
                if (entity.bounds.intersects(gp.player.bounds)) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entity.bounds.y += entity.speed;
                if (entity.bounds.intersects(gp.player.bounds)) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entity.bounds.x -= entity.speed;
                if (entity.bounds.intersects(gp.player.bounds)) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entity.bounds.x += entity.speed;
                if (entity.bounds.intersects(gp.player.bounds)) {
                    entity.collisionOn = true;
                }
                break;


        }
        entity.bounds.x = entity.boundsDefaultX;
        entity.bounds.y = entity.boundsDefaultY;
        gp.player.bounds.x = gp.player.boundsDefaultX;
        gp.player.bounds.y = gp.player.boundsDefaultY;

    }
}
