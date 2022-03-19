package DAO;

import DAO.ConexaoDAO;
import DTO.ConsoleDTO;
import DTO.JogosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsoleDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ConsoleDTO> lista = new ArrayList<>();

    public void cadastrarconsole(ConsoleDTO objconsdto) {
        String sql = "insert into console (nome_console) values (?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objconsdto.getConsole());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ConsoleDAO" + erro);
        }
    }

    public ArrayList<ConsoleDTO> PesquisarConsole() {
        String sql = "select * from console";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ConsoleDTO objconsoledto = new ConsoleDTO();
                objconsoledto.setCodigoconsole(rs.getInt("codigoconsole"));
                objconsoledto.setConsole(rs.getString("nome_console"));

                lista.add(objconsoledto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConsoleDAO Pesquisar" + erro);

        }
        return lista;

    }
}
