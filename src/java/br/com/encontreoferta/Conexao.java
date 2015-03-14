package br.com.encontreoferta;

import java.sql.*;

public class Conexao {

    private Connection conexao;
    private Statement expressao;

    boolean conectar() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.conexao = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/EncontreOferta", "leonardo", "123456"
            );
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    boolean executar(String sql) {
        if (this.conexao == null) {
            conectar();
        }
        try {
            expressao = conexao.createStatement();
            expressao.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            desconectar();
            return false;
        }
    }

    ResultSet consultar(String sql) {
        if (this.conexao == null) {
            conectar();
        }
        try {
            expressao = conexao.createStatement();
            return expressao.executeQuery(sql);
        } catch (SQLException ex) {
            desconectar();
            return null;
        }
    }

    void desconectar() {
        try{
            this.expressao.close();
            this.conexao.close();
        }catch(SQLException ex){}
    }
}