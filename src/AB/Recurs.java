package AB;

public class Recurs {

    private int  limite;
    private int  actualLimit;
    private int ADins;
    private int BDins;
    private boolean recursOcupat = true;

    public Recurs(int limite) {
        this.limite = limite;
    }

    synchronized public void utilitzarRecurs (String AoB) throws InterruptedException {

        try {
            while (actualLimit >= limite && recursOcupat != true ) {
                wait();
            }
            while ( 0 >= actualLimit && AoB.equalsIgnoreCase("A") ) {
                System.out.println("INTENTA ENTRAR PRIMERO A");
                wait();
            }
            while ( BDins<=(ADins*2) && AoB.equalsIgnoreCase("A") ) {
                if (AoB.equalsIgnoreCase("A") && BDins >= 2 && ADins == 0) break;
                wait();
            }


            if (AoB.equalsIgnoreCase("A")){
                ADins++;
            } else BDins++;
            recursOcupat = false;
            actualLimit++;
            notifyAll();
            System.out.println("A utilitzan el rucurs: "+ADins+" | B utilitzan el rucurs: " + BDins);
        } catch (InterruptedException e) {

        }
    }

    synchronized public void deixarBany(String AoB) {
        recursOcupat = true;
        actualLimit--;
        notifyAll();
        if (AoB.equalsIgnoreCase("A")) {
            ADins --;
        } else {
            BDins --;
        }
        System.out.println("A utilitzan el rucurs: "+ADins+" | B utilitzan el rucurs: " + BDins);
    }

}
