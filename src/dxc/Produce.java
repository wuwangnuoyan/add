package dxc;

import entity.Count;

public class Produce {
    private Count c;
    private Object lock;
    public Produce() {}
    public Produce(Count c, Object lock) {
        super();
        this.c = c;
        this.lock = lock;
    }
    
    public void add() {
        synchronized(lock) {
            if(c.getCount()<20) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                c.setCount(c.getCount()+1);
                System.out.println(Thread.currentThread().getName()+"数量+1，当前数量为："+c.getCount());
                lock.notify();
            }else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
