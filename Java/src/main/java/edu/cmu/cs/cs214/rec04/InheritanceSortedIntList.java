package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

    //     Hints:

    // InheritanceSortedIntList should extend SortedIntList.
    // The SortedIntList contains two methods that add elements, add and addAll.
    // You should override both of these methods to track how many elements have been added.
    // Make sure you check that getTotalAdded works with both add and addAll.
public class InheritanceSortedIntList extends SortedIntList{
    // Write your implementation below with API documentation
    private int totalAdded = 0;
    public InheritanceSortedIntList(){
        super();

    }

    @Override
    public boolean add(int value){
        boolean result = super.add(value);
        if (result) {
            totalAdded++;
        }
        return result;
    }

    @Override
    public boolean addAll(IntegerList list){
        boolean result = super.addAll(list);
        totalAdded += list.size();
        return result;
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}