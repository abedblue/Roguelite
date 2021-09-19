/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelite;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Screen;

/**
 *
 * @author Abe
 */
public class CustomAnimationTimer extends AnimationTimer{
    Player player;
    GraphicsContext gc;
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    int rofTimer = 0;
    int rofMax = 10;
    double shotSpeed = 5.0;
    
    public CustomAnimationTimer(GraphicsContext gc, Player player)
    {
    this.player = player;
    this.gc = gc;
    }
    
    @Override
    public void handle(long currentNanoTime)
    {
    //first: entity generatoion
    if(((Roguelite.downPressed && !Roguelite.upPressed && !Roguelite.leftPressed && !Roguelite.rightPressed) || (Roguelite.downPressed && !Roguelite.upPressed && Roguelite.leftPressed && Roguelite.rightPressed)) && rofTimer <= 0)
    {
        Projectile playerProjectile = new Projectile(0.0, shotSpeed);
        RenderableTracker.add(playerProjectile);
        AnimateEntityTracker.add(playerProjectile);
        EntityTracker.add(playerProjectile);
        rofTimer = rofMax;
    }
    if(((Roguelite.upPressed && !Roguelite.downPressed && !Roguelite.leftPressed && !Roguelite.rightPressed) || (Roguelite.upPressed && !Roguelite.downPressed && Roguelite.leftPressed && Roguelite.rightPressed)) && rofTimer <= 0)
    {
        Projectile playerProjectile = new Projectile(0.0, -1.0 * shotSpeed);
        RenderableTracker.add(playerProjectile);
        AnimateEntityTracker.add(playerProjectile);
        EntityTracker.add(playerProjectile);
        rofTimer = rofMax;
    }
    if(((Roguelite.leftPressed && !Roguelite.upPressed && !Roguelite.downPressed && !Roguelite.rightPressed) || (Roguelite.leftPressed && Roguelite.upPressed && Roguelite.downPressed && !Roguelite.rightPressed)) && rofTimer <= 0)
    {
        Projectile playerProjectile = new Projectile(-1.0 * shotSpeed, 0.0);
        RenderableTracker.add(playerProjectile);
        AnimateEntityTracker.add(playerProjectile);
        EntityTracker.add(playerProjectile);
        rofTimer = rofMax;
    }
    if(((Roguelite.rightPressed && !Roguelite.upPressed && !Roguelite.leftPressed && !Roguelite.downPressed) || (Roguelite.rightPressed && Roguelite.upPressed && !Roguelite.leftPressed && Roguelite.downPressed)) && rofTimer <= 0)
    {
        Projectile playerProjectile = new Projectile(shotSpeed, 0.0);
        RenderableTracker.add(playerProjectile);
        AnimateEntityTracker.add(playerProjectile);
        EntityTracker.add(playerProjectile);
        rofTimer = rofMax;
    }
    if(((Roguelite.downPressed && !Roguelite.upPressed && Roguelite.leftPressed && !Roguelite.rightPressed)) && rofTimer <= 0)
    {
        Projectile playerProjectile = new Projectile(-1.0 * (shotSpeed/2.0), (shotSpeed/2.0));
        RenderableTracker.add(playerProjectile);
        AnimateEntityTracker.add(playerProjectile);
        EntityTracker.add(playerProjectile);
        rofTimer = rofMax;
    }
    if(((Roguelite.upPressed && !Roguelite.downPressed && Roguelite.leftPressed && !Roguelite.rightPressed)) && rofTimer <= 0)
    {
        Projectile playerProjectile = new Projectile(-1.0 * (shotSpeed/2.0), -1.0 * (shotSpeed/2.0));
        RenderableTracker.add(playerProjectile);
        AnimateEntityTracker.add(playerProjectile);
        EntityTracker.add(playerProjectile);
        rofTimer = rofMax;
    }
    if(((!Roguelite.leftPressed && !Roguelite.upPressed && Roguelite.downPressed && Roguelite.rightPressed)) && rofTimer <= 0)
    {
        Projectile playerProjectile = new Projectile((shotSpeed/2.0), (shotSpeed/2.0));
        RenderableTracker.add(playerProjectile);
        AnimateEntityTracker.add(playerProjectile);
        EntityTracker.add(playerProjectile);
        rofTimer = rofMax;
    }
    if(((Roguelite.rightPressed && Roguelite.upPressed && !Roguelite.leftPressed && !Roguelite.downPressed)) && rofTimer <= 0)
    {
        Projectile playerProjectile = new Projectile((shotSpeed/2.0), -1.0 * (shotSpeed/2.0));
        RenderableTracker.add(playerProjectile);
        AnimateEntityTracker.add(playerProjectile);
        EntityTracker.add(playerProjectile);
        rofTimer = rofMax;
    }
    rofTimer -= 1;    
    if(Roguelite.wPressed)
    {
    Roguelite.globalY += 3.0;
    }
    if(Roguelite.aPressed)
    {
    Roguelite.globalX += 3.0;
    }
    if(Roguelite.sPressed)
    {
    Roguelite.globalY -= 3.0;
    }
    if(Roguelite.dPressed)
    {
    Roguelite.globalX -= 3.0;
    }
    //second: Movement
    ArrayList<AnimateEntity> myAnimateEntities = AnimateEntityTracker.getAnimateEntities();
    for(int i = 0; i < myAnimateEntities.size(); i++)
    {
    myAnimateEntities.get(i).move();
    }
    //third: Collision Detection
    ArrayList<Entity> myEntities = EntityTracker.getEntities();
    if(myEntities.size() > 1)
    {
        for(int i = 0; i < myEntities.size() - 1; i++)
        {
            for (int j = 1; j < myEntities.size(); j++)
            {
                myEntities.get(i).detectCollisions(myEntities.get(j));
            }
        }
    }
    //fourth: Rendering
    gc.clearRect(0, 0, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
    player.render();
    ArrayList<Renderable> myRenderables = RenderableTracker.getRenderables();
    for(int i = 0; i < myRenderables.size(); i++)
    {
    myRenderables.get(i).render();
    }
    }
}
