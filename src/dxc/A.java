package dxc;

public class A extends Thread{
    private String name;
    public A(String name) {
        this.name=name;
    }
    @Override
    public void run() {
        for(int i=0;i<=50;i++) {
            System.out.println(name+":"+i);
            if(i==30) {
                this.yield();
            }
        }
      
    }
}
