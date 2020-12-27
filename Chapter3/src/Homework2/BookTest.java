package Homework2;

/*
Book 类
 */
public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Book("鲁滨逊漂流记",120);
        Book b2 = new Book("老人与海",250);
        Book b3 = new Book("简爱",300);
        b1.detail();
        b2.detail();
        b3.detail();
    }
}

class Book {
    private String name;
    private int pageNum;

    public Book(String name, int pageNum) {
        this.name = name;
        if (pageNum >= 200) {
            this.pageNum = pageNum;
        } else {
            this.pageNum = 200;
            System.out.println("页数不能低于200页");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum >= 200) {
            this.pageNum = pageNum;
        }else{
            this.pageNum = 200;
            System.out.println("页数不能低于200页");
        }
    }

    public void detail() {
        System.out.println("书名：" + name + ", 页数" + pageNum);
    }
}
