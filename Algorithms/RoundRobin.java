import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
    public static void roundRobin(int[] processes, int[] burstTime, int quantum) {
        int n = processes.length;
        int[] remainingTime = new int[n];
        int currentTime = 0;

        for (int i = 0; i < n; i++) {
            remainingTime[i] = burstTime[i];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (remainingTime[i] > quantum) {
                currentTime += quantum;
                remainingTime[i] -= quantum;
                queue.add(i);
            } else {
                currentTime += remainingTime[i];
                remainingTime[i] = 0;
                System.out.println("Process " + processes[i] + " completed at time " + currentTime);
            }
        }
    }

    public static void main(String[] args) {
        int[] processes = {1, 2, 3};
        int[] burstTime = {10, 5, 8};
        int quantum = 2;

        roundRobin(processes, burstTime, quantum);
    }
}
