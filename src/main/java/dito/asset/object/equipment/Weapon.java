package dito.asset.object.equipment;

import java.awt.*;

import dito.GamePanel;
import dito.asset.object.Object;

public class Weapon extends Object {
    private Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    private int attackValue;

    public Weapon(GamePanel gamePanel) {
        super(gamePanel);
    }

    public Rectangle getAttackArea() {
        return attackArea;
    }

    public void setAttackArea(Rectangle attackArea) {
        this.attackArea = attackArea;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }
}
