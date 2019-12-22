package dxc;

import entity.Count;

public class Consumer {
    private Count c;
    private Object lock;
    public Consumer() {}
    public Consumer(Count c, Object lock) {
        super();
        this.c = c;
        this.lock = lock;
    }
    
    public void sub() {
        synchronized(lock) {
            if(c.getCount()>0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                c.setCount(c.getCount()-1);
                System.out.println(Thread.currentThread().getName()+"消费-1，当前数量为"+c.getCount());
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
