package Homework3;

import java.util.Scanner;

/*
出租车计费
 */
public class TexiFee {
    public static void main(String[] args) {
        //invoiceCalculator();
//        System.out.println(totalTime(new Time(3, 55), new Time(2, 12)).toMinute());
//        System.out.println(totalTime(new Time(3, 55), new Time(2, 12)));
//        int morRush = minutesInRushHour(new Time(6,30),new Time(11,30),true);
//        int nightRush = minutesInRushHour(new Time(7,0),new Time(17,30),false);
//        System.out.println(morRush);
//        System.out.println(nightRush);
        Time minInNight = inNight(new Time(0,20), new Time(2,50));
        System.out.println(minInNight);

    }

    public static void invoiceCalculator() {
        Scanner in = new Scanner(System.in);

        int START_FEE = 13;
        double STANDARD_PRICE = 2.3;
        boolean isNight = false;
        int orderFee = 0;
        int FUEL = 1;

        double totalMileage = 0;
        int totalTime = 0; // 单位：分钟
        int lowSpeedTime = 0; // 单位：分钟
        int totalPrice = 0;
        int nightFee = 0;
        int emptyDriveFee = 0;
        int lowSpeedFee = 0;

        System.out.println("请输入总里程数：");
        totalMileage = in.nextDouble();
        System.out.println("请输入乘车总时间：（单位：分钟）");
        totalTime = in.nextInt();
        System.out.println("是否是夜间行驶：（Y/N）");
        isNight = in.next().equalsIgnoreCase("Y");
        System.out.println("是否预约叫车？（Y/N）");
        if (in.next().equalsIgnoreCase("Y")) {
            System.out.println("预约是否在4小时内？（Y/N）");
            if (in.next().equalsIgnoreCase("Y")) {
                orderFee = 5;
            } else {
                orderFee = 6;
            }
        }
        System.out.println("是否有低速行驶？（Y/N）");
        if (in.next().equalsIgnoreCase("Y")) {
            System.out.println("请输入低速行驶时间：（分钟）");
            lowSpeedTime = in.nextInt();
            System.out.println("是否是在早晚高峰？（Y/N）");
            if (in.next().equalsIgnoreCase("Y")) {
                lowSpeedFee = (int) ((lowSpeedTime % 5 > 0 ? lowSpeedTime / 5 + 1 : lowSpeedTime / 5) * 2 * STANDARD_PRICE);
            } else {
                lowSpeedFee = (int) ((lowSpeedTime % 5 > 0 ? lowSpeedTime / 5 + 1 : lowSpeedTime / 5) * 1 * STANDARD_PRICE);
            }
        }

        if (isNight) {
            nightFee = (int) (totalMileage * STANDARD_PRICE * 0.2);
        }

        if (totalMileage > 15) {
            System.out.println("是否往返2公里范围内？（Y/N）");
            if (in.next().equalsIgnoreCase("Y")) {
                emptyDriveFee = 0;
            } else {
                emptyDriveFee = (int) (totalMileage * STANDARD_PRICE * 0.5);
            }
        }

        if (totalMileage < 3) {
            totalPrice = (int) (START_FEE + orderFee + emptyDriveFee + nightFee + FUEL);
        } else {
            totalPrice = (int) (START_FEE + totalMileage * STANDARD_PRICE + orderFee + emptyDriveFee + nightFee + FUEL);
        }

        System.out.println("-----------invoice-----------");
        System.out.println("start fee: 13\n" +
                "total mileage: " + totalMileage + "\n" +
                "order fee: " + orderFee + "\n" +
                "low speed fee: " + lowSpeedFee + "\n" +
                "night fee: " + nightFee + "\n" +
                "empty drive fee: " + emptyDriveFee + "\n" +
                "fuel surcharge: " + FUEL + "\n" +
                "total price:" + totalPrice + "\n");

    }

    /**
     * 根据开始时间和结束时间推算在早晚高峰内的时间
     *
     * @param start 开始时间
     * @param end   结束时间
     * @param morning 判断是否是早上的高峰/晚上的高峰
     * @return 处在高峰时间内的分钟数
     */
    public static int minutesInRushHour(Time start, Time end, boolean morning) {
        //早高峰时间段（分钟）：
        int rushStart = morning?new Time(7, 0).toMinute():new Time(17,0).toMinute();
        int rushEnd = morning?new Time(8, 59).toMinute():new Time(18,59).toMinute();
        int rushDuration = 0;
        if (start.toMinute()>=rushStart&&end.toMinute()<=rushEnd){
            rushDuration = end.toMinute()-start.toMinute();
        }else if(start.toMinute()<rushStart&&end.toMinute()>rushEnd){
            rushDuration = rushEnd - rushStart;
        }else if(start.toMinute()<rushStart && end.toMinute()>rushStart&&end.toMinute()<rushEnd){
            rushDuration = end.toMinute() - rushStart;
        }else if(start.toMinute()>rushStart&&start.toMinute()<rushEnd&&end.toMinute()>rushEnd){
            rushDuration = rushEnd - start.toMinute();
        }
        return rushDuration;
    }


    public static class Time {
        int hour;
        int min;

        public Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }

        public int toMinute() {
            return hour * 60 + min;
        }

        public String toString() {
            return hour + " h " + min + " min";
        }
    }

    /*
    假设乘客坐车的时间不会超过24小时
     */

    /**
     * 返回的是分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 坐车总时间（分钟）
     */
    public static Time totalTime(Time start, Time end) {
        int startMin = start.toMinute();
        int endMin = end.toMinute();
        int subMin = startMin < endMin ? endMin - startMin : endMin + 24 * 60 - startMin;
        return new Time(subMin / 60, subMin % 60);
    }

    /**
     * 夜间行车的时间（分钟）
     * @param start 开始时间
     * @param end 结束时间
     * @return 在夜间行车的分钟数
     */
    public static Time inNight(Time start, Time end){
        int minuteInNight = 0;
        int nightStart = new Time(23,0).toMinute();
        int nightEnd = new Time(4,59).toMinute();
        int midNight = new Time(24,0).toMinute();
        //起止时间在夜间范围内
        if ((start.toMinute()>=nightStart && end.toMinute()<=nightEnd)||(start.toMinute()>=0&&end.toMinute()<=nightEnd) ||
                (start.toMinute()>=nightStart && end.toMinute()<=midNight)){
            int subMin = end.toMinute() - start.toMinute();
            minuteInNight = subMin<0?subMin+24*60:subMin;
        }else if((start.toMinute()<=nightStart&&start.toMinute()>nightEnd) && (end.toMinute()>=nightEnd && end.toMinute()<nightStart)){
        //起止时间在夜间范围外
            minuteInNight = nightEnd-nightStart+24*60;
        }else if((start.toMinute()<nightStart&&start.toMinute()>nightEnd) && (end.toMinute()<nightEnd || end.toMinute()<midNight)){
        //起时间在夜间外，止时间在夜间内
            int subMin = end.toMinute() - nightStart;
            minuteInNight = subMin<0?subMin+24*60:subMin;
        }else if((end.toMinute()>=nightEnd && end.toMinute()<nightStart) && (start.toMinute()>nightStart || start.toMinute()<nightEnd)){
        //起时间在夜间内，止时间在夜间外
            int subMin = nightEnd-start.toMinute();
            minuteInNight = subMin<0?subMin+24*60:subMin;
        }
        return new Time(minuteInNight/60, minuteInNight%60);
    }
}
