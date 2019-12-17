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
public class Background {
    private Integer anchorX, anchorY;
    public Background(Integer x, Integer y){
        anchorX = x;
        anchorY = y;
    }

    public void draw(Graphics g){
        g.setColor(new Color(204,255,255));
        g.fillRect(0,0,800,600);
        g.setColor(new Color(204,255,204));
        g.fillRect(0,475,800,50);
        g.setColor(new Color(153,102,51));
        g.fillRect(275,0,100,600);
        g.setColor(Color.GREEN.darker());
        g.fillArc(anchorX-150, anchorY-225,1000,450,180,180);
    }

} // end of class Background
