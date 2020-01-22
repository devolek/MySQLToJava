import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubscriptionId implements Serializable {

    private int courseId;

    private int studentId;

    SubscriptionId(int courseId, int studentId){
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}