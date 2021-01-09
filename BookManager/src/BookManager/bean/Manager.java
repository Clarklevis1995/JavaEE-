package BookManager.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * 管理员
 */
public class Manager implements Serializable {
    private int stuffNo;
    private String password;

    public Manager(int stuffNo, String password) {
        this.stuffNo = stuffNo;
        this.password = password;
    }

    public Manager() {
    }

    public int getStuffNo() {
        return stuffNo;
    }

    public void setStuffNo(int stuffNo) {
        this.stuffNo = stuffNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        Manager manager = (Manager) o;
        return getStuffNo() == manager.getStuffNo() &&
                Objects.equals(getPassword(), manager.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStuffNo(), getPassword());
    }
}
