package Homework3;

import java.util.Scanner;

/*
石头剪刀布游戏
 */
public class GuessGame {
    //1-平局，2-人胜， 3-人输
    int manCount;
    int robotCount;

    public void play() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入你想玩的轮数：");
        int n = in.nextInt();
        Robot r = new Robot();
        while(n>0){
            System.out.println("请输入你的选择：（1.剪刀，2.石头，3.布）");
            int i = in.nextInt();
            String robotGuess = r.guess();
            String myGuess = "";
            switch(i){
                case 1: myGuess = "剪刀"; break;
                case 2: myGuess = "石头"; break;
                case 3: myGuess = "布"; break;
            }
            String compare = "";
            switch (judge(myGuess, robotGuess)){
                case 1: compare = "--";break;
                case 2: compare = "->";manCount++;break;
                case 3: compare = "<-";robotCount++;break;
            }
            System.out.println("你的选择\t"+"\t机器人的选择");
            System.out.println(myGuess+"\t"+compare+"\t"+robotGuess+"\n");
            n--;
        }
        System.out.println("游戏结束-------------");
        System.out.println("你的积分\t\t机器人积分\n"+manCount+"\t\t\t"+robotCount);
        String result = "";
        if (manCount == robotCount) result = "平局";
        else if(manCount>robotCount) result = "你赢了";
        else result = "你输了";
        System.out.println("最终结果是："+result);
    }

    public int judge(String man, String robot){
        if (man.equals(robot)){
            return 1;
        }
        if (man.equals("剪刀")) return robot.equals("石头")?3:2;
        if (man.equals("石头")) return robot.equals("布")?3:2;
        if (man.equals("布")) return robot.equals("剪刀")?3:2;
        return -1;
    }
}
