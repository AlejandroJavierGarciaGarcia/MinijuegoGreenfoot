import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bote here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bote extends Actor
{
    private int velocidad;
    
    public bote(int v){
        velocidad = v;
    }
    
    public void act()
    {
        // Movilización.
        if(Greenfoot.isKeyDown("right")){
            if(getX() < 650)
                setLocation(getX() + velocidad, getY());
        }
        if(Greenfoot.isKeyDown("left")){
            if(getX() > 50)
                setLocation(getX() - velocidad, getY()); 
        }
        if(Greenfoot.isKeyDown("up")){
            if(getY() > 150)
                setLocation(getX() , getY() - velocidad); 
        }
        if(Greenfoot.isKeyDown("down")){
            if(getY() < 640)
                setLocation(getX() , getY() + velocidad); 
        }
        Choque();// Add your action code here.
    }
    
    public void Choque(){
        Actor colision = getOneIntersectingObject(barco.class);
        if (colision != null)
        {
          getWorld().removeObject(colision);
          getWorld().removeObject(this);
          Greenfoot.stop();
          Greenfoot.playSound("explosion.wav");
        }
    }
    public void aumenta_velocidad(){
        velocidad++;
    }
}
