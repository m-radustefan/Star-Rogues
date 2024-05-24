package Objects;

import Entity.Entity;
import Graphics.SpriteSheet;
import Main.GamePanel;

import java.awt.image.BufferedImage;

import static Graphics.Assets.*;

public class ObjectAmmo extends Entity {

    public ObjectAmmo(GamePanel gp) {

       super(gp);

        name = "Ammo";
        Init();
        BufferedImage[][] ammoImage = {
                { ammo }
        };
        loadAndScaleImages(ammoImage);
        collision = false;
    }
}
