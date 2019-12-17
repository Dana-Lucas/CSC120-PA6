/*
 * CSC 120 PA6
 * Dana Lucas
 * 11/08/19
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucasdm2022
 */
public class Obstacle {
    private Integer anchorX, anchorY;
    private Color color;
    private Boolean isNotCaught;
    private Integer randomSpeed;

    public Obstacle(Integer x, Integer y, Color c, Boolean inc, Integer speed){
        anchorX = x;
        anchorY = y;
        color = c;
        isNotCaught = inc;
        randomSpeed = speed;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(anchorX, anchorY, 20,16);
        g.setColor(color.BLACK);
        g.drawArc(anchorX-10,anchorY-15, 20, 35, 0, 30);
//        random = new Random(seed);
//        randomSpeed = random.nextInt(15)+1;
//        seed += 20;
//        g.setColor(Color.BLACK);
//        g.drawRect(anchorX, anchorY, 20,16);
    }
    
    public void moveApples(){
//        random = new Random(seed);
//        randomSpeed = random.nextInt(15) + 1;
        anchorY += randomSpeed;
    }
  
    public Integer getLeftEdge(){
        return anchorX;
    }
    
    public Integer getRightEdge(){
        return anchorX+20;
    }

    public Integer getTopEdge(){
        return anchorY;
    }

    public Integer getBottomEdge(){
        return anchorY+16;
    }

    public Boolean getIsNotCaught(){
        return isNotCaught;
    }

    public void setIsNotCaught(Boolean inc){
        isNotCaught = inc;
    }

    public void setAnchorY(Integer y){
        anchorY = y;
    }
    
    public void setAnchorX(Integer x){
        anchorX = x;
    }

    public void setRandomSpeed(Integer s){
        randomSpeed = s;
    }

} // end of class Obstacle
