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
public final class EntityTracker {
    static ArrayList<Entity> myEntities = new ArrayList();
    
    public static void add(Entity toAdd)
    {
    myEntities.add(toAdd);
    }
    
    public static void remove(Entity toAdd)
    {
    myEntities.remove(toAdd);
    }
    
    public static void clear()
    {
    myEntities.clear();
    }
    
    public static ArrayList<Entity> getEntities()
    {
    return myEntities;
    }
}
