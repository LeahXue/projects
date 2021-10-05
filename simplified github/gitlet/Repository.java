package gitlet;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.*;
import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
// contains staging area (may create files containing the name of files)
    // possibly two files

public class Repository implements Serializable{
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = Utils.join(CWD, ".gitlet");
    public static final File BLOB = Utils.join(GITLET_DIR,"/blob");
    public static final File COMMIT = Utils.join(GITLET_DIR,"/commit");
    public static final File Staging_Area = Utils.join(GITLET_DIR,"/staging");
    public static final File BRANCHES = Utils.join(GITLET_DIR,"/branches");

    public Repository(){

    }
    /* TODO: fill in the rest of this class. */
    public Commit getCurCommit(){
        String branch = Utils.readContentsAsString(Utils.join(BRANCHES, "HEAD"));
        String commitID = Utils.readContentsAsString(Utils.join(BRANCHES,branch));
        return Utils.readObject(Utils.join(COMMIT,commitID),Commit.class);
    }
    
    public String getBranch(Commit c){
        String hashVale = c.getHashVale();
        String br = Utils.readContentsAsString(Utils.join(BRANCHES,"HEAD"));
        for (String branch: Utils.plainFilenamesIn(BRANCHES)){
            if (branch.equals("HEAD")){
                break;
            }
            String commitID = Utils.readContentsAsString(Utils.join(BRANCHES,branch));
            Commit cur = Utils.readObject(Utils.join(COMMIT,commitID),Commit.class);
            if (cur.equals(c)){
                br = branch;
                break;
            }
            while (cur.getParent() != null){
                if (cur.getParent().equals(hashVale)){
                    br = branch;
                    break;
                }
                cur = Utils.readObject(Utils.join(COMMIT,cur.getParent()),Commit.class);
            }
        }
        return br;
    }

    public void init(){
        // get the current working directory
        File cwd = new File (System.getProperty("user.dir"));
        Repository repo = new Repository();
        if (GITLET_DIR.exists()){
            System.out.print("A Gitlet version-control system already exists in the current directory.");
        }else{
            GITLET_DIR.mkdir();
            BLOB.mkdir();
            COMMIT.mkdir();
            Staging_Area.mkdir();
            BRANCHES.mkdir();
        }
        // start with one commit
        Commit initial = new Commit("initial commit", null, new HashMap<String,String>());
        Utils.writeObject(Utils.join(COMMIT,initial.getHashVale()),initial);
        // make a master branch
        File master= Utils.join(BRANCHES, "master");
        Utils.writeContents(master,initial.getHashVale());
        // make a HEAD
        File HEAD = Utils.join(BRANCHES, "HEAD");
        Utils.writeContents(HEAD,"master");
        // make a stagingArea
        StagingArea staging = new StagingArea();
        Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
        // what is UID?


    }

    public void add (String fileName){
        File toAdd = new File(fileName);
        if (! toAdd.exists()){
            System.out.println("File does not exist.");
        }else{
            StagingArea staging = Utils.readObject(Utils.join(Staging_Area,"stage"),StagingArea.class);
            HashMap<String,String> map = staging.getAdded();
            HashSet<String> set = staging.getRemoved();
            byte[] blob = Utils.readContents(toAdd);
            String shavalue = Utils.sha1(blob);
            Commit recent = getCurCommit();
            HashMap<String,String> blobs = recent.getBlob();
            // check if the file is in the removedFiles
            if (set.contains(fileName)){
                staging.removeFromRemoved(fileName);
                Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
                return;
            }
            //check if it equals to the current commit;
            if (blobs.containsKey(fileName) && blobs.get(fileName).equals(shavalue)){
                    // if the file is staged and it changed back to committed file
                    if (map.containsKey(fileName)){
                        staging.removeFromAdded(fileName);
                    }
                    return;
            }
            // check if the file is already in the staging area;
            if (map.containsKey(fileName)) {
                // if it is different, replace the old version;
                if (map.get(fileName) != shavalue) {
                    staging.removeFromAdded(fileName);
                } else {
                    return;
                }
            }
            staging.addFile(fileName,shavalue);
            Utils.writeContents(Utils.join(BLOB,Utils.sha1(blob)),blob);
            Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
        }

    }

