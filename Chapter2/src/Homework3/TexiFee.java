package Homework3;

import java.util.Scanner;

/*
出租车计费
 */
public class TexiFee {
    public static void main(String[] args) {
        invoiceCalculator();
    }

    public static void invoiceCalculator() {
        Scanner in = new Scanner(System.in);

        int START_FEE = 13;
        double STANDARD_PRICE = 2.3;
        int orderFee = 0;
        int FUEL = 1;

        double totalMileage = 0;
        Time totalTime = null;
        int lowSpeedTime = 0; // 单位：分钟
        int totalPrice = 0;
        int nightFee = 0;
        int emptyDriveFee = 0;
        int lowSpeedFee = 0;
        int lowSpeedDuringRush = 0;

        System.out.println("请输入总里程数：");
        totalMileage = in.nextDouble();

        System.out.println("请输入起步时间：（格式：00:00）");
        String[] startTimeString = in.next().split(":");
        Time startTime = new Time(Integer.parseInt(startTimeString[0]), Integer.parseInt(startTimeString[1]));
        System.out.println("请输入下车时间：（格式：00:00）");
        String[] endTimeString = in.next().split(":");
        Time endTime = new Time(Integer.parseInt(endTimeString[0]), Integer.parseInt(endTimeString[1]));
        int duringTime = ((endTime.toMinute() + 24 * 60) - startTime.toMinute()) % (24 * 60);
        totalTime = new Time(duringTime / 60, duringTime % 60);
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
            System.out.println("请输入低速行驶开始时间：（格式：00:00）");
            String[] lowSpeedStartString = in.next().split(":");
            Time lowSpeedStart = new Time(Integer.parseInt(lowSpeedStartString[0]), Integer.parseInt(lowSpeedStartString[1]));

            System.out.println("请输入低速行驶结束时间：（格式：00:00）");
            String[] lowSpeedEndString = in.next().split(":");
            Time lowSpeedEnd = new Time(Integer.parseInt(lowSpeedEndString[0]), Integer.parseInt(lowSpeedEndString[1]));

            lowSpeedTime = lowSpeedEnd.toMinute() - lowSpeedStart.toMinute();

            //早高峰时间(分钟)
            lowSpeedDuringRush = minutesInRushHour(lowSpeedStart, lowSpeedEnd, true) + minutesInRushHour(lowSpeedStart, lowSpeedEnd, false);

            //总的低速花销 = (（低速时间/5）*1 + （早高峰时间+晚高峰时间）/5) * 基本单价
            lowSpeedFee = (int) (Math.ceil(lowSpeedTime / 5.0) + Math.ceil((lowSpeedDuringRush) / 5.0) * STANDARD_PRICE);
        }


        if (totalMileage > 15) {
                emptyDriveFee = (int) ((totalMileage-15) * STANDARD_PRICE * 0.5);
        }

        System.out.println("夜间行驶里程？（km）");
        int nightMileage = in.nextInt();

        nightFee = (int)(Math.round (nightMileage) * STANDARD_PRICE * 0.2);


        if (totalMileage < 3) {
            totalPrice = (int) Math.round(START_FEE + orderFee + emptyDriveFee + nightFee + FUEL);
        } else {
            totalPrice = (int) Math.round(START_FEE + totalMileage * STANDARD_PRICE + orderFee + emptyDriveFee + nightFee + FUEL + lowSpeedFee);
        }

        System.out.println("-----------invoice-----------");
        System.out.println(
                "start fee: 13\n" +
                        "start time: " + startTime.toString() + "\n" +
                        "end time: " + endTime.toString() + "\n" +
                        "total duration time: " + totalTime.toString() + "\n" +
                        "total mileage: " + totalMileage + "\n" +
                        "order fee: " + orderFee + "\n" +
                        "low speed duration: " + lowSpeedTime + "\n" +
                        "----low speed rush hour: " + lowSpeedDuringRush + "\n" +
                        "low speed fee: " + lowSpeedFee + "\n" +
                        "night duration time:" + inNight(startTime, endTime).toString() + "\n" +
                        "night fee: " + nightFee + "\n" +
                        "empty drive fee: " + emptyDriveFee + "\n" +
                        "fuel surcharge: " + FUEL + "\n" +
                        "total price:" + totalPrice + "\n");
    }

    /**
     * 根据开始时间和结束时间推算在早晚高峰内的时间
     *
     * @param start   开始时间
     * @param end     结束时间
     * @param morning 判断是否是早上的高峰/晚上的高峰
     * @return 处在高峰时间内的分钟数
     */
    public static int minutesInRushHour(Time start, Time end, boolean morning) {
        //早高峰时间段（分钟）：
        int rushStart = morning ? new Time(7, 0).toMinute() : new Time(17, 0).toMinute();
        int rushEnd = morning ? new Time(8, 59).toMinute() : new Time(18, 59).toMinute();
        int rushDuration = 0;
        if (start.toMinute() >= rushStart && end.toMinute() <= rushEnd) {
            rushDuration = end.toMinute() - start.toMinute();
        } else if (start.toMinute() < rushStart && end.toMinute() > rushEnd) {
            rushDuration = rushEnd - rushStart;
        } else if (start.toMinute() < rushStart && end.toMinute() > rushStart && end.toMinute() < rushEnd) {
            rushDuration = end.toMinute() - rushStart;
        } else if (start.toMinute() > rushStart && start.toMinute() < rushEnd && end.toMinute() > rushEnd) {
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
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 在夜间行车的分钟数
     */
    public static Time inNight(Time start, Time end) {
        int minuteInNight = 0;
        int nightStart = new Time(23, 0).toMinute();
        int nightEnd = new Time(4, 59).toMinute();
        int midNight = new Time(24, 0).toMinute();

        if (start.toMinute() < end.toMinute()) {
            if (start.toMinute() > nightStart && end.toMinute() < nightEnd) {//在夜间之外
                minuteInNight = 0;
            } else if (start.toMinute() < nightEnd && end.toMinute() > nightEnd && end.toMinute() < nightStart) {//起点小于5点，终点小于23点大于5点
                minuteInNight = nightEnd - start.toMinute();
            } else if (end.toMinute() <= nightEnd) {//起点终点都在0-5点之内
                minuteInNight = end.toMinute() - start.toMinute();
            } else if (end.toMinute() > nightStart) {
                if (start.toMinute() < nightStart && start.toMinute() > nightEnd) {
                    minuteInNight = end.toMinute() - nightStart;
                } else if (start.toMinute() < nightEnd) {
                    minuteInNight = (end.toMinute() - nightStart) + (nightEnd - start.toMinute());
                }
            } else if (start.toMinute() >= nightStart && end.toMinute() <= midNight) {
                minuteInNight = end.toMinute() - start.toMinute();
            }
        } else {
            if (start.toMinute() >= nightStart && start.toMinute() < midNight && end.toMinute() >= 0 && end.toMinute() <= nightEnd) {
                minuteInNight = end.toMinute() + 24 * 60 - start.toMinute();
            } else if (start.toMinute() > nightEnd && start.toMinute() < nightStart && end.toMinute() >= 0 && end.toMinute() <= nightEnd) {
                minuteInNight = end.toMinute() + 24 * 60 - nightStart;
            }
        }
        return new Time(minuteInNight / 60, minuteInNight % 60);
    }
}
