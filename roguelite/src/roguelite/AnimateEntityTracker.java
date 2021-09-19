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
public class AnimateEntityTracker {
    static ArrayList<AnimateEntity> myAnimateEntities = new ArrayList();
    public static void add(AnimateEntity toAdd)
    {
    myAnimateEntities.add(toAdd);
    }
    
    public static void remove(AnimateEntity toAdd)
    {
    myAnimateEntities.remove(toAdd);
    }
    
    public static void clear()
    {
    myAnimateEntities.clear();
    }
    
    public static ArrayList<AnimateEntity> getAnimateEntities()
    {
    return myAnimateEntities;
    }
}
