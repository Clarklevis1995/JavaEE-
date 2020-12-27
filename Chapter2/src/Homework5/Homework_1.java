package Homework5;

import java.util.Random;
import java.util.Scanner;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-21 17:46
 **/
public class Homework_1 {
    static Scanner in = new Scanner(System.in);
    static int size;
    static int[] expressNums = new int[50];//假设柜子只能存放50个
    static String[] expressComps = new String[50];
    static int[] tokenCodes = new int[50];
    public static void main(String[] args) {
        System.out.println();
        while(true) {
            System.out.println("=====欢迎使用快递柜=====");
            System.out.println("请输入您的身份：1-快递员，2-用户");
            int role = in.nextInt();
            if (role == 1) {
                deliverMan();
            }else if(role == 2){
                customer();
            }else {
                System.out.println("输入错误请重试");
            }
        }
    }

    public static void deliverMan(){
        System.out.println("请选择操作：1-存快递 2-删除快递 3-修改快递信息 4-查看所有快递");
        switch (in.nextInt()){
            case 1: {
                System.out.println("请输入快递单号");
                int eNum = in.nextInt();
                expressNums[size] = eNum;
                System.out.println("请输入空司名称");
                String compName = in.next();
                expressComps[size] = compName;
                int code = (int)(Math.random()*900+101);//生成100-1000的随机数
                tokenCodes[size] = code;
                System.out.println("快递已存入：取件码是："+code);
                size++;
            }break;
            case 2:{
                System.out.println("请输入要删除的快递单号");
                int eNum = in.nextInt();
                if (search(eNum)!=-1){
                    delete(search(eNum));
                    System.out.println("删除成功");
                }else{
                    System.out.println("未找到快递");
                }
            }break;
            case 3:{
                System.out.println("请输入要修改的快递编号");
                int eNum = in.nextInt();
                if (search(eNum)!=-1){
                    update(search(eNum));
                }else {
                    System.out.println("未找到该快递");
                }
            }break;
            case 4:{
                System.out.println("所有快递信息如下：");
                showAllPackages();
            }
        }
    }

    public static void customer(){
        System.out.println("请输入取件码：");
        int code = in.nextInt();
        if (search2(code)!=-1){
            delete(search2(code));
            System.out.println("取件成功");
        }else {
            System.out.println("未找到该快递");
        }
    }

    /**
     * 用快递单号查快递
     * @param eNum 快递单号
     * @return
     */
    public static int search(int eNum){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(expressNums[i]==eNum){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 取件码查快递
     * @param code 取件码
     * @return
     */
    public static int search2(int code){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(tokenCodes[i]==code){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 根据存储位置删除快递
     * @param index 存储位置下标
     */
    public static void delete(int index){
        for (int i = index; i < size; i++) {
            expressNums[i] = expressNums[i+1];
        }
        expressNums[size] = 0;

        for (int i = index; i < size; i++) {
            expressComps[i] = expressComps[i+1];
        }
        expressComps[size] = null;

        for (int i = index; i < size; i++) {
            tokenCodes[i] = tokenCodes[i+1];
        }
        tokenCodes[--size] = 0;
    }

    /**
     * 根据存储位置更新快递信息
     * @param index 存储位置的下标
     */
    public static void update(int index){
        System.out.println("请输入新的快递单号：");
        expressNums[index] = in.nextInt();
        System.out.println("请输入新的公司名称：");
        expressComps[index] = in.next();
        System.out.println("修改成功");
    }
    public static void showAllPackages(){
        System.out.println("快递单号\t公司名称\t取件码");
        if (size==0){
            System.out.println("快递柜为空");
        }
        for (int i = 0; i < size; i++) {
            System.out.println(expressNums[i]+"\t"+expressComps[i]+"\t"+tokenCodes[i]);
        }
    }

}
