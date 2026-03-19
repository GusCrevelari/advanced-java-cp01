package br.com.fiap.app;

import br.com.fiap.modelo.Funcionario;
import br.com.fiap.modelo.FuncionarioComissionado;
import br.com.fiap.modelo.FuncionarioSenior;
import br.com.fiap.reflection.GeradorSQL;

public class Main {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario("Gustavo", 160, 25.0);
        FuncionarioSenior senior = new FuncionarioSenior("Marina", 160, 25.0, 100.0);
        FuncionarioComissionado comissionado = new FuncionarioComissionado("Carlos", 160, 25.0, 800.0);

        System.out.println("=== FUNCIONÁRIO COMUM ===");
        funcionario.imprimirInformacao();

        System.out.println("\n=== FUNCIONÁRIO SÊNIOR ===");
        senior.imprimirInformacao();

        System.out.println("\n=== FUNCIONÁRIO COMISSIONADO ===");
        comissionado.imprimirInformacao();

        System.out.println("\n=== SQL GERADO VIA REFLECTION ===");
        System.out.println(GeradorSQL.gerarSelectTodos(funcionario));
        System.out.println(GeradorSQL.gerarInsert(funcionario));
        System.out.println(GeradorSQL.gerarInsert(senior));
        System.out.println(GeradorSQL.gerarInsert(comissionado));
    }
}