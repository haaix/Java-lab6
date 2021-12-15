package Testing;

import xuankeSystem.Course;
import xuankeSystem.Student;
import xuankeSystem.Teacher;

import java.util.Objects;
import java.util.Scanner;

//定义类
public class Testing {

    public static void main(String[] args)throws Exception{
        //设置课程数组并添加课程
        Course[] cour = new Course[5];
        //Teacher[] tea = new Teacher[5];

        //实例化多个老师对象
        Teacher t1 = new Teacher(1,"张三","男");
        Teacher t2 = new Teacher(2,"李四","男");
        Teacher t3 = new Teacher(3,"王五","男");

        //实例化多个课程对象
        Course c1 = new Course(202101,"C语言","教103",1,"8:00-9:40",120);
        //课程对象添加到课程数组
        cour[0] = c1;
        Course c2 = new Course(202102,"线代","教202",3,"15:30-17:10",90);
        cour[1] = c2;
        Course c3 = new Course(202103,"Web","综0618",5,"13:30-17:10",68);
        cour[2] = c3;
        Course c4 = new Course(202104,"Java","1710",2,"8:00-9:40",60);
        cour[3] = c4;
        Course c5 = new Course(202105,"Python","综0606",4,"10:00-11:40",44);
        cour[4] = c5;

        //给每门课程分配老师
        c1.setTeacher(t1);
        c2.setTeacher(t2);
        c3.setTeacher(t3);
        c4.setTeacher(t2);
        c5.setTeacher(t3);

        //获取控制台的输入
        Scanner in = new Scanner(System.in);

        //界面
        System.out.println("\n********************北京石油化工学院教务处********************\n"+
                "                      请选择您的身份:\n"+
                "                教师系统请按1  学生系统请按2");

        int a = in.nextInt();

        //教师查看课表的操作
        if (a == 1) {

            System.out.println("请输入ID：");
            int id = in.nextInt();
            System.out.println("请输入姓名：");
            String name = in.next();
            System.out.println("请输入性别：");
            String sex = in.next();
            //实例化教师对象
            Teacher tea = new Teacher(id, name, sex);


            //循环课程数组，将某教师的课程添加到教师个人课表数组里
            for (int i = 0; i < cour.length; i++) {
                if (cour[i] == null) {
                    break;
                }
                else {
                    //字符串比较用Objects.equals()，如果老师的名字和课程里老师的名字对应，就导入到这个老师的课表里
                    if (Objects.equals(tea.getName(), cour[i].getTeacher())) {
                        tea.daoru(cour[i]);
                    }
                    else {
                        continue;
                    }
                }
            }
            //输出老师课表
            tea.tea_show();
        }

        //学生操作界面
        if (a == 2) {
            System.out.println("请输入学号：");
            int id = in.nextInt();
            System.out.println("请输入姓名：");
            String name = in.next();
            System.out.println("请输入性别：");
            String sex = in.next();
            Student stu = new Student(id, name, sex);
            System.out.print("你的专业可以选择以下选课程：\n");
            // 显示所有课程信息
            for (int i=0;i<cour.length;i++){
                if(cour[i] == null){
                    break;
                }
                else {
                    System.out.print("课程号："+cour[i].getId());
                    System.out.print(" 课程名："+ cour[i].getName());
                    System.out.print(" 授课教师："+cour[i].getTeacher());
                    System.out.print(" 上课地点："+cour[i].getPlace());
                    System.out.print(" 上课时间：周"+cour[i].getWeek() +" "+ cour[i].getTime());
                    System.out.println(" 课程人数："+cour[i].getStu_num());
                }
            }
            System.out.println("请输入课程号进行选课：");
            int get_id = in.nextInt();

            stu.xuanke(get_id,cour);

            for (int i=0; ;i++){
                System.out.println("继续选课输入“1”，退课输入“2”，查看课表输入“3”，退出“4”");
                int b = in.nextInt();
                if (b == 1){
                    System.out.println("请输入课程号选课：");
                    get_id = in.nextInt();
                    stu.xuanke(get_id,cour);
                }
                else if (b == 2){
                    System.out.println("请输入课程号退课：");
                    get_id = in.nextInt();
                    stu.tuike(get_id);
                }
                else if (b == 3) {
                    stu.stu_show();
                }
                else if (b == 4) {
                    break;
                }
            }
        }
    }
}

