package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    /**
     * Hints:

        Ensure your class implements the IntegerList interface.
        Create a private SortedIntList instance for delegation.
        Delegate list operations to the SortedIntList instance.
        Make sure you check that getTotalAdded works with both add and addAll.
        After you have implemented the DelegationSortedIntList class, test the instrumentation 
        you just added using tests in DelegationSortedIntListTest class.
     */

    private SortedIntList list;
    private int totalAdded = 0;

    public DelegationSortedIntList(){
        this.list = new SortedIntList();
        this.totalAdded = 0;
    }

    public boolean add(int value){
        boolean result = list.add(value);
        if (result) {
            totalAdded++;
        }
        return result;
    }

    public boolean addAll(IntegerList list){
        boolean result = this.list.addAll(list);
        totalAdded += list.size();
        return result;
    }

    public int getTotalAdded() {
        return totalAdded;
    }

    public boolean removeAll(IntegerList subList) {
        return this.list.removeAll(subList);
    }

    public int get(int index) {
        return this.list.get(index);
    }

    public boolean remove(int num) {
        return this.list.remove(num);
    }

    public int size() {
        return this.list.size();
    }
}