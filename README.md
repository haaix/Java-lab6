## 一、实验目的
1. 掌握文件输入输出；
2. 掌握对象序列化方法。

## 二、实验要求
&emsp;&emsp;在实验三（学生选课模拟系统）的基础上，利用文件保存选课结果，过程如下：
1. 采用对象序列化的writeObject方法把选课结果存到硬盘文件系统中；
2. 采用对象序列化的readObject方法从文件中恢复对象，并操作学生的选课课表，实现退课操作；
3. 打印课程对象信息，采用覆盖定义toString（）方法的方式。

## 三、实验过程
1. 在Student类里构造write函数，将学生课表写入txt文件中，创建输出流-写入课
表-关闭流。
2. 在stu_show函数构造write函数。
3. 在退课函数中，实现读取txt文建中的信息后，对信息进行更改。

## 四、主要代码
1. 在stu_show函数之前构造write函数并执行。
```java
    public void write() throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f)); //输出流：往外输出
        System.out.println(Arrays.toString(stu_cour));
        out.writeObject(stu_cour);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        System.out.println(in.readObject().toString());
        out.close();
    }
```
2. 在退课函数中，实现读取txt文建中的信息后，对信息进行更改。
```java
        stu_cour = a;
        System.out.println("您已成功退出该课程!");
        stu_show(stu_cour);
```

## 五、流程图
![](https://github.com/haaix/Java-lab6/blob/main/img/%E6%B5%81%E7%A8%8B%E5%9B%BE.png)

## 六、运行截图
![](https://github.com/haaix/Java-lab6/blob/main/img/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C.png)

## 七、实验感想
&emsp;&emsp;对于这次实验，由于是模仿老师的Demo程序来完成的实验，所以只是基本掌
握了文件读写的方法和规则，并没有其他深度的学习，希望下周最后的实验课能
够有真正掌握这部分内容。