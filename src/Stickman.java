import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.graphics.GLine;


public class Stickman extends GCompound{

    public Stickman(){

        GRect torso = new GRect(1,50);
        add(getWidth()/2,1);

        GLine line = new GLine(1,100,300,200);
        add(line);

    }
}
