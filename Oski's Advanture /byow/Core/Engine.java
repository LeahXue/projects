package byow.Core;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Engine {
    /* Feel free to change the width and height. */
    public static TERenderer ter;
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;
    private final boolean DEBUG = false;
    private static TETile[][] finalWorldFrame;
    private static Avatar main;
    private static String record;
    public static int score;
    private static Enemy midterm1;
    public static Random random;
    public static Avatar submain;
    public static int remaining;
    public static boolean badKey = false;
    public static boolean goodKey = false;
    public static int numQuestions = 5;
    public key goodkey;
    public key badkey;
    public static ArrayList<Integer> visitedQuestion = new ArrayList<>();
    public static boolean saved = false;
    public static boolean tried = false;
    public static Position tree = null;
    public static boolean active = true;
    public static TERenderer terr;
    public static TETile[][] subworld;

    /**
     * Method used for exploring a fresh world. This method should handle all inputs,
     * including inputs from the main menu.
     * phase 2!!!
     */

    public Engine(){
        main = null;
        finalWorldFrame = null;
        record = "";
        int WIDTH = 80;
        int HEIGHT = 30;
        score = 0;
    }


    public void save(String record) throws IOException {
        File f = new File("./save.txt");
        if (! f.exists()){
            f.createNewFile();
        }
        Utils.writeContents(f,record);
    }

    public void load() throws IOException {
        File f = new File("./save.txt");
        if (!f.exists()){
            System.exit(0);
        }
        String saved = Utils.readContentsAsString(f);
        System.out.println(saved);
        if (saved == ""){
            System.exit(0);
        }else{
            System.out.println(saved);
            startNewGame(saved.substring(0,saved.length()));
            record += saved.substring(0,saved.length()-1);
        }

    }

    public void action (Character cur, TETile[][] finalWorldFrame, Avatar main) throws IOException {
        if (cur.equals('W') || cur.equals('w')){
            finalWorldFrame[main.getX()][main.getY()] = Tileset.FLOOR;
            main.moveUp();
            finalWorldFrame[main.getX()][main.getY()] = Tileset.AVATAR;
            //finalWorldFrame[20][29] = Tileset.FLOWER;
            ter.renderFrame(finalWorldFrame);
        }else if (cur.equals('A') || cur.equals('a')){
            finalWorldFrame[main.getX()][main.getY()] = Tileset.FLOOR;
            main.moveLeft();
            finalWorldFrame[main.getX()][main.getY()] = Tileset.AVATAR;
            ter.renderFrame(finalWorldFrame);
        }else if (cur.equals('S') || cur.equals('s')){
            finalWorldFrame[main.getX()][main.getY()] = Tileset.FLOOR;
            main.moveDown();
            finalWorldFrame[main.getX()][main.getY()] = Tileset.AVATAR;
            ter.renderFrame(finalWorldFrame);
        } else if (cur.equals('D') || cur.equals('d')){
            finalWorldFrame[main.getX()][main.getY()] = Tileset.FLOOR;
            main.moveRight();
            finalWorldFrame[main.getX()][main.getY()] = Tileset.AVATAR;
            ter.renderFrame(finalWorldFrame);
        } else if (cur.equals(':')){
            while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character curr = StdDraw.nextKeyTyped();
                if (curr.equals('Q') || curr.equals('q')){
                save(record);
                System.exit(0);}
            }}
        } else if ((cur.equals('L')) || (cur.equals('l'))){
            File f = new File("./save.txt");
            if (!f.exists()){
                System.exit(0);
            }
            String saved = Utils.readContentsAsString(f);
            if (saved == ""){
                System.exit(0);
            }else{
                load();
                record += saved;
            }
        }}


    public void menu(){
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(WIDTH * 8 , HEIGHT * 8, "Oski’s chilling adventure in CS61BL");
        StdDraw.text(WIDTH * 8, HEIGHT * 5, "NEW GAME (N)");
        StdDraw.text(WIDTH * 8, HEIGHT * 4, "LOAD GAME (L)");
        StdDraw.text(WIDTH * 8, HEIGHT * 3, "QUIT (Q)");
        StdDraw.text(WIDTH * 8, HEIGHT * 2, "BACKGROUND (B)");
        StdDraw.show();
    }

    public void newGame(String seed){
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(WIDTH * 8 , HEIGHT * 8, "Please enter your adventure SEED !");
        StdDraw.text(WIDTH * 8, HEIGHT * 5, "seed  " + seed);
        StdDraw.show();
    }


    public void BackgroundStory(){
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(WIDTH * 8 , HEIGHT * 8, "This is where story begins: press C to continue.");
        StdDraw.show();
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "Your name is Oski Bear. And you are a famous adventurer.");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "One day, you come to the immense world of computer science.");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "At first, your journey is quite smooth.");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "You visited CS88 Kingdom and CS61A Kingdom. It was quite a journey.");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "But then, you encountered the ruler of the CS61BL Kingdom: Josh Hug.");
                    StdDraw.picture(80, 80, "hug.png");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "'To enter my Kingdom, you have to accept the challenges.'");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "'My challenges are set to test your heart and your mind.'");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "'In order to to prove to the world that you are THE CHOSEN adventurer,'");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "'the only option left for you is to PASS my challenges.'");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "You know you have no other options. The moment has come, so you...");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH * 8 , HEIGHT * 8, "ACCEPT THE CHALLENGE");
                    StdDraw.show();
                    break;
                }
            }
        }
        while (true){
            if (StdDraw.hasNextKeyTyped()){
                Character cur = StdDraw.nextKeyTyped();
                if (cur == 'c' || cur == 'C'){
                    menu();
                    break;
                }
            }
        }

    }






    public void interactWithKeyboard() throws IOException {
        StdDraw.setCanvasSize(WIDTH * 16, HEIGHT * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, WIDTH * 16);
        StdDraw.setYscale(0, HEIGHT * 16) ;
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();
        menu();
        while (true){
        if (StdDraw.hasNextKeyTyped()){
            Character cur = StdDraw.nextKeyTyped();
            if ((cur == 'N') || (cur == 'n')){
                String seed = "";
                char c = 0;
                while ((c != 'S') || (c != 's')){
                    if (c == 's'){
                        break;
                    }
                    newGame(seed);
                    if (StdDraw.hasNextKeyTyped()){
                        c = StdDraw.nextKeyTyped();
                        seed += c;
                    }
                }
                byow.Core.Engine engine = new byow.Core.Engine();
                startNewGame('n' + seed);
            } if ((cur == 'Q') || (cur == 'q')){
                System.exit(0);
            } if ((cur == 'L') || (cur == 'l')){
                File f = new File("./save.txt");
                String saved = Utils.readContentsAsString(f);
                startNewGame(saved.substring(0,saved.length()-1));
            } if ((cur == 'B') || (cur == 'b')){
                BackgroundStory();
            }
        }
        }
    }

    public void drawHUDFrame() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(3, HEIGHT + 2, "Score: " + score );
        StdDraw.text(7 ,HEIGHT + 4, "You need " + (60 - score) + " more points");
        int curX = Math.min((int) StdDraw.mouseX(),WIDTH-1);
        int curY = Math.min((int) StdDraw.mouseY(),HEIGHT-1);
        TETile target = finalWorldFrame[curX][curY];
        StdDraw.text(WIDTH - 10, HEIGHT + 2, "MOUSE OVER: " + target.description());
        if (target.equals(Tileset.badKey) || target.equals(Tileset.goodKey)){
            StdDraw.text(WIDTH-15,HEIGHT + 4, "This might be a key to success or failure, choose wisely");
        }
        if (score >= 60 && !tried){
            StdDraw.text(30,HEIGHT + 4, "You now have the chance to rescue the princess Stanford Tree");
            StdDraw.text(30,HEIGHT + 2, "Success -- Princess will be free; Fail -- you will lose all your points !");
        }
        StdDraw.show();
        StdDraw.pause(50);
    }

    public void startNewGame(String input) throws IOException {
        ter = new TERenderer();
        ter.initialize(WIDTH,HEIGHT + 7,0,0);
        interactWithInputString(input);
        StdDraw.clear(StdDraw.BLACK);
        if (!active){
            active = true;
            numQuestions --;
            boolean subactive = true;
            while (subactive){
                drawSubFrame();
                terr.renderFrame(subworld);
                if (remaining == 0){
                    subactive = false;
                    // add question here (you can add a static integer variable to keep track of which question should be asked)
                    int question = RandomUtils.uniform(random, 1, 6);
                    while (visitedQuestion.contains(question)){
                        question = RandomUtils.uniform(random, 1, 6);
                    }
                    if (question == 1){
                        Q1();
                        visitedQuestion.add(question);
                        ter = new TERenderer();
                        ter.initialize(WIDTH,HEIGHT + 7);
                        ter.renderFrame(finalWorldFrame);
                    } else if (question == 2){
                        Q2();
                        visitedQuestion.add(question);
                        ter = new TERenderer();
                        ter.initialize(WIDTH,HEIGHT + 7);
                        ter.renderFrame(finalWorldFrame);
                    } else if (question == 3) {
                        Q3();
                        visitedQuestion.add(question);
                        ter = new TERenderer();
                        ter.initialize(WIDTH,HEIGHT + 7);
                        ter.renderFrame(finalWorldFrame);
                    } else if (question == 4) {
                        Q4();
                        visitedQuestion.add(question);
                        ter = new TERenderer();
                        ter.initialize(WIDTH,HEIGHT + 7);
                        ter.renderFrame(finalWorldFrame);
                    } else if (question == 5) {
                        Q5();
                        visitedQuestion.add(question);
                        ter = new TERenderer();
                        ter.initialize(WIDTH,HEIGHT + 7);
                        ter.renderFrame(finalWorldFrame);
                    }
                    //ter.renderFrame(finalWorldFrame);
                    // if wrong, don't increase the score
                    //score += 20;
                }
                if (StdDraw.hasNextKeyTyped()) {
                    Character curr = StdDraw.nextKeyTyped();
                    record += curr;
                    if (test(curr,Tileset.TREE,submain,subworld)){
                        remaining --;
                    }
                    action(curr,subworld,submain);
                }
            }
        }
        while (active){
            drawHUDFrame();
            ter.renderFrame(finalWorldFrame);
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                record += cur;
                if (numQuestions == 0 && score < 60){
                    // you lose;
                    Ending.YouLose();
                }
                if (score >= 60 && test(cur,Tileset.Stanford,main,finalWorldFrame)){
                    Q6();
                    if (!saved){
                        Ending.YouLose();
                    }
                    ter = new TERenderer();
                    ter.initialize(WIDTH,HEIGHT + 7);
                    ter.renderFrame(finalWorldFrame);
                }
                if (score >= 60 && test(cur,Tileset.LOCKED_DOOR,main,finalWorldFrame) && (goodKey || badKey)){
                    active = false;
                    if (goodKey && saved){
                        Ending.extra();
                    }
                    if (goodKey && !saved){
                        //good ending;
                        Ending.GoodEnding();
                    }
                    if (badKey){
                        //bad ending;
                        Ending.BadEnding();
                    }
                }
                boolean j = false;
                if (test(cur,Tileset.goodKey,main,finalWorldFrame) || test(cur,Tileset.badKey,main,finalWorldFrame)){
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(WIDTH-15,HEIGHT + 4, "Are you sure? This might be the WRONG key !");
                    StdDraw.text(WIDTH - 15, HEIGHT + 2, "'Y': yes; 'N': No");
                    StdDraw.show();
                    StdDraw.pause(50);
                    boolean i = true;
                    while(i){
                        if (StdDraw.hasNextKeyTyped()){
                            i = false;
                            Character currr = StdDraw.nextKeyTyped();
                            record += currr;
                            if (currr.equals('Y') || currr.equals('y')){
                                if (test(cur,Tileset.goodKey,main,finalWorldFrame)){
                                    goodKey = true;
                                    finalWorldFrame[badkey.getX()][badkey.getY()] = Tileset.FLOOR;
                                }
                                if (test(cur,Tileset.badKey,main,finalWorldFrame)){
                                    badKey = true;
                                    finalWorldFrame[goodkey.getX()][goodkey.getY()] = Tileset.FLOOR;
                                }
                            }else{
                                j = true;
                            }
                        }
                    }
                }
                if (j){
                    continue;
                }
                if (test(cur,Tileset.FLOWER,main,finalWorldFrame)){
                    numQuestions --;
                    terr = new TERenderer();
                    terr.initialize(WIDTH,HEIGHT + 7);
                    subworld = createSubWorld();
                    terr.renderFrame(subworld);
                    boolean subactive = true;
                    while (subactive){
                        drawSubFrame();
                        terr.renderFrame(subworld);
                        if (remaining == 0){
                            subactive = false;
                            // add question here (you can add a static integer variable to keep track of which question should be asked)
                            int question = RandomUtils.uniform(random, 1, 6);
                            while (visitedQuestion.contains(question)){
                                question = RandomUtils.uniform(random, 1, 6);
                            }
                            if (question == 1){
                                Q1();
                                visitedQuestion.add(question);
                                ter = new TERenderer();
                                ter.initialize(WIDTH,HEIGHT + 7);
                                ter.renderFrame(finalWorldFrame);
                            } else if (question == 2){
                                Q2();
                                visitedQuestion.add(question);
                                ter = new TERenderer();
                                ter.initialize(WIDTH,HEIGHT + 7);
                                ter.renderFrame(finalWorldFrame);
                            } else if (question == 3) {
                                Q3();
                                visitedQuestion.add(question);
                                ter = new TERenderer();
                                ter.initialize(WIDTH,HEIGHT + 7);
                                ter.renderFrame(finalWorldFrame);
                            } else if (question == 4) {
                                Q4();
                                visitedQuestion.add(question);
                                ter = new TERenderer();
                                ter.initialize(WIDTH,HEIGHT + 7);
                                ter.renderFrame(finalWorldFrame);
                            } else if (question == 5) {
                                Q5();
                                visitedQuestion.add(question);
                                ter = new TERenderer();
                                ter.initialize(WIDTH,HEIGHT + 7);
                                ter.renderFrame(finalWorldFrame);
                            }
                            //ter.renderFrame(finalWorldFrame);
                            // if wrong, don't increase the score
                            //score += 20;
                        }
                        if (StdDraw.hasNextKeyTyped()) {
                            Character curr = StdDraw.nextKeyTyped();
                            record += curr;
                            if (test(curr,Tileset.TREE,submain,subworld)){
                                remaining --;
                            }
                            action(curr,subworld,submain);
                        }
                    }
                }
                action(cur,finalWorldFrame,main);
            }
        }
    }

    public void drawSubFrame(){
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(7 ,HEIGHT + 4, remaining + " more to be collected ...");
        StdDraw.text(10,HEIGHT + 2, "Please collect all the coins ...");
        StdDraw.show();
        StdDraw.pause(50);
    }

    public boolean test(Character cur, TETile tileset,Avatar main, TETile[][] finalWorldFrame){
        if ((cur == 'W' || cur == 'w') && main.getY() < finalWorldFrame[0].length - 1 && finalWorldFrame[main.getX()][main.getY() + 1].equals(tileset)){
            return true;
        }
        if ((cur == 'a' || cur == 'A') && main.getX() > 0 && finalWorldFrame[main.getX() - 1][main.getY()].equals(tileset)){
            return true;
        }
        if ((cur == 'S' || cur == 's') && main.getY() > 0 && finalWorldFrame[main.getX()][main.getY() - 1].equals(tileset)){
            return true;
        }
        if ((cur == 'D' || cur == 'd') && main.getX() < finalWorldFrame.length - 1 && finalWorldFrame[main.getX() + 1][main.getY()].equals(tileset)){
            return true;
        }
        return false;
    }

    /**
     * Method used for autograding and testing your code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The engine should
     * behave exactly as if the user typed these characters into the engine using
     * interactWithKeyboard.
     *
     * Recall that strings ending in ":q" should cause the game to quite save. For example,
     * if we do interactWithInputString("n123sss:q"), we expect the game to run the first
     * 7 commands (n123sss) and then quit and save. If we then do
     * interactWithInputString("l"), we should be back in the exact same state.
     *
     * In other words, both of these calls:
     *   - interactWithInputString("n123sss:q")
     *   - interactWithInputString("lww")
     *
     * should yield the exact same world state as:
     *   - interactWithInputString("n123sssww")
     *
     * @return the 2D TETile[][] representing the state of the world
     */

    public static Avatar addAvatar (TETile[][] tiles, Random random){
        boolean has = false;
        int i = 0;
        int j = 0;
        while (!has){
            i = RandomUtils.uniform(random,tiles.length);
            j = RandomUtils.uniform(random,tiles[0].length);
            if (tiles[i][j].equals(Tileset.FLOOR)){
                tiles[i][j] = Tileset.AVATAR;
                has = true;
            }
        }

        return new Avatar(new Position(i,j),Tileset.AVATAR,tiles);
    }

    public TETile[][] createSubWorld(){
        remaining = 5;
        TETile[][] subWorld = new TETile[WIDTH][HEIGHT];
        int newS = 0;
        for (int k = 0; k < 10; k ++){
            newS += RandomUtils.uniform(random,0,50);
        }
        random = new Random(newS);
        for (int i = 0; i < WIDTH; i ++){
            for (int j = 0; j < HEIGHT; j ++){
                subWorld[i][j] = Tileset.FLOOR;
            }
        }
        int n = 0;
        while (n < 5){
            int i = RandomUtils.uniform(random,0,WIDTH - 1);
            int j = RandomUtils.uniform(random,0,HEIGHT - 1);
            subWorld[i][j] = Tileset.TREE;
            n ++;
        }
        submain = addAvatar(subWorld,random);
        return subWorld;
    }

    public void addFlowers(TETile[][] tiles, Random random){
        int has = 0;
        int i;
        int j;
        while (has < 5){
            i = RandomUtils.uniform(random,tiles.length);
            j = RandomUtils.uniform(random,tiles[0].length);
            if (tiles[i][j].equals(Tileset.FLOOR)){
                tiles[i][j] = Tileset.FLOWER;
                has += 1;
            }
        }
    }

    public void addTree(Random random){
        boolean has = false;
        int i = 0;
        int j = 0;
        while (!has) {
            i = RandomUtils.uniform(random, finalWorldFrame.length);
            j = RandomUtils.uniform(random, finalWorldFrame[0].length);
            if (finalWorldFrame[i][j].equals(Tileset.FLOOR)) {
                finalWorldFrame[i][j] = Tileset.Stanford;
                has = true;
            }
        }
        tree = new Position(i,j);
    }

    public key addKeys(Random random, boolean truth){
        boolean has = false;
        int i;
        int j;
        key result = null;
        while (!has) {
            i = RandomUtils.uniform(random, finalWorldFrame.length);
            j = RandomUtils.uniform(random, finalWorldFrame[0].length);
            if (finalWorldFrame[i][j].equals(Tileset.FLOOR)) {
               if (truth){
                   finalWorldFrame[i][j] = Tileset.goodKey;
                   result = new key(new Position(i,j),true);
               }else{
                   finalWorldFrame[i][j] = Tileset.badKey;
                   result = new key(new Position(i,j),false);
               }
               has = true;
            }
        }
        return result;
    }

    public TETile[][] interactWithInputString(String input) throws IOException {
        // TODO: Fill out this method so that it run the engine using the input
        // passed in as an argument, and return a 2D tile representation of the
        // world that would have been drawn if the same inputs had been given
        // to interactWithKeyboard().
        //
        // See proj3.byow.InputDemo for a demo of how you can make a nice clean interface
        // that works for many different input types.

        int index = 1;
        if (input.charAt(0) == 'L' || input.charAt(0) == 'l'){
            load();
            System.out.println("!");
        }else{
            record += input.charAt(0);
            while ((input.charAt(index) != 'S') && (input.charAt(index) != 's')){
                record += input.charAt(index);
                index ++;
            }
        Long SEED = Long.parseLong(input.substring(1,index));
        Random rand = new Random(SEED);
        random = rand;
        finalWorldFrame= new TETile[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i ++){
            for (int j = 0; j < HEIGHT; j ++){
                finalWorldFrame[i][j] = Tileset.WALL;
            }
        }
        finalWorldFrame = World.createWorld(finalWorldFrame,rand);
        main = addAvatar(finalWorldFrame,rand);
        addFlowers(finalWorldFrame,rand);
        addTree(rand);
        goodkey = addKeys(rand,true);
        badkey = addKeys(rand,false);
            ter = new TERenderer();
            ter.initialize(WIDTH,HEIGHT + 7,0,0);
            ter.renderFrame(finalWorldFrame);}
        while (index < input.length()){
            if (input.charAt(index) == ':' && index < input.length() - 1 && (input.charAt(index + 1) == 'Q' || input.charAt(index + 1) == 'q')){
                save(record);
                System.exit(0);
                break;
            }
            Character cur = input.charAt(index);
            record += cur;
            index ++;
            if (score >= 60 && test(cur,Tileset.Stanford,main,finalWorldFrame)){
                if (index < input.length()){
                    Character curr = input.charAt(index);
                    index ++;
                    record += curr;
                    if (curr.equals('y')){
                        saved = true;
                    }
                }
                ter = new TERenderer();
                ter.initialize(WIDTH,HEIGHT + 7);
                ter.renderFrame(finalWorldFrame);
            }
            boolean j = false;
            if (test(cur,Tileset.goodKey,main,finalWorldFrame) || test(cur,Tileset.badKey,main,finalWorldFrame)){
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(WIDTH-15,HEIGHT + 4, "Are you sure? This might be the WRONG key !");
                StdDraw.text(WIDTH - 15, HEIGHT + 2, "'Y': yes; 'N': No");
                StdDraw.show();
                StdDraw.pause(50);
                boolean i = true;
                while(i){
                    if (index < input.length()){
                        i = false;
                        Character currr = input.charAt(index);
                        record += currr;
                        index ++;
                        if (currr.equals('Y') || currr.equals('y')){
                            if (test(cur,Tileset.goodKey,main,finalWorldFrame)){
                                goodKey = true;
                                finalWorldFrame[badkey.getX()][badkey.getY()] = Tileset.FLOOR;
                            }
                            if (test(cur,Tileset.badKey,main,finalWorldFrame)){
                                badKey = true;
                                finalWorldFrame[goodkey.getX()][goodkey.getY()] = Tileset.FLOOR;
                            }
                        }else{
                            j = true;
                        }
                    }
                }
            }
            if (j){
                continue;
            }
            if (test(cur,Tileset.FLOWER,main,finalWorldFrame)){
                numQuestions --;
                terr = new TERenderer();
                terr.initialize(WIDTH,HEIGHT + 7);
                subworld = createSubWorld();
                terr.renderFrame(subworld);
                boolean subactive = true;
                while (subactive ){
                    if (index < input.length()){
                    drawSubFrame();
                    terr.renderFrame(subworld);
                        //ter.renderFrame(finalWorldFrame);
                        // if wrong, don't increase the score
                        //score += 20;
                    if (remaining == 0){
                        if (index < input.length()){
                            int question = RandomUtils.uniform(random,1,6);
                            while (visitedQuestion.contains(question)){
                               question = RandomUtils.uniform(random,1,6);
                            }
                            visitedQuestion.add(question);
                            active = true;
                            subactive = false;
                            Character curr = input.charAt(index);
                            index ++;
                            record += curr;
                            if (curr.equals('y')){
                                score += 20;
                            }
                            if (curr.equals('n')){
                                score += 20;
                            }
                        }
                        ter.renderFrame(finalWorldFrame);
                    }
                    if (index < input.length()) {
                        Character curr = input.charAt(index);
                        record += curr;
                        index ++;
                        if (test(curr,Tileset.TREE,submain,subworld)){
                            remaining --;
                        }
                        action(curr,subworld,submain);
                    }
                }else{
                        active = false;
                        break;
                    }}
            }
            action(cur,finalWorldFrame,main);
        }
        return finalWorldFrame;
    }

    private static void QDefault(){
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setPenRadius(0.005);
        StdDraw.setCanvasSize(Engine.WIDTH * 16, Engine.HEIGHT * 16);
        Font lose = new Font("Monoco", Font.BOLD, 25);
        StdDraw.setXscale(0, Engine.WIDTH * 12);
        StdDraw.setYscale(0, Engine.HEIGHT * 12) ;
        StdDraw.rectangle(30, 30, 40, 20);
        StdDraw.show();
        StdDraw.enableDoubleBuffering();
    }
    public static void Q1(){
        QDefault();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 8, "You can't leave this room yet! To pass the room, please answer the question: ");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 10, "hug1.jpeg");
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 7, "How many medals do former and current Cal athletes win for the past 3 Olympiads?");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "A. 40");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "B. 50");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "C. 60");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character now = StdDraw.nextKeyTyped();
                if ((now == 'A') || (now == 'a')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Wrong!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'n';
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Correct! You win 20 points!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'y';
                    Engine.score += 20;
                    break;
                } else if ((now == 'C') || (now == 'c')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Wrong!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'n';
                    break;
                }
            }
        }
    }

    public static void Q2(){
        QDefault();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 8, "You can't leave this room yet! To pass the room, please answer the question: ");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 10, "hug1.jpeg");
        StdDraw.show();

        while (true) {
                if (StdDraw.hasNextKeyTyped()){
                    Character cur = StdDraw.nextKeyTyped();
                    if ((cur == 'C') || (cur == 'c')) {
                        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 7, "I (Hug) am also a Youtuber. About how many subscribers do I have on Youtube?");
                        StdDraw.show();
                        break;
                    }
                }}

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "A. 1.3M");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "B. 5.3K");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "C. 6.4K");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character now = StdDraw.nextKeyTyped();
                if ((now == 'A') || (now == 'a')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Too much!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'n';
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Too little!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'n';
                    break;
                } else if ((now == 'C') || (now == 'c')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Correct! You know me well!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'y';
                    Engine.score += 20;
                    break;
                }
            }
        }
    }

    public static void Q3(){
        QDefault();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 8, "You can't leave this room yet! To pass the room, please answer the question: ");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 10, "hug1.jpeg");
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 7, "Baked Century ==");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "A. Stone Age");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "B. Stink Bread");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "C. Middle Age");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character now = StdDraw.nextKeyTyped();
                if ((now == 'A') || (now == 'a')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Correct!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'y';
                    Engine.score += 20;
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Of course it's wrong!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'n';
                    break;
                } else if ((now == 'C') || (now == 'c')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Of course it's wrong!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'n';
                    break;
                }
            }
        }
    }

    public static void Q4(){
        QDefault();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 8, "You can't leave this room yet! To pass the room, please answer the question: ");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 10, "hug1.jpeg");
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 7, "Do you like Stanford?");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "A. Yes!");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "B. No!");
                    StdDraw.show();
                    break;
                }
            }
        }


        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character now = StdDraw.nextKeyTyped();
                if ((now == 'A') || (now == 'a')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "You can't get this one right? Shame on you!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record +='y';
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Yesss!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'n';
                    Engine.score += 20;
                    break;
                }
            }
        }
    }

    public static void Q5(){
        QDefault();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 8, "You can't leave this room yet! To pass the room, please answer the question: ");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 10, "hug1.jpeg");
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 7, "What are the CS Kingdoms you have traveled so far?");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "A. CS88 & CS61A");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "B. CS10 & CS61A");
                    StdDraw.show();
                    break;
                }
            }
        }


        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character now = StdDraw.nextKeyTyped();
                if ((now == 'A') || (now == 'a')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "This only proves you brain functions OKAY, OSKI.");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'y';
                    Engine.score += 20;
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "You don't read our background story? I am sad!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'n';
                    break;
                }
            }
        }
    }

    public static void Q6(){
        QDefault();
        score = 60;
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 8, "You enter the basement, and you see a Princess Stanford Tree right in the middle of a large ceil. ");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 10, "stanford.jpeg");
        StdDraw.show();
        tried = true;
        finalWorldFrame[tree.x][tree.y] = Tileset.NOTHING;

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 7, "You recognize that this is the missing princess from Stanford Empire.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "You immediately realize that Hug kidnapped the princess!");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "\"Save me, young man,' the princess said, 'I was trapped in this high-tech ceil.\"");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "\"The ceil can only be opened if you answer the secret question that is set by Hug.\"");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.black);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 8, "How many data structures have learned this summer? ");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 10, "hug1.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 7, "A. 14");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "B. 15");
                    StdDraw.show();
                    break;
                }
            }
        }


        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "C. 16");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character now = StdDraw.nextKeyTyped();
                if ((now == 'A') || (now == 'a') || (now == 'C') || (now == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "WRONG!!!!!! Princess will be trapped here forever and ever and ever ...");
                    StdDraw.show();
                    StdDraw.pause(500);
                    saved = false;
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Yeah ! You saved the princess!");
                    StdDraw.show();
                    StdDraw.pause(500);
                    record += 'y';
                    saved = true;
                    break;
                }
            }
        }

    }


}
