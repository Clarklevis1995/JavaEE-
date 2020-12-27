package Homework3;


/*
编写MyList
 */
public class MyList {
    private Object[] elements;
    private int size;
    private int DEFAULT_CAPACITY = 10;

    public MyList(){
        this(10);
    }

    public MyList(int initialCapacity) {
        if (initialCapacity<0){
            elements = new Object[DEFAULT_CAPACITY];
        }else{
            elements = new Object[initialCapacity];
        }
    }

    /**
     * 向List中添加元素
     * @param obj 要添加的元素
     * @return 返回是否添加成功
     */
    public boolean add(Object obj){
        if (size+1>elements.length){ //如果添加后的长度>属性数组的长度，扩容为1.5倍,原数组元素拷贝过来，原数组引用指向新的引用
            Object[] newElements = new Object[elements.length+(elements.length>>1)];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = obj;

        return true;
    }

    /**
     * 根据下标删除指定位置的数据
     * @param index 要删除的数据的下标
     * @return 返回是否删除成功
     */
    public boolean removeIndex(int index){
        if (size == 0){
            System.out.println("列表为空，无法删除");
            return false;
        }
        if (index<0 || index>=size){
            System.out.println("下标越界");
            return false;
        }else {
            System.arraycopy(elements, index+1, elements, index, size-1-index);
            size--;
        }
        return true;
    }

    /**
     * 通过元素删除
     * @param element 要删除的元素
     * @return 返回是否删除成功
     */
    public boolean removeElement(Object element){
        int sizeCopy = size;
        //从后向前遍历，每找到一个相同的元素，就调用下标删除的方法
        for (int i = size-1; i >= 0; i--) {
            if (elements[i].equals(element)){
                removeIndex(i);
            }
        }
        return sizeCopy == size; //如果前后两次size相同，证明没有删除数据，否则数据删除成功
    }

    /**
     * 根据下标查看元素
     * @param index 要查看元素的下标
     * @return 返回当前下标对应的元素
     */
    public Object get(int index){
        return elements[index];
    }

    /**
     * 返回当前列表的size
     * @return size值
     */
    public int getSize(){
        return size;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            if (i!=size-1){
                result.append(elements[i]);
                result.append(", ");
            }else {
                result.append(elements[i]);
            }
        }
        result.append("]");
        return result.toString();
    }
}
