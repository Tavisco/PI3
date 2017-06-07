/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.si.pi3.graficos.dao;

import java.sql.Connection;
 
import java.sql.DriverManager;
import java.sql.ResultSet;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBConection {
    
    public static String status = "Conexão falhou.";
    
    public DBConection(){
        
    }
    
    public static Connection getConexaoMySql(){
        Connection connection = null;
        
        try{
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            String serverName = "localhost";
            String dataBase = "bolsa_de_valores";
            String url = "jdbc:mysql://" + serverName + "/" + dataBase + "?autoReconnect=true&useSSL=false";
            String userName = "root";
            String passWord = "root";
            connection = DriverManager.getConnection(url,userName,passWord);
            
            if (connection != null)
                status = ("STATUS--->Conectado com sucesso!");
             else 
                status = ("STATUS--->Não foi possivel realizar conexão");
            
            return connection;    
        }
        catch(SQLException e){
            System.out.println("Não foi possivel se conectar ao banco de dados\n " + e);
            return null;    
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver especificado não encontrado\n" + e);
            return null;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
        
    }
    
    public static String getStatus(){
        return status;
    }
    
    public static boolean FecharConexao(){
        
        if(getConexaoMySql() == null){
            System.out.println("conexao não ativa");
            return false;
        }
        
        try{
            getConexaoMySql().close();
            return true;
        }
        catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public static Connection ReiniciarConexao(){
        FecharConexao();
        
        return getConexaoMySql();
    }
    
    
    //Metodo para retornar dados do banco usando datas como parametro
    public static List<Object> getData(String dataInicial, String dataFinal){
        if(getConexaoMySql() == null)
            return null;
        List<Object> ListDadosDoBanco = new ArrayList();
        Statement st = null;
        ResultSet rs = null;
        
        try
        {
            st = getConexaoMySql().createStatement();
            rs = st.executeQuery("SELECT * FROM Ativos WHERE DataAcao " + "BETWEEN '" +
                    dataInicial + "' and '" + dataFinal +"';");
            
            //insere todos os dados em uma lista (ListDadosDoBanco)
            while(rs.next())
            {
                final String sNome = rs.getString("nome");
                final String sCodAcao = rs.getString("codAcao");
                final String sAlta = rs.getString("alta");
                final String sBaixa = rs.getString("baixa");
                final String sAbertura = rs.getString("abertura");
                final String sFechamento = rs.getString("fechamento");
                final String sVolume = rs.getString("volume");
                final String sDataAcao = rs.getString("DataAcao");
                
                ListDadosDoBanco.add(new ObjectDadosDB(){{
                    nome = sNome;
                    codAcao = sCodAcao;
                    DataAcao = sDataAcao;
                    abertura = sAbertura;
                    alta = sAlta;
                    baixa = sBaixa;
                    fechamento = sFechamento;
                    volume = sVolume;
                }});
                
            }
            
            st.close();
            rs.close();
            return ListDadosDoBanco;
            
        }catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
        finally
        {
             FecharConexao();
        }
        
    }
   
}