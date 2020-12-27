package Homework4.theBestExpress.dao;

import Homework4.theBestExpress.bean.Express;
import Homework4.theBestExpress.bean.Location;
import Homework4.theBestExpress.viewing.View;

import java.util.Random;


/*
用于存储数据的数据结构和操作方法
 */
public class DataOperation {
    Express[][] goods;
    private int size;

    public int getSize() {
        return size;
    }

    public DataOperation(){
        goods = new Express[10][10];
        size = 0;
    }

    /**
     * 将目标包裹添加到柜子中，位置随机生成
     * @param e 目标包裹
     * @return 是否成功添加
     */
    public boolean add(Express e){
        if (size == 100){
            return false; // 柜子满了，无法添加
        }
        Random random = new Random();
        while(true) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (goods[x][y] == null) {
                goods[x][y] = e;
                e.setLocation(new Location(x,y));
                e.setCode(generateCode()+"");
                size++;
                return true;
            }
        }
    }

    /**
     * 生成不重复的取件码
     * @return 生成的取件码
     */
    public int generateCode(){
        Random random = new Random();
        int code = -1;
        while(true) {
            code = random.nextInt(899999) + 100000;
            if (findByCode(code) == null){
                break;
            }
        }
        return code;

    }

    /**
     * 从柜子中移除目标包裹
     * @param e 需要被移除的包裹
     */
    public void remove(Express e){
        Location lo = e.getLocation();
        goods[lo.getX()][lo.getY()] = null;
        size--;
    }

    /**
     * 根据单号查询快递
     * @param number 要查询的单号
     * @return 返回单号对应的快递，没有则返回null
     */
    public Express findByNumber(String number){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (goods[i][j]!=null && number.equals(goods[i][j].getNumber())){
                    return goods[i][j];
                }
            }
        }
        return null;
    }

    /**
     * 根据输入的取件码，获得对应的快递
     * @param code 目标取件码
     * @return 对应的快递
     */
    public Express findByCode(int code){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (goods[i][j]!=null && (code+"").equals(goods[i][j].getCode())){
                    return goods[i][j];
                }
            }
        }
        return null;
    }

    /**
     * 更新数据，删除旧的快递，添加新的快递
     * @param oldExpress
     * @param newExpress
     * @return
     */
    public boolean update(Express oldExpress, Express newExpress){
        remove(oldExpress);
        add(newExpress);
        return true;
    }


    /**
     * 打印柜子中的所有快件
     * @param v view工具类
     */
    public void browse(View v){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (goods[i][j]!=null) {
                    v.printExpress(goods[i][j]);
                }
            }
        }
    }







}
