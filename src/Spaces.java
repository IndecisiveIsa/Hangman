import acm.graphics.GCanvas;
import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;


import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Spaces extends GCompound{

    public Spaces(GCanvas screen){
        for (int i = 0; i < letters.length; i++) {
            double size = screen.getWidth()/(letters.length*1.5+(letters.length/2));

            add(new GRect(size,1),size*1.5*(i+1),screen.getHeight()-screen.getHeight()/4);


            gLabels[i] = new GLabel(String.valueOf(word.charAt(i)));
            add(gLabels[i],size*1.5*(i+1)+(size/2),screen.getHeight()-screen.getHeight()/4-gLabels[i].getHeight());
            gLabels[i].setVisible(false);

        }
    }


    public Random randy = new Random();

    public char[] letters;
    public String word = wordList();
    GLabel[] gLabels = new GLabel[letters.length];

    public String wordList(){

        List<String> words = Arrays.asList("play","that","funky","music","white","boy");

        int let=0;
        boolean play = true;
        String s = words.get(randy.nextInt(3));

        letters = s.toCharArray();

        return s;
    }

}
