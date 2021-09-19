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
public class Enemy extends AnimateEntity implements Renderable{
    double health;
    
    int moveSpeed;
    int shotSpeed;
    int fireRate;
    int contactDamage;
    int shotDamage;
    int knockbackResistance;
    @Override
    public void setPosition(){}
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
    return "Enemy";
    }
    
    @Override
    public void takeDamage(double damage)
    {
    health -= damage;
    if(health <= 0.0)
    {
        RenderableTracker.remove(this);
        AnimateEntityTracker.remove(this);
        EntityTracker.remove(this);
    }
    }
}
