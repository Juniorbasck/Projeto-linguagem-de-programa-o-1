/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Projeto_1.ctr;
import java.sql.ResultSet;
import br.com.Projeto_1.dto.JogadorDTO;
import br.com.Projeto_1.dao.JogadorDAO;
import br.com.Projeto_1.dao.ConexaoDAO;


/**
 *
 * @author aluno
 */
public class JogadorCTR {
    JogadorDAO jogadorDAO = new JogadorDAO();

    public JogadorCTR(){
        
    }
    public String insereJogador(JogadorDTO jogadorDTO){
        try{
            
            if (jogadorDAO.inserirJogador(jogadorDTO)) {
                return "Jogador Cadastrado com Sucesso!!! ";                
        }else {
                return "Jogador não Cadastrado!!! ";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Jogador não cadastrado ";
        }
        
    }
    
    public ResultSet consultarJogador(JogadorDTO jogadorDTO, int opcao){
        
        ResultSet rs = null; 
        
        rs = jogadorDAO.consultarJogador(jogadorDTO, opcao);
                
                
        return rs;         
      }        
    
     public void CloseDB(){
          ConexaoDAO.CloseDB();
  }
    
  public String excluirJogador(JogadorDTO jogadorDTO){
       try{
           
           if (jogadorDAO.inserirJogador(jogadorDTO)){
               return "Jogador excluído com sucesso!!!";
           }else{
               return "Jogador não Excluído!!!"; 
           }     
       }
      catch (Exception e){
          System.out.println(e.getMessage()); 
          return "Jogador NÃO Excluído!!!"; 
      }      
  
  }//fecha metodo cliente
  
  
}//fecha método consultarCliente
