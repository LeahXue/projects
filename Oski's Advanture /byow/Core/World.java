package byow.Core;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    public static List<Room> rooms;

    public static Room createRoom(TETile[][] tiles, Random random){
        //initialize
        //make rooms that are at most 6 * 6
        int width = RandomUtils.uniform(random, 2, 8);
        int height = RandomUtils.uniform(random, 2, 3);
        //start at random position in tiles
        int x = RandomUtils.uniform( random, 2, tiles.length - width - 1);
        int y = RandomUtils.uniform(random,2, tiles[0].length - height -1 );
        //set the position of room and create the object
        Position pos = new Position(x, y);
        Room room = new Room(width, height, pos);

        //check to see if this random room overlaps or directly adjacent to the another room
        for (int i = room.getPosition().x; i <= room.getPosition().x + room.width; i++){
            for (int j = room.getPosition().y; j <= room.getPosition().y + room.height; j++){
                if (tiles[i][j].equals(Tileset.FLOOR) ||
                        tiles[i - 1][j].equals(Tileset.FLOOR) ||
                        tiles[i + 1][j].equals(Tileset.FLOOR) ||
                        tiles[i][j + 1].equals(Tileset.FLOOR) ||
                        tiles[i][j - 1].equals(Tileset.FLOOR)){
                    return null;
                }
            }
        }

        //draw room
        for (int i = room.getPosition().x; i < room.getPosition().x + room.width; i++){
            for (int j = room.getPosition().y; j < room.getPosition().y + room.height; j++){
                tiles[i][j] = Tileset.FLOOR;
            }
        }
        return room;
    }

    public static void createMultipleRooms(TETile[][] tiles, Random random){
        rooms = new ArrayList<>();
        //create random # of rooms with random attempts
        int attempts = RandomUtils.uniform(random, 10, 80);
        for (int i = 0; i < attempts; i++){
            Room room = createRoom(tiles, random);
            if (room != null){
                rooms.add(room);
            }
        }
    }

    public static Position centerPos(Room room){
        int x = room.pos.x + room.width/2;
        int y = room.pos.y + room.height/2;
        return new Position(x,y);
    }

    public static void addHorizontal (TETile[][] tiles, Position start, int length, int width, boolean isWall){
        int x = start.x;
        int y = start.y;
        for (int j=0; j < width; j ++){
        for (int i = 0; i < length; i ++){
            if (!isWall){
            tiles[x+i][y-j] = Tileset.FLOOR;
            }else{
                if (tiles[x+i][y-j] == Tileset.NOTHING){
                    tiles[x+i][y-j] = Tileset.WALL;
                }
            }
        }
        }
        /*if (!isWall){
            Position startW = new Position(x,y+1);
            addHorizontal(tiles,startW,length + 1,1,true);
            startW = new Position(x,y-width);
            addHorizontal(tiles,startW,length + 1,1,true);
        }*/
    }

    public static void addVertical (TETile[][] tiles, Position start, int length, int width, boolean isWall){
        int x = start.x;
        int y = start.y;
        for (int j=0; j < width; j ++){
            for (int i = 0; i < length; i ++){
                if (!isWall){
                tiles[x-j][y+i] = Tileset.FLOOR;
                }else{
                    if (tiles[x-j][y+i] == Tileset.NOTHING){
                        tiles[x-j][y+i] = Tileset.WALL;
                    }
                }
            }
        }
        /*if (!isWall){
            Position startW = new Position(x + 1, y);
            addVertical(tiles,startW,length + 1,1, true);
            startW = new Position(x - width, y-1);
            addVertical(tiles,startW,length + 2,1,true);
        }*/
    }
    public static void connectRoomsHelper(TETile[][] tiles, Room room1, Room room2, Random random){
        //int width = RandomUtils.uniform(random,1,3);
        int width = 1;
        Position mid1 = centerPos(room1);
        Position mid2 = centerPos(room2);
        Position start;
        Position end;
        if (mid1.y < mid2.y){
            start = mid1;
            end = mid2;
        }else{
            start = mid2;
            end = mid1;
        }
        int vLen = Math.abs(mid1.y - mid2.y);
        addVertical(tiles,start,vLen, width, false);
        start = new Position(start.x,end.y);
        int hLen = Math.abs(start.x - end.x);
        if (start.x > end.x){
            start = end;
        }
        addHorizontal(tiles,start,hLen,width,false);

        // horizontal hallway
        /*int minx = Math.min(mid1.x,mid2.x);
        int maxx = Math.max(mid1.x,mid2.x);
        int maxy = Math.max(mid1.y,mid2.y);
        int miny = Math.min(mid1.y,mid2.y);
        Position startM = new Position(minx,miny);
        Position startA = new Position (maxx,maxy);
        int hLen = maxx - minx;
        int vLen = maxy - miny;
        addHorizontal(tiles,startM,hLen + 1,width,false);
        addVertical(tiles,startA,vLen + 1,width,false);*/

    }
    //make hallways to connect these rooms
    public static void connectRooms(TETile[][] tiles, Random random){
        //sort rooms based on x position
        /*Queue<Room> unConnected = new LinkedList<Room> ();
        for (Room r : rooms){
            unConnected.add(r);
        }
        while (unConnected.size() > 1){
            Room roomA = unConnected.remove();
            Room roomB = unConnected.remove();
            connectRoomsHelper(tiles, roomA, roomB, random);
            int i = random.nextInt(2);
            if (i == 0){unConnected.add(roomA);}else{unConnected.add(roomB);}
        }*/

        UnionFind uf = new UnionFind(rooms.size());
        for (int i = 0; i < 80; i ++){
            int a = random.nextInt(rooms.size());
            int b = random.nextInt(rooms.size());
            Room roomA = rooms.get(a);
            Room roomB = rooms.get(b);
            if (! uf.connected(a,b)){
                uf.union(a,b);
                connectRoomsHelper(tiles,roomA,roomB,random);
            }
        }

        for (int i = 0; i < rooms.size(); i ++){
            for (int j = 0; j < rooms.size(); j ++){
                if (i != j && !uf.connected(i,j)){
                    uf.union(i,j);
                    connectRoomsHelper(tiles,rooms.get(i),rooms.get(j),random);
                }
            }
        }

    }

    /*
        1. pick a random room to have a door
        2. build walls around the door

     */

    public static void wallHelper(TETile[][] tiles, Room room){
        Position pos = room.pos;
        int x = pos.x;
        int y = pos.y;
        int width = room.width;
        int height = room.height;
        // bottom
        addHorizontal(tiles,new Position(x,y-1),width + 1,1,true);
        // up
        addHorizontal(tiles,new Position(x,y+height),width + 1,1,true);
        //left
        addVertical(tiles, new Position(x - 1,y - 1), height + 2, 1, true);
        // right
        addVertical(tiles, new Position(x + width, y),height + 1 ,1,true);
    }
    // build walls around rooms
    public static void createWalls(TETile[][] tiles){
        for (Room r : rooms){
            wallHelper(tiles, r);
        }
    }

    public static void removeWalls(TETile[][] tiles){
        int width = tiles.length;
        int height = tiles[0].length;
        for (int i = 0; i < tiles.length; i ++){
            for (int j = 0; j < tiles[0].length; j ++){
                int floors = 0;
                if (tiles[i][j].equals(Tileset.WALL)){
                    if (j < height - 1 && tiles[i][j+1].equals(Tileset.FLOOR)){floors ++;}
                    if (j > 0 && tiles[i][j -1].equals(Tileset.FLOOR)){floors ++;}
                    if (i < width -1 && tiles[i + 1][j].equals(Tileset.FLOOR)){floors ++;}
                    if (i > 0 && tiles[i-1][j].equals(Tileset.FLOOR)){floors ++;}
                    if (i > 0 && j > 0 && tiles[i-1][j-1].equals(Tileset.FLOOR)){floors ++;}
                    if (i > 0 && j <height -1 && tiles[i - 1][j + 1].equals(Tileset.FLOOR)){floors ++;}
                    if (i < width -1 && j > 0 && tiles[i + 1][j -1].equals(Tileset.FLOOR)){floors ++;}
                    if (i < width - 1 && j < height -1 && tiles [i + 1][j + 1].equals(Tileset.FLOOR)){floors ++;}
                    if (floors == 0){tiles[i][j] = Tileset.NOTHING;}
                }
            }
        }
    }

    public static void addDoor(TETile[][] tiles, Random random){
        boolean hasDoor = false;
        while(! hasDoor){
            int i = RandomUtils.uniform(random,tiles.length);
            int j = RandomUtils.uniform(random,tiles[0].length);
            if (tiles[i][j].equals(Tileset.WALL)){
                int nothing = 0;
                if (i > 0 && tiles[i-1][j].equals(Tileset.NOTHING)){nothing ++;}
                if (j > 0 && tiles[i][j - 1].equals(Tileset.NOTHING)){nothing ++;}
                if (i < tiles.length - 1 && tiles[i+1][j].equals(Tileset.NOTHING)){nothing ++;}
                if (j < tiles[0].length -1 && tiles[i][j + 1].equals(Tileset.NOTHING)){nothing ++;}
                if (nothing != 0){
                    tiles[i][j] = Tileset.LOCKED_DOOR;
                    hasDoor = true;
                }
            }
        }
    }

    public static void addProjDoor(TETile[][] tiles, Random random){

    }


    public static TETile[][] createWorld(TETile[][] tiles, Random random){
        createMultipleRooms(tiles, random);
        //connectRoomsHelper(tiles,rooms.get(0),rooms.get(1),random);
        connectRooms(tiles,random);
        //createWalls(tiles);
        removeWalls(tiles);
        addDoor(tiles,random);
        //addAvatar(tiles,random);
        return tiles;
    }

   /*public static void main(String[] args){
        TERenderer ter = new TERenderer();
        int WIDTH = 80;
        int HEIGHT = 30;
        ter.initialize(WIDTH,HEIGHT);
        TETile[][] tiles = new TETile[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i ++){
            for (int j = 0; j < HEIGHT; j ++){
                tiles[i][j] = Tileset.WALL;
            }
        }
        Random random = new Random(15331);
        createWorld(random);
        ter.renderFrame(tiles);
    }*/


}
