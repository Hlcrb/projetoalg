package DAO;

import DTO.JogosDTO;
import DTO.PessoasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JogosDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<JogosDTO> lista = new ArrayList<>();

    public void cadastrarJogos(JogosDTO objjogodto) {
        String sql = "insert into jogos (titulo) values (?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objjogodto.getTitulo());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "JogosDAO" + erro);
        }
    }

    public ArrayList<JogosDTO> PesquisarJogos() {
        String sql = "select * from jogos";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
              JogosDTO objjogosdto = new JogosDTO();
                objjogosdto.setCodigo(rs.getInt("codigo"));
                objjogosdto.setTitulo(rs.getString("titulo"));

                lista.add(objjogosdto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "JogosDAO Pesquisar" + erro);

        }
        return lista;

    }

}
