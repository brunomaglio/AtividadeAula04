package com.aula04.servlet.session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ListarClienteServlet
 */
@WebServlet("/listarClientes")
public class ListarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Clientes Cadastrados</h2>");
        out.println("<ul>");
        
        for (Cliente cliente : clientes) {
            out.println("<li>ID: " + cliente.getId() + " - Nome: " + cliente.getNome() +
                    " - <a href='editarCliente?id=" + cliente.getId() + "'>Editar</a> | " +
                    "<a href='removerCliente?id=" + cliente.getId() + "'>Remover</a></li>");
        }
        
        out.println("</ul>");
        out.println("<a href='adicionarCliente'>Adicionar Novo Cliente</a>");
        out.println("</body></html>");
    }
}
