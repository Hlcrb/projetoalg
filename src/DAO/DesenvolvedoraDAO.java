/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.ConexaoDAO;
import DTO.DesenvolvedoraDTO;
import DTO.JogosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DesenvolvedoraDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<DesenvolvedoraDTO> lista = new ArrayList<>();

    public void cadastrardesen(DesenvolvedoraDTO objdesendto) {
        String sql = "insert into desenvolvedora (nome_desenvolvedora) values (?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objdesendto.getNome_desen());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "DesenvolvedoraDAO" + erro);
        }
    }

    public ArrayList<DesenvolvedoraDTO> PesquisarDesenvolvedora() {
        String sql = "select * from desenvolvedora";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                DesenvolvedoraDTO objdesendto = new DesenvolvedoraDTO();
                objdesendto.setCodigo(rs.getInt("codigo"));
                objdesendto.setNome_desen(rs.getString("nome_desenvolvedora"));

                lista.add(objdesendto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DesenvolvedoraDAO Pesquisar" + erro);

        }
        return lista;

    }
}
