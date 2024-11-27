import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

    private Queue<Integer> directionQueue;
    private Random random;

    // Initializes the queue with default directions
    public CarQueue() {
        directionQueue = new LinkedList<>();
        random = new Random();
        directionQueue.add(0);
        directionQueue.add(2);
        directionQueue.add(1);
        directionQueue.add(3);
        directionQueue.add(0);
    }

    // Adds random directions to the queue in a separate thread
    public void addToQueue() {

        class RandomDirectionTask implements Runnable {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
                        int direction = random.nextInt(4); // Generate direction (0-3)
                        directionQueue.add(direction);
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Thread taskThread = new Thread(new RandomDirectionTask());
        taskThread.start();
    }

    // Removes and returns the front direction from the queue
    public int deleteQueue() {
        return directionQueue.remove();
    }
}
