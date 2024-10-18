package com.aula04.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class RemoverClienteServlet
 */

@WebServlet("/removerCliente")
public class RemoverClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");

        if (clientes != null) {
            int indexToRemove = -1;
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                if (cliente.getId() == id) {
                    indexToRemove = i; 
                    break;
                }
            }

            if (indexToRemove != -1) {
                clientes.remove(indexToRemove);
            }
        }

        response.sendRedirect("listarClientes");
    }
}
