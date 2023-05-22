public class name_to_task_2 implements Comparable<name_to_task_2> {
    public String Name;
    public int Count;

    public name_to_task_2(String name, int count) {
        Name = name;
        Count = count;
    }

    @Override
    public int compareTo(name_to_task_2 o) {
        if (this.Count > o.Count)
            return -1;
        else if (this.Count < o.Count)
            return 1;
        if (this.Name.compareTo(o.Name) > 0)
            return 1;
        else if (this.Name.compareTo(o.Name) < 0)
            return -1;
        return 0;
    }
}
