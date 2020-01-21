import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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

        GetSessionFactory.closeSession();
    }
}
