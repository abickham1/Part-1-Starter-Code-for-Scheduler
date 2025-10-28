import java.util.*;

public class SJF implements Algorithm{
    private PriorityQueue queue;

    public SJF(List<Task> task){
        queue = new PriorityQueue(Comparator.comparingInt(Task::getBurst));
        for(Task t : task){
            queue.insert(t, t.getBurst());
        }
    }

    @Override
    public void schedule(){
        System.out.println("Starting Shortest-Job-First Scheduling...\n");
        while(!queue.isEmpty()){
            Task next = pickNextTask();
            int slice = next.getBurst();
            CPU.run(next, slice);
            System.out.println("Finished task: " + next.getName() + "\n");
        }
        System.out.println("All tasks finished (SJF).");
    }
    @Override
    public Task pickNextTask() {
        return (Task) queue.deleteMin(); // smallest burst time = next task
    }
}
