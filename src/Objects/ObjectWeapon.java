package Objects;

import Main.GamePanel;

import static Graphics.Assets.*;

public class ObjectWeapon extends ObjectsMain {

    GamePanel gp;

    public ObjectWeapon(GamePanel gp) {
        name = "Weapon";
        Init();
        try{
            image = weapon;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        image = setup(image, 32, 32);
        collision = false;

    }
}

