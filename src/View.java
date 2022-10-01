import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JFrame;

public class View extends JFrame{
    private Horloge horloge;
    int width=500;
    int height=500;

     public View(){
            this.horloge=new Horloge();
            this.horloge.setHeure(12,13);
            
          setSize(width,height);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setResizable(false);
          setLocationRelativeTo(null);
          setVisible(true);
     }
     

     public static void main(String a[]){
         new View();
     }

    public void paint(Graphics g){
        
            
        
         Point center = new Point();
         center.x=width/2;
        center.y=width/2;
         int rayon =width/5;
         
         
         for(int i=1;i<=12;i++){
            double angle=i*Math.PI/6.0-Math.PI/2.0;
            double x=center.x+rayon*Math.cos(angle);
            double y=center.y+rayon*Math.sin(angle);
            g.drawString(" "+i,(int)x,(int)y);
        }
        //bare des secondes 
        int sec=this.horloge.getSecondes().getValeur();
        double anglesec=(sec*((Math.PI)/30.0)-(Math.PI/2.0));
        bare( g,Color.red,rayon,anglesec,center.x,center.y, 0.6);

	    //bare des minutes 
       
        int min=this.horloge.getMinutes().getValeur();
        double anglemin=(min*((Math.PI)/30.0)-(Math.PI/2.0));
        bare( g,Color.yellow,rayon,anglemin,center.x,center.y, 0.5);
        
        //bares des heures 
        int h=this.horloge.getHeures().getValeur();
        double angleheure=(h*((2*Math.PI)/12.0)-(Math.PI/2.0));
        bare( g,Color.black,rayon,angleheure,center.x,center.y, 0.4);
        
	   

        //le cerle 
        g.fillRect(center.x, center.y, 5, 5);
        drawCircleByCenter(g, center.x, center.y, width/4);
         
    }

    void drawCircleByCenter(Graphics g, int x, int y, int radius){
         g.setColor(Color.LIGHT_GRAY);
         g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
     }
     void bare(Graphics g,Color c,int rayon,double angle,int cx,int cy ,double z){
        int xsf=cx+(int)(z*rayon*Math.cos(angle));
	    int ysf=cy+(int)(z*rayon*Math.sin(angle));
	    g.setColor(c);
	    g.drawLine(cx,cy,xsf,ysf);
    }
 
     
}


