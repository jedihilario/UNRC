package TADs;

public class ArrayList<T> implements List {
    private int size;
    private T[] arr;
    private int last;

    public ArrayList (int l) {
        this.size = l;
        this.last = 0;
    }
}
