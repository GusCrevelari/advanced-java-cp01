package br.com.fiap.modelo;

import br.com.fiap.anotacoes.Coluna;
import br.com.fiap.anotacoes.Descricao;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_FUNCIONARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_FUNCIONARIO")
@Descricao(descricao = "TB_FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Coluna(nome = "NOME")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Coluna(nome = "HORAS_TRABALHADAS")
    @Column(name = "HORAS_TRABALHADAS")
    private double horasTrabalhadas;

    @Coluna(nome = "VALOR_HORA")
    @Column(name = "VALOR_HORA")
    private double valorHora;

    public Funcionario() {
    }

    public Funcionario(String nome, double horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }

    public void imprimirInformacao() {
        System.out.println("Funcionário: " + nome);
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por hora: R$ " + valorHora);
        System.out.println("Salário final: R$ " + calcularSalario());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}