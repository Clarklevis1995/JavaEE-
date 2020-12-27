package Homework3;

import java.util.Scanner;

/*
人工智障训练任务
 */
public class Homework_6 {
    public static void main(String[] args) {
        //通过Scanner获得控制台输入
        Scanner in = new Scanner(System.in);
        //建立question变量用来接收用户的输入，可以初始化为空字符串
        String question = "";
        //判断输入的内容是不是“滚”，如果是则终止循环，否则继续循环
        while(!"滚".equalsIgnoreCase(question)){
            //桶过扫描器对象的next方法获得用户的字符串输入
            question = in.next();
            //替换用户输入中的 “吗” 为空字符串：删除 “吗”
            question = question.replace("吗","");
            //替换字符串中的 “我” 为 “我也”
            question = question.replace("我","我也");
            //替换问号为感叹号，注意如果输入的是中文对话，要用中文的标点符号
            question = question.replace("？","！");
            //打印出经过修改的对话
            System.out.println(question);
        }
        //循环中断，说明你对AI说了“滚”，AI向你告别
        System.out.println("拜拜了您内！");
    }
}
