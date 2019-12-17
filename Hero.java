/*
 * CSC 120 PA6
 * Dana Lucas
 * 11/08/19
 */
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucasdm2022
 */
public class Hero {
    
    private Integer anchorX, anchorY;

    public Hero(Integer x, Integer y){
        anchorX = x;
        anchorY = y;
        }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(anchorX, anchorY, 30,30);
        g.drawLine(anchorX+15,anchorY+30,anchorX+15,anchorY+40);
        g.drawLine(anchorX+15,anchorY+80,anchorX+15,anchorY+90);
        g.drawLine(anchorX+15,anchorY+90,anchorX,anchorY+110);
        g.drawLine(anchorX+15,anchorY+90,anchorX+30,anchorY+110);
        g.setColor(Color.ORANGE.darker()); // here down is the basket stuff
        g.drawArc(anchorX-10,anchorY+15,70,65,180,180);
        g.drawArc(anchorX-10,anchorY+40,70,15,180,180);
        g.drawArc(anchorX-10,anchorY+40,70,15,0,180);
    }
    
    public void setAnchorX(Integer x){
        anchorX = x;
    } // end of setAnchorX
    
    public void setAnchorY(Integer y){
        anchorY = y;
    } // end of setAnchorY
    
    public void moveObjectLeft(){
        if(anchorX > 0){
            anchorX -= 50;
        }
        else{
            anchorX = 640;
        }
    } // end of moveObjectLeft
    
    public void moveObjectRight(){
        if(anchorX < 640){
            anchorX += 50;
        }
        else{
            anchorX = 0;
        }
    } // end of moveObjectRight

    public Boolean isTouchingObstacle(Obstacle obst){
            Boolean answer;
            if(obst.getRightEdge() < anchorX-10 || obst.getLeftEdge() > anchorX+60 
                || obst.getTopEdge() > anchorY+47 || obst.getBottomEdge() < anchorY+47){
                answer = false;
            }
            else{
                answer = true;
            }
            return answer;
    } // Collision Detection

    public Integer getAnchorX(){
        return anchorX;
    } // end of getAnchorX

} // end of class Hero
