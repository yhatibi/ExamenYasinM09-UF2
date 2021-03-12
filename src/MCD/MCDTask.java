package MCD;

import java.util.concurrent.RecursiveTask;

public class MCDTask extends RecursiveTask<Integer> {
    private int a, b;
    private static int LLIDAR = 20;

    public MCDTask(int _a, int _b) {
        a = _a;
        b = _b;
    }

    //mcd recursives
    public Integer mcdR() {
        if(b == 0) return a;
        else {
            MCDTask f = new MCDTask(b,a%b);
            f.fork();
            return f.join();
        }
    }

    //mcd iteratives
    public Integer mcdS() {
        int temporal;//Para no perder b
        while( b != 0){
            temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    @Override
    protected Integer compute() {
        if(b > LLIDAR && a > LLIDAR) return mcdR();
        else return mcdS();
    }
}
