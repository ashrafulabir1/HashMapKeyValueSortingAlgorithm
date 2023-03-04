import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapKeyValueSortingAlgorithm {

  public static <Key,Value extends Comparable<Value>> Map<Key,Value > sortByValue(Map<Key, Value> map) {
    List<Map.Entry<Key, Value>> list = new LinkedList<>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Key, Value>>() {

      @Override
      public int compare(Map.Entry<Key, Value> Object1, Map.Entry<Key, Value> Object2) {
        return Object2.getValue().compareTo(Object1.getValue());
      }
    });

    Map<Key, Value> result = new LinkedHashMap<>();
    for (Iterator<Map.Entry<Key, Value>> it = list.iterator(); it.hasNext();) {
      Map.Entry<Key, Value> entry =  it.next();
      result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }

  public static void main(String[] args) {

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    map.put("Abir", 1);
    map.put("Jon", 2);
    map.put("Abed", 1);
    map.put("King", 7);
    map.put("Rova", 3);
    map.put("Piong", 4);

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.println("Key is:" + entry.getKey() + " with value:"
          + entry.getValue());
    }

    Map<String, Integer> sortedMap = sortByValue(map);

    System.out.println();
    
    for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
      System.out.println("Key is:" + entry.getKey() + " with value:"
          + entry.getValue());
    }
  }
}