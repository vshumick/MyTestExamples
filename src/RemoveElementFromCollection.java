import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class RemoveElementFromCollection {
    public static void main(String[] args) {
        Collection<SomeClass> col = new ArrayList<>();
        col.add(new SomeClass("Object3", 3));
        col.add(new SomeClass("Object5", 5));
        col.add(new SomeClass("Object1", 1));
        col.add(new SomeClass("Object10", 10));
        col.add(new SomeClass("Object99", 99));
        col.add(new SomeClass("Object101", 101));

        SomeClass element = new SomeClass("Object1", 1);

        System.out.println(col.toString());
        deleteElement(col, element);
        System.out.println(col.toString());
    }

    private static void deleteElement(Collection<SomeClass> col, SomeClass element) {
        while (col.contains(element)){
            col.remove(element);
        }
        /*Iterator iterator = col.iterator();
        while (iterator.hasNext()){
            //iterator.next();

            if (iterator.next().equals(element)){
                iterator.remove();
            }
        }*/
    }
}

class SomeClass {
  String name;
  int value;

    public SomeClass(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeClass someClass = (SomeClass) o;
        return value == someClass.value && Objects.equals(name, someClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return '\"' + name + " => " + value + '\"';
    }
}


