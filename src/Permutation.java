import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (k > 0) {
            try {
                rq.enqueue(StdIn.readString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            k--;
        }
        Iterator<String> it = rq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}
