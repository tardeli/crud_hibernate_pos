package br.com.tardeli.controle;

import br.com.tardeli.dao.VereadorDao;
import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Vereador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class VereadorControle {
    private VereadorDao dao = new VereadorDao();
    private List<Vereador> listaObjs = new ArrayList<>();
        
    public boolean salvarOuAtualizar(Vereador obj){
        try {
            dao.salvar(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public boolean remover(Vereador obj){
        try {
            dao.excluir(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public List<Vereador> listarTodos(){
        try {
            return listaObjs = dao.listar();
        } catch (Exception e) {
            e.getMessage();
        }
        return listaObjs;
    }
    
    public Vereador buscarVereadorPorCodigo(Long codigo) {
        Vereador p = new Vereador();
        try {
            p = dao.buscarPorCodigo(codigo);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return p;
    }
    
    public List buscarVereadoresPorPartido(Partido obj) {
        try {
            return listaObjs = dao.buscarVereadoresPorPartido(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listaObjs;
    }
    
    public Object buscarDadosVereadorPorNome(String nome) {
        try {
           return dao.buscarDadosVereadorPorNome(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List buscarVereadoresAssociadosPorDatas(Date d_Inicial, Date d_Final) { 
        try {
            return listaObjs = dao.buscarVereadoresAssociadosPorDatas(d_Inicial, d_Final);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listaObjs;
    }
    
    
}
