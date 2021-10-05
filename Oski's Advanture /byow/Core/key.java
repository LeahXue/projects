package byow.Core;

public class key {
    public Position pos;
    public boolean truth;

    public key (Position pos,boolean truth){
        this.pos = pos;
        this.truth = truth;
    }

    public int getX(){
        return this.pos.x;
    }

    public int getY(){
        return this.pos.y;
    }

    public boolean getTruth(){
        return this.truth;
    }
}
