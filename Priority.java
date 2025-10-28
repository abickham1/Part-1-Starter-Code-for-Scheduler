import java.util.*;

public class Priority implements Algorithm{
    private PriorityQueue<Task> queue;

    public Priority(List<Task> task){
        queue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getPriority(), t1.getPriority()));
        for(Task t : task){
            queue.insert(t, t.getPriority());
        }
    }

    @Override
    public void schedule() {
        System.out.println("Starting Priority Scheduling...\n");

        while (!queue.isEmpty()) {
            Task next = pickNextTask();
            int slice = next.getBurst();
            CPU.run(next, slice);
            System.out.println("Finished task: " + next.getName() + "\n");
        }

        System.out.println("All tasks finished (Priority).");
    }

    @Override
    public Task pickNextTask() {
        return queue.deleteMin(); // smallest priority value = highest priority
    }

}