    public void commit(String msg){
        if (msg.equals("")){
            System.out.println("Please enter a commit message.");
            return;
        }
        StagingArea staging = Utils.readObject(Utils.join(Staging_Area,"stage"),StagingArea.class);
        if (staging.getAdded().isEmpty() && staging.getRemoved().isEmpty()){
            System.out.print("No changes added to the commit.");
            return;
        }
        Commit curr = getCurCommit();
        HashMap<String,String> blob1 = (HashMap<String,String>) curr.getBlob();
        HashMap<String,String> toAdd = (HashMap<String, String>) staging.getAdded();
        HashSet<String> toRemove = (HashSet<String>) staging.getRemoved();
        for(String key: toAdd.keySet()){
            blob1.put(key,toAdd.get(key));
        }
        for (String key: toRemove){
            blob1.remove(key);
        }
        // parent is hashvalue
        Commit another = new Commit(msg,curr.getHashVale(),blob1);
        Utils.writeObject(Utils.join(COMMIT,another.getHashVale()),another);
        File branch= Utils.join(BRANCHES, Utils.readContentsAsString(Utils.join(BRANCHES,"HEAD")));
        Utils.writeContents(branch,another.getHashVale());
        staging.clear();
        Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
    }

    public void checkout(String fileName){
            Commit cur = getCurCommit();
            HashMap<String,String> blobs = cur.getBlob();
            if (! blobs.containsKey(fileName)){
                System.out.println("File does not exist in that commit.");
                return;
            }
            if (Utils.join(CWD,fileName).exists()){
                Utils.restrictedDelete(Utils.join(CWD,fileName));
            }
            File newF = Utils.join(CWD,fileName);
            File toCheckOut = Utils.join(BLOB,blobs.get(fileName));
            byte[] toStore = Utils.readContents(toCheckOut);
            Utils.writeContents(newF,toStore);

    }

    public void checkout(String ID, String fileName){
        String[] commitList = COMMIT.list();
        boolean ifContains = false;
        for (String s: commitList){
            if (s.contains(ID)){
                ID = s;
                ifContains = true;
                break;
            }
        }
        if (! ifContains){
            System.out.println("No commit with that id exists.");
            return;
        }
        Commit cur = Utils.readObject(Utils.join(COMMIT,ID),Commit.class);
        if (!cur.getBlob().containsKey(fileName)){
            System.out.println("File does not exist in that commit.");
        }else{
            if (Utils.join(CWD,fileName).exists()){
                Utils.restrictedDelete(Utils.join(CWD,fileName));
            }
            File newF = Utils.join(CWD,fileName);
            File toCheckOut = Utils.join(BLOB,cur.getBlob().get(fileName));
            byte[] toStore = Utils.readContents(toCheckOut);
            Utils.writeContents(newF,toStore);
        }
    }

