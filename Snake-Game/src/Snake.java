import java.util.ArrayDeque;
import java.util.Deque;
import java.awt.*;

/*
  Snake 类
  控制 up dn left right
  死亡逻辑
  增长逻辑

 */

public class Snake{
    boolean up, dn, left, right;
    Deque<Block> body = new ArrayDeque<>();
    boolean grow, dead;
    Block head;
    int sz = CONST.BLOCK_SZ, alpha = 255;

    Snake(){
        head = new Block();
        body.addFirst(head);
    }

    void draw(Graphics gra){

        if(!dead){
            for(Block block : body){
                // gra.setColor(Color.BLUE);
                gra.setColor(new Color(111,220,255));
                gra.fillRect(block.x, block.y, sz, sz);
            }
            
            gra.setColor(new Color(100, 130, 255));
            gra.fillRect(head.x, head.y, sz, sz);
        }
        else{
            body.removeFirst();
            alpha = Math.max(50, alpha-10);
            for(Block block : body){
                gra.setColor(new Color(111,220,255, alpha));
                gra.fillRect(block.x, block.y, sz, sz);
            }
        }

    }

    void up(){
        head = new Block(head.upPos());
        body.addFirst(head);
        if(!grow) body.removeLast();
        grow = false;
    }
    void dn(){
        head = new Block(head.dnPos());
        body.addFirst(head);
        if(!grow) body.removeLast();
        grow = false;
    }
    void left(){
        head = new Block(head.leftPos());
        body.addFirst(head);
        if(!grow) body.removeLast();
        grow = false;
    }
    void right(){
        head = new Block(head.rightPos());
        body.addFirst(head);
        if(!grow) body.removeLast();
        grow = false;
    }

}
