package Objects;

import Graphics.SpriteSheet;

import static Graphics.Assets.*;

public class ObjectAmmo extends ObjectsMain {

    public ObjectAmmo() {
        name = "Ammo";
        Init();
        try{
            image = ammo;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
