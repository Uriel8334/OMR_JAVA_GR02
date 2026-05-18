package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Departamento;
import ec.edu.monster.modelo.DepartamentoDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DepartamentoServlet", urlPatterns = {"/departamentos"})
public class DepartamentoServlet extends HttpServlet {

    private DepartamentoDAO dao;

    @Override
    public void init() throws ServletException {
        // Inicializamos el DAO
        dao = new DepartamentoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Pedir los datos al Modelo (DAO con Hibernate)
        List<Departamento> listaDepartamentos = dao.listarDepartamentos();
        
        // 2. Pasar los datos a la Vista
        request.setAttribute("departamentos", listaDepartamentos);
        
        // 3. Redirigir al index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}