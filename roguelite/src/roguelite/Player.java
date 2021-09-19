/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelite;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Abe
 */
public class Player extends AnimateEntity implements Renderable{
    double speed = 1.0;
    boolean movingLeft = false;
    boolean movingRight = false;
    boolean movingUp = false; 
    boolean movingDown = false;
    int health;
    
    Image img = new Image( "Resources/Player.png", 100.0, 100.0, false, false );
    double screenWidth;
    double screenHeight;
    
    GraphicsContext gc;
    
    public Player(GraphicsContext gc, double screenWidth, double screenHeight)
    {
    this.gc = gc;
    this.screenWidth = screenWidth;
    this.screenHeight = screenHeight;
    this.health = 100;
    }
    
    @Override
    public void setPosition(){}
    @Override
    public int[] getPosition(){return new int[2];}
    @Override
    public void detectCollisions(Entity other)
    {
    other.detectCollisions(this);
    }
    @Override
    public void render()
    {
    gc.drawImage(img, screenWidth / 2 - 50, screenHeight / 2 - 50);
    }
    
    @Override
    public Rectangle2D getHitBox()
    {
    return new Rectangle2D(screenWidth / 2 - 50, screenHeight / 2 - 50, 100, 100);
    }
    @Override
    public String getEntityType()
    {
    return "Player";
    }
    @Override
    public void takeDamage(double damage)
    {
    health -= damage;
    }
}
