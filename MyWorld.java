import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private counter score;
    private counter level;

    private int velocidadBarco;
    private int desplazamiento;
    private int desplazamientoNivel;
    private bote principal;
    private int num_rivales;

    public MyWorld()
    {    
        // Creación del mundo según tamaños indicados.
        super(700, 800, 1);

        desplazamiento = 0;
        desplazamientoNivel = 4;
        velocidadBarco = 2;

        score = new counter("Puntaje: " );
        level = new counter("Nivel: " );
        level.add(1);
        principal = new bote(velocidadBarco);

        addObject(principal, 300, 600);
        addObject(level, 180, 90);
        addObject(score, 180, 60);

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    public void act(){
        aumentar_dificultad();
        aniadir_rivales();
    }

    public int getRandomNumber(int start,int end){
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }

    public void aumentar_puntuacion(int valor){
        score.add(valor);
    }

    public void aumentar_num_adelantamientos(){
        desplazamiento++;
    }

    public void disminuir_num_rivales(){
        num_rivales--;
    }

    public void aumentar_dificultad(){
        if(desplazamiento == desplazamientoNivel){
            desplazamiento = 0;
            desplazamientoNivel = desplazamientoNivel + 2;
            velocidadBarco++;
            level.add(1);
            principal.aumenta_velocidad();
        }
    }

    public void aniadir_rivales(){

        if(num_rivales == 0){

            int carril = getRandomNumber(0,3);

            if(carril == 0){
                addObject(new barco(velocidadBarco),160, 80);
            }
            else if( carril == 1){
                addObject(new barco(velocidadBarco),290, 80);
            }
            else{
                addObject(new barco(velocidadBarco),450, 80);
            }

            carril++;
            carril = carril % 5;

            if(carril == 0){
                addObject(new barco(velocidadBarco),160, 80);
            }
            else if( carril == 1){
                addObject(new barco(velocidadBarco),290, 80);
            }
            else{
                addObject(new barco(velocidadBarco),450, 80);
            }

            num_rivales = 2;
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        bote bote = new bote(2);
        addObject(bote,285,586);
        removeObject(bote);
    }
}
