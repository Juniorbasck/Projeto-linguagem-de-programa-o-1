/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Projeto_1.dao;
import java.sql.*;
import br.com.Projeto_1.dto.JogadorDTO;

/**
 *
 * @author aluno
 */
public class JogadorDAO {
    
    public JogadorDAO(){
        
    }
    
    private ResultSet rs = null;
    
    private Statement stmt = null;
    
    public boolean inserirJogador(JogadorDTO jogadorDTO){
        try{
            
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into jogador (nome, time, altura,"
                    + "peso, posicao, idade, cpf, pais) values ( "
                    + "'" + jogadorDTO.getNome() + "', "
                    + "'" + jogadorDTO.getTime()+ "', "
                    +       jogadorDTO.getAltura()+ ", "
                    +     + jogadorDTO.getPeso()+ ", "
                    + "'" + jogadorDTO.getPosicao()+ "', "
                    +     + jogadorDTO.getIdade()+ ", "
                    + "'" + jogadorDTO.getCpf() + "',"
                    + "'" + jogadorDTO.getPais()+ "')";
                    
                
            
            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            return true;
                            
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            
            ConexaoDAO.CloseDB();
        }
    }
    
  public ResultSet consultarJogador(JogadorDTO jogadorDTO, int opcao){
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select j.* "+
                              "from jogador j "+
                              "where nome like '" + jogadorDTO.getNome()+ "%' " +
                              "order by j.nome";    
                break;
                case 2:
                    comando = "Select j.* "+
                              "from jogador j " +
                              "where j.id_jogador = " + jogadorDTO.getId_jogador();
                break;
                case 3:
                    comando = "Select j.id_jogador, j.nome "+
                              "from jogador j ";
                break;
                
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarCliente
  
  public boolean excluirCliente(JogadorDTO jogadorDTO){
      try{
        
          ConexaoDAO.ConectDB();
          
          stmt = ConexaoDAO.con.createStatement(); 
                    
          String comando = "Delete from jogador where id_jogador =  " + jogadorDTO.getId_jogador();
          
          stmt.execute(comando); 
          
            ConexaoDAO.con.commit();
          
          stmt.close();
          return true; 
      }
       catch(Exception e){
           System.out.println(e.getMessage());
           return false; 
       }
      finally{
          
          ConexaoDAO.CloseDB(); 
      }      
  }//fecha metodo cliente 
  
}