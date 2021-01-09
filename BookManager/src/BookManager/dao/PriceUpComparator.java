package BookManager.dao;

import BookManager.bean.Book;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 按照价格升序的比较器
 */
public class PriceUpComparator implements Comparator<Book> , Serializable {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getPrice() == o2.getPrice()){
            return 0;
        }else if (o1.getPrice()>o2.getPrice()){
            return 1;
        }else {
            return -1;
        }
    }
}
