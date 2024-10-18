package com.aula04.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Servlet implementation class AtualizarProdutoServlet
 */
@WebServlet("/atualizarProduto")
public class AtualizarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String priceString = request.getParameter("preco");
        
        BigDecimal price = new BigDecimal(priceString);

        ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");

        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(nome);
                p.setPreco(price);
                break;
            }
        }

        response.sendRedirect("listarProdutos");
    }
}
