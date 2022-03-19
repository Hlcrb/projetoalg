package DAO;

import DTO.PessoasDTO;
import VIEW.PessoasVIEW;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PessoasDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PessoasDTO> lista = new ArrayList<>();
    
    public void cadastrarPessoas(PessoasDTO objpessoasdto) {
        PessoasVIEW pv = new PessoasVIEW();
        pv.setVisible(true);
        
        String sql = "insert into pessoas (nome_pessoa) values (?)";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpessoasdto.getNome_pessoas());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "PessoasDAO" + erro);
        }
        
    }
    
    public ArrayList<PessoasDTO> PesquisarPessoas() {
        String sql = "select * from pessoas";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                PessoasDTO objpessoasdto = new PessoasDTO();
                objpessoasdto.setCodigop(rs.getInt("codigop"));
                objpessoasdto.setNome_pessoas(rs.getString("nome_pessoa"));
                
                lista.add(objpessoasdto);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PessoasDAO Pesquisar" + erro);
            
        }
        return lista;
        
    }
    
}
