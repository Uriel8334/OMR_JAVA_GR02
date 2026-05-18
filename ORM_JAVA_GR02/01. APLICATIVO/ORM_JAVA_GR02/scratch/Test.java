package scratch;
import ec.edu.monster.modelo.HibernateUtil;
public class Test {
    public static void main(String[] args) {
        try {
            HibernateUtil.getSessionFactory();
            System.out.println("Success!");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
