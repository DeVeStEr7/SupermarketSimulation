public class QueueMain<T> {

    T data;
    QueueMain next;
    QueueMain prev;

    public QueueMain(T data) {
        this.data = data;
    }
    public QueueMain(QueueMain<T> prev, T data, QueueMain<T> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public QueueMain<T> getNext() {
        return next;
    }

    public void setNext(QueueMain<T> next) {
        this.next = next;
    }

    public QueueMain<T> getPrev() {
        return prev;
    }

    public void setPrev(QueueMain<T> prev) {
        this.prev = prev;
    }
}
/*
public class QueueMain<T> {
    LinkedList<T> queueList = new LinkedList<T>();

    public QueueMain(LinkedList queueList) {
        queueList = new LinkedList<Object>();
    }

    public void enqueue(T queuer) {
        if(isEmpty()) {
            queueList.addFirst(queuer);
        }
        else {
            queueList.addLast(queuer);
        }


    }

    public void dequeue(T quener) {
        if(isEmpty()) {
            return;
        }
        else {
            if(size(queueList) < 1) {
                queueList.removeFirst();
                //more below
            }
            else {
                queueList.removeFirst();
            }

        }

    }
    public int size(LinkedList arr) {
        return arr.size();
    }

    public boolean isEmpty() {
        return queueList.peek() == null;
    }

    public String toString(LinkedList arr) {
        String list = "";
        for(int i = 0; i < arr.size(); i++) {
            list = arr.get(i) + " ";
        }
        return list;
    }
}

 */

