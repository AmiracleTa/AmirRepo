import java.util.*;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

/*
  向右为 x 轴且正
  向下为 y 轴且正

*/

public class Item {
    List<Point> list = new ArrayList<>();
    Random rand = new Random();
    int sz = CONST.BLOCK_SZ;
    int x, y;

    Item(){

        for(int i=0; i<CONST.COL; i++){
            for(int j=0; j<CONST.ROW; j++){
                if(i == 0 && j == 0) continue;
                list.add(new Point(i*sz, j*sz));
            }
        }   
        
        create();

    }

    void create(){

        int idx = rand.nextInt(list.size());
        Collections.swap(list, idx, list.size()-1);
        
        Point pt = list.remove(list.size()-1);
        this.x = pt.x;
        this.y = pt.y;

    }

    void draw(Graphics gra){

        gra.setColor(new Color(130, 230, 130));
        gra.fillOval(this.x, this.y, sz, sz);

    }

    Point getPos(){
        Point p = new Point(this.x, this.y);
        return p;
    }

}
