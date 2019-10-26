package br.com.tardeli.controle;

import br.com.tardeli.dao.PartidoDao;
import br.com.tardeli.modelo.Partido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class PartidoControle {
    private PartidoDao dao = new PartidoDao();

    public boolean salvarOuAtualizar(Partido obj){
        try {
            dao.salvar(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public boolean remover(Partido obj){
        try {
            dao.excluir(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public List<Partido> listarTodos(){
        List<Partido> objs = new ArrayList<>();
        try {
            return objs = dao.listar();
        } catch (Exception e) {
            e.getMessage();
        }
        return objs;
    }
    
    public Partido buscarPartidoPorCodigo(Long codigo) {
        Partido p = new Partido();
        try {
            p = dao.buscarPorCodigo(codigo);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return p;
    }
}
