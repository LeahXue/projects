
package byow.Core;

import java.io.IOException;

/** This is the main entry point for the program. This class simply parses
 *  the command line inputs, and lets the byow.Core.Engine class take over
 *  in either keyboard or input string mode.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Can only have two arguments - the flag and input string");
            System.exit(0);
        } else if (args.length == 1) {
            byow.Core.Engine engine = new byow.Core.Engine();
            engine.interactWithInputString(args[0]);
            System.out.println(engine.toString());
        // DO NOT CHANGE THESE LINES YET ;)
        } else if (args.length == 2 && args[0].equals("-p")) { System.out.println("Coming soon."); }
        // DO NOT CHANGE THESE LINES YET ;)
        else {
            byow.Core.Engine engine = new byow.Core.Engine();
            engine.interactWithKeyboard();
        }
    }
}
