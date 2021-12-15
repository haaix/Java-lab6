package xuankeSystem;

import java.io.*;
import java.util.Arrays;

//定义学生类
public class Student extends Father {
    Course[] stu_cour  = new Course[5];//储存学生选的课程
    private int i;
    private File f = new File("d:" + File.separator + "Java\\Java课程\\lab6-文件输入输出\\文本" + File.separator + this.getName() + "的课表.txt");
    //构造函数
    public Student(int id, String name, String sex) {
        super(id,name,sex);
    }

//    int i;
    //学生选课函数
    public void xuanke(int course_id, Course[] stu_c) {
        //输入的课程号与课组里某门课的课号相等，则将该门课添加到学生的个人课程数组里
            int q = 0;
            for (int a = 0; a < stu_c.length; a++) {
                if (stu_c[a] == null) {
                    break;
                }
                else if (course_id == stu_c[a].getId()) {
                    for (int b=0; b<stu_cour.length; b++){
                        if(stu_cour[0] == null) {
                            stu_cour[i] = stu_c[a];
                            i++;
                            System.out.println("您已成功选上该课程！");
                            break;
                        }
                        else if(stu_cour[0] != null){
                            if(course_id == stu_cour[b].getId()){
                                System.out.println("重复选择，请重新操作！");
                                break;
                            }
                            else if (stu_cour[b] == null){
                                break;
                            }

                            else{
                                stu_cour[i] = stu_c[a];
                                i++;
                                System.out.println("您已成功选上该课程！");
                                break;
                            }
                        }
                    }
                    q = 1;
                    break;
                }
                else {
                    continue;
                }
            }
            if(q == 0){
                System.out.println("课程号输入错误，请重新操作！");
            }
        }


    //退课函数
    public void tuike(int id)throws Exception{
        //数组a用来储存学生退课后的课程
        Course[] a = new Course[5];
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Course[] stu_cour = (Course[]) in.readObject();
        //输入的课号与学生个人课组里某门课的课号相等，则将除该门课以外的其他课添加到数组a里，再把数组a又给stu_cour
        for(int i=0, j=0; i<stu_cour.length; i++) {
            //如果学生选的课不足5门，则跳过数组中的空值
            if (stu_cour[i] == null) {
                continue;
            }
            else {
                if (id == stu_cour[i].getId()) {
                    continue;
                }
                else {
                    a[j] = stu_cour[i];
                    j++;
                }
            }
        }
        stu_cour = a;
        System.out.println("您已成功退出该课程!");
        stu_show(stu_cour);
    }


    public void write() throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f)); //输出流：往外输出
        System.out.println(Arrays.toString(stu_cour));
        out.writeObject(stu_cour);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        System.out.println(in.readObject().toString());
        out.close();
    }


    public void stu_show(Course[] stu_cour)throws Exception{
        System.out.println("学生课表");
        //循环学生个人课程数组，依次输出每门课程信息
        for(int i=0;i<=this.i;i++) {
            if (stu_cour[i] == null) {
                continue;
            }
            else {
                System.out.print("课程号："+stu_cour[i].getId());
                System.out.print(" 课程名："+ stu_cour[i].getName());
                System.out.print(" 授课教师："+stu_cour[i].getTeacher());
                System.out.print(" 上课地点："+stu_cour[i].getPlace());
                System.out.print(" 上课时间：周"+stu_cour[i].getWeek() +" "+ stu_cour[i].getTime());
                System.out.println(" 课程人数："+stu_cour[i].getStu_num());
            }
        }
    }


    //显示学生课表函数
    public void stu_show()throws Exception{
        write();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Course[] stu_cour = (Course[]) in.readObject();
        System.out.println("学生课表");
        //循环学生个人课程数组，依次输出每门课程信息
        for(int i=0;i<=this.i;i++) {
            if (stu_cour[i] == null) {
                continue;
            }
            else {
                System.out.print("课程号："+stu_cour[i].getId());
                System.out.print(" 课程名："+ stu_cour[i].getName());
                System.out.print(" 授课教师："+stu_cour[i].getTeacher());
                System.out.print(" 上课地点："+stu_cour[i].getPlace());
                System.out.print(" 上课时间：周"+stu_cour[i].getWeek() +" "+ stu_cour[i].getTime());
                System.out.println(" 课程人数："+stu_cour[i].getStu_num());
            }
        }
    }

}
