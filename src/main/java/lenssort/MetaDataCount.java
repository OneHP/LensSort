package lenssort;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class MetadataCount<T> {

    private T value;
    private int count;
    private int filteredCount;

    public MetadataCount(){

    }

    public MetadataCount(T value, int count, int filteredCount) {
        this.value = value;
        this.count = count;
        this.filteredCount = filteredCount;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFilteredCount() {
        return filteredCount;
    }

    public void setFilteredCount(int filteredCount) {
        this.filteredCount = filteredCount;
    }
}
