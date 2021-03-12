package AB;

public class Main {
    public static void main(String[] args) {


        Recurs recurs = new Recurs(10);
        AB a [] = new AB[50];
        AB b [] = new AB[50];

        for(int i=0;i<50;i++) {
            a[i] = new AB(recurs,"A");
            b[i] = new AB(recurs,"B");
        }

        for(int i=0;i<50;i++) {
            a[i].start();
            b[i].start();
        }



    }
}
