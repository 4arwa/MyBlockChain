import bean.MyBlock;
import bean.MyChain;

/**
 * Created by IntelliJ IDEA.
 * User: Arwa Arif  - arwaarif1994@gmail.com
 * Date: 19-Oct-18
 */
public class Main {

    public static void main(String[] args) {
        MyChain myChain = new MyChain();

        myChain.addBlock(new MyBlock("0", "First block"));
        myChain.getLastBlock().mineBlock(myChain.difficulty);

        myChain.addBlock(new MyBlock(myChain.getLastBlock().currHash, "second block"));
        myChain.getLastBlock().mineBlock(myChain.difficulty);

        System.out.println(myChain.toJson());
        System.out.println(myChain.isValidChain());


    }
}
