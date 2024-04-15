package Graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage playerIdle1;
    public static BufferedImage playerIdle2;
    public static BufferedImage playerIdle3;
    public static BufferedImage playerIdle4;
    public static BufferedImage playerLeft1;
    public static BufferedImage playerLeft2;
    public static BufferedImage playerLeft3;
    public static BufferedImage playerLeft4;
    public static BufferedImage playerLeft5;
    public static BufferedImage playerLeft6;
    public static BufferedImage playerRight1;
    public static BufferedImage playerRight2;
    public static BufferedImage playerRight3;
    public static BufferedImage playerRight4;
    public static BufferedImage playerRight5;
    public static BufferedImage playerRight6;
    public static BufferedImage playerUp1;
    public static BufferedImage playerUp2;
    public static BufferedImage playerUp3;
    public static BufferedImage playerUp4;
    public static BufferedImage playerUp5;
    public static BufferedImage playerDown1;
    public static BufferedImage playerDown2;
    public static BufferedImage playerDown3;
    public static BufferedImage playerDown4;
    public static BufferedImage playerDown5;
    public static BufferedImage ground1;
    public static BufferedImage ground2;
    public static BufferedImage wallLeft;
    public static BufferedImage wallRight;
    public static BufferedImage wallUp;
    public static BufferedImage wallDown;
    public static BufferedImage cornerUpLeft;
    public static BufferedImage cornerUpRight;
    public static BufferedImage cornerDownLeft;
    public static BufferedImage cornerDownRight;
    public static BufferedImage hole;
    public static BufferedImage rock1;
    public static BufferedImage rock2;
    public static BufferedImage plant1;
    public static BufferedImage plant2;
    public static BufferedImage bones;

    public static void Init()
    {
        SpriteSheet sheetPlayerIdle = new SpriteSheet(ImageLoader.LoadImage("/player/Cyborg_idle.png"));
        SpriteSheet sheetPlayerLeft = new SpriteSheet(ImageLoader.LoadImage("/player/Cyborg_run_left.png"));
        SpriteSheet sheetPlayerRight = new SpriteSheet(ImageLoader.LoadImage("/player/Cyborg_run_right.png"));
        SpriteSheet sheetPlayerUp = new SpriteSheet(ImageLoader.LoadImage("/player/Cyborg_run_back.png"));
        SpriteSheet sheetPlayerDown = new SpriteSheet(ImageLoader.LoadImage("/player/Cyborg_run_front.png"));
        SpriteSheet sheetTiles = new SpriteSheet(ImageLoader.LoadImage("/tiles/SpriteSheet.png"));


        playerIdle1= sheetPlayerIdle.cropPlayer(0,0);
        playerIdle2= sheetPlayerIdle.cropPlayer(1,0);
        playerIdle3= sheetPlayerIdle.cropPlayer(2,0);
        playerIdle4= sheetPlayerIdle.cropPlayer(3,0);

        playerLeft1= sheetPlayerLeft.cropPlayer(0,0);
        playerLeft2= sheetPlayerLeft.cropPlayer(1,0);
        playerLeft3= sheetPlayerLeft.cropPlayer(2,0);
        playerLeft4= sheetPlayerLeft.cropPlayer(3,0);
        playerLeft5= sheetPlayerLeft.cropPlayer(4,0);
        playerLeft6= sheetPlayerLeft.cropPlayer(5,0);

        playerRight1= sheetPlayerRight.cropPlayer(0,0);
        playerRight2= sheetPlayerRight.cropPlayer(1,0);
        playerRight3= sheetPlayerRight.cropPlayer(2,0);
        playerRight4= sheetPlayerRight.cropPlayer(3,0);
        playerRight5= sheetPlayerRight.cropPlayer(4,0);
        playerRight6= sheetPlayerRight.cropPlayer(5,0);

        playerUp1= sheetPlayerUp.cropPlayer(0,0);
        playerUp2= sheetPlayerUp.cropPlayer(1,0);
        playerUp3= sheetPlayerUp.cropPlayer(2,0);
        playerUp4= sheetPlayerUp.cropPlayer(3,0);
        playerUp5= sheetPlayerUp.cropPlayer(4,0);

        playerDown1= sheetPlayerDown.cropPlayer(0,0);
        playerDown2= sheetPlayerDown.cropPlayer(1,0);
        playerDown3= sheetPlayerDown.cropPlayer(2,0);
        playerDown4= sheetPlayerDown.cropPlayer(3,0);
        playerDown5= sheetPlayerDown.cropPlayer(4,0);

        ground1= sheetTiles.cropTile(0,0);
        ground2= sheetTiles.cropTile(2,0);
        wallUp= sheetTiles.cropTile(4,0);
        wallLeft= sheetTiles.cropTile(6,0);
        wallDown= sheetTiles.cropTile(8,0);
        wallRight= sheetTiles.cropTile(10,0);
        cornerUpLeft= sheetTiles.cropTile(12,0);
        cornerUpRight= sheetTiles.cropTile(14,0);
        cornerDownLeft= sheetTiles.cropTile(16,0);
        cornerDownRight= sheetTiles.cropTile(18,0);
        hole = sheetTiles.cropTile(1,1);
        rock1= sheetTiles.cropTile(3,1);
        rock2= sheetTiles.cropTile(5,1);
        plant1= sheetTiles.cropTile(7,1);
        bones= sheetTiles.cropTile(9,1);
        plant2= sheetTiles.cropTile(11,1);




    }

}
