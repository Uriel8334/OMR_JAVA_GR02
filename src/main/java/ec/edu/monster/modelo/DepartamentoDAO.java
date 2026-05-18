package ec.edu.monster.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    // Método para obtener todos los registros usando Hibernate
    public List<Departamento> listarDepartamentos() {
        List<Departamento> lista = new ArrayList<>();
        Transaction transaction = null;
        
        // Abrimos una sesión de Hibernate utilizando nuestra clase de utilidad
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Iniciamos la transacción
            transaction = session.beginTransaction();
            
            // ¡Aquí ocurre la magia! 
            // "from Departamento" se refiere al nombre de tu CLASE Java, no a la tabla.
            // Hibernate hace el SELECT por debajo y convierte los resultados en una lista de objetos automáticamente.
            lista = session.createQuery("from Departamento", Departamento.class).list();
            
            // Confirmamos la transacción
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Si algo sale mal, deshacemos los cambios
            }
            System.err.println("Error al listar departamentos con Hibernate: " + e.getMessage());
            e.printStackTrace();
        }
        
        return lista;
    }
}