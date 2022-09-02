package collectiondemo.mapdemo;

import java.util.Comparator;

public class IdKeyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer key1, Integer key2) {
        return key1-key2;
    }
}
