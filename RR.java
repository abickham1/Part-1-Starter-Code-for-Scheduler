import java.util.*;

public class RR implements Algorithm {
    private Queue<Task> queue;
    private int quantum; // time slice

    public RR(List<Task> tasks) {
        this.queue = new LinkedList<>(tasks);
        //this.quantum = quantum;
    }

    @Override
    public void schedule() {
        System.out.println("Starting Round Robin Scheduling...\n");

        while (!queue.isEmpty()) {
            Task current = pickNextTask();
            int slice = Math.min(current.getBurst(), quantum);
            CPU.run(current, slice);

            current.setBurst(current.getBurst() - slice);
            if (current.getBurst() > 0) {
                // Put back in queue if still needs time
                queue.add(current);
            } else {
                System.out.println("Finished task: " + current.getName());
            }
        }

        System.out.println("\nAll tasks finished (RR).");
    }

    @Override
    public Task pickNextTask() {
        return queue.poll();
    }
}
