import acm.program.GraphicsProgram;
import acm.graphics.GLabel;
import acm.graphics.GObject;

import svu.csc213.Dialog;


public class Hangman extends GraphicsProgram{

    private Stickman stickman;

    @Override
    public void init(){

        stickman = new Stickman();
        add(stickman);


    }


    public static void main(String[] args) {
    new Hangman().start();
    }

}
