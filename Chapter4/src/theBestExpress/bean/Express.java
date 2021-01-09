package theBestExpress.bean;

import java.util.Objects;

/**
 * 快递件类
 */
public class Express {
    private String number;
    private String code;
    private String company;
    private Location location;

    public Express(String number, String code, String company) {
        this.number = number;
        this.code = code;
        this.company = company;
    }

    public Express() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "快递单号："+number+"\t快递公司："+company+"\t取件码："+code;
    }

    //根据快递单号比较两个快递是否相同（快递单号可以唯一确定一个快递）
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Express)) return false;
        Express express = (Express) o;
        return Objects.equals(getNumber(), express.getNumber());
    }

}
