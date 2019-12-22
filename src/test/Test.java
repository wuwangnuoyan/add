package test;

import dxc.A;

public class Test {
    public static void main(String[] args) {
        A a1 = new A("A");
        A a2 = new A("B");
        a1.start();
        a2.start();
    }
}
