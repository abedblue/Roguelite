/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelite;


import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Abe
 */
public class Roguelite extends Application {
    
    public static GraphicsContext gc;
    public static boolean downPressed = false;
    public static boolean upPressed = false;
    public static boolean leftPressed = false;
    public static boolean rightPressed = false;
    public static boolean wPressed = false;
    public static boolean aPressed = false;
    public static boolean sPressed = false;
    public static boolean dPressed = false;
    public static double globalX = 0.0;
    public static double globalY = 0.0;
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth(primaryScreenBounds.getWidth());
        primaryStage.setHeight(primaryScreenBounds.getHeight());
        
        final Canvas canvas = new Canvas(primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
        gc = canvas.getGraphicsContext2D();
 
        gc.setFill(Color.BLUE);
        //gc.fillRect(0,0,primaryScreenBounds.getWidth(),250);
 
        root.getChildren().add(canvas);
        
        Scene scene = new Scene(root, 300, 250);
         
        scene.addEventFilter(KeyEvent.ANY, keyEvent -> {
            System.out.println(keyEvent);
        });
        
        scene.setOnKeyPressed(e -> 
        {
            if (e.getCode() == KeyCode.UP) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                upPressed = true;
            }
            
            if (e.getCode() == KeyCode.LEFT) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                leftPressed = true;
            }
            
            if (e.getCode() == KeyCode.DOWN) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                downPressed = true;
            }
              
            if (e.getCode() == KeyCode.RIGHT) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                rightPressed = true;
            }
            
            if (e.getCode() == KeyCode.W) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                wPressed = true;
            }
            
            if (e.getCode() == KeyCode.A) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                aPressed = true;
            }
            
            if (e.getCode() == KeyCode.S) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                sPressed = true;
            }
              
            if (e.getCode() == KeyCode.D) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                dPressed = true;
            }
        });
        
        scene.setOnKeyReleased(e -> 
        {
            if (e.getCode() == KeyCode.UP) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                upPressed = false;
            }
            
            if (e.getCode() == KeyCode.LEFT) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                leftPressed = false;
            }
            
            if (e.getCode() == KeyCode.DOWN) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                downPressed = false;
            }
            if (e.getCode() == KeyCode.RIGHT) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                rightPressed = false;
            }
            
            if (e.getCode() == KeyCode.W) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                wPressed = false;
            }
            
            if (e.getCode() == KeyCode.A) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                aPressed = false;
            }
            
            if (e.getCode() == KeyCode.S) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                sPressed = false;
            }
            if (e.getCode() == KeyCode.D) 
            {
                //BlueBlob buildablob = new BlueBlob(50, 50, gc);
                dPressed = false;
            }
        });
        primaryStage.setTitle("I Am");
        primaryStage.setScene(scene);
        
        
        System.out.println("x: " + primaryScreenBounds.getWidth() + " y: " + primaryScreenBounds.getHeight());
        
        primaryStage.show();
        
        Player player = new Player(gc, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
        EntityTracker.add(player);
        
        CustomAnimationTimer gameLoop = new CustomAnimationTimer(gc, player);
        BlueBlob myBlob = new BlueBlob(50.0, 50.0, gc);
        RenderableTracker.add(myBlob);
        AnimateEntityTracker.add(myBlob);
        EntityTracker.add(myBlob);
        
        BlueBlob myBlob2 = new BlueBlob(-50.0, -50.0, gc);
        RenderableTracker.add(myBlob2);
        AnimateEntityTracker.add(myBlob2);
        EntityTracker.add(myBlob2);
        
        
        BlueBlob myBlob3 = new BlueBlob(-50.0, 50.0, gc);
        RenderableTracker.add(myBlob3);
        AnimateEntityTracker.add(myBlob3);
        EntityTracker.add(myBlob3);
        
        gameLoop.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
