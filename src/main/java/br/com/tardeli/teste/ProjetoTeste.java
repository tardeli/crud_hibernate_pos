package br.com.tardeli.teste;

import br.com.tardeli.controle.ProjetoControle;
import br.com.tardeli.controle.VereadorControle;
import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class ProjetoTeste {
    public static void main(String[] args) {
        ProjetoControle projetoControle= new ProjetoControle();
        VereadorControle vereadorControle = new VereadorControle();
        List<Projeto> listaObjs = new ArrayList<>();
        
        //BUSCAR O PROJETO PELO NOME
        System.out.println("BUSCAR O PROJETO PELO NOME");
        Projeto projeto = (Projeto) projetoControle.buscarProjetoPorNome("Projeto-2");
        System.out.println(projeto.toString());
        
        //BUSCAR OS PROJETOS CRIADOS POR UM VEREADOR
        System.out.println("BUSCAR OS PROJETOS CRIADOS POR UM VEREADOR");
        Vereador v = vereadorControle.buscarVereadorPorCodigo(1L);
        listaObjs = projetoControle.buscarProjetosPorVereador(v);
        
        for (Projeto p : listaObjs) {
            System.out.println(p.toString());
        }
        
        
       
    }
}