    public void checkoutB(String branchName){
        if (! Utils.join(BRANCHES,branchName).exists()){
            System.out.println("No such branch exists.");
            return;
        }
        if (branchName.equals(Utils.readContentsAsString(Utils.join(BRANCHES,"HEAD")))){
            System.out.println("No need to checkout the current branch.");
            return;
        }
        String newCID = Utils.readContentsAsString(Utils.join(BRANCHES,branchName));
        Commit newC = Utils.readObject(Utils.join(COMMIT,newCID),Commit.class);
        Commit cur = getCurCommit();
        HashMap<String,String> newCMap = newC.getBlob();
        HashMap<String,String> curMap = cur.getBlob();
        for (String key: newCMap.keySet()){
            File f = new File(key);
            if (f.exists()) {
            byte[] blob = Utils.readContents(f);
            String shavalue = Utils.sha1(blob);
            if ((!curMap.containsKey(key)) && Utils.join(CWD,key).exists() && !shavalue.equals(newCMap.get(key))){
                System.out.println("There is an untracked file in the way; delete it, or add and commit it first.");
                return;
            }
            }
        }
        for (String key: newCMap.keySet()){
            if (Utils.join(CWD,key).exists()){
                Utils.restrictedDelete(Utils.join(CWD,key));
            }
            File newF = Utils.join(CWD,key);
            File toCheckOut = Utils.join(BLOB,newC.getBlob().get(key));
            byte[] toStore = Utils.readContents(toCheckOut);
            Utils.writeContents(newF,toStore);
        }
        for (String key: curMap.keySet()){
            if (! newCMap.containsKey(key)){
                Utils.restrictedDelete(Utils.join(CWD,key));
            }
        }
        Utils.writeContents(Utils.join(BRANCHES,"HEAD"),branchName);
        StagingArea staging = Utils.readObject(Utils.join(Staging_Area,"stage"),StagingArea.class);
        staging.clear();
        Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
    }

    public void log() {
        Commit cur = getCurCommit();
        while (true){
            System.out.println("===");
            System.out.println("commit " + cur.getHashVale());
            System.out.println("Date: " + cur.getDate());
            System.out.println(cur.getMessage());
            System.out.println();
            if (cur.getParent() != null){
                cur = Utils.readObject(Utils.join(COMMIT,cur.getParent()),Commit.class);
            }else{
                break;
            }
        }
    }

    public void rm(String fileName){
        StagingArea staging = Utils.readObject(Utils.join(Staging_Area,"stage"),StagingArea.class);
        Commit cur = getCurCommit();
        HashMap<String,String> blob = cur.getBlob();
        if (!staging.getAdded().containsKey(fileName) && !blob.containsKey(fileName)){
            System.out.println("No reason to remove the file.");
        }
        if (staging.getAdded().containsKey(fileName)){
            staging.removeFromAdded(fileName);
            Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
        }else if (blob.containsKey(fileName)){
            staging.removeFile(fileName);
            Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
            File fileToRemove = new File(fileName);
            if (fileToRemove.exists()){
                Utils.restrictedDelete(fileToRemove);
            }
        }
    }

    public void globalLog(){
        for (String fileName: Utils.plainFilenamesIn(COMMIT)){
            Commit cur = Utils.readObject(Utils.join(COMMIT,fileName),Commit.class);
            System.out.println("===");
            System.out.println("commit " + cur.getHashVale());
            System.out.println("Date: " + cur.getDate());
            System.out.println(cur.getMessage());
            System.out.println();
        }
    }

    public void find(String message){
        boolean found = false;
        HashSet<String> printed = new HashSet<String>();
        for (String fileName: Utils.plainFilenamesIn(COMMIT)){
            Commit cur = Utils.readObject(Utils.join(COMMIT,fileName),Commit.class);
            while (cur.getParent() != null) {
                if (cur.getMessage().equals(message) && !printed.contains(cur.getHashVale())) {
                    System.out.println(cur.getHashVale());
                    printed.add(cur.getHashVale());
                    found = true;
                }
                cur = Utils.readObject(Utils.join(COMMIT,cur.getParent()),Commit.class);
            }
            if (cur.getMessage().equals(message) && !printed.contains(cur.getHashVale())) {
                System.out.println(cur.getHashVale());
                printed.add(cur.getHashVale());
                found = true;
            }
        }
        if (!found){
            System.out.println("Found no commit with that message.");
        }
    }

