import java.util.LinkedList;

public class QueueRunCode {

    public static void main(String[] args) {
        Queue queueList = new Queue();
        int a = 10;
        int b = 20;

        if(queueList.isEmpty()) {
            System.out.println("hi");
        }
        queueList.enqueue(a);
        queueList.enqueue(b);
        queueList.enqueue(a);
        queueList.enqueue(b);
        queueList.dequeue();
        System.out.print(queueList.size());
        System.out.print(queueList.toString());

    }

}
