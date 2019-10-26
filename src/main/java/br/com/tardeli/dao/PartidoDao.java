package br.com.tardeli.dao;

import br.com.tardeli.modelo.Partido;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class PartidoDao implements Crud<Partido> {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("atividade");
    EntityManager manager = factory.createEntityManager();
    private Partido p = new Partido();

    @Override
    public Partido salvar(Partido obj) {
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
    public void excluir(Partido obj) {
        try {
            manager.getTransaction().begin();
            manager.remove(obj);
            manager.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public List<Partido> listar() {
        List<Partido> partidos = new ArrayList<>();
        try {
            partidos = manager.createQuery("select partido from Partido partido").getResultList(); 
            return partidos;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return partidos;
    }

    @Override
    public Partido buscarPorCodigo(Long codigo) {
        try {
            manager.getTransaction().begin();
            p = manager.find(Partido.class, codigo);
            manager.getTransaction().commit();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return p;
    }

}
