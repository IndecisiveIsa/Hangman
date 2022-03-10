import acm.program.GraphicsProgram;
import acm.graphics.GLabel;
import acm.graphics.GObject;

import svu.csc213.Dialog;


public class Hangman extends GraphicsProgram{
    private Stickman stickman;
    private Spaces spaces;

    @Override
    public void init(){
        int wins = 0;
        int losses = 0;
        GLabel winLabel = new GLabel("wins = 0");
        add(winLabel,25,25);
        GLabel lossLabel = new GLabel("losses = 0");
        add(lossLabel,25,50);
        GLabel wrongGuesses = new GLabel("Wrong Guesses:");
        add(lossLabel,25,50);
        while (true) {
            stickman = new Stickman(this.getGCanvas());
            add(stickman);

            spaces = new Spaces(this.getGCanvas());
            add(spaces);

            if (gameHappen()) {
                wins++;
                winLabel.setLabel("wins = " + wins);
            } else {
                losses++;
                lossLabel.setLabel("losses = " + losses);
            }
        }
    }

    public boolean gameHappen() {
        int remaining = spaces.word.length();
        while (true) {
            if (stickman.lives==0){
                Dialog.showMessage("You got the word wrong!");
                Dialog.showMessage("Play again!");
                remove(stickman);
                remove(spaces);
                return false;
            }
            if (remaining == 0) {
                Dialog.showMessage("You got the word right!");
                Dialog.showMessage("Play again!");
                remove(stickman);
                remove(spaces);
                return true;
            }
            else {
                remaining = guess(remaining);
                System.out.println(remaining);
            }
        }
    }


    public int guess(int rem){
            String guess = Dialog.getString("Input guess!");
            Boolean guR = false;
            if (guess.length() == 1) {
                for (int i = 0; i < spaces.word.length(); i++) {
                    if (guess.charAt(0) == Character.toLowerCase(spaces.word.charAt(i))) {
                        if (spaces.gLabels[i].isVisible()){
                            Dialog.showMessage("You already guessed this!");
                        }else {
                            spaces.gLabels[i].setVisible(true);
                            rem--;
                            guR = true;
                        }
                    }
                }
                if (guR == true) {
                    Dialog.showMessage("You got this letter right!");
                } else {
                    Dialog.showMessage("This letter is not right.");
                    stickman.mistake();
                }

            }else {
                if (guess.equals(spaces.word)){
                    rem=0;
                    for (int i = 0; i < spaces.word.length(); i++) {
                        spaces.gLabels[i].setVisible(true);
                    }
                } else {
                    Dialog.showMessage("This word is not right.");
                    stickman.mistake();
                }
            }
            return rem;
    }

    public void wrong(){

    }



    public static void main(String[] args) {
    new Hangman().start();
    }


}
