package BookManager.dao;

import BookManager.bean.Book;
import BookManager.bean.Manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 数据操作类
 */
public class DataOperation implements Serializable {
    private ArrayList<Book> bookshelf;
    private int size;
    private HashMap<Integer, Manager> stuffDatabase;

    public ArrayList<Book> getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(ArrayList<Book> bookshelf) {
        this.bookshelf = bookshelf;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<Integer, Manager> getStuffDatabase() {
        return stuffDatabase;
    }

    public void setStuffDatabase(HashMap<Integer, Manager> stuffDatabase) {
        this.stuffDatabase = stuffDatabase;
    }

    public DataOperation() {
        bookshelf = new ArrayList<>();
        size = 0;
        stuffDatabase = new HashMap<>();
    }

    /**
     * 添加新的book
     * @param book 要添加的新book
     * @return 添加成功
     */
    public boolean addBook(Book book){
        bookshelf.add(book);
        size++;
        return true;
    }

    /**
     * 更新图书（通过删除旧的，添加新的）
     * @param oldBook 旧的图书
     * @param newBook 新的图书
     * @return 更新成功
     */
    public boolean update(Book oldBook, Book newBook){
        remove(oldBook);
        addBook(newBook);
        return true;
    }

    /**
     * 删除图书
     * @param book 要删除的图书
     * @return 删除成功
     */
    public boolean remove(Book book){
        bookshelf.remove(book);
        size--;
        return true;
    }

    /**
     * 通过书名查找图书
     * @param name 图书的名字
     * @return 根据名字查找到的图书或null
     */
    public Book search(String name){
        for (Book b:bookshelf
             ) {
            if (b.getName().equals(name)){
                return b;
            }
        }
        return null;
    }

    /**
     * 按照价格降序排序
     */
    public void sortByPriceDown(){
        bookshelf.sort(new PriceDownComparator());
    }

    /**
     * 按照价格升序排列
     */
    public void sortByPriceUp(){
        bookshelf.sort(new PriceUpComparator());
    }

    /**
     * 按照日期排序
     */
    public void sortByDate(){
        bookshelf.sort(new DateComparator());
    }

    /**
     * 遍历整个数组
     */
    public void browse(){
        for (Book book: bookshelf
             ) {
            book.printBook();
        }
    }


}
