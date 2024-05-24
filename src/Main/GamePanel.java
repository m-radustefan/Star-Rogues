package Main;

import Entity.Entity;
import Entity.Player;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    KeyHandler keyH = new KeyHandler(this);
    public UI ui = new UI(this);
    public EventHandler eventHandler = new EventHandler(this);
    Thread gameThread;

    //ENTITY ASSET OBJECT
    public CollisionCheck collisionCheck = new CollisionCheck(this);
    public AssetCreate assetCreate = new AssetCreate(this);
    public Player player =  Player.getInstance(this,keyH);
    public Entity object[] = new Entity[10];
    public Entity npc[] = new Entity[10];
    ArrayList<Entity> entityList = new ArrayList<>();
    //GAME STATE
    public int gameState;
    public final int titleState=0;
    public final int playState=1;
    public final int pauseState=2;



    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setupObjects(){

        assetCreate.setObjects();
        assetCreate.setNPC();
        gameState= titleState;
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

        if(gameState == playState) {
            //PLAYER
            player.update();
            //NPC
            for(int i = 0; i < npc.length; i++) {
                if(npc[i] != null) {
                    npc[i].update();
                }
            }

        }
        //if(gameState == pauseState) {

        //}
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == titleState) {
            ui.draw(g2);
        } else {
            tileManager.draw(g2);
            // Add player and other entities to list for drawing
            entityList.add(player);

            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    entityList.add(npc[i]);
                }
            }

            for (int i = 0; i < object.length; i++) {
                if (object[i] != null) {
                    entityList.add(object[i]);
                }
            }

            // Sort entities by worldY for correct drawing order
            Collections.sort(entityList, Comparator.comparingInt(e -> e.worldY));

            // Draw all entities
            for (Entity entity : entityList) {
                entity.draw(g2);
            }

            // Clear the list after drawing
            entityList.clear();

            // Draw tiles and UI

            ui.draw(g2);
        }
        g2.dispose();
    }
}
