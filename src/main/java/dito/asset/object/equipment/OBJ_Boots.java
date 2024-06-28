package dito.asset.object.equipment;

import javax.imageio.ImageIO;

import dito.GamePanel;
import dito.asset.object.Object;
import dito.util.UtilityTool;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Boots extends Object {

    public OBJ_Boots(GamePanel gamePanel) {
        super(gamePanel);

        setName("Boots");
        setDescription("[" + getName() + "]\nA pair of old boots");

        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/objects/boots.png")));
            setImage1(UtilityTool.scaleImage(image, gamePanel.getTileSize(), gamePanel.getTileSize()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
