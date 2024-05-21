package Objects;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Graphics.Assets.*;

public class ObjectHealthBar extends ObjectsMain {

    GamePanel gp;

    public ObjectHealthBar(GamePanel gp) {
        name = "HealthBar";
        Init();
        try {
            image = healthBar100;
            image2 = healthBar75;
            image3 = healthBar50;
            image4 = healthBar25;
            image5 = healthBar0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        image = setup(image, 32, 1);
        image2 = setup(image2, 32, 1);
        image3 = setup(image3, 32, 1);
        image4 = setup(image4, 32, 1);
        image5 = setup(image5, 32, 1);
        collision = false;
    }

}
