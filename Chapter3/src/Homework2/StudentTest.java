package Homework2;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-22 16:38
 **/
public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("Jack",21, "boy", "tennis");
        Student s2 = new Student("Jenny",22, "girl", "volleyball");
        Student s3 = new Student("Bob",23, "boy", "video games");
        Student s4 = new Student("Lucy",20, "girl", "dancing");
        Student s5 = new Student("Eric",24, "boy", "basketball");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}

class Student{
    private static String company = "开课吧";
    private static String discipline = "Java学科";
    private String name;
    private int age;
    private String gender;
    private String hobby;

    public Student() {}

    public Student(String name, int age, String gender, String hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }

    public static String getCompany() {
        return company;
    }

    public static void setCompany(String company) {
        Student.company = company;
    }

    public static String getDiscipline() {
        return discipline;
    }

    public static void setDiscipline(String discipline) {
        Student.discipline = discipline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String toString() {
        return "姓名："+name+"\t年龄："+age+"\t性别："+gender+"\t爱好："+hobby+"\t\t公司："+company+"\t\t学科："+discipline;
    }
}
