import java.sql.SQLOutput;

public class MyList<T> {
    private int capacity;
    private int index;
    private Object[] list;

    public MyList() {
        this.capacity = 10;
        list = new Object[capacity];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        list = new Object[capacity];

    }

    public int size()
    {
        int size = 0;
        for(Object o : list) {
            if(o == null)
            {
                return size;
            }
            size++;
        }
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void add(T data)
    {
        int index = 0;
        for(Object o : this.list)
        {
            if(o == null){
                break;
            }
            index++;
        }

        if(index == (this.capacity - 1)){
            increaseArrayLength();
        }

        this.list[index] = data;
    }

    public Object get(int index)
    {
        if(index<0 || index > capacity - 1)
        {
            return null;
        }

        return list[index];
    }

    public int indexOf(T data)
    {
        int index = 0;
        for(Object temp : list){
            if(temp == data){
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(T data)
    {
        int index = list.length - 1;
        for(int i = index; i >= 0 ; i--){
            if(list[i] == data){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty()
    {
        for(int i=0; i < capacity; i++)
        {
            if(list[i] != null){
                return false;
            }
        }
        return true;
    }

    public T[] toArray()
    {
        return (T[]) list;
    }

    public void clear()
    {
        for(int i=0; i < capacity; i++)
        {
            list[i] = null;
        }
    }

    public MyList<T> subList(int start, int finish)
    {
        MyList<T> myList = new MyList<>();
        for(int i = start; i <= finish; i++){
            myList.add((T) list[i]);
        }

        return myList;
    }

    public Object remove(int index)
    {
        if(index<0 || index > capacity - 1)
        {
            return null;
        }
        Object removedItem = list[index];
        list[index] = null;
        for(int i = index; i < capacity; i++){
            list[index] = list[index + 1];
            if(list[index + 1] == null){
                break;
            }
            if(i == capacity - 1){
                list[i] = null;
            }
        }

        return removedItem;
    }

    public Object set(int index, T data)
    {
        if(index<0 || index > capacity - 1)
        {
            return null;
        }

        list[index] = data;
        return list[index];
    }

    public String toString()
    {
        String toString = "[";
        for(Object o : list)
        {
            if(o == null)
            {
                continue;
            }
            toString += o.toString() + ",";
        }
        if(!toString.contains(","))
        {
            toString += "]";
            return toString;
        }
        String result = toString.substring(0, toString.length()-1);
        result += "]";
        return result;
    }

    public boolean contains(T data)
    {
        for(Object o : list)
        {
            if(o == data)
            {
                return true;
            }
        }
        return false;
    }

    private void increaseArrayLength()
    {
        this.capacity = capacity * 2;
        Object[] list2 = new Object[capacity];
        int index = 0;
        for(Object o : this.list)
        {
            list2[index] = o;
            index++;
        }

        this.list = list2;
    }

}
