package br.com.tardeli.testeconsole;

import br.com.tardeli.teste.*;
import br.com.tardeli.controle.PartidoControle;
import br.com.tardeli.controle.ProjetoControle;
import br.com.tardeli.controle.VereadorControle;
import br.com.tardeli.dao.EntityManagerProvider;
import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class CarregarBancoExecutar {

    public static void main(String[] args) throws ParseException {

        EntityManagerProvider.getInstance().getFactory();

        //INSERE NO BANCO PARTIDOS.....
        PartidoControle partidoControle = new PartidoControle();
        Partido ob_1 = new Partido(15L, "PMDB");
        Partido ob_2 = new Partido(13L, "PT");
        Partido ob_3 = new Partido(17L, "PSL");
        Partido ob_4 = new Partido(45L, "PSDB");
        Partido ob_5 = new Partido(14L, "PTB");
        Partido ob_6 = new Partido(25L, "DEM");
        Partido ob_7 = new Partido(12L, "PDT");

        partidoControle.salvarOuAtualizar(ob_1);
        partidoControle.salvarOuAtualizar(ob_2);
        partidoControle.salvarOuAtualizar(ob_3);
        partidoControle.salvarOuAtualizar(ob_4);
        partidoControle.salvarOuAtualizar(ob_5);
        partidoControle.salvarOuAtualizar(ob_6);
        partidoControle.salvarOuAtualizar(ob_7);

        List<Partido> partidos = new ArrayList<>();
        partidos = partidoControle.listarTodos();

        try {
            for (Partido partido : partidos) {
                System.out.println(partido.toString());
            }
            System.out.println("Partidos cadastrados com sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não foi salvo!!!");
        }

        //===============================================================================
        //INSERE NO BANCO VEREADORES.....
        VereadorControle vereadorControle = new VereadorControle();
       
        Partido partido1 = partidoControle.buscarPartidoPorCodigo(13L);
        Partido partido2 = partidoControle.buscarPartidoPorCodigo(12L);
        Partido partido3 = partidoControle.buscarPartidoPorCodigo(45L);
        Partido partido4 = partidoControle.buscarPartidoPorCodigo(17L);

        Vereador v_1 = new Vereador(converterStringParaDate("22/10/2019"), partido1, "Tardeli da Rocha");
        Vereador v_2 = new Vereador(converterStringParaDate("22/10/2019"), partido1, "Fernando da Silva");
        Vereador v_3 = new Vereador(converterStringParaDate("24/10/2019"), partido2, "Maria da Rosa");
        Vereador v_4 = new Vereador(converterStringParaDate("25/08/2019"), partido3, "Marilse Cardoso");
        Vereador v_5 = new Vereador(converterStringParaDate("27/07/2019"), partido1, "Prdro Fernandes");
        Vereador v_6 = new Vereador(converterStringParaDate("30/06/2019"), partido4, "Thomas Edisom");
        Vereador v_7 = new Vereador(converterStringParaDate("22/10/2019"), partido4, "Dyenifer Vitória");
        Vereador v_8 = new Vereador(converterStringParaDate("24/10/2019"), partido4, "Jessica Patricia");
        Vereador v_9 = new Vereador(converterStringParaDate("24/10/2019"), partido3, "Silvia Bedim");
        Vereador v_10 = new Vereador(converterStringParaDate("22/10/2019"), partido1, "Lurdes Carraro");

        vereadorControle.salvarOuAtualizar(v_1);
        vereadorControle.salvarOuAtualizar(v_2);
        vereadorControle.salvarOuAtualizar(v_3);
        vereadorControle.salvarOuAtualizar(v_4);
        vereadorControle.salvarOuAtualizar(v_5);
        vereadorControle.salvarOuAtualizar(v_6);
        vereadorControle.salvarOuAtualizar(v_7);
        vereadorControle.salvarOuAtualizar(v_8);
        vereadorControle.salvarOuAtualizar(v_9);
        vereadorControle.salvarOuAtualizar(v_10);

        List<Vereador> vereadores = new ArrayList<>();
        vereadores = vereadorControle.listarTodos();

        try {
            for (Vereador projeto : vereadores) {
                System.out.println(projeto.toString());
            }
            System.out.println("Vereadores cadastrados com sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //===============================================================================
        //INSERE NO BANCO PROJETOS.....
        ProjetoControle projetoControle = new ProjetoControle();

        Vereador ve_1 = vereadorControle.buscarVereadorPorCodigo(1L);
        Vereador ve_2 = vereadorControle.buscarVereadorPorCodigo(3L);
        Vereador ve_3 = vereadorControle.buscarVereadorPorCodigo(4L);
        Vereador ve_4 = vereadorControle.buscarVereadorPorCodigo(5L);
        Vereador ve_5 = vereadorControle.buscarVereadorPorCodigo(10L);

        Projeto pj_1 = new Projeto("Projeto-1", false, true, ve_1);
        Projeto pj_2 = new Projeto("Projeto-2", false, true, ve_2);
        Projeto pj_3 = new Projeto("Projeto-3", false, true, ve_3);
        Projeto pj_4 = new Projeto("Projeto-4", true, true, ve_1);
        Projeto pj_5 = new Projeto("Projeto-5", true, true, ve_4);
        Projeto pj_6 = new Projeto("Projeto-6", true, true, ve_2);
        Projeto pj_7 = new Projeto("Projeto-7", false, true, ve_1);
        Projeto pj_8 = new Projeto("Projeto-8", false, true, ve_5);
        Projeto pj_9 = new Projeto("Projeto-9", true, true, ve_4);
        Projeto pj_10 = new Projeto("Projeto-10", false, true, ve_1);
        Projeto pj_11 = new Projeto("Projeto-11", true, true, ve_3);
        Projeto pj_12 = new Projeto("Projeto-12", false, true, ve_5);
        Projeto pj_13 = new Projeto("Projeto-13", true, true, ve_5);
        Projeto pj_14 = new Projeto("Projeto-14", false, true, ve_3);

        projetoControle.salvarOuAtualizar(pj_1);
        projetoControle.salvarOuAtualizar(pj_2);
        projetoControle.salvarOuAtualizar(pj_3);
        projetoControle.salvarOuAtualizar(pj_4);
        projetoControle.salvarOuAtualizar(pj_5);
        projetoControle.salvarOuAtualizar(pj_6);
        projetoControle.salvarOuAtualizar(pj_7);
        projetoControle.salvarOuAtualizar(pj_8);
        projetoControle.salvarOuAtualizar(pj_9);
        projetoControle.salvarOuAtualizar(pj_10);
        projetoControle.salvarOuAtualizar(pj_11);
        projetoControle.salvarOuAtualizar(pj_12);
        projetoControle.salvarOuAtualizar(pj_13);
        projetoControle.salvarOuAtualizar(pj_14);

        List<Projeto> projetos = new ArrayList<>();
        projetos = projetoControle.listarTodos();

        try {
            for (Projeto projeto : projetos) {
                System.out.println(projeto.toString());
            }
            System.out.println("Projetos cadastrados com sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Date converterStringParaDate(String data) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date d = formato.parse(data);
        return d;
    }
}
