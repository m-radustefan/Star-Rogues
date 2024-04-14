package Tile;

import Main.GamePanel;


import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static Graphics.Assets.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[20];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

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
            tile[3] = new Tile();
            tile[3].image = wallUp;
            tile[4] = new Tile();
            tile[4].image = wallDown;
            tile[5] = new Tile();
            tile[5].image = wallLeft;
            tile[6] = new Tile();
            tile[6].image = wallRight;
            tile[7] = new Tile();
            tile[7].image = cornerUpLeft;
            tile[8] = new Tile();
            tile[8].image = cornerUpRight;
            tile[9] = new Tile();
            tile[9].image = cornerDownLeft;
            tile[10] = new Tile();
            tile[10].image = cornerDownRight;

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

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

                String line = br.readLine();

                while (col < gp.maxScreenCol) {
                    String numbers[] = line.split(" ");

                    int number = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = number;
                    col++;
                }
                if(col == gp.maxScreenCol){
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

         int col = 0;
         int row = 0;
         int x = 0;
         int y = 0;

         while(col<gp.maxScreenCol && row<gp.maxScreenRow) {

             int tileNum = mapTileNum[col][row];

             g2.drawImage(tile[tileNum].image, x, y,gp.tileSize,gp.tileSize, null);
             col++;
             x += gp.tileSize;

             if(col>=gp.maxScreenCol) {
                 col = 0;
                 x = 0;
                 row++;
                 y += gp.tileSize;
             }


         }
    }
}
