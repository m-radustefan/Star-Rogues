package Objects;

import Entity.Entity;
import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Graphics.Assets.*;

public class ObjectHealthBar extends Entity {

    public ObjectHealthBar(GamePanel gp) {

        super(gp);
        name = "HealthBar";
        Init();
        BufferedImage[][] healthBarImage = {
                { healthBar100, healthBar75, healthBar50, healthBar25, healthBar0 }
        };
        loadAndScaleImages(healthBarImage);
//        image = setup(healthBar100, 32, 1);
//        image2 = setup(healthBar75, 32, 1);
//        image3 = setup(healthBar50, 32, 1);
//        image4 = setup(healthBar25, 32, 1);
//        image5 = setup(healthBar0, 32, 1);
        collision = false;

    }

}
