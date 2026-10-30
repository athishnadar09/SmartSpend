
import org.hibernate.Session;

public class HibernateTest {

    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();

            session.createNativeQuery("SELECT 1", Integer.class)
                    .getSingleResult();

            System.out.println("Hibernate initialized successfully!");
            System.out.println("MySQL connection successful!");

            session.close();
            HibernateUtil.shutdown();

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}

