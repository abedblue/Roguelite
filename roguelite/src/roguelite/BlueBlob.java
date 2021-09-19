/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelite;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Screen;

/**
 *
 * @author Abe
 */
public class BlueBlob extends Blob{
    
    GraphicsContext gc;
    Image img = new Image( "Resources/Basic Blue Enemy.png", 50.0, 50.0, false, false );
    int xDirection = 1;
    int yDirection = 1;
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    
    
    public BlueBlob(double x, double y, GraphicsContext gc)
    {
    this.gc = gc;
    this.localX = x;
    this.localY = y;
    this.moveSpeed = 1;
    this.contactDamage = 1;
    this.health = 15.0;
    
    if(Math.random() <= 0.5)
    {
    xDirection *= -1;
    }
    if(Math.random() <= 0.5)
    {
    yDirection *= -1;
    }
    }
    
    @Override
    public void render()
    {
    gc.drawImage(img, this.localX + Roguelite.globalX, this.localY + Roguelite.globalY);
    }
    
    @Override
    public void move()
    {
    if(Math.random() <= 0.02)
    {
    xDirection *= -1;
    }
    if(Math.random() <= 0.02)
    {
    yDirection *= -1;
    }
    if(this.localX + (this.moveSpeed * xDirection) >= 0 && this.localX + (this.moveSpeed * xDirection) <= primaryScreenBounds.getWidth())
    {
    this.localX += (this.moveSpeed * xDirection);
    }
    
    if(this.localY + (this.moveSpeed * yDirection) >= 0 && this.localY + (this.moveSpeed * yDirection) <= primaryScreenBounds.getHeight())
    {
    this.localY += (this.moveSpeed * yDirection);
    }
    }
    
    @Override
    public Rectangle2D getHitBox()
    {
    return new Rectangle2D(localX + Roguelite.globalX, localY + Roguelite.globalY, 50, 50);
    }
    
    @Override
    public void detectCollisions(Entity other)
    {
    Rectangle2D myHitBox = this.getHitBox();
    Rectangle2D otherHitBox = other.getHitBox();
    if(!(myHitBox.getMaxX() < otherHitBox.getMinX() || myHitBox.getMinX() > otherHitBox.getMaxX() || myHitBox.getMaxY() < otherHitBox.getMinY() || myHitBox.getMinY() > otherHitBox.getMaxY()))
    {
    if(other.getEntityType().equals("Player"))
    {
    other.takeDamage(contactDamage);
    this.localX -= (this.moveSpeed * xDirection);
    if(!(myHitBox.getMaxX() < otherHitBox.getMinX() || myHitBox.getMinX() > otherHitBox.getMaxX() || myHitBox.getMaxY() < otherHitBox.getMinY() || myHitBox.getMinY() > otherHitBox.getMaxY()))
    {
    this.localY -= (this.moveSpeed * yDirection);
    this.localX += (this.moveSpeed * xDirection);
    if(!(myHitBox.getMaxX() < otherHitBox.getMinX() || myHitBox.getMinX() > otherHitBox.getMaxX() || myHitBox.getMaxY() < otherHitBox.getMinY() || myHitBox.getMinY() > otherHitBox.getMaxY()))
    {
    this.localX -= (this.moveSpeed * xDirection);
    }
    }
    }
    if(other.getEntityType().equals("Enemy"))
    {
    
    }
    if(other.getEntityType().equals("Projectile"))
    {
    
    }
    if(other.getEntityType().equals("RoomBorder"))
    {
    this.localX -= (this.moveSpeed * xDirection);
    this.localY -= (this.moveSpeed * yDirection);
    }
    }
    }
}
