import java.util.*;

public class FCFS implements Algorithm {
    private List<Task> queue;

    public FCFS(List<Task> task){
        this.queue = new ArrayList<>(task);
    }

    @Override
    public void schedule(){
        System.out.println("Starting First-Come, First-Served Scheduling...\n");
        while(!queue.isEmpty()){
            Task next = pickNextTask();
            int slice = next.getBurst(); //run for the task's full burst time
            CPU.run(next, slice);
            System.out.println("Finished task: " + next.getName() + "\n");

        }
        System.out.println("All tasks finished (FCFS).");
    }

    @Override
    public Task pickNextTask(){
        return queue.remove(0); // get(0) returns 1st element but doesn't remove it, remove(0) does both actions
    }

}
