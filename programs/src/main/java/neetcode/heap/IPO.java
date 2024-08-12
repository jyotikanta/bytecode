package neetcode.heap;


import java.util.Collections;
import java.util.PriorityQueue;

class Project implements Comparable<Project>{
    int profit;
    int capital;
    public Project(int profit, int capital){
        this.profit=profit;
        this.capital=capital;
    }
    public int compareTo(Project that){
        return this.capital - that.capital;
    }
}

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minPQ = new PriorityQueue<>();
        //Add all the projects to the min PQ and it will be arranged in ascending order of capital, so when we need element from it the minimum can be polled
        for(int i=0;i<profits.length;i++){
            minPQ.offer(new Project(profits[i],capital[i]));
        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        while(k>0){
            while(!minPQ.isEmpty() && minPQ.peek().capital<=w){
                maxPQ.offer(minPQ.poll().profit);
            }
            if(maxPQ.isEmpty()){//When the project capital is costlier than the capital we have.
                break;
            }
            w+=maxPQ.poll();
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for(int i=9999;i>0;i--){
            s.append(i).append(',');
        }
        System.out.println(s.toString());
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        int k = 2;
        int w = 0;
        IPO ipo = new IPO();
        System.out.println(ipo.findMaximizedCapital(k,w,profits,capital));

    }
}
