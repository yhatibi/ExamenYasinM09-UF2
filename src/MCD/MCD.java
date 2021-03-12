package MCD;

import java.util.concurrent.ForkJoinPool;

public class MCD {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        MCDTask mcd = new MCDTask(5,5);

        pool.invoke(mcd);
        int res = mcd.join();

        System.out.println("Resultat:" + res);
    }
}
