package gitlet;

// TODO: any imports you need here
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.Serializable;
import java.util.Date; // TODO: You'll likely use this in this class

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */
    /** The message of this Commit. */
    private String message;
    private String timestamp;
    private String parent;
    private String hashVale;
    private HashMap<String,String> blobs;
    private String parent2;
    // a Linkedlist to keep track of blobs
    private String branch;
    private int length;

    public Commit(String message, String parent, HashMap<String,String> blobs){
        this.message = message;
        this.parent = parent;
        this.blobs = blobs;
        byte[] obj = Utils.serialize(this);
        this.hashVale = Utils.sha1(obj);
        java.util.Date now = new java.util.Date();
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy Z");
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy Z");
        if (this.parent == null){
            this.timestamp = "Wed Dec 31 16:00:00 1969 -0800";
            this.length = 1;
        } else {
            this.timestamp = f.format(d);
            this.length = Utils.readObject(Utils.join(Repository.COMMIT,this.getParent()),Commit.class).getLength() + 1;
        }
        this.parent2 = null;
    }

    public String getHashVale() {return this.hashVale;}
    public String getMessage(){
        return this.message;
    }
    public HashMap<String,String> getBlob(){return this.blobs;}
    public String getParent(){
        return this.parent;
    }
    public String getDate(){return this.timestamp;}
    public int getLength(){return this.length;}
    /* TODO: fill in the rest of this class. */
}
