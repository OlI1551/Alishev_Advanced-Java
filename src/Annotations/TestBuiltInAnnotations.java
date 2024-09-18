package Annotations;

public class TestBuiltInAnnotations {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello from main thread");
    }
}

class MyThread extends Thread {
    @Override
    public void run() { // если что-то добавим - параметры - без сигнатуры, что это переопределение метода -
        // код скомпилируется и это будет просто лишний метод
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello from MyThread");
    }
}
