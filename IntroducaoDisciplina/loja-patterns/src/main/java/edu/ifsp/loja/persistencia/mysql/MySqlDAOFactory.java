package edu.ifsp.loja.persistencia.mysql;

import edu.ifsp.loja.persistencia.DAOFactory;
import edu.ifsp.loja.persistencia.ProdutoDAO;

public class MySqlDAOFactory extends DAOFactory {

    @Override
    public ProdutoDAO getProdutoDAO() {
        return new ProdutoDAOMySql();
    }

}