package Tile;

import Main.GamePanel;


import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static Graphics.Assets.*;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[20];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/Maps/TileMap");
    }

    public void  getTileImage() {

        Init();

        try{
            tile[0] = new Tile();
            tile[0].image = ground1;
            tile[1] = new Tile();
            tile[1].image = ground2;
            tile[2] = new Tile();
            tile[2].image = hole;
            tile[2].collission = true;
            tile[3] = new Tile();
            tile[3].image = wallUp;
            tile[3].collission = true;
            tile[4] = new Tile();
            tile[4].image = wallDown;
            tile[4].collission = true;
            tile[5] = new Tile();
            tile[5].image = wallLeft;
            tile[5].collission = true;
            tile[6] = new Tile();
            tile[6].image = wallRight;
            tile[6].collission = true;
            tile[7] = new Tile();
            tile[7].image = cornerUpLeft;
            tile[7].collission = true;
            tile[8] = new Tile();
            tile[8].image = cornerUpRight;
            tile[8].collission = true;
            tile[9] = new Tile();
            tile[9].image = cornerDownLeft;
            tile[9].collission = true;
            tile[10] = new Tile();
            tile[10].image = cornerDownRight;
            tile[10].collission = true;
            tile[11] = new Tile();
            tile[11].image = rock1;
            tile[11].collission = true;
            tile[12] = new Tile();
            tile[12].image = rock2;
            tile[12].collission = true;
            tile[13] = new Tile();
            tile[13].image = plant1;
            tile[13].collission = true;
            tile[15] = new Tile();
            tile[15].image = plant2;
            tile[15].collission = true;
            tile[14] = new Tile();
            tile[14].image = bones;

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void loadMap(String path){
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");

                    int number = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = number;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e)
        {

        }
    }

    public void draw(Graphics2D g2) {

         int worldCol = 0;
         int worldRow = 0;

         while(worldCol<gp.maxWorldCol && worldRow<gp.maxWorldRow) {

             int tileNum = mapTileNum[worldCol][worldRow];

             int worldX = worldCol * gp.tileSize;
             int worldY = worldRow * gp.tileSize;
             int screenX = worldX - gp.player.worldX + gp.player.screenX;
             int screenY = worldY - gp.player.worldY + gp.player.screenY;

             if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                 g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
             }
             worldCol++;


             if(worldCol>=gp.maxWorldCol) {
                 worldCol = 0;
                 worldRow++;

             }


         }
    }
}
