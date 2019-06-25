/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tipoCliente.Cliente;
import tipoCliente.TipoClienteDestinatario;
import tipoCliente.TipoClienteRemetente;

/**
 *
 * @author @author Ramon
 */
public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    private ClienteDAO() {
    }

    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO cliente (idCliente,nomeCliente,cepCliente,cpfCliente, tipoCliente) "
                    + "VALUES ('"
                    + cliente.getIdCliente()
                    + "', '"
                    + cliente.getNome()
                    + "', '"
                    + cliente.getCep()
                    + "', '"
                    + cliente.getCpf()
                    + "', '"
                    + cliente.getTipoCliente()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void delete(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM cliente WHERE idCliente = " + cliente.getIdCliente());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public Cliente get(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        //gambiarra, se nao fizer isso, tem que fazer 2 get(um pra cada tipo, e bota rum IF no try do Preparar editar)
        Cliente clienteResult = new TipoClienteDestinatario();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM cliente AS c WHERE c.idCliente = "
                    + cliente.getIdCliente());
            while (rs.next()) {
                clienteResult.setIdCliente(rs.getInt("c.idCliente"));
                clienteResult.setNome(rs.getString("c.nomeCliente"));
                clienteResult.setCpf(rs.getString("c.cpfCliente"));
                clienteResult.setCep(rs.getString("c.cepCliente"));
                clienteResult.setTipoCliente(rs.getString("c.tipoCliente"));
            }

            return clienteResult;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public List<Cliente> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        List<Cliente> clientesList = new ArrayList<>();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM cliente ");

            while (rs.next()) {
                Cliente cliente = new TipoClienteRemetente();
                cliente.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
                cliente.setNome(rs.getString("nomeCliente"));
                cliente.setCep(rs.getString("cepCliente"));
                cliente.setCpf(rs.getString("cpfCliente"));

                clientesList.add(cliente);
            }

            return clientesList;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void editar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            st.execute(
                    "UPDATE Cliente AS c"
                    + " SET nomeCliente = '"
                    + cliente.getNome()
                    + "', cpfCliente = '"
                    + cliente.getCpf()
                    + "', cepCliente = '"
                    + cliente.getCep()
                    + "'"
                    + " WHERE c.idCliente = '"
                    + cliente.getIdCliente()+ "'"
            );

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void closeResourcer(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }

}
