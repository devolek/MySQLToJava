import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LinkedPurchaseList")
@IdClass(LinkedPurchase.LinkedPurchaseId.class)
public class LinkedPurchase
{
    @Id
    @Column(name = "student_id")
    private int studentId;

    @Id
    @Column(name = "course_id")
    private int courseId;

    private int price;

    public LinkedPurchase() {
    }

    public LinkedPurchase(int studentId, int courseId, int price) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.price = price;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public static class LinkedPurchaseId implements Serializable {


        private int studentId;

        private int courseId;

        public LinkedPurchaseId() {
        }

        public LinkedPurchaseId(int studentId, int courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
    }
}
