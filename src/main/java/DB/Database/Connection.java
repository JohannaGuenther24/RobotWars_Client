package DB.Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("Verbunden!");
        } catch (RuntimeException ex) {
            System.out.println("Fehler!");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void disconnect(Session session){
        session.close();
        sessionFactory.close();
    }
}