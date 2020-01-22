import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "Subscriptions")
@IdClass(SubscriptionId.class)
public class Subscription
{
    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "studentId",
                    column = @Column(name="student_id")),
            @AttributeOverride(name = "courseId",
                    column = @Column(name="course_id"))
    })


    @Column(name = "student_id")
    private int studentId;


    @Column(name = "course_id")
    private int courseId;

    @Column(name = "subscription_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar subscriptionDate;


    public Calendar getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Calendar subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
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
