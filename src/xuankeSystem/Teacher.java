package xuankeSystem;

import java.io.Serializable;

//定义老师类
public class Teacher extends Father implements Serializable {

    Course[] tea_cour = new Course[5];
    int i;

    public Teacher(int id,String name,String sex){

        super(id, name, sex);
    }

    //导入老师各自的课程
    public void daoru(Course tea_c){
        tea_cour[i] = tea_c;
        i++;
    }

    //老师课表
    public void tea_show(){
        System.out.println(getName()+"的课表");
        for(int i=0;i<tea_cour.length;i++) {
            if (tea_cour[i] == null) {
                continue;
            }
            else {
                System.out.print("课程号："+tea_cour[i].getId());
                System.out.print(" 课程名："+ tea_cour[i].getName());
//                System.out.print(" 授课老师："+tea_cour[i].getTeacher());
                System.out.print(" 上课地点："+tea_cour[i].getPlace());
                System.out.print(" 上课时间：周"+tea_cour[i].getWeek() +" "+ tea_cour[i].getTime());
                System.out.println(" 课程人数："+tea_cour[i].getStu_num());
            }
        }
    }
}
