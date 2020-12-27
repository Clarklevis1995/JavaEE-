package Homework3;

/*
测试MyList
 */
public class MyListTest {
    public static void main(String[] args) {
        MyList myList = new MyList(5);
        myList.add("Hello");
        myList.add("my");
        myList.add("name");
        myList.add("is");
        myList.add("Hello");
        myList.add("world");
        myList.add("Hello");
        System.out.println("\nTest add:--------------");
        System.out.println(myList.toString()+"\tsize "+ myList.getSize());
        System.out.println("\nTest remove index 3:--------------");
        myList.removeIndex(3);
        System.out.println(myList.toString()+"\tsize "+ myList.getSize());
        System.out.println("\nTest remove element: Hello-------");
        myList.removeElement("Hello");
        System.out.println(myList.toString()+"\tsize "+ myList.getSize());
        System.out.println("\nTest get index 2:--------");
        System.out.println(myList.get(2));
    }
}
