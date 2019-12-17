/* CSC 120 PA6
 * Dana Lucas
 * 11/08/19
 *
 * Project Description: This program draws a scene of an apple tree with a figure of
 *                      Isaac Newton holding a basket. As the buttons are clicked, the
 *                      apples move down the screen and the task is to capture them in
 *                      the basket. If more than 3 apples reach the ground, then the game
 *                      is over.
 *
 * Aknowledgements:
 *
 */
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class MUPanel extends JPanel {

    // 1. Declare private objects here:
    private Background treeBackground;
    private Hero isaacNewton;
    private Obstacle[] apples;
    private Random randomX, randomY, randPCT, randomSpeed;
    private Integer applesCaught, applesDropped, randomSpeedInt, endAnchorX;
    private Integer seed;

    // constructor method
    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setUp();
        setBackground(Color.WHITE);

        seed = 1;

        // 2. Instantiate objects here by calling "new":
        treeBackground = new Background(0,0);
        isaacNewton = new Hero(300,375);
        apples = new Obstacle[12];
        randomX = new Random();
        randomY = new Random();
        randPCT = new Random();

        applesCaught = 0;
        applesDropped = 0;
        
        for(int i = 0; i < apples.length; i++){
            Integer x = randomX.nextInt(650);
            Integer y = randomY.nextInt(175);
            randomSpeed = new Random(seed);
            Integer randomSpeedInt = randomSpeed.nextInt(15)+3;
            seed++;
            Color appleColor;
            Double pct = randPCT.nextDouble();
            if(pct <= 0.6){
                appleColor = Color.RED;
            }
            else if(pct > 0.7){
                appleColor = new Color(153,255,102);
            }
            else{
                appleColor = new Color(255,255,53);
            }

            apples[i] = new Obstacle(x,y,appleColor, true, randomSpeedInt);  
        } // decide apple color
        
    } // end of constructor
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This line must be first in this method!

        // 3. Call methods of objects here:
        treeBackground.draw(g);
        isaacNewton.draw(g);
        
        for(int i = 0; i < apples.length; i++){
          if(apples[i].getIsNotCaught() == true){
                apples[i].draw(g);
            }  

        }
        for(int i = 0; i < apples.length; i++){
            if(isaacNewton.isTouchingObstacle(apples[i])){
                apples[i].setIsNotCaught(false);
                applesCaught++;
                apples[i].setAnchorY(435);
                apples[i].setAnchorX(isaacNewton.getAnchorX() + 20);
                apples[i].setRandomSpeed(0);
            }
        }
	
        for(int i = 0; i < apples.length; i++){
            if(apples[i].getBottomEdge() >= 511){
                applesDropped++;
                apples[i].setAnchorY(490);
                apples[i].setRandomSpeed(0);
                }
            }    

        if(applesDropped > 3){
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0,100,800,300);
            g.setColor(Color.MAGENTA.darker());
            g.setFont(new Font("Serif", Font.PLAIN, 25));
            g.drawString("Game Over - You dropped more than 3 apples!!!", 100, 250);
        } // end of game over screen

        if((applesCaught + applesDropped == apples.length)){
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0,100,800,300);
            g.setColor(Color.MAGENTA.darker());
            g.setFont(new Font("Serif", Font.PLAIN, 35));
            g.drawString("You have won!!!", 250,250);
        } // end of win screen

    } // end of paintComponent()
    
    public void moveLeft(){
        isaacNewton.moveObjectLeft();
        for(int i = 0; i < apples.length; i++){
            apples[i].moveApples();
        }
    } // end of moveLeft
    
    public void moveRight(){
        isaacNewton.moveObjectRight();
        for(int i = 0; i < apples.length; i++){
            apples[i].moveApples();
        }
    } // end of moveRight
		
    public Integer getApplesCaught(){
        return applesCaught;
    } // end of getApplesCaught
    
    public Integer getApplesDropped(){
        return applesDropped;
    } // end of getApplesDropped
       
    
    
    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void setUp() {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(false);    
    }

    public static void main(String args[]){new MUPanel();}

} // end of class MUPanel
