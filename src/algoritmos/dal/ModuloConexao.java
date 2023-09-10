/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.dal;


import java.sql.*;

/**
 *
 * @author 422UR4H
 */
public class ModuloConexao {
    // METODO RESPONSAVEL POR ESTABELECER A CONEXAO COM O BANCO
    
    // Connection é um framework (um conjunto de funcionalidades) que
    // vem do pacote java.sql
    public static Connection conector() {
        // estamos criando uma conexão (por enquanto nula) (classe de java.sql)
        Connection conexao = null;
        // carregando o driver importado em Bibliotecas
        String driver = "com.mysql.jdbc.Driver";
        
        // armazenando informações referentes ao banco
        // jdbc:mysql:// nunca muda, pois é referente ao driver importado
        // localhost significa que o banco de dados esta instalado na propria maquina
        // 3306 é a porta padrão do mysql
        // dbgxg é o nome do banco de dados
        String url = "jdbc:mysql://localhost:3306/dbgxg";
        String user = "root";
        String password = "Tiago-99834147t";
        
        // linhas principais - estabelecendo conexão com o banco
        try {
            // essa linha vai executar o arquivo do driver
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static Connection postgresConector() {
        Connection conexao = null;
        String driver = "org.postgresql.Driver";
//        String url = "jdbc:postgresql://localhost:5432/dbgxg";
        String url = "jdbc:postgresql://silly.db.elephantsql.com:5432/kaggpxjq";
        String user = "kaggpxjq";
        String password = "n74B-SWQTilRIM-pQwKZO_k5SmMRPfFI";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
