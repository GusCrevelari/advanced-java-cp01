package br.com.fiap.modelo;

import br.com.fiap.anotacoes.Coluna;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SENIOR")
public class FuncionarioSenior extends Funcionario {

    @Coluna(nome = "BONUS_POR_15_HORAS")
    @Column(name = "BONUS_POR_15_HORAS")
    private double bonusPor15Horas;

    public FuncionarioSenior() {
    }

    public FuncionarioSenior(String nome, double horasTrabalhadas, double valorHora, double bonusPor15Horas) {
        super(nome, horasTrabalhadas, valorHora);
        this.bonusPor15Horas = bonusPor15Horas;
    }

    @Override
    public double calcularSalario() {
        double salarioBase = getHorasTrabalhadas() * getValorHora();
        int blocosDe15Horas = (int) (getHorasTrabalhadas() / 15);
        double bonusTotal = blocosDe15Horas * bonusPor15Horas;
        return salarioBase + bonusTotal;
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Funcionário Sênior: " + getNome());
        System.out.println("Horas trabalhadas: " + getHorasTrabalhadas());
        System.out.println("Valor por hora: R$ " + getValorHora());
        System.out.println("Bônus por cada 15 horas: R$ " + bonusPor15Horas);
        System.out.println("Salário final: R$ " + calcularSalario());
    }

    public double getBonusPor15Horas() {
        return bonusPor15Horas;
    }

    public void setBonusPor15Horas(double bonusPor15Horas) {
        this.bonusPor15Horas = bonusPor15Horas;
    }
}