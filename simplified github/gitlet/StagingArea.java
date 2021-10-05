package gitlet;
import java.util.*;
import java.io.Serializable;

public class StagingArea implements Serializable{
    // fileAdded track <file name, sha1>
    private HashMap<String,String> fileAdded;
    // fileRemoved track filename
    private HashSet<String> fileRemoved;

    public StagingArea(){
        fileAdded = new HashMap<String,String>();
        fileRemoved = new HashSet<String>();
    }

    public void addFile(String name, String sha1){
        fileAdded.put(name,sha1);
    }

    public void removeFromAdded(String name){
        fileAdded.remove(name);
    }

    public void removeFile(String name){
        fileRemoved.add(name);
    }

    public void removeFromRemoved(String name) {fileRemoved.remove(name);}

    public boolean isInRemovedFile(String name){
        return fileRemoved.contains(name);
    }

    public void clear(){
        this.fileAdded = new HashMap<String,String>();
        this.fileRemoved = new HashSet<String>();
    }

    public HashMap<String,String> getAdded(){
        return this.fileAdded;
    }

    public HashSet<String> getRemoved(){
        return this.fileRemoved;
    }
}
