package byow.Core;

import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

import java.util.LinkedList;

class Enemy extends Avatar{

    public int speed;

    public Enemy(Position pos, TETile tile, TETile[][] world, int speed) {
        super(pos, tile, world);
        this.speed = speed;
    }

    public void setPos(Position pos){
        this.pos = pos;
    }
    // inability to deal with the case when Xs are equal, Ys are different, but cannot go vertical beacuse of the wall;
    public LinkedList<Position> generatePath(Avatar main, boolean vertical, TETile[][] world){
        int curX = this.pos.x;
        int curY = this.pos.y;
        int targetX = main.pos.x;
        int targetY = main.pos.y;
        if (this.pos.equals(main.pos)){
            return new LinkedList();
        }
        if (vertical){
        if (curY < targetY){
            Position att = new Position(curX,curY + 1);
            if (world[curX][curY+1].equals(Tileset.FLOOR)){
                Enemy temp = new Enemy(att,tile,world,speed);
                LinkedList<Position> result = temp.generatePath(main,true,world);
                result.add(att);
                return result;
            }
            else{
                return generatePath(main,false,world);
            }
        }
        if (curY > targetY){
            Position att = new Position(curX,curY - 1);
            if (world[curX][curY - 1].equals(Tileset.FLOOR)){
                Enemy temp = new Enemy(att,tile,world,speed);
                LinkedList<Position> result = temp.generatePath(main,true,world);
                result.add(att);
                return result;
            }else{
                return generatePath(main,false,world);
            }
        }else{
            return generatePath(main,false,world);
        }/**else{
            if (curX > targetX){
                int temp = curY;
                while (!world[temp][curX - 1].equals(Tileset.FLOOR)){

                }
            }
        }**/}
        if (! vertical){
        if (curX < targetX){
            Position att = new Position(curX + 1,curY);
            if (world[curX + 1][curY].equals(Tileset.FLOOR)){
                Enemy temp = new Enemy(att,tile,world,speed);
                LinkedList<Position> result = temp.generatePath(main,false,world);
                result.add(att);
                return result;
            }
            else{
                return generatePath(main,true,world);
            }
        }
        if (curX > targetX){
            Position att = new Position(curX - 1,curY);
            if (world[curX - 1][curY].equals(Tileset.FLOOR)){
                Enemy temp = new Enemy(att,tile,world,speed);
                LinkedList<Position> result = temp.generatePath(main,false,world);
                result.add(att);
                return result;
            }else{
                return generatePath(main,true,world);
            }
        }else{
            generatePath(main,true,world);
        }}
        return new LinkedList();
    }

    public static void chaseAvatar(){

    }

}
