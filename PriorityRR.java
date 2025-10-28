import java.util.*;

public class PriorityRR implements Algorithm {
    private Map<Integer, Queue<Task>> priorityQueues;
    private PriorityQueue<Integer> priorityOrder;
    private int quantum;

    public PriorityRR(List<Task> tasks) {
        //this.quantum = quantum;
        this.priorityQueues = new HashMap<>();
        this.priorityOrder = new PriorityQueue<>((t1, t2) -> Integer.compare(t1, t2));

        // Group tasks by priority level
        for (Task t : tasks) {
            priorityQueues
                    .computeIfAbsent(t.getPriority(), k -> new LinkedList<>())
                    .add(t);
            priorityOrder.insert(t.getPriority(), t.getPriority());
        }
    }

    @Override
    public void schedule() {
        System.out.println("Starting Priority Round Robin Scheduling...\n");

        while (!priorityOrder.isEmpty()) {
            int currentPriority = priorityOrder.deleteMin();
            Queue<Task> q = priorityQueues.get(currentPriority);

            while (!q.isEmpty()) {
                Task current = q.poll();
                int slice = Math.min(current.getBurst(), quantum);
                CPU.run(current, slice);

                current.setBurst(current.getBurst() - slice);
                if (current.getBurst() > 0) {
                    q.add(current);
                } else {
                    System.out.println("Finished task: " + current.getName());
                }
            }

            priorityQueues.remove(currentPriority);
        }

        System.out.println("\nAll tasks finished (Priority RR).");
    }

    @Override
    public Task pickNextTask() {
        // Not used directly — handled in schedule()
        return null;
    }
}

