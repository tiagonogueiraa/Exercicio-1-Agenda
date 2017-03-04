/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda;

import static java.awt.Event.INSERT;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

/**
 *
 * @author aluno
 */
@WebServlet(name = "InsereContatoServlet", urlPatterns = {"/insere.html"})
public class InsereContatoServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/NovoContato.jsp").forward(request, response);
        
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefone = request.getParameter("telefone");
        
        Logger.getLogger(InsereContatoServlet.class.getName()).log(Level.INFO, "POST:" + nome + " " + sobrenome + " " + telefone + ".");
        
       
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url = "jdbc:derby://localhost:1527/Exercicio-1-Agenda";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            
                Statement operacao = conexao.createStatement();
            String sql = "INSERT INTO contato(nome, sobrenome, telefone) VALUES ('"
                    +nome+ "','"
                    +sobrenome+ "','"
                    +telefone+ "')";
            operacao.executeUpdate(sql);
           
        }
        
        catch (Exception e){
           Logger.getLogger(InsereContatoServlet.class.getName()).log
(Level.ERROR, "Erro ao inserir o registro!" + e);
            
        }
            response.sendRedirect("lista.html");
        
       
        
    }

   

}
