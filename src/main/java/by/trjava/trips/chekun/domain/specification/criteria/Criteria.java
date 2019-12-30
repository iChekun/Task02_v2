package by.trjava.trips.chekun.domain.specification.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<Value> {

    private String groupSearchName = null;

    private Map<String, Value> criteria = new HashMap<String, Value>();

    public Criteria() { }

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchParameter, Value value) {
        criteria.putIfAbsent(searchParameter, value);
    }


    Map<String, Value> getSearchCriteria() {
        Map<String, Value> cloneCriteria = new HashMap<>(criteria);
        return cloneCriteria;
    }
}
