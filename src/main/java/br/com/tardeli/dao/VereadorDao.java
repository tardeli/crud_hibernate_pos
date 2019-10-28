package br.com.tardeli.dao;

import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Vereador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class VereadorDao implements Crud<Vereador> {

    EntityManagerFactory factory = EntityManagerProvider.getInstance().getFactory();
    EntityManager manager = factory.createEntityManager();
    private Vereador p = new Vereador();

    @Override
    public Vereador salvar(Vereador obj) {
        try {
            manager.getTransaction().begin();
            manager.merge(obj);
            manager.getTransaction().commit();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void excluir(Vereador obj) {
        try {
            manager.getTransaction().begin();
            manager.remove(obj);
            manager.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public List<Vereador> listar() {
        List<Vereador> vereadores = new ArrayList<>();
        try {
            vereadores = manager.createQuery("select vereador from Vereador vereador").getResultList(); 
            return vereadores;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return vereadores;
    }
    
    @Override
    public Vereador buscarPorCodigo(Long codigo) {
        try {
            manager.getTransaction().begin();
            p = manager.find(Vereador.class, codigo);
            manager.getTransaction().commit();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return p;
    }
    
    public List buscarVereadoresPorPartido(Partido partido) {
        
        try {
            return this.manager
                    .createNamedQuery("Vereador.buscarVereadoresPorPartido", Vereador.class)
                    .setParameter("partido", partido)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    
    public Vereador buscarDadosVereadorPorNome(String nome) {
        try {
            return this.manager
                    .createNamedQuery("Vereador.buscarDadosVereadorPorNome", Vereador.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List buscarVereadoresAssociadosPorDatas(Date d_Inicial, Date d_Final) {
        
        try {
            return this.manager
                    .createNamedQuery("Vereador.buscarVereadoresAssociadosPorDatas", Vereador.class)
                    .setParameter("data_1", d_Inicial)
                    .setParameter("data_2", d_Final)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

}
