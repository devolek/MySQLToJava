import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "Subscriptions")
public class Subscription
{
    @EmbeddedId
    private SubscriptionId id;

    @Column(name = "subscription_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar subscriptionDate;


    public Calendar getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Calendar subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public SubscriptionId getId() {
        return id;
    }

    public void setId(SubscriptionId id) {
        this.id = id;
    }
}
