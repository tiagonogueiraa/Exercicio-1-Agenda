/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cpd
 */
@WebServlet(name = "ListaContatoServlet", urlPatterns = {"/Lista2.html"})
public class ListaContatoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
            try {
                       Class.forName("org.apache.derby.jdbc.ClientDriver");
                       String url ="jdbc:derby://localhost:1527/Exercicio-1-Agenda";
                       Connection conexao = DriverManager.getConnection(url, "usuario" , "senha");
                      // System.out.println("Conexao aberta com sucesso!");
                      
                      //mandar comando após conexao
                      
                      String sql = "select * from contato";
                      
                      Statement operacao = conexao.createStatement();
                      //executar uma ação ou uma query
                      ResultSet resultado = operacao.executeQuery(sql);
                      out.print("Nome: \t Sobrenome: \t Telefone:");
                      while(resultado.next()){
                          out.print("\n"+resultado.getString("nome"));
                          out.print("\t"+resultado.getString("sobrenome"));
                          out.print("\t"+resultado.getString("telefone"));
                      }
                      
            } catch (SQLException ex) {
            Logger.getLogger(ListaContatoServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Driver não disponível");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaContatoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }       System.err.println("Problema ao acessar o banco!");
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
