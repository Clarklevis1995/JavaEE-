package Homework3;

import java.util.Calendar;
import java.util.Scanner;

public class FindTheDayOff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = in.nextInt();
        System.out.println("请输入月：");
        int month = in.nextInt();

        findBreak(year, month);
    }



    public static void findBreak(int year, int month){
        int breakDays = 0;
        int breakDaysInWeekends = 0;
        //第一天放假的日子
        Calendar firstBreak = Calendar.getInstance();
        firstBreak.set(Calendar.YEAR,2020);
        firstBreak.set(Calendar.MONTH,Calendar.FEBRUARY);
        firstBreak.set(Calendar.DAY_OF_MONTH,2);
        //将时间规整化
        firstBreak.set(Calendar.HOUR,0);
        firstBreak.set(Calendar.MINUTE,0);
        firstBreak.set(Calendar.SECOND,0);
        firstBreak.set(Calendar.MILLISECOND,0);


        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, year);
        c1.set(Calendar.MONTH, month-1);//设定为参数月
        c1.set(Calendar.DAY_OF_MONTH,1);//设定成本月的第一天
        //将时间规整化，防止误差
        c1.set(Calendar.HOUR,0);
        c1.set(Calendar.MINUTE,0);
        c1.set(Calendar.SECOND,0);
        c1.set(Calendar.MILLISECOND,0);
        int firstDay = c1.get(Calendar.DAY_OF_WEEK);

        System.out.println("Sun\t\tMon\t\tTue\t\tWed\t\tThu\t\tFri\t\tSat");

        for (int i = 0; i < firstDay-1; i++) {
            System.out.print("\t\t");
        }

        int daysOfMonth = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < daysOfMonth; i++) {
            StringBuilder s = new StringBuilder();
            c1.set(Calendar.DAY_OF_MONTH,i+1);

            if (isFourDayTime(c1.getTimeInMillis(),firstBreak.getTimeInMillis())){
                s.append("[");
                breakDays++;
                if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY||(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)){
                    breakDaysInWeekends++;
                }
            }
            s.append(c1.get(Calendar.DAY_OF_MONTH));
            if (isFourDayTime(c1.getTimeInMillis(),firstBreak.getTimeInMillis())){
                s.append("]");
            }

            if (s.length()<4){
                System.out.print(s.toString()+"\t\t");
            }else {
                System.out.print(s.toString()+"\t");
            }

            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                System.out.println();
            }

        }
        System.out.println("本周休息天数有："+breakDays+"天");
        System.out.println("本周轮到周末休息是："+breakDaysInWeekends+"天");
    }

    public static boolean isFourDayTime(long milli1, long milli2){
        //看看时间差是否是4天的整数倍
        return Math.abs(milli1-milli2)%(4*3600*24*1000) == 0;
    }
}
