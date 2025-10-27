Part 1: CPU Scheduling Implementation
Notes:
 You must submit an AI reflection (see end of document)
 This assignment is adapted from the programming project in Chapter
5. I have borrowed exact wording from the textbook with some
modifications.
 You are not allowed to use the Java Collections framework. Your
BinarySearchTree and PriorityQueue classes must be created from
scratch. I will deduct at least 60% if you violate this rule.
 Start early. This is a big project.
I. Overview
This project involves implementing several different process scheduling
algorithms. The scheduler will be assigned a predefined set of tasks and will
schedule the tasks based on the selected scheduling algorithm. Each task is
assigned a priority and CPU burst. The following scheduling algorithms will
be implemented:
 First-come, first-served (FCFS), which schedules tasks in the order in
which they request the CPU.
 Shortest-job-first (SJF), which schedules tasks in order of the length of
the tasks' next CPU burst.
 Priority scheduling, which schedules tasks based on priority.
Priorities range from 1 to 10, where a higher numeric value indicates a
higher relative priority.
II. Implementation
The implementation of this project should be completed in Java, and program
files are provided on Brightspace. These supporting files read in the schedule
of tasks, insert the tasks into a list, and invoke the scheduler.
The schedule of tasks has the form [task name] [priority] [CPU burst],
with the following example format:
T1, 4, 20
T2, 2, 25
T3, 3, 25
T4, 3, 15
T5, 10, 10
Thus, task T1 has priority 4 and a CPU burst of 20 milliseconds, and so forth.
It is assumed that all tasks arrive at the same time, so your scheduler
algorithms do not have to support higher-priority processes preempting
processes with lower priorities. In addition, tasks do not have to be placed
into a queue or list in any particular order.
Implementing SJF and Priority scheduling requires organizing the tasks by
order of burst times and priority, respectively. A useful data structure for this
is a priority queue. The priority queue abstract data type (ADT) supports
the following operations:
 insert(item, priority) – inserts the object item into the queue with the
given priority
 findMin() — returns the item with the smallest priority value
 deleteMin() — removes and returns the item with the smallest
priority value
In SJF scheduling, a process’ associated priority value is its burst time.
Implementations of the above operations should be fast, so as not to add
unnecessary kernel overhead. Array-based binary heaps are traditionally
used to implement the Priority Queue ADT. However, binary search trees
(BST) are more memory-efficient than binary heaps, and they support O(log
n) deletion; deleting an arbitrary node from a heap is O(n).
You will implement a PriorityQueue class for this project, in addition to a
BinarySearchTree class. The PriorityQueue class will have an instance
variable of type BinarySearchTree<Task> which will store the running tasks.
The PriorityQueue class must have methods that implement the above
PriorityQueue ADT operations. Your BinarySearchTree class should have
methods to search, insert, and delete a node with a given key value. The BST
will store Task objects, so you must figure out how to compare objects in Java
(see the Comparator and Comparable tutorial on Brightspace).
The file Driver.java reads in the schedule of tasks, inserts each task into a
Java ArrayList, and invokes the process scheduler by calling the schedule()
method. The following interface identifies a generic scheduling algorithm,
which the different scheduling algorithms will implement:
public interface Algorithm
{
// Implementation of scheduling algorithm
public void schedule();
// Selects the next task to be scheduled
public Task pickNextTask();
}
The schedule() method obtains the next task to be run on the CPU by
invoking the pickNextTask() method and then executes this Task by calling
the static run() method in the CPU.java class.
Required Classes
Completing this project will require writing the following Java classes:
 FCFS.java
 SJF.java
 Priority.java
The above classes must implement the Algorithm.java interface. Additionally,
you must implement the following classes to support SJF and Priority
scheduling:
 BinarySearchTree.java
 PriorityQueue.java
The program is run as follows:
java Driver fcfs schedule.txt
Before proceeding, be sure to familiarize yourself with all Java source files
provided on Brightspace.
