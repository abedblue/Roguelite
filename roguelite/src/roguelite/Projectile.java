/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelite;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;

/**
 *
 * @author Abe
 */
public class Projectile extends AnimateEntity implements Renderable{
    Image img = new Image( "Resources/BaseProjectile.png", 25.0, 25.0, false, false );
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    double dx;
    double dy;
    double damage = 10.0;
    
    public Projectile(double dx, double dy)
    {
    this.dx = dx;
    this.dy = dy;
    this.localX = (double)((primaryScreenBounds.getWidth() / 2) - 12.5 - Roguelite.globalX);
    this.localY = (double)((primaryScreenBounds.getHeight() / 2) - 12.5 - Roguelite.globalY);
    }
    
    @Override
    public void setPosition(){}
    @Override
    public int[] getPosition(){return new int[2];}
    @Override
    public void detectCollisions(Entity other)
    {
        if(other.getHitBox().intersects(this.getHitBox()))
        {
            if(other.getEntityType().equals("Enemy"))
            {
                other.takeDamage(damage);
                RenderableTracker.remove(this);
                AnimateEntityTracker.remove(this);
                EntityTracker.remove(this);
            }
        }
    }
    @Override
    public void render()
    {
    Roguelite.gc.drawImage(img, this.localX + Roguelite.globalX, this.localY + Roguelite.globalY);
    } 
    @Override
    public Rectangle2D getHitBox()
    {
    return new Rectangle2D(this.localX + Roguelite.globalX, this.localY + Roguelite.globalY, 25.0, 25.0);
    }
    @Override
    public String getEntityType()
    {
    return "Projectile";
    }
    
    @Override
    public void takeDamage(double damage)
    {
    //intentionally left blank
    }
    
    @Override
    public void move()
    {
    this.localX += dx;
    this.localY += dy;
    }
}
