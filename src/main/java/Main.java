import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
        Subscription subscription = session.get(Subscription.class, new SubscriptionId(course, course.getStudents().get(1)));
        System.out.println("Course №1: " + course.getName() + " - Учитель:  " + course.getTeacher().getName() + " - Студент №1:  "
                + course.getStudents().get(1).getName() + " - Дата подписки: " + format.format(subscription.getSubscriptionDate().getTime()));

        /*Purchase purchase = session.get(Purchase.class, new PurchaseId("Жариков Афанасий", "Веб-разработчик c 0 до PRO"));
        System.out.println(format.format(purchase.getSubscriptionDate().getTime()));*/


        String hql = "From " + Purchase.class.getSimpleName();
        String findCourseId = "From " + Course.class.getSimpleName() + " Where name = ";
        String findStudentId = "From " + Student.class.getSimpleName() + " Where name = ";
        List<Purchase> purchaseList = session.createQuery(hql).getResultList();

        Transaction transaction = session.beginTransaction();

        purchaseList.forEach(purchase -> {
            String studentName = purchase.getStudentName();
            String courseName = purchase.getCourseName();
            List<Student> studentList = session.createQuery(findStudentId + "'" + studentName + "'").getResultList();
            List<Course> courseList = session.createQuery(findCourseId + "'" + courseName + "'").getResultList();
            int studentId = studentList.get(0).getId();
            int courseId = courseList.get(0).getId();
            int price = purchase.getPrice();

            LinkedPurchase linkedPurchase = new LinkedPurchase();
            linkedPurchase.setCourseId(courseId);
            linkedPurchase.setStudentId(studentId);
            linkedPurchase.setPrice(price);

            session.save(linkedPurchase);
        });

        transaction.commit();
        GetSessionFactory.closeSession();
    }
}
