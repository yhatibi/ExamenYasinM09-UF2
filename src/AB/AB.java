package AB;

public class AB extends Thread {
    private String AoB;
    private Recurs recurs;

    public AB(Recurs recurs, String AoB) {
        this.AoB = AoB;
        this.recurs = recurs;
    }

    public void run() {
        int random = (int) (Math.random()*5+1);

        try {
            recurs.utilitzarRecurs(AoB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(AoB +" estara fent servir el recurs durant " + random);

        try {
            Thread.sleep(random*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(AoB +" deixe el recurs");
        recurs.deixarBany(AoB);
    }

}
