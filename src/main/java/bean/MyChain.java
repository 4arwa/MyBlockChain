package bean;


import com.google.gson.GsonBuilder;

import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Arwa Arif  - arwaarif1994@gmail.com
 * Date: 19-Oct-18
 */
public class MyChain {
    LinkedList<MyBlock> chain = new LinkedList<MyBlock>();
    public static int difficulty = 4;

    public void addBlock(MyBlock block) {
        chain.add(block);
    }

    public String toJson() {
        String chainJson = new GsonBuilder().setPrettyPrinting().create().toJson(chain);
        return chainJson;
    }

    public MyBlock getLastBlock() {
        return chain.getLast();
    }

    public boolean isValidChain() {
        MyBlock currentBlock;
        MyBlock previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for(int i = 1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i-1);

            if(!currentBlock.currHash.equals(currentBlock.calculateHash())){
                System.out.println("Hash mismatch for block : " + currentBlock.currHash);
                return false;
            }

            if(!previousBlock.currHash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }

            if(!currentBlock.currHash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}
