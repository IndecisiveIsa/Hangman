import acm.program.GraphicsProgram;
import acm.graphics.GLabel;
import acm.graphics.GObject;

import svu.csc213.Dialog;


public class Hangman extends GraphicsProgram{

    private Stickman stickman;
    private Spaces spaces;

    @Override
    public void init(){

        stickman = new Stickman(this.getGCanvas());
        add(stickman);

        spaces = new Spaces(this.getGCanvas());
        add(spaces);

        gameHappen();


    }

    public void gameHappen(){

        while (true) {
            guess();
        }
    }

    public void guess(){
        String guess = Dialog.getString("Input guess!");
        Boolean guR=false;
        if (guess.length()==1){
            for (int i = 0; i < spaces.word.length(); i++) {
                if(guess.charAt(0)==spaces.word.charAt(i)){
                spaces.gLabels[i].setVisible(true);
                guR=true;
                }
            }
            if (guR==true){
                Dialog.showMessage("You got this letter right!");
            }else {
                Dialog.showMessage("This letter is not right.");
                stickman.mistake();
            }
        }
    }




    public static void main(String[] args) {
    new Hangman().start();
    }


}
