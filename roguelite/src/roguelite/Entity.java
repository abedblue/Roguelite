/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelite;

import javafx.geometry.Rectangle2D;

/**
 *
 * @author Abe
 */
public abstract class Entity {
    double localX;
    double localY;
    abstract void detectCollisions(Entity other);
    abstract int[] getPosition();
    abstract Rectangle2D getHitBox();
    abstract String getEntityType();
    abstract void takeDamage(double damage);
}
