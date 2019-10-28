package br.com.tardeli.dao;

import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class ProjetoDao implements Crud<Projeto> {

    EntityManagerFactory factory = EntityManagerProvider.getInstance().getFactory();
    EntityManager manager = factory.createEntityManager();
    private Projeto p = new Projeto();

    @Override
    public Projeto salvar(Projeto obj) {
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
    public void excluir(Projeto obj) {
        try {
            manager.getTransaction().begin();
            manager.remove(obj);
            manager.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public List<Projeto> listar() {
        List<Projeto> projetos = new ArrayList<>();
        try {
            projetos = manager.createQuery("select proj from Projeto proj").getResultList(); 
            return projetos;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return projetos;
    }

    @Override
    public Projeto buscarPorCodigo(Long codigo) {
        try {
            manager.getTransaction().begin();
            p = manager.find(Projeto.class, codigo);
            manager.getTransaction().commit();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return p;
    }
    
    public List buscarProjetosPorVereador(Vereador vereador) {
        
        try {
            return this.manager
                    .createNamedQuery("Projeto.buscaProjetosPorVereador", Projeto.class)
                    .setParameter("vereador", vereador)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    
     public Projeto buscarProjetoPorNome(String nome) {
        try {
            return this.manager
                    .createNamedQuery("Projeto.buscaPorNome", Projeto.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

}
