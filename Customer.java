import java.util.concurrent.CyclicBarrier;

public class Customer implements Runnable {


    private int enterTime;          //time stamp of Customer entry into store
    private int shopTime;           //randomly generated: time spent shopping
    private int leaveTime;          //time stamp of Customer exit

    private int enterQTime;         //time stamp of Customer enters the Queue
    private int beginProcessTime;   //time stamp they begin checking out (no longer in line)
    private int processTime;        //randomly generated: time spent in processing

    private boolean isAtCashier;

    public void setInQueue(boolean inQueue) {
        this.inQueue = inQueue;
    }

    private boolean inQueue;

    Thread t;
    private static int rollingID = 1;
    private int customerID;

    public Customer(int enterTime) {
        this.enterTime = enterTime;
        shopTime = (int)(1 + Math.random() * 15);
        enterQTime = enterTime + shopTime;
        customerID = rollingID;
        beginProcessTime = enterQTime;
        rollingID++;
        processTime = (int)(1 + Math.random() * 15);
        leaveTime++;
        //isAtCashier = false;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        //System.out.println(this.toString() + " entering at " + CustomerMain.simTime);

        while(enterQTime >= CustomerMain.simTime) {
            //System.out.print("");
        }
        //System.out.println(this.toString() + " going into queue at " + CustomerMain.simTime);

        while(((beginProcessTime + processTime >= CustomerMain.simTime) && isAtCashier) || inQueue) {
            //System.out.print("");
        }
        //System.out.println(this.toString() + " leaving at " + CustomerMain.simTime);



    }

    public String toString() {
        return "Customer " + customerID + " (" + shopTime + ")" + "(" + enterQTime + ")" + "(" + processTime + ")";
    }

/*
    public int determinedLeaveTime(int givenShopTime) {
        if(givenShopTime >= 100) {
            return 100;
        }
        return givenShopTime;
    }

 */

    public int getEnterQTime() {
        return enterQTime;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    public void setEnterQTime(int enterQTime) {
        this.enterQTime = enterQTime;
    }

    public int getProcessTime() {
        return processTime;
    }

    public int getBeginProcessTime() {
        return beginProcessTime;
    }

    public void setBeginProcessTime(int beginProcessTime) {
        this.beginProcessTime = beginProcessTime;
    }

    public void setAtCashier(boolean atCashier) {
        isAtCashier = atCashier;
    }

    public int getShopTime() {
        return shopTime;
    }
}
