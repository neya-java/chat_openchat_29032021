public class homework4 {
    static Object monitor = new Object();
    static volatile int numbers = 5;
    static int n = 1;
    static int counter = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < numbers; i++) {
                synchronized (monitor){
                    while (n != 1) {
                        monitor.wait();
                    }
                    System.out.println("A");
                    n = 2;
                    monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 0; i < numbers; i++) {
                    synchronized (monitor){
                        while (n != 2) {
                            monitor.wait();
                        }
                        System.out.println("B");
                        n = 3;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                for (int i = 0; i < numbers; i++) {
                    synchronized (monitor){
                        while (n != 3) {
                            monitor.wait();
                        }
                        System.out.println("C");

                        //выводит АВСАВСАВС
                        counter++;
                        if (counter < 3 ) {
                            n = 1;
                            monitor.notifyAll();
                        } else {
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
