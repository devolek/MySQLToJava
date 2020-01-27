import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SubscriptionId implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    SubscriptionId(Course course, Student student){
        this.course = course;
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}