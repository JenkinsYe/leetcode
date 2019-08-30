import java.util.*;

public class LeetCode56 {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, (o1, o2)-> o1.start - o2.start);
        List<Interval> list = new LinkedList<>();
        for(Interval temp : intervals){
            if(list.isEmpty() || ((LinkedList<Interval>) list).getLast().end < temp.start){
                list.add(temp);
            }else{
                ((LinkedList<Interval>) list).getLast().end =
                        Math.max(((LinkedList<Interval>) list).getLast().end, temp.end);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2,6);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(15, 18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        System.out.println(leetCode56.merge(intervals).toString());
    }
}

class Interval{
    int start;
    int end;
    Interval(){start = 0; end = 0;}
    Interval(int s, int e){
        start = s;
        end = e;
    }
    @Override
    public String toString(){
        return "[" + this.start + ", " + this.end + "]";
    }
}
