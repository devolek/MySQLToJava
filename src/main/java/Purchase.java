import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "purchaselist")
@IdClass(PurchaseId.class)
public class Purchase
{
    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "studentName",
                    column = @Column(name="student_name")),
            @AttributeOverride(name = "courseName",
                    column = @Column(name="course_name"))
    })

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar subscriptionDate;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Calendar getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Calendar subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
