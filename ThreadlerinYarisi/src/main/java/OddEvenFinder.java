import com.sun.source.tree.Tree;

import java.util.List;
import java.util.TreeSet;

public class OddEvenFinder implements Runnable {
    public boolean even;
    public boolean odd;
    private TreeSet<Integer> targetList;
    private List<Integer> sourceList;
    public static Object LOCK = new Object();

    public OddEvenFinder(TreeSet<Integer> targetList, List<Integer> sourceList) {
        this.even = false;
        this.odd = false;
        this.targetList = targetList;
        this.sourceList = sourceList;
    }

    @Override
    public void run() {
        if(even){
            for(int target : sourceList){
                if(target % 2 == 0){

                    synchronized (LOCK){
                        targetList.add(target);
                    }
                }
            }
        }

        if(odd){
            for(int target : sourceList){
                if(target % 2 == 1){
                    synchronized (LOCK){
                        targetList.add(target);
                    }
                }
            }
        }
    }

    public TreeSet<Integer> getTargetList() {
        return targetList;
    }

    public void setTargetList(TreeSet<Integer> targetList) {
        this.targetList = targetList;
    }

    public List<Integer> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<Integer> sourceList) {
        this.sourceList = sourceList;
    }
}
