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
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/adicionarCliente")
public class CadastrarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Cliente novoCliente = new Cliente(nome);

		ArrayList<Cliente> clientes = (ArrayList<Cliente>) getServletContext().getAttribute("clientes");

		if (clientes == null) {
			clientes = new ArrayList<>();
			getServletContext().setAttribute("clientes", clientes);
		}

		clientes.add(novoCliente);

		response.sendRedirect("listarClientes");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Adicionar Cliente</h2>");
		out.println("<form action='adicionarCliente' method='POST'>");
		out.println("Nome: <input type='text' name='nome'><br>");
		out.println("<input type='submit' value='Adicionar'>");
		out.println("</form>");
	}
}
