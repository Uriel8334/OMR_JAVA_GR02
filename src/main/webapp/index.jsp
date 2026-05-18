<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="java.util.List" %>
        <%@page import="ec.edu.monster.modelo.Departamento" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Gestión de Departamentos</title>
                <link rel="stylesheet" href="css/estilos.css">
            </head>

            <body>
                <h2>Módulo de Recursos Humanos - Monster</h2>

                <a href="departamentos">Consultar Departamentos</a>
                <br><br>

                <% // Recuperamos la lista de departamentos enviada por el Servlet List<Departamento> lista = (List
                    <Departamento>) request.getAttribute("departamentos");

                        // Evaluamos si la lista contiene elementos para generar la estructura
                        if (lista != null && !lista.isEmpty()) {
                        %>
                        <table>
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Nombre del Departamento</th>
                                    <th>Descripción</th>
                                    <th>Fecha de Creación</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% // Ciclo iterativo para renderizar cada fila de la tabla for (Departamento d : lista)
                                    { %>
                                    <tr>
                                        <td>
                                            <%= d.getCodigo() %>
                                        </td>
                                        <td>
                                            <%= d.getNombre() %>
                                        </td>
                                        <td>
                                            <%= d.getDescripcion() %>
                                        </td>
                                        <td>
                                            <%= d.getFecha() %>
                                        </td>
                                    </tr>
                                    <% } %>
                            </tbody>
                        </table>
                        <% } else if (lista !=null && lista.isEmpty()) { %>
                            <p>No hay departamentos registrados en la base de datos.</p>
                            <% } %>
            </body>

            </html>