package DAO;

import DAO.ConexaoDAO;
import DTO.EnderecoDTO;
import DTO.JogosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EnderecoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<EnderecoDTO> lista = new ArrayList<>();

    public void cadastrarEndereco(EnderecoDTO objenderecodto) {
        String sql = "insert into endereço (rua, bairro) values (?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objenderecodto.getRua());
            pstm.setString(2, objenderecodto.getBairro());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "EnderecoDAO" + erro);
        }
    }

    public ArrayList<EnderecoDTO> PesquisarEndereco() {
        String sql = "select * from endereço";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                EnderecoDTO objenderecodto = new EnderecoDTO();
                objenderecodto.setCodigo(rs.getInt("codigo"));
                objenderecodto.setRua(rs.getString("rua"));
                objenderecodto.setBairro(rs.getString("bairro"));

                lista.add(objenderecodto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "JogosDAO Pesquisar" + erro);

        }
        return lista;

    }
}
