import java.util.ArrayList;

//in main
//- a queue customers join after done shopping
//# of cashiers, something we can change and analyze efficiency (1,2,3 tellers)
//          Customer[] cashiers = new Customer[3];
//
//              cashiers[null, null, null]                    Queue : C1, C2, C3, C4   customers hop into cashiers
//
// when done
/*
 Output:    Total Customers Served,
            Total Cashiers Used,
            Total Queue Wait Time,
            Average Queue Wait Time,
            Longest Queue Wait Time,
            Average Time Shopping
 */
public class CustomerMain {

    public static int simTime = 0;
    public static int cashierCount = 3;
    public static Queue<Customer> waitLine = new Queue<Customer>();
    public static ArrayList<Customer> customers = new ArrayList<>(100);
    public static Customer[] cashiers = new Customer[cashierCount];

    public static int customersServed = 0;
    public static int totalQueueTime = 0;
    public static int longestQueueTime = 0;
    public static int totalShoppingTime = 0;


    public static void main(String[] args) throws InterruptedException {

        Customer c1 = new Customer(simTime);

        customers.add(c1);


        while(simTime < 40) {
            simTime++;
            //System.out.println("Seconds: " + simTime);

            int randNum = (int)(1 + Math.random() * 100);
            if (randNum <= 40) {
                Customer shopper = new Customer(simTime);
                customers.add(shopper);
            }

            checkWaitLine();
            checkCashiers();

            Thread.sleep(10);
        }
        while(waitLine.isEmpty()) {
            System.out.println("Checking late checkout");
            simTime++;
            checkCashiers();
            checkWaitLine();
        }
        boolean cashiersNotEmpty = true;
        while(cashiersNotEmpty) {
            simTime++;
            for (int i = 0; i < cashiers.length; i++) {
                if (cashiers[i] != null) {
                    cashiersNotEmpty = false;
                }
            }
            if(cashiersNotEmpty) {
                cashiersNotEmpty = false;
            }
            else {
                cashiersNotEmpty = true;
            }
            checkWaitLine();
            checkCashiers();
        }

        System.out.println("Customers served: " + customersServed);
        System.out.println("Cashier size: " + cashierCount);
        System.out.println("Total Queue Time: " + totalQueueTime);
        System.out.println("Average Queue Time: " + (double)(totalQueueTime/customersServed));
        System.out.println("Longest Queue Time: " + longestQueueTime);
        System.out.println("Average Time Shopping: " + (double)(totalShoppingTime/customersServed));

    }

    public static void checkWaitLine() {
        for(int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getEnterQTime() == simTime) {
                customers.get(i).setBeginProcessTime(simTime);
                waitLine.enqueue(customers.get(i));
                customers.get(i).setAtCashier(false);
                customers.get(i).setInQueue(true);
                totalShoppingTime += customers.get(i).getShopTime();
            }
        }
    }

    public static void checkCashiers() {
        for(int i = 0; i < cashierCount; i++) {
            Customer grabbedCustomer = cashiers[i];
            if(grabbedCustomer != null) {
                //System.out.println(cashiers[i].toString());
                //System.out.println("");
                if(grabbedCustomer.getProcessTime() + grabbedCustomer.getBeginProcessTime() <= simTime) {
                    grabbedCustomer.setAtCashier(false);
                    grabbedCustomer.setInQueue(false);
                    cashiers[i] = null;
                    customersServed++;
                }
            }
            if(grabbedCustomer == null && !(waitLine.isEmpty())) {
                grabbedCustomer = waitLine.dequeue();
                cashiers[i] = grabbedCustomer;
                //System.out.println("Cashier " + (i+1) + " is taken");
                grabbedCustomer.setBeginProcessTime(simTime);
                totalQueueTime += grabbedCustomer.getBeginProcessTime()-grabbedCustomer.getEnterQTime();
                if( grabbedCustomer.getBeginProcessTime()-grabbedCustomer.getEnterQTime() >= longestQueueTime) {
                    longestQueueTime =  grabbedCustomer.getBeginProcessTime()-grabbedCustomer.getEnterQTime();
                }
                grabbedCustomer.setAtCashier(true);
                grabbedCustomer.setInQueue(false);
            }

        }
    }
}
