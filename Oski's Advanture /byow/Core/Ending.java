package byow.Core;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.io.IOException;

public class Ending {


    public static void Default(){
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setPenRadius(0.005);
        StdDraw.setCanvasSize(Engine.WIDTH * 16, Engine.HEIGHT * 16);
        Font lose = new Font("DIALOG", Font.BOLD, 25);
        StdDraw.setXscale(0, Engine.WIDTH * 12);
        StdDraw.setYscale(0, Engine.HEIGHT * 12) ;
        StdDraw.rectangle(30, 30, 40, 20);
        StdDraw.show();
        StdDraw.enableDoubleBuffering();
    }

    public static void YouLose() throws IOException {
        Default();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "You heard a dark, deep voice whispering around your ears, 'you did not pass my test, Oski.");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "hug2.jpeg");
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "...you do not have the courage and wisdom that an adventurer has. Your journey ENDS.'");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Then, a strong force push you out of Hug's palace.");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "palace.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "...");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "You know there is nothing you can do. Your adventure ends.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 3, "...Or, has it even started?");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "You return back to your home, and you have lost all your hope to become an adventurer." );
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "home.png");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "Many years later, you still tell this story to your grandchildren." );
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "In your story, Oski becomes the renowned adventurer on this land." );
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "You know your story can become a reality only if you pass Hug's challenges.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "...Only IF.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Ending 1: DREAM");
                    StdDraw.show();
                    StdDraw.pause(500);
                    break;
                }
            }
        }
        System.exit(0);
    }

    public static void BadEnding() throws IOException {
        Default();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "The moment you open the door, you hear a voice, 'Looks like you have found a way out...");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "hug2.jpeg");
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "...BUT you doesn't. Look closely Oski, the key in your hand is a fake one.'");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9,"lasereyes.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "You are being fooled!'");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 3, "You are shocked, and you can't believe the words you heard.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "'This is unfair!' you yelled back, 'I have passed all the challenges!'");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "'Well, yes,' you heard that demonic voice said, '...only IF you have found the RIGHT KEY.'");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "meme.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "'Now, you may leave my palace.'" );
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Then, a strong force push you out of Hug's palace." );
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "palace.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "You are frustrated, but you know your journey should not end here." );
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "You pack your stuff, and soon begins a new journey.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "Tomorrow will be a new day.");
                    StdDraw.show();
                    break;
                }
            }
        }


        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Ending 2: Adventurer? Or not?");
                    StdDraw.show();
                    StdDraw.pause(500);
                    break;
                }
            }
        }
        System.exit(0);
    }


    public static void GoodEnding() throws IOException {
        Default();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "The moment you open the door, you hear a voice, 'Looks like you have found a way out...");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "hug2.jpeg");
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "and congratulations! You have found the RIGHT KEY!'");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "smile.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "Thrilled and astonished, you know all your hard work gets paid off.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "'Now, you have proven to me that you have the courage and wisdom to become an adventurer.'");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "smile1.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "'You may continue your journey. Wish you all the best!'");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Then, you visit CS61C Kingdom, and CS70 Kingdom.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "You become more confident, and you know you are one step closer to your dream." );
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Many years later, you become a renowned adventurer in the land." );
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "oskihappy.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "Even though you have been to many places, you still remember clearly about that journey in Hug's kingdom." );
                    StdDraw.show();
                    break;
                }
            }
        }


        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "True Ending: The BEST Adventurer");
                    StdDraw.show();
                    StdDraw.pause(500);
                    break;
                }
            }
        }
        System.exit(0);
    }

    public static void extra() throws IOException {
        Default();
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "The moment you open the door, you hear a voice, 'Looks like you have found a way out...");
        StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "hug2.jpeg");
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "and congratulations! You have found the RIGHT KEY!'");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "smile.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "Thrilled and astonished, you know all your hard work gets paid off.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "'Now, you have proven to me that you have the courage and wisdom to become an adventurer.'");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "smile1.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "'And you successfully save a fellow of yours who are trapped in the CS61BL world.'");
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "smile1.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 4, "'You may continue your journey. Wish you all the best!'");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Then, you, along with Princess Stanford, visit CS61C Kingdom, and CS70 Kingdom.");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "Together, you guys chase for a bigger dream: to become the renowned adventurer." );
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "Many years later, your dreams come true. You and Princess Stanford Tree become good friends." );
                    StdDraw.picture(Engine.WIDTH * 6, Engine.HEIGHT * 9, "oskihappy.jpeg");
                    StdDraw.show();
                    break;
                }
            }
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 5, "You collaborated to overcome difficulties along the journey, and that's the key to success." );
                    StdDraw.show();
                    break;
                }
            }
        }


        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                Character cur = StdDraw.nextKeyTyped();
                if ((cur == 'C') || (cur == 'c')) {
                    StdDraw.clear(Color.BLACK);
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(Engine.WIDTH * 6, Engine.HEIGHT * 6, "True Ending: The BEST Adventurer");
                    StdDraw.show();
                    StdDraw.pause(500);
                    break;
                }
            }
        }
        System.exit(0);
    }

}
