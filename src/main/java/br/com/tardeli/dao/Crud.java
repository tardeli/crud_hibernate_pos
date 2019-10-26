package br.com.tardeli.dao;

import java.util.List;

/**
 *
 * @author rocha
 */
public interface Crud<Entidade> {

    public Entidade salvar(Entidade obj);

    public void excluir(Entidade obj);

    public List<Entidade> listar();

    public Entidade buscarPorCodigo(Long codigo);
    
}
