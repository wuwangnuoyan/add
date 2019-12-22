package test;

import dxc.Consumer;
import dxc.Produce;
import entity.Count;

public class Test2 {
    public static void main(String[] args) {
        Count c = new Count();
        c.setCount(20);
        Object lock = new Object();
        Consumer consumer = new Consumer(c,lock);
        Produce produce = new Produce(c,lock); 
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                   consumer.sub(); 
                }
            }
        },"c").start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                   produce.add();
                }
            }
        },"p").start();
        
//        Thread pThread[] = new Thread[2];
//        Thread cThread[] = new Thread[2];
//        
//        for(int i=0;i<2;i++) {
//            pThread[i] = new Thread(()->{
//                while(true) {
//                    produce.add();
//                }
//            },"生产者"+(i+1));
//            cThread[i] = new Thread(()->{
//                while(true) {
//                    consumer.sub();
//                }
//            },"消费者"+(i+1));
//        }
//        for(int i=0;i<2;i++) {
//            pThread[i].start();
//            cThread[i].start();       
//        }
    }
   
}
