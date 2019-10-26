package br.com.tardeli.controle;

import br.com.tardeli.dao.ProjetoDao;
import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class ProjetoControle {
    private ProjetoDao dao = new ProjetoDao();
    private List<Projeto> listaObjs = new ArrayList<>();
    
    public boolean salvarOuAtualizar(Projeto obj){
        try {
            dao.salvar(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public boolean remover(Projeto obj){
        try {
            dao.excluir(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public List<Projeto> listarTodos(){
        try {
            return listaObjs = dao.listar();
        } catch (Exception e) {
            e.getMessage();
        }
        return listaObjs;
    }
    
    public Projeto buscarProjetoPorCodigo(Long codigo) {
        Projeto p = new Projeto();
        try {
            p = dao.buscarPorCodigo(codigo);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return p;
    }
    
    public List buscarProjetosPorVereador(Vereador obj) {
        try {
            return listaObjs = dao.buscarProjetosPorVereador(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    
     public Object buscarProjetoPorNome(String nome) {
        try {
            return dao.buscarProjetoPorNome(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
