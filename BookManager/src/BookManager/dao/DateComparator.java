package BookManager.dao;

import BookManager.bean.Book;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 按照日期排序的比较器
 */
public class DateComparator implements Comparator<Book>, Serializable {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getDate().equals(o2.getDate())){
            return 0;
        }else if(o1.getDate().isBefore(o2.getDate())){
            return 1;
        }else {
            return -1;
        }
    }
}
