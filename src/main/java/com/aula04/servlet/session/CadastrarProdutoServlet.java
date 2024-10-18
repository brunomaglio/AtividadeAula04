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
 * Servlet implementation class CadastrarProdutoServlet
 */
@WebServlet("/adicionarProduto")
public class CadastrarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String priceString = request.getParameter("preco");
        
        BigDecimal preco = new BigDecimal(priceString);
        
        Produto novoProduto = new Produto(nome, preco);

        ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");

        if (produtos == null) {
            produtos = new ArrayList<>();
            getServletContext().setAttribute("produtos", produtos);
        }

        produtos.add(novoProduto);

        response.sendRedirect("listarProdutos");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Adicionar Produto</h2>");
        out.println("<form action='adicionarProduto' method='POST'>");
        out.println("Nome: <input type='text' name='nome'><br>");
        out.println("Preço: <input type='text' name='preco'><br>");
        out.println("<input type='submit' value='Adicionar'>");
        out.println("</form>");
    }
}