    public void status(){
        // track all branches
        ArrayList<String> branches = new ArrayList<String>();
        for (String file: Utils.plainFilenamesIn(BRANCHES)){
            branches.add(file);
        }
        branches.remove("HEAD");
        String cur = Utils.readContentsAsString(Utils.join(BRANCHES, "/HEAD"));
        branches.remove(cur);
        branches.add("*" + cur);
        // track staged files
        StagingArea staging = readObject(Utils.join(Staging_Area,"stage"),StagingArea.class);
        HashMap<String,String> fileAdded = staging.getAdded();
        //track removed files
        HashSet<String> fileRemoved = staging.getRemoved();
        //last two sections are optional
        // print items
        System.out.println("=== Branches ===");
        Collections.sort(branches);
        for (String branch: branches){
            System.out.println(branch);
        }
        System.out.println("");
        System.out.println("=== Staged Files ===");
        for (String key : fileAdded.keySet()){
            System.out.println(key);
        }
        System.out.println("");
        System.out.println("=== Removed Files ===");
        for (String element : fileRemoved){
            System.out.println(element);
        }
        System.out.println();
        System.out.println("=== Modifications Not Staged For Commit ===");
        System.out.println();
        System.out.println("=== Untracked Files ===");
    }

    public void branch(String branchName){
        File branchF = Utils.join(BRANCHES,branchName);
        if (branchF.exists()){
            System.out.println("A branch with that name already exists.");
            return;
        }
        Commit cur = getCurCommit();
        String shavale = cur.getHashVale();
        Utils.writeContents(branchF,shavale);
    }

    public void rmb(String branchName){
        String branch = Utils.readContentsAsString(Utils.join(BRANCHES, "HEAD"));
        if (branch.equals(branchName)){
            System.out.println("Cannot remove the current branch.");
            return;
        }
        File branchF = Utils.join(BRANCHES,branchName);
        if (!branchF.exists()){
            System.out.println("A branch with that name does not exist.");
            return;
        }
        branchF.delete();
    }

