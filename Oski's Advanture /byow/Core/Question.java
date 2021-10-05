package byow.Core;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Question {

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
                    break;
                } else if ((now == 'B') || (now == 'B')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Correct! You win 20 points!");
                    StdDraw.show();
                    Engine.score += 20;
                    break;
                } else if ((now == 'C') || (now == 'C')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Wrong!");
                    StdDraw.show();
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
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 7, "I (Hug) am also a Youtuber. About how many subscribers do I have on Youtube?");
                    StdDraw.show();
                    break;
                }
            }
        }

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
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Too little!");
                    StdDraw.show();
                    break;
                } else if ((now == 'C') || (now == 'c')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Correct! You know me well!");
                    StdDraw.show();
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
                    Engine.score += 20;
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Of course it's wrong!");
                    StdDraw.show();
                    break;
                } else if ((now == 'C') || (now == 'c')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Of course it's wrong!");
                    StdDraw.show();
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
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Yesss!");
                    StdDraw.show();
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
                    Engine.score += 20;
                    StdDraw.show();
                    break;
                } else if ((now == 'B') || (now == 'b')){
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "You don't read our background story? I am sad!");
                    StdDraw.show();
                    break;
                }
            }
        }
    }



}
