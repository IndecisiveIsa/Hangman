import acm.graphics.*;


public class Stickman extends GCompound{

    //make body parts (public)
    public GRect torso;
    public GLine rArm;
    public GLine lArm;
    public GLine rLeg;
    public GLine lLeg;
    public GOval head;

    private GCanvas screen;
    public int lives=6;

    public Stickman(GCanvas screen){
        this.screen = screen;

        makeStickman();


    }

    private void makeStickman(){
        //Make torso, build off torso
        torso = new GRect(0,100);
        add(torso, screen.getWidth()/2-torso.getWidth()/2,screen.getHeight()/2-torso.getHeight());

        //Make right arm

        rArm = new GLine(torso.getX()+torso.getWidth(),torso.getY()+torso.getHeight()/4, //starting position
                torso.getX()+torso.getWidth()+torso.getHeight()-torso.getHeight()/3,torso.getY()+torso.getHeight()-torso.getHeight()/5); //end position
        add(rArm);

        //Make left arm
        lArm = new GLine(torso.getX(),torso.getY()+torso.getHeight()/4, //starting position
                torso.getX()-torso.getHeight()+torso.getHeight()/3,torso.getY()+torso.getHeight()-torso.getHeight()/5); //end position
        add(lArm);

        //Make right leg
        rLeg = new GLine(torso.getX()+torso.getWidth(),torso.getY()+torso.getHeight(), //starting position
                torso.getX()+torso.getWidth()+torso.getHeight()/2,torso.getY()+torso.getHeight()+torso.getHeight()-torso.getHeight()/4); //end position
        add(rLeg);

        //Make left leg
        lLeg = new GLine(torso.getX(),torso.getY()+torso.getHeight(), //starting position
                torso.getX()-torso.getHeight()/2,torso.getY()+torso.getHeight()+torso.getHeight()-torso.getHeight()/4); //end position
        add(lLeg);

        double headSize = torso.getHeight()/2;

        //Make Head
        head = new GOval(headSize,headSize);
        add(head,torso.getX()+torso.getWidth()/2-headSize/2,torso.getY()-headSize);

    }

    public void mistake(){

    switch (lives){
        case 6:
            remove(lLeg);
            break;
        case 5:
            remove(rLeg);
            break;
        case 4:
            remove(lArm);
            break;
        case 3:
            remove(rArm);
            break;
        case 2:
            remove(torso);
            break;
        case 1:
            remove(head);
            //todo: Make it able to loose, and do it here
            break;
    }
    lives--;

    }



}
