package gitlet;
import java.util.*;
import java.io.File;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    private static Object Map;

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    //call java.main
    public static void main(String[] args) {
        Repository repo = new Repository();
        if (args.length == 0){
            System.out.println("Please enter a command.");
            return;
        }
        boolean worked = false;
        // TODO: what if args is empty?
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                if (workable(1,args)){
                repo.init();}
                worked = true;
                break;
            case "add":
                if (workable(2,args) && initialized()){
                repo.add(args[1]);}
                worked = true;
                break;
            case "commit":
                if (workable(2,args) && initialized()){
                repo.commit(args[1]);}
                worked = true;
                break;
            case "checkout":
                if (initialized()){
                if (args.length != 2 && args.length != 3 && args.length != 4) {
                    System.out.println("Incorrect Operands");}
                else if ((args.length == 4 && !args[2].equals("--"))
                        || (args.length == 3 && !args[1].equals("--"))) {
                    System.out.println("Incorrect Operands");
                }
                if (args.length == 3) {
                    repo.checkout(args[2]);
                } else if (args.length == 4) {
                    repo.checkout(args[1], args[3]);
                } else {
                    repo.checkoutB(args[1]);
                }}
                worked = true;
                break;
            case "log":
                if (workable(1,args) && initialized()){
                repo.log();}
                worked = true;
                break;
            case "global-log":
                if (workable(1,args) && initialized()){
                repo.globalLog();}
                worked = true;
                break;
            case "rm":
                if (workable(2,args) && initialized()){
                repo.rm(args[1]);}
                worked = true;
                break;
            case "find":
                if (workable(2,args) && initialized()){
                repo.find(args[1]);}
                worked = true;
                break;
            case "status":
                if (workable(1,args) && initialized()){
                repo.status();}
                worked = true;
                break;
            case "branch":
                if (workable(2,args) && initialized()){
                repo.branch(args[1]);}
                worked = true;
                break;
            case "rm-branch":
                if (workable(2,args) && initialized()){
                repo.rmb(args[1]);}
                worked = true;
                break;
            case "reset":
                if (workable(2,args) && initialized()){
                repo.reset(args[1]);}
                worked = true;
                break;
            case "merge":
                if (workable(2,args) && initialized()){
                    repo.merge(args[1]);
                }
                worked = true;
                break;
            // TODO: FILL THE REST IN
        }
        if (!worked){
            System.out.println("No command with that name exists.");
            return;
        }
    }

    public static boolean workable(int length, String... args){
        if (args.length == length){
            return true;
        }
        System.out.println("Incorrect operands.");
        return false;
    }

    public static boolean initialized(){
        boolean initialized = Repository.GITLET_DIR.exists();
        if (!initialized){
            System.out.println("Not in an initialized Gitlet directory.");
        }
        return initialized;
    }

}
