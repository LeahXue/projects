package byow.Core;
import byow.TileEngine.*;

public class Avatar {
    public Position pos;
    public TETile tile;
    public int score;
    public TETile[][] world;

    public Avatar(Position pos, TETile tile, TETile[][] world){
        this.pos = pos;
        this.tile = tile;
        this.world = world;
        this.score = 0;
    }

    public int getX(){
        return pos.x;
    }

    public int getY(){
        return pos.y;
    }

    public void setX(int x){
        this.pos = new Position(x, getY());
    }

    public void setY(int y){
        this.pos = new Position(getX(), y);
    }

    public Position getPos(){
        return pos;
    }

    public TETile getTile(){
        return tile;
    }

    public void moveUp(){
        int curY = getY() + 1;
        if (world[0].length == curY){
            return;
        }
        if (world[getX()][curY].equals(Tileset.WALL) || world[getX()][curY].equals(Tileset.LOCKED_DOOR) || world[getX()][curY].equals(Tileset.Stanford)){
            return;
        }
        this.setY(getY() + 1);
    }

    public void moveDown(){
        int curY = getY() - 1;
        if (curY == -1){
            return;
        }
        if (world[getX()][curY].equals(Tileset.WALL) || world[getX()][curY].equals(Tileset.LOCKED_DOOR) || world[getX()][curY].equals(Tileset.Stanford)){
            return;
        }
        this.setY(curY);
    }

    public void moveLeft(){
        int curX = getX() - 1;
        if (curX == -1){return;}
        if (world[curX][getY()].equals(Tileset.WALL) || world[curX][getY()].equals(Tileset.LOCKED_DOOR) || world[curX][getY()].equals(Tileset.Stanford)){
            return;
        }
        this.setX(curX);
    }

    public void moveRight(){
        int curX = getX() + 1;
        if (curX == world.length){return;}
        if (world[curX][getY()].equals(Tileset.WALL) || world[curX][getY()].equals(Tileset.LOCKED_DOOR) || world[curX][getY()].equals(Tileset.Stanford)){
            return;
        }
        this.setX(curX);
    }

    public void addScore(int num){
        this.score += num;
    }

    public void minusScore(int num){
        this.score -= num;
    }
}
