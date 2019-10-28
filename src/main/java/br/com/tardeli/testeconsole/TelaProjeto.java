package br.com.tardeli.testeconsole;

import br.com.tardeli.controle.ProjetoControle;
import br.com.tardeli.controle.VereadorControle;
import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class TelaProjeto {

    private Scanner teclado = new Scanner(System.in);

    private Projeto p = new Projeto();
    private ProjetoControle projetoControle = new ProjetoControle();

    private Vereador v = new Vereador();
    private VereadorControle vereadorControle = new VereadorControle();

    public Scanner getTeclado() {
        return teclado;
    }

    public void salvarConsole() {
        String codigo = "", opcao = "";

        System.out.println("Digite o nome do projeto: ");
        p.setNome(teclado.nextLine());

        System.out.println("Escolha um verador digitando seu código: ");
        codigo = teclado.nextLine();
        v = vereadorControle.buscarVereadorPorCodigo(Long.parseLong(codigo));
        p.setVereador(v);

        System.out.println("Projeto Apresentado\nSim---Digite 1\nNão---Digite 0\n ");
        opcao = teclado.nextLine();
        if (opcao == "1") {
            p.setApresentado(true);
        } else {
            p.setApresentado(false);
        }

        System.out.println("Projeto Aprovado\nSim---Digite 1\nNão---Digite 0\n ");
        opcao = teclado.nextLine();
        if (opcao == "1") {
            p.setAprovado(true);
        } else {
            p.setAprovado(false);
        }

        if (projetoControle.salvarOuAtualizar(p)) {
            System.out.println("Salvo projeto: " + p.getNome() + ", com sucesso!!!");
        } else {
            System.out.println("*****Erro ao salvar*****");
        }

    }

    public void atualizarConsole() {
        String codigo = "", opcao = "";
        Projeto obj = new Projeto();

        System.out.println("Digite um código de projeto para atualizar: ");

        codigo = teclado.nextLine();

        obj = projetoControle.buscarProjetoPorCodigo(Long.parseLong(codigo));

        if (obj.getCodigo() > 0l) {
            System.out.println("Digite o nome do projeto: ");
            obj.setNome(teclado.nextLine());

            System.out.println("Escolha um verador digitando seu código: ");
            codigo = teclado.nextLine();
            v = vereadorControle.buscarVereadorPorCodigo(Long.parseLong(codigo));
            obj.setVereador(v);

            System.out.println("Projeto Apresentado\nSim---Digite 1\nNão---Digite 0\n ");
            opcao = teclado.nextLine();
            if (opcao == "1") {
                obj.setApresentado(true);
            } else {
                obj.setApresentado(false);
            }

            System.out.println("Projeto Aprovado\nSim---Digite 1\nNão---Digite 0\n ");
            opcao = teclado.nextLine();
            if (opcao == "1") {
                obj.setAprovado(true);
            } else {
                obj.setAprovado(false);
            }

            if (projetoControle.salvarOuAtualizar(obj)) {
                System.out.println("Atualizado projeto de nome: " + obj.getNome() + ", com sucesso!!!");
            } else {
                System.out.println("*****Erro ao atualizar*****");
            }
        } else {
            System.out.println("*****Pessoa não localizada*****");
        }

    }

    public void buscarPorIdConsole() {
        String codigo = "";
        Projeto obj = new Projeto();

        System.out.println("Digite um código para buscar: ");

        codigo = teclado.nextLine();

        try {
            obj = projetoControle.buscarProjetoPorCodigo(Long.parseLong(codigo));

            if (obj.getCodigo() > 0) {
                System.out.println(obj.toString());
            } else {
                System.out.println("*****Projeto não localizada*****");
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("*****Erro ao buscar*****");
        }

    }

    public void listarConsole() {
        for (Projeto obj : projetoControle.listarTodos()) {
            System.out.println(obj.toString());
        }
    }

    public void buscarProjetoPorNome() {
        String nome = "";
        System.out.println("Digite o nome do projeto para buscar: ");
        nome = teclado.nextLine();
        try {
            Projeto projeto = projetoControle.buscarProjetoPorNome(nome);
            System.out.println(projeto.toString());
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ao buscar");
        }
    }

    public void buscarProjetoPorVereador() {
        String cod = "";

        System.out.println("Digite um código de vereador para buscar: ");

        cod = teclado.nextLine();

        try {
            List<Projeto> listaObjs = new ArrayList<>();
            Vereador v = vereadorControle.buscarVereadorPorCodigo(Long.parseLong(cod));
            listaObjs = projetoControle.buscarProjetosPorVereador(v);
            if (!listaObjs.isEmpty()) {
                for (Projeto p : listaObjs) {
                    System.out.println(p.toString());
                }
            } else {
                System.out.println("Nenhum resultado foi encontrado para sua busca!!!");
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ao buscar");
        }
    }

}
