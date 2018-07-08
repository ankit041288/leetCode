import java.util.*;

class RandomisezSet {
    List<Integer> list;
    HashMap<Integer, Integer> loc;
    Random r;

    /**
     * Initialize your data structure here.
     */
    public RandomisezSet() {
        loc = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (loc.containsKey(val)) return false;
        list.add(val);
        loc.put(val, list.size() - 1);
        return true;

    }


}