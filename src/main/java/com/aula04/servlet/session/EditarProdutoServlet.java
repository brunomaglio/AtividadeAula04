package com.aula04.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Servlet implementation class EditarProdutoServlet
 */
@WebServlet("/editarProduto")
public class EditarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");
		Produto produto = null;

		for (Produto p : produtos) {
			if (p.getId() == id) {
				produto = p;
				break;
			}
		}

		if (produto != null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<form action='atualizarProduto' method='POST'>");
			out.println("<input type='hidden' name='id' value='" + produto.getId() + "'>");
			out.println("Nome: <input type='text' name='nome' value='" + produto.getNome() + "'><br>");
			out.println("Preço: <input type='text' name='preco' value='" + produto.getPreco() + "'><br>");
			out.println("<input type='submit' value='Atualizar'>");
		} else {
			response.sendRedirect("listarProdutos");
		}
	}
}
