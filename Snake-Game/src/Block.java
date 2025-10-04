import java.awt.Point;

/*
  左上 (0, 0)
  
  向右 dx +
  向下 dy +

*/

public class Block{
    int x, y;

    // 无传参即默认
    Block(){
        this(0, 0);
    }
    Block(int x, int y){
        this.x = x;
        this.y = y;
    }
    Block(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    // 得到此方块上方位置
    Point upPos(){
        Point p = new Point(this.x, this.y - CONST.BLOCK_SZ);
        return p;
    }
    Point dnPos(){
        Point p = new Point(this.x, this.y + CONST.BLOCK_SZ);
        return p;
    }
    Point leftPos(){
        Point p = new Point(this.x - CONST.BLOCK_SZ, this.y);
        return p;
    }
    Point rightPos(){
        Point p = new Point(this.x + CONST.BLOCK_SZ, this.y);
        return p;
    }
    Point getPos(){
        Point p = new Point(this.x, this.y);
        return p;
    }

}
