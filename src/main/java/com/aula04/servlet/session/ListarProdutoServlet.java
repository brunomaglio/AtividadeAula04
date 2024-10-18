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
 * Servlet implementation class ListarProdutoServlet
 */
@WebServlet("/listarProdutos")
public class ListarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Produto> produtos = (ArrayList<Produto>) getServletContext().getAttribute("produtos");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Produtos Cadastrados</h2>");
        out.println("<ul>");

        if (produtos != null && !produtos.isEmpty()) {
            for (Produto produto : produtos) {
                out.println("<li>ID: " + produto.getId() + " - Nome: " + produto.getNome() + " - Preço: " + produto.getPreco() +
                            " - <a href='editarProduto?id=" + produto.getId() + "'>Editar</a> | <a href='removerProduto?id=" + produto.getId() + "'>Remover</a></li>");
            }
        } else {
            out.println("<li>Nenhum produto cadastrado.</li>");
        }

        out.println("</ul>");
        out.println("<a href='adicionarProduto'>Adicionar Novo Produto</a>");
        out.println("</body></html>");
    }
}
