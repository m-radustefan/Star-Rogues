package Objects;

import static Graphics.Assets.*;

public class ObjectWeapon extends ObjectsMain {

    public ObjectWeapon() {
        name = "Weapon";
        Init();
        try{
            image = weapon;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        collision = false;
    }
}

