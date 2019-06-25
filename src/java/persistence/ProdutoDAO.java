/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author @author Ramon
 */
public class ProdutoDAO {

    private static ProdutoDAO instance = new ProdutoDAO();

    public static ProdutoDAO getInstance() {
        return instance;
    }

    private ProdutoDAO() {
    }

   

    public void delete(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM produto WHERE idProduto = " + produto.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public Produto get(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Produto produtoResult = new Produto();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM produto AS p WHERE p.idProduto = "
                    + produto.getId());
            while (rs.next()) {
                produtoResult.setId(rs.getInt("p.idProduto"));
                produtoResult.setNome(rs.getString("p.nomeProduto"));
                produtoResult.setPeso(rs.getString("p.pesoProduto"));
                produtoResult.setRemetente(rs.getString("p.clienteRemetente"));
                produtoResult.setDestino(rs.getString("p.clienteDestinatario"));
                produtoResult.setState(rs.getString("p.estado"));
                produtoResult.setMemento(rs.getString("p.memento"));
            }

            return produtoResult;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public List<Produto> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        List<Produto> produtosList = new ArrayList<Produto>();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM produto");

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nomeProduto"));
                produto.setPeso(rs.getString("pesoProduto"));
                produto.setDestino(rs.getString("clienteDestinatario"));
                produto.setRemetente(rs.getString("clienteRemetente"));
                produto.setState(rs.getString("estado"));
                produto.setMemento(rs.getString("memento"));
                produtosList.add(produto);
            }

            return produtosList;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }
 public void save(Produto produto, String estado) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO produto (idProduto,nomeProduto,pesoProduto,clienteRemetente,clienteDestinatario,memento,estado) "
                    + "VALUES ('"
                    + produto.getId()
                    + "', '"
                    + produto.getNome()
                    + "', '"
                    + produto.getPeso()
                    + "', '"
                    + produto.getRemetente()
                    + "', '"
                    + produto.getDestino()
                    + "', '"
                    + produto.getMemento()
                    + "', '"
                    + estado
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }
    public void editar(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            st.execute(
                    "UPDATE Produto AS p"
                    + " SET nomeProduto = '"
                    + produto.getNome()
                    + "', pesoProduto = '"
                    + produto.getPeso()
                    + "', clienteRemetente = '"
                    + produto.getRemetente()
                    + "', clienteDestinatario = '"
                    + produto.getDestino()
                    + "', estado = '"
                    + produto.getState()
                    + "'"
                    + " WHERE p.idProduto = '"
                    + produto.getId() + "'"
            );

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void updateMemento(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            st.execute(
                    "UPDATE produto AS p"
                    + " SET estado = '"
                    + produto.getState()
                    + "', memento = '"
                    + produto.getMemento()
                    + "'"
                    + " WHERE idProduto = '"
                    + produto.getId() + "'"
            );

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void updateEstado(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            st.execute(
                    "UPDATE produto "
                    + " SET estado = '"
                    + produto.getEstado().getEstado()
                    + "', memento = '"
                    + produto.getMemento()
                    + "' WHERE idProduto = '"
                    + produto.getId() + "'"
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
