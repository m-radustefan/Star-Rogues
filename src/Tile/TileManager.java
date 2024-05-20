package Tile;

import Main.GamePanel;
import Main.ImageScale;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static Graphics.Assets.*;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public Tile[] objects;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/Maps/TileMap");
    }


    public void  getTileImage() {

        Init();

        try{

            setup(0,ground1,false);
            setup(1, ground2, false);
            setup(2, hole, true);
            setup(3, wallUp, true);
            setup(4, wallDown, true);
            setup(5, wallLeft, true);
            setup(6, wallRight, true);
            setup(7, cornerUpLeft, true);
            setup(8, cornerUpRight, true);
            setup(9, cornerDownLeft, true);
            setup(10,cornerDownRight, true);
            setup(11,rock1, true);
            setup(12,rock2, true);
            setup(13,plant1, true);
            setup(14,bones, false);
            setup(15,plant2, true);
            setup(16,water,true);
            setup(17,waterCornerUpLeft,true);
            setup(18,waterMiddleUp,true);
            setup(19,waterCornerUpRight,true);
            setup(20,waterMiddleRight,true);
            setup(21,waterCornerDownRight,true);
            setup(22,waterMiddleDown,true);
            setup(23,waterCornerDownLeft,true);
            setup(24,waterMiddleLeft,true);
            setup(25,waterCenter,true);
            setup(26,waterInsideCornerUpLeft,true);
            setup(27,waterInsideCornerUpRight,true);
            setup(28,waterInsideCornerDownRight,true);
            setup(29,waterInsideCornerDownLeft,true);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void setup(int index, BufferedImage imagePath, boolean collision) {
        ImageScale imageScale = new ImageScale();
            tile[index] = new Tile();
            tile[index].image = imagePath;
            tile[index].image = imageScale.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collission = collision;
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
            e.printStackTrace();
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
