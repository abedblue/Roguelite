/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelite;

/**
 *
 * @author Abe
 */
public class Map implements Renderable{
    private String[][] myMap;
    
    @Override
    public void render(){}
    public void makeFloor()
    {
        myMap = new String[9][9];
        myMap[4][4] = "nsew";
    }
}
