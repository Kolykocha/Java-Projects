import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Arrays;
import java.awt.Graphics;
public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 100;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int appleEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;


    GamePanel(){

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        random = new Random();
        startGame();
    }
    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

        public void paintComponent(Graphics graphics){
            super.paintComponent(graphics);
            draw(graphics);
        }
        public void draw(Graphics graphics){

            if(running) {

                for (int i = 0; i < (SCREEN_HEIGHT / UNIT_SIZE); i++) {
                    graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                    graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
                }
                graphics.setColor(Color.RED);
                graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        graphics.setColor(Color.green);
                        graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                    else {
                        graphics.setColor(new Color(15, 73, 62));
                        graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
                graphics.setColor(Color.RED);
                graphics.setFont(new Font("Ink Free",Font.BOLD,35));
                FontMetrics metrics = getFontMetrics(graphics.getFont());
                graphics.drawString("SCORE"+appleEaten, (SCREEN_WIDTH-metrics.stringWidth("SCORE"))/2, graphics.getFont().getSize());
            }else{
                gameOver(graphics);
            }
        }
        public void newApple(){
            appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
            appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
            System.out.println(appleX+"x"+appleY+"y");

        }
        public void move(){
            for (int i = bodyParts;i>0;i--){
                x[i] = x[i-1];
                y[i]= y[i-1];
            }
            switch (direction){
                case 'U':
                    y[0]=y[0]-UNIT_SIZE;
                    break;
                case 'D':
                    y[0]=y[0]+UNIT_SIZE;
                    break;
                case'L':
                   x[0]=x[0]-UNIT_SIZE;
                    break;
                case 'R':
                   x[0]=x[0]+UNIT_SIZE;
                    break;
            }
        }

        public void checkApple(){
            if((x[0] == appleX) && (y[0]== appleY)){
                bodyParts++;
                appleEaten++;
                newApple();
            }
        }

        public void checkCollisions(){
            for (int i = bodyParts;i>0;i--){
                    if ((x[0] == x[i]) && (y[0] == y[i])) {
                        running = false;
                    }
           }
           if(x[0]<0){
               running = false;
           }
           if(y[0]<0){
               running = false;
           }
           if(x[0]>SCREEN_WIDTH){
               running = false;
           }
           if(y[0]>SCREEN_HEIGHT){
               running = false;
           }
           if(running == false){
               timer.stop();
           }
        }

        public void gameOver(Graphics graphics){

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free",Font.BOLD,75));
            FontMetrics metrics2 = getFontMetrics(graphics.getFont());
            graphics.drawString("SCORE"+appleEaten, (SCREEN_WIDTH-metrics2.stringWidth("SCORE"))/2, graphics.getFont().getSize());

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free",Font.BOLD,75));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("GAME OVER", (SCREEN_WIDTH-metrics.stringWidth("GAME OVER"))/2, SCREEN_HEIGHT/2);

        }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(running){
                move();
                checkApple();
                checkCollisions();
            }
            repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case  KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case  KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
