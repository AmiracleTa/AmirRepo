import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel implements KeyListener {
    
    boolean left, right, up, dn;
    Snake snake;
    Item item;
    Timer timer;
    int dt = 300;
    boolean over;
    Image GAMEOVER;
    
    public static void main(String[] args) {
        // 初始化窗口
        JFrame window = new JFrame("Snake Game");
        Game game = new Game(); // JPanel 内容面板
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);

        window.add(game);
        window.pack();
        
    }

    public Game() {

        setPreferredSize(new Dimension(CONST.COL * CONST.BLOCK_SZ, CONST.ROW * CONST.BLOCK_SZ));
        setBackground(new Color(226,224,250));
        setFocusable(true);
        addKeyListener(this);
    
        // 初始化图像
        GAMEOVER = new ImageIcon(getClass().getResource("/img/gameover.png")).getImage();
        
        snake = new Snake();
        item = new Item();
        left = right = up = dn = false;
        
        // 主循环逻辑
        timer = new Timer(this.dt, upd -> {

            if(!snake.dead){
                if(checkEat()){
                    snake.grow = true;
                    item.create();
                    this.dt = Math.max(150, dt-7);
                    timer.setDelay(Math.min(timer.getDelay(), this.dt));
                }
                if(checkDeath()){
                    snake.dead = true;
                    timer.setDelay(130);
                    up = dn = left = right = false;
                    try{
                        Thread.sleep(1300);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                if(up) snake.up();
                if(dn) snake.dn();
                if(left) snake.left();
                if(right) snake.right();
            }

            // 彻底消失，GameOver !
            if(snake.body.isEmpty()) over = true;
            
            repaint(); // 自动调用 paintComponent

        });
        timer.start();

    }

    // 检查是否吃到
    boolean checkEat(){
        if(snake.head.x == item.x && snake.head.y == item.y) return true;
        return false;
    }
    boolean checkDeath(){
        // 检查越界
        Point pos = snake.head.getPos();
        if(pos.x < 0 || pos.x >= CONST.COL*CONST.BLOCK_SZ || pos.y < 0 || pos.y >= CONST.ROW*CONST.BLOCK_SZ){
            return true;
        }

        // 检查自身相撞
        boolean fir = true;
        for(Block block : snake.body){
            if(fir){
                fir = false;
                continue;
            }
            if(block.getPos().equals(snake.head.getPos())) return true; // ??? 不能 == 
        }
        return false;
    }
    
    @Override
    public void paintComponent(Graphics gra) {
        super.paintComponent(gra);
        if(!over){
            item.draw(gra);
            snake.draw(gra);
        }
        // DISPLAY GAMEOVER IMAGE
        else{
            int W = this.getWidth(), H = this.getHeight();
            int imgW = GAMEOVER.getWidth(null);
            int imgH = GAMEOVER.getHeight(null);

            // 等比缩放
            double scale = Math.min(1.0*W/imgW, 1.0*H/imgH);
            imgW = (int)(imgW * scale);
            imgH = (int)(imgH * scale);

            // 居中显示
            int x = (W - imgW) / 2;
            int y = (H - imgH) / 2;
            gra.drawImage(GAMEOVER, x, y, imgW, imgH, this);
        }
    }

    // 键盘监听
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP && !this.dn) { this.up = true; this.dn = this.left = this.right = false; }
        if(key == KeyEvent.VK_DOWN && !this.up) { this.dn = true; this.up = this.left = this.right = false; }
        if(key == KeyEvent.VK_LEFT && !this.right) { this.left = true; this.up = this.dn = this.right = false; }
        if(key == KeyEvent.VK_RIGHT && !this.left) { this.right = true; this.up = this.dn = this.left = false; }
        if(key == KeyEvent.VK_SHIFT) timer.setDelay(100);
        
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_SHIFT) timer.setDelay(dt);

        // int key = e.getKeyCode();
        // if(key == KeyEvent.VK_UP) this.up = false;
        // if(key == KeyEvent.VK_DOWN) this.dn = false;
        // if(key == KeyEvent.VK_LEFT) this.left = false;
        // if(key == KeyEvent.VK_RIGHT) this.right = false;
    }
    @Override public void keyTyped(KeyEvent e) {}

}
