package Java.lab12;

class Counter {
    int count = 0;

    public void increment() {
        count += 5000;
        System.out.println("Incremented by 5000, current value: " + count);
    }

    public void decrement() {
        count -= 3000;
        System.out.println("Decremented by 3000, current value: " + count);
    }

    public int getCount() {
        return count;
    }
}

class CounterIncrement extends Thread {
    private Counter counter;

    public CounterIncrement(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
        System.out.println("Executing Increment Counter");
    }
}

class CounterDecrement extends Thread {
    private Counter counter;

    public CounterDecrement(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.decrement();
        System.out.println("Executing Decrement Counter");
    }
}

public class Threads {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterIncrement incrementer = new CounterIncrement(counter);
        CounterDecrement decrementer = new CounterDecrement(counter);

        incrementer.start();
        decrementer.start();
        
        System.out.println("Current count value (without join): " + counter.getCount());
        
        // decrementer.run();
        // incrementer.run();
        try{
            incrementer.join();
            decrementer.join();
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Current count value (after joining): " + counter.getCount());
    }
}