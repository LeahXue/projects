package byow.Core;

public class Room {
    public int width;
    public int height;
    public Position pos;

    public Room(int width, int length, Position pos){
        this.width = width;
        this.height = length;
        this.pos = pos;
    }

    public int getWidth(){
        return this.width;
    }

    public int getLength(){
        return this.height;
    }

    public Position getPosition(){
        return pos;
    }
}
