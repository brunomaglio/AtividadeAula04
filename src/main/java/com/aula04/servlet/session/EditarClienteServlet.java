package com.aula04.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class EditarClienteServlet
 */
@WebServlet("/editarCliente")
public class EditarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = null;
        
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");

        for (Cliente c : clientes) {
            if (c.getId() == id) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<form action='atualizarCliente' method='POST'>");
            out.println("<input type='hidden' name='id' value='" + cliente.getId() + "'>");
            out.println("Nome: <input type='text' name='nome' value='" + cliente.getNome() + "'><br>");
            out.println("<input type='submit' value='Atualizar'>");
        } else {
            response.sendRedirect("listarClientes");
        }
    }
}
