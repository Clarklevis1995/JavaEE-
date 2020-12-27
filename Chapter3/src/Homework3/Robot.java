package Homework3;

import java.util.Random;

/*
和你一起猜拳的机器人
 */
public class Robot {
    public String guess(){
        int ran = (int)(Math.random()*10);
        switch (ran%3){
            case 0: return "石头";
            case 1: return "剪刀";
            case 2: return "布";
        }
        return null;
    }
}
