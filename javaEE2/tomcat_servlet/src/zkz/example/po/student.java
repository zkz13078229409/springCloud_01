package zkz.example.po;

import java.io.Serializable;

public class student implements Serializable {
        private int stuId;
        private int stuNum;
        private String sex;
        private int phone;
        private String stuName;

    public student() {
    }

    public student(int stuNum, String sex, int phone, String stuName) {
        this.stuNum = stuNum;
        this.sex = sex;
        this.phone = phone;
        this.stuName = stuName;
    }

    public student(int stuId, int stuNum, String sex, int phone, String stuName) {
        this.stuId = stuId;
        this.stuNum = stuNum;
        this.sex = sex;
        this.phone = phone;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "student{" +
                "stuId=" + stuId +
                ", stuNum=" + stuNum +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
