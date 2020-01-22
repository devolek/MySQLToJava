import org.hibernate.Session;
import java.text.SimpleDateFormat;

public class Main
{
    final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args)
    {
        Session session = GetSessionFactory.getSession();

        Student student1 = session.get(Student.class, 1);
        System.out.println("Имя первого студента: " + student1.getName());
        System.out.println("Возраст первого студента: " + student1.getAge());
        System.out.println("Дата регистрации первого студента: " + format.format(student1.getRegistrationDate().getTime()));

        Course course = session.get(Course.class, 1);
        System.out.println("Course №1: " + course.getName() + " - " + course.getTeacher().getName() + " - " + course.getStudents().get(1).getName());

        Purchase purchase = session.get(Purchase.class, new PurchaseId("Жариков Афанасий", "Веб-разработчик c 0 до PRO"));
        System.out.println(format.format(purchase.getSubscriptionDate().getTime()));
        Subscription subscription = session.get(Subscription.class, new SubscriptionId(1,2));
        System.out.println(format.format(subscription.getSubscriptionDate().getTime()));

        GetSessionFactory.closeSession();
    }
}