    public void reset(String ID){
        boolean found = false;
        // cur is the commit with given ID while current is the current commit;
        String[] commitList = COMMIT.list();
        for (String s: commitList){
            if (s.contains(ID)){
                ID = s;
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("No commit with that id exists.");
            return;
        }
        Commit cur = Utils.readObject(Utils.join(COMMIT,ID),Commit.class);
        Commit current = getCurCommit();
        for (String key: cur.getBlob().keySet()){
            File f = new File(key);
            if (f.exists()) {
                byte[] blob = Utils.readContents(f);
                String shavalue = Utils.sha1(blob);
                if ((!current.getBlob().containsKey(key)) && Utils.join(CWD,key).exists() && !shavalue.equals(cur.getBlob().get(key))){
                    System.out.println("There is an untracked file in the way; delete it, or add and commit it first.");
                    break;
                }
            }
        }
        for (String key: cur.getBlob().keySet()){
            checkout(ID,key);
        }
        String branch = getBranch(cur);
        Utils.writeContents(Utils.join(BRANCHES,branch),cur.getHashVale());
        Utils.writeContents(Utils.join(BRANCHES,"HEAD"),branch);
        StagingArea staging = Utils.readObject(Utils.join(Staging_Area,"stage"),StagingArea.class);
        staging.clear();
        Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
    }

    private Commit findParent (Commit cur, int length){
        for (int i = 0; i < length; i ++){
            cur = Utils.readObject(Utils.join(COMMIT,cur.getParent()),Commit.class);
        }
        return cur;
    }

    private Commit findSplit(Commit cur, Commit bcur){
        int curLength = cur.getLength();
        int bcurLength = bcur.getLength();
        if (curLength > bcurLength){
            findParent(cur,curLength - bcurLength);
        }
        if (curLength < bcurLength){
            findParent(bcur,bcurLength - curLength);
        }
        while (! cur.equals(bcur)){
            bcur = findParent(bcur,1);
            cur = findParent(cur,1);
        }
        return cur;
    }
    
    private Commit getSplit(Commit cur, Commit bcur){
        Commit curr = cur;
        while (curr.getParent()!= null){
            Commit bcurr = bcur;
            while (bcurr.getParent() != null){
                if (curr.equals(bcurr)){
                    return curr;
                }
                bcurr = Utils.readObject(Utils.join(COMMIT,bcurr.getParent()),Commit.class);
            }
            curr = Utils.readObject(Utils.join(COMMIT,curr.getParent()),Commit.class);
        }
        return null;
    }

    public void merge(String branchName){
        boolean isConflit = false;
        Commit cur = getCurCommit();
        Commit bcur = Utils.readObject(Utils.join(COMMIT,Utils.readContentsAsString(Utils.join(BRANCHES,branchName))),Commit.class);
        // check if there are stagged additions or removals
        StagingArea staging = Utils.readObject(Utils.join(Staging_Area,"stage"),StagingArea.class);
        if (! (staging.getAdded().isEmpty()) || ! (staging.getRemoved().isEmpty())){
            System.out.println("You have uncommitted changes.");
            return;
        }
        // check if there is the branch
        if (!(Utils.join(BRANCHES,branchName).exists())){
            System.out.println("A branch with that name does not exist.");
            return;
        }
        // when the branch is the head
        if (Utils.readContentsAsString(Utils.join(BRANCHES, "HEAD")) == branchName){
            System.out.println("Cannot merge a branch with itself.");
            return;
        }
        Commit split = null;
        HashMap<String,Commit> curTree = new HashMap();
        Commit curr = cur;
        Commit bcurr = bcur;
        while (curr != null && curr.getParent() != null){
            curTree.put(curr.getHashVale(),Utils.readObject(Utils.join(COMMIT,curr.getHashVale()),Commit.class));
            curr = Utils.readObject(Utils.join(COMMIT,curr.getParent()),Commit.class);
        }
        while (bcurr != null && bcurr.getParent() != null){
            if (curTree.containsKey(bcurr.getHashVale())){
                split = curTree.get(bcurr.getHashVale());
            }
            bcurr = Utils.readObject(Utils.join(COMMIT,bcurr.getParent()),Commit.class);
        }
        //There is an untracked file in the way; delete it, or add and commit it first.
        /*for (String key: bcur.getBlob().keySet()){
            File f = Utils.join(CWD,key);
            if (f.exists()) {
                byte[] blob = Utils.readContents(f);
                String shavalue = Utils.sha1(blob);
                if ((!cur.getBlob().containsKey(key)) && !shavalue.equals(bcur.getBlob().get(key))){
                    System.out.println("There is an untracked file in the way; delete it, or add and commit it first.");
                    return;
                }
            }
        }*/
        /*
        String hashvalue = Utils.readContentsAsString (Utils.join(BRANCHES,branchName));
        //ommit split = null; // find the split point*/
        ArrayList<File> fileCWD = new ArrayList<File>();
        for (File f : CWD.listFiles()){
            fileCWD.add(f);
        }
        for (File file : fileCWD){
            if (!cur.getBlob().containsKey(file.getName()) && bcur.getBlob().containsKey(file.getName())){
                System.out.println("There is an untracked file in the way; delete it, or add and commit it first.");
                return;
            }
        }
        // find the split point
        /*
        while (curr.getParent()!= null){
            Commit bcurr = bcur;
            while (bcurr.getParent() != null){
                if (curr.equals(bcurr)){
                    break;
                }
                bcurr = Utils.readObject(Utils.join(COMMIT,bcurr.getParent()),Commit.class);
            }
            if (curr.equals(bcurr)){
                break;
            }
            curr = Utils.readObject(Utils.join(COMMIT,curr.getParent()),Commit.class);
        }
        */
        //check if split point is the same as given branch commit
        if (split.getHashVale().equals(bcur.getHashVale())){
            System.out.println("Given branch is an ancestor of the current branch.");
            return;
        }
        // check if the split is the same as head
        if (split.getHashVale().equals(getCurCommit().getHashVale())){
            checkout(branchName);
            System.out.println("Current branch fast-forwarded.");
            return;
        }
        HashMap<String,String> splitMap = split.getBlob();
        HashMap<String,String> curMap = cur.getBlob();
        HashMap<String,String> bcurMap = bcur.getBlob();
        for (String key : splitMap.keySet()){
            // unchanged in head + changed in branch --> branch
            if (bcurMap.containsKey(key) && !bcurMap.get(key).equals(splitMap.get(key)) && curMap.containsKey(key) && curMap.get(key).equals(splitMap.get(key))){
                checkout(bcur.getHashVale(),key);
                staging.addFile(key,bcurMap.get(key));
                Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
            }
            // changed in head + unchanged in branch --> head (no change)
            // both changed in the same way --> no change
            // removed in branch
            if (curMap.containsKey(key) && curMap.get(key).equals(splitMap.get(key)) && !bcurMap.containsKey(key)){
                staging.removeFile(key);
                Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
                Utils.restrictedDelete(Utils.join(CWD,key));
            }
            // check conflicts
            if (mergeConflict(cur,bcur,split,key)){
                isConflit = true;
                File merge = Utils.join(CWD,key);
                String message = "<<<<<<< HEAD" + "\n";
                if (curMap.containsKey(key)){
                    message += Utils.readContentsAsString(Utils.join(BLOB,curMap.get(key)));
                }
                message += "=======";
                message += "\n";
                if (bcurMap.containsKey(key)) {
                    message += Utils.readContentsAsString(Utils.join(BLOB, bcurMap.get(key)));
                }
                message += ">>>>>>>";
                Utils.writeContents(merge,message);
                staging.addFile(key,Utils.sha1(Utils.readContents(merge)));
                Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
            }
        }
        // only in the given branch
        for (String key : bcurMap.keySet()){
            if (curMap.containsKey(key) && !splitMap.containsKey(key) && !curMap.get(key).equals(bcurMap.get(key))){
                isConflit = true;
                File merge = Utils.join(CWD,key);
                String message = "<<<<<<< HEAD" + "\n";
                if (curMap.containsKey(key)){
                    message += Utils.readContentsAsString(Utils.join(BLOB,curMap.get(key)));
                }
                message += "=======";
                message += "\n";
                if (bcurMap.containsKey(key)){
                    message += Utils.readContentsAsString(Utils.join(BLOB,bcurMap.get(key)));
                }
                message += ">>>>>>>";
                Utils.writeContents(merge,message);
                staging.addFile(key,Utils.sha1(Utils.readContents(merge)));
                Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
            }
        }
        for (String key : bcurMap.keySet()){
            if (!curMap.containsKey(key) && !splitMap.containsKey(key)){
                checkout(bcur.getHashVale(),key);
                staging.addFile(key,bcurMap.get(key));
                Utils.writeObject(Utils.join(Staging_Area,"stage"),staging);
            }
        }
        // parent 2?
        staging = Utils.readObject(Utils.join(Staging_Area,"stage"),StagingArea.class);
        if (!(staging.getAdded().isEmpty()) || !(staging.getRemoved().isEmpty())){
            commit("Merged " + branchName + " into " + Utils.readContentsAsString(Utils.join(BRANCHES,"HEAD")) + ".");
        }
        if (isConflit){
            System.out.println("Encountered a merge conflict.");
        }
    }

    private boolean mergeConflict(Commit cur, Commit bcur, Commit split, String key){
        HashMap<String,String> splitMap = split.getBlob();
        HashMap<String,String> curMap = cur.getBlob();
        HashMap<String,String> bcurMap = bcur.getBlob();

            // both changed but with different content
            if (bcurMap.containsKey(key) && curMap.containsKey(key) && !curMap.get(key).equals(splitMap.get(key)) && !bcurMap.get(key).equals(splitMap.get(key)) && curMap.get(key) != bcurMap.get(key)){
                return true;
            }
            // one is changed and the other one is deleted
            if (bcurMap.containsKey(key) && !bcurMap.get(key).equals(splitMap.get(key)) && !curMap.containsKey(key)){
                return true;
            }
            if (curMap.containsKey(key) && !curMap.get(key).equals(splitMap.get(key)) && !bcurMap.containsKey(key)){
                return true;
            }
        // absent from split, but changed in different ways
        return false;
    }

}
