package br.com.tardeli.testeconsole;

import br.com.tardeli.controle.PartidoControle;
import br.com.tardeli.modelo.Partido;
import java.util.Scanner;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class TelaPartido {

    private Scanner teclado = new Scanner(System.in);

    private Partido p = new Partido();
    private PartidoControle partidoControle = new PartidoControle();

    public Scanner getTeclado() {
        return teclado;
    }

    public void salvarConsole() {

        System.out.println("Digite o número do partido: ");
        p.setNumero(teclado.nextLong());
        System.out.println("Digite o nome do partido: ");
        p.setNome(teclado.nextLine());

        if (partidoControle.salvarOuAtualizar(p)) {
            System.out.println("Salvo partido: " + p.getNome() + ", com sucesso!!!");
        } else {
            System.out.println("*****Erro ao salvar*****");
        }

    }

    public void excluirConsole() {
        String codigo = "";
        Partido obj = new Partido();

        teclado.nextLine();
        System.out.println("Digite um código para excluir: ");

        codigo = teclado.nextLine();

        obj = partidoControle.buscarPartidoPorCodigo(Long.parseLong(codigo));

        if (partidoControle.remover(obj)) {
            System.out.println("Excluido com sucesso!!!");
        } else {
            System.out.println("*****Erro ao excluir*****");
        }

    }

    public void buscarPorIdConsole() {
        String codigo = "";
        Partido obj = new Partido();

        teclado.nextLine();
        System.out.println("Digite um código para buscar: ");

        codigo = teclado.nextLine();

        try {
            obj = partidoControle.buscarPartidoPorCodigo(Long.parseLong(codigo));

            if (obj.getNumero() > 0) {
                System.out.println(obj.toString());
            } else {
                System.out.println("*****Partido não localizada*****");
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("*****Erro ao buscar*****");
        }

    }

    public void listarConsole() {
        for (Partido obj : partidoControle.listarTodos()) {
            System.out.println(obj.toString());
        }
    }

}
