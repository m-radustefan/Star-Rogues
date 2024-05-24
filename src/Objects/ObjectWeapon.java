package Objects;

import Entity.Entity;
import Main.GamePanel;

import java.awt.image.BufferedImage;

import static Graphics.Assets.*;

public class ObjectWeapon extends Entity {


    public ObjectWeapon(GamePanel gp) {

        super(gp);

        name = "Weapon";
        Init();
        BufferedImage[][] weaponImage = {
                { weapon }
        };
        loadAndScaleImages(weaponImage);
        collision = false;

    }
}

