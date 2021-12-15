package xuankeSystem;

import java.io.Serializable;

//定义course类
public class Course implements Serializable {
    //课程的属性
    private int id;
    private String name;
    private Teacher tea;  //授课教师
    private String place;  //上课地点
    private int week;  //上课周几
    private String time;  //上课时间
    private int stu_num;  //学生数量

    //构造函数
    public Course(int id,String name,String place,int week,String time,int stu_num){
        this.id = id;
        this.name = name;
       // tea = teacher;
        this.place = place;
        this.week = week;
        this.time = time;
        this.stu_num = stu_num;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getTeacher( ){ return tea.getName(); }
    public String getPlace() { return place; }
    public int getWeek() { return week; }
    public String getTime() { return time; }
    public int getStu_num() { return stu_num; }
    public void setTeacher(Teacher teacher){
        this.tea = teacher;
    }
}


