package ObjectSorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ObjectSorting {

  static class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
      this.name = name;
      this.salary = salary;
    }
  }

  public static void main(String[] args) {
    ArrayList<Employee> arrayList = new ArrayList<Employee>();

    arrayList.add(new Employee("Abir", 10000));
    arrayList.add(new Employee("James", 20000));
    arrayList.add(new Employee("Faria", 15000));
    arrayList.add(new Employee("Anika", 17000));
    arrayList.add(new Employee("Anik", 15000));

    Collections.sort(arrayList, new Comparator<Employee>() {
      @Override
      public int compare(Employee o1, Employee o2) {
        if(o1.salary - o2.salary == 0) {
          return o1.name.compareTo(o2.name);
        }
        return (int)(o1.salary - o2.salary);
      }
    });

    for(Employee e : arrayList) {
      System.out.println(e.name + " " + e.salary);
    }
  }
}