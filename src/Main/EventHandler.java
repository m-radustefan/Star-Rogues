package Main;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect[][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    boolean eventDone = false;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];
        int col=0;
        int row=0;
        while(col<gp.maxWorldCol && row<gp.maxWorldRow){

            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if(col==gp.maxWorldCol){
                col=0;
                row++;
            }
        }

    }
    public void checkEvent(){

        //Check if player is more than 1 tile away from last event

        int xDistamce = Math.abs(gp.player.worldX - previousEventX);
        int yDistamce = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistamce, yDistamce);
        if(distance > gp.tileSize){
            canTouchEvent = true;
        }

        if(canTouchEvent == true){
            if(hit(36,17,"any") == true){
                blockRoad(36,17, gp.playState);
            }
        }

    }
    public boolean hit(int eventCol,int eventRow, String reqDirection){

        boolean hit = false;
        gp.player.bounds.x = gp.player.worldX + gp.player.bounds.x;
        gp.player.bounds.y = gp.player.worldY + gp.player.bounds.y;
        eventRect[eventCol][eventRow].x = eventCol*gp.tileSize + eventRect[eventCol][eventRow].x;
        eventRect[eventCol][eventRow].y = eventRow*gp.tileSize + eventRect[eventCol][eventRow].y;

        if(gp.player.bounds.intersects(eventRect[eventCol][eventRow]) && eventRect[eventCol][eventRow].eventDone == false){
            if(gp.player.direction.contentEquals(reqDirection)||reqDirection.contentEquals("any")){
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }
        gp.player.bounds.x = gp.player.boundsDefaultX;
        gp.player.bounds.y = gp.player.boundsDefaultY;
        eventRect[eventCol][eventRow].x = eventRect[eventCol][eventRow].eventRectDefaultX;
        eventRect[eventCol][eventRow].y = eventRect[eventCol][eventRow].eventRectDefaultY;

        return hit;
    }
    public void blockRoad(int col, int row, int gameState){
        gp.gameState = gameState;
        System.out.print("blockRoad");
        eventRect[col][row].eventDone = true;
        eventRect[col][row].canTouchEvent = false;
    }
}
