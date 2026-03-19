package br.com.fiap.modelo;

import br.com.fiap.anotacoes.Coluna;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMISSIONADO")
public class FuncionarioComissionado extends Funcionario {

    @Coluna(nome = "COMISSAO")
    @Column(name = "COMISSAO")
    private double comissao;

    public FuncionarioComissionado() {
    }

    public FuncionarioComissionado(String nome, double horasTrabalhadas, double valorHora, double comissao) {
        super(nome, horasTrabalhadas, valorHora);
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return (getHorasTrabalhadas() * getValorHora()) + comissao;
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Funcionário Comissionado: " + getNome());
        System.out.println("Horas trabalhadas: " + getHorasTrabalhadas());
        System.out.println("Valor por hora: R$ " + getValorHora());
        System.out.println("Comissão: R$ " + comissao);
        System.out.println("Salário final: R$ " + calcularSalario());
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}