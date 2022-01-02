package threads;
interface runnable1 {
    void run();}
class Q1 {
    int n;
    boolean value = true;
    synchronized void put(int n1) {
        while (!value)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted caught");
            }
            this.n = n1;
            value = false;
            System.out.println("the values has been entered:" + this.n);
            notify();
    }
    synchronized void get() {
        while (value)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("the Interrupton caught");
            }
            value  = true;
            System.out.println("GOT:" + this.n);
            notify();

    }
}
class producer1 implements runnable1 {
    Q1 q;
    Thread t;
    producer1(Q1 q) {
        this.q = q;
        t  = new Thread(this::run, "producer");
    }
    public void run() {
        int i = 0;
        while(true) {
            q.put(i++);
        }
    }
}
class consumer1 implements runnable1 {
    Q1 q;
    Thread t;
    consumer1(Q1 q) {
        this.q  = q;
        t = new Thread(this::run, "consumer");
    }
    public void run() {
        while(true) {
            q.get();
        }
    }
}
class interthread2 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        producer1 p = new producer1(q1);
        consumer1 c =new consumer1(q1);
        p.t.start();
        c.t.start();
        System.out.println("press control-c to stop");
    }
}

