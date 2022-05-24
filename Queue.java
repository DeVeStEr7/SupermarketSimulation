public class Queue<T> {
    QueueMain<T> head;
    QueueMain<T> tail;
    int counter = 0;

    public Queue() {

    }

    public void enqueue(T data) {
        if (head == null) {
            head = new QueueMain<T>(data);
            tail = head;
        } else {
            QueueMain<T> newNode = new QueueMain<T>(tail, data, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        counter++;
    }

    public String toString() {
        String a = " ";
        QueueMain<T> currentNode = head;
        while (currentNode.getNext() != null) {
            a += currentNode.getData() + " <-> ";
            currentNode = currentNode.getNext();
        }
        a += currentNode.getData();
        return a;
    }

    public T dequeue() {
        T dataToReturn = head.getData();
        if(size() == 1) {
            //System.out.print("running");
            head = null;
            counter--;
            return dataToReturn;
        }
        QueueMain<T> tempNode = head;
        head = head.getNext();
        head.setPrev(null);
        tempNode.setNext(null);
        counter--;
        return dataToReturn;
    }

    public int size() {
        return counter;
    }

    public boolean isEmpty() {
        return head == null;
        /*
        QueueMain<T> currentNode = head;
        while(currentNode.getNext() != null) {
            if(currentNode == null) {
                return false;
            }
        }

         */
    }
}