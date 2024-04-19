package Main;

import Entity.Player;
import Objects.ObjectAmmo;
import Objects.ObjectsMain;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

import static Graphics.Assets.Init;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3; //x3 scale

    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //WORLD SETTINGS
    public final int maxWorldCol = 40;
    public final int maxWorldRow = 25;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionCheck collisionCheck = new CollisionCheck(this);
    public AssetCreate assetCreate = new AssetCreate(this);
    public Player player =  Player.getInstance(this,keyH);
    public ObjectsMain objectsMain[] = new ObjectsMain[10];



    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setupObjects(){

        assetCreate.setObjects();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {

                //1.Update position
                update();
                //2.Draw the screen
                repaint();

                delta--;
                drawCount++;

            }

            if(timer >= 1000000000) {
                System.out.println("FPS:"+ drawCount);
                drawCount = 0;
                timer = 0;
            }


        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        //TILE
        tileManager.draw(g2);

        //OBJECTS
        for( int i=0; i < objectsMain.length; i++)
        {

            if(objectsMain[i] != null){
                objectsMain[i].draw(g2,this);
            }
        }

        //PLAYER
        player.draw(g2);

        g2.dispose();
    }
}
