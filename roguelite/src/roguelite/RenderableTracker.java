/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelite;

import java.util.ArrayList;

/**
 *
 * @author Abe
 */
public final class RenderableTracker {
    static ArrayList<Renderable> myRenderables = new ArrayList();
    public static void add(Renderable toAdd)
    {
    myRenderables.add(toAdd);
    }
    
    public static void remove(Renderable toAdd)
    {
    myRenderables.remove(toAdd);
    }
    
    public static void clear()
    {
    myRenderables.clear();
    }
    
    public static ArrayList<Renderable> getRenderables()
    {
    return myRenderables;
    }
}
