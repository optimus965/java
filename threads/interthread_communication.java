package threads;
interface runnable {
    void run();
}
class Q {
    int n;
    synchronized int get() {
        System.out.println("GOT:" + n);
        return n;
    }
    synchronized void put(int n) {
        this.n = n;
        System.out.println("put:" + this.n);
    }
}
class producer implements runnable {
    Thread t;
    Q q;
    producer(Q q) {
        this.q = q;
        t = new Thread(this::run, "producer");
    }
    public void run() {
        int i = 0;
        while(true) {
            q.put(i++);
        }
    }
}
class consumer implements runnable {
    Q q;
    Thread t;
    consumer(Q q) {
        this.q = q;
        t  = new Thread(this::run, "consumer");
    }
    public void run() {
        while(true) {
            q.get();
        }
    }
}
class interthread_communication {
    public static void main(String[] args) {
        Q q = new Q();
        producer p = new producer(q);
        consumer c = new consumer(q);
        p.t.start();
        c.t.start();
        System.out.println("press control-c to stop");

    }
}