package com.aula04.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class AtualizarClienteServlet
 */
@WebServlet("/atualizarCliente")
public class AtualizarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id"); 
        String nome = request.getParameter("nome");

        if (idString == null || nome == null) {
            response.sendRedirect("listarClientes"); 
            return;
        }

        int id = Integer.parseInt(idString);

        ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");

        if (clientes != null) {
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    cliente.setNome(nome);
                    break;
                }
            }
        }

        response.sendRedirect("listarClientes");
    }
}
