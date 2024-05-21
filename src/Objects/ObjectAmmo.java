package Objects;

import Graphics.SpriteSheet;
import Main.GamePanel;

import static Graphics.Assets.*;

public class ObjectAmmo extends ObjectsMain {

    GamePanel gp;

    public ObjectAmmo(GamePanel gp) {
        name = "Ammo";
        Init();
        try{
            image = ammo;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        image = setup(image, 32, 32);
        collision = false;
    }
}
