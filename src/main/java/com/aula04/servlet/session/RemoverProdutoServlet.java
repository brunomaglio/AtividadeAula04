package com.aula04.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class RemoverProdutoServlet
 */

@WebServlet("/removerProduto")
public class RemoverProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");

        if (produtos != null) {
            int indexToRemove = -1;
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                if (produto.getId() == id) {
                    indexToRemove = i; 
                    break;
                }
            }

            if (indexToRemove != -1) {
                produtos.remove(indexToRemove);
            }
        }

        response.sendRedirect("listarProdutos");
    }

}
