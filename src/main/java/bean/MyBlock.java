package bean;
/*
 ** @author : Arwa Arif - arwaarif1994@gmail.com
 */

import Util.StringUtil;

import java.util.Date;

public class MyBlock {
    public String currHash;
    public String previousHash;
    private String transaction;
    private long currTime;
    private int nonce;

    public MyBlock(String previousHash, String transaction) {
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.currTime = new Date().getTime();
        this.currHash = calculateHash();
    }

    public String calculateHash() {
        return StringUtil.calculateHash(previousHash, currTime, transaction, nonce);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!currHash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            currHash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + currHash);
    }
}
