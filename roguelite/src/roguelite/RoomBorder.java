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
public class RoomBorder extends Terrain implements Renderable{
    @Override
    public int damageTaken(){return 0;}
    @Override
    public boolean passable(){return false;}
    @Override
    public int[] getPosition(){return new int[2];}
    @Override
    public void detectCollisions(Entity other){}
    @Override
    public void render(){}
    @Override
    public Rectangle2D getHitBox()
    {
    return new Rectangle2D(0.0, 0.0, 0.0, 0.0);
    }
    @Override
    public String getEntityType()
    {
    return "RoomBorder";
    }
    @Override
    public void takeDamage(double damage)
    {
    //intentionally left blank
    }
}
