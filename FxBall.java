import static java.lang.Math.*;
import java.util.*;
import java.util.Scanner;
import java.awt.Color;


public class FxBall extends Ball implements IBall{
    public FxBall(double cx, double cy, double width, double height, java.awt.Color color, double speed, double vx, double vy){
        super(cx, cy, width, height, color, speed, vx, vy);
        
        this.height = height;
        this.width = width;
    }   


    private double speed, cx, cy, width, height, vx, vy;
    java.awt.Color color;

    private double diminuicao = 0;

    private double auxiliar;
      
    private Queue <Double> coordenadasX = new LinkedList<>();
    
    private Queue <Double> coordenadasY = new LinkedList<>();




    @Override
    public void draw(){
        super.draw();
    
            IBall ultimaBolinha = BallManager.bolas.get(0);
            if(coordenadasX.isEmpty()){
                for(int t=0;t<50;t++){
                    coordenadasX.add(getCx());
                    coordenadasY.add(getCy());
                }
                Iterator x = coordenadasX.iterator();
                Iterator y = coordenadasY.iterator();
                
                while(x.hasNext() && y.hasNext()){
                
                    double coordenadX = (double) x.next();
                    double coordenadY = (double) y.next();
    
                
                    
                     if(equals(ultimaBolinha)){
                        GameLib.setColor(Color.YELLOW); 
                     }else{
                        GameLib.setColor(Color.RED);
                     }  
                     if(this.diminuicao<15){
                        GameLib.fillRect(coordenadX, coordenadY,width+this.diminuicao,height+this.diminuicao);
                        this.diminuicao =  this.diminuicao + 0.1;
                        this.auxiliar = this.diminuicao;
                     }else{
                        GameLib.fillRect(coordenadX, coordenadY, width+this.auxiliar -this.diminuicao,height+this.auxiliar -this.diminuicao);
                        this.diminuicao =  this.diminuicao + 0.1;

                     }  
                     
                     
                }
               
                this.diminuicao = 0;
        }else{
           
            coordenadasX.remove();
                
            coordenadasY.remove();	
    
            coordenadasX.add(getCx());
            coordenadasY.add(getCy());
    
            Iterator x = coordenadasX.iterator();
            Iterator y = coordenadasY.iterator();
            this.diminuicao = 0;
                while(x.hasNext() && y.hasNext()){
                
                    double coordenadX = (double) x.next();
                    double coordenadY = (double) y.next();
    
                        if(equals(ultimaBolinha)){
                            GameLib.setColor(Color.YELLOW); 
                         }else{
                            GameLib.setColor(Color.RED);
                         }  
                         if(this.diminuicao<5){
                            GameLib.fillRect(coordenadX, coordenadY, width+this.diminuicao,height+this.diminuicao);
                            this.diminuicao =  this.diminuicao + 0.1;
                         }else{
                            GameLib.fillRect(coordenadX, coordenadY, width-this.diminuicao,height-this.diminuicao);
                            this.diminuicao =  this.diminuicao + 0.1;
    
                         } 

        }                 
        }
        
        
}

}
      
