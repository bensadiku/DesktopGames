package LojaSrc;



import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author B.Sadiku
 */
public class Handler {
    
    LinkedList <GameObject>object = new LinkedList <GameObject>();
    public int spd =5;
    
    public void tick(){
        for (int i =0; i<object.size();i++){
            
            GameObject tempObject = object.get(i);
            
            tempObject.tick();
        }  
    }
    public void render (Graphics g)  {
            for (int i =0; i<object.size();i++){
                GameObject tempObject = object.get(i);

               tempObject.render(g);
            }
         }
    
    public void addObject(GameObject object){
            this.object.add(object);
        }
    public void removeObject(GameObject object){
            this.object.remove(object);
        }
    
    public void clearEnemies() {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
            if (tempObject.getID() != ID.Player) {
                this.removeObject(tempObject);
                i--;
            }
        }
    }
    public void clearPlayer() {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
            if (tempObject.getID() == ID.Player) {
                this.removeObject(tempObject);
                i--;
            }
        }
    }
    }

