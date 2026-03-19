package br.com.fiap.app;

import br.com.fiap.modelo.Funcionario;
import br.com.fiap.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            System.out.println("=== DELETE ===");

            List<Funcionario> lista = em.createQuery(
                            "SELECT f FROM Funcionario f WHERE f.nome = :nome", Funcionario.class)
                    .setParameter("nome", "Gustavo Evidencia")
                    .getResultList();

            if (lista.isEmpty()) {
                System.out.println("Funcionário não encontrado para exclusão.");
                return;
            }

            Funcionario funcionario = lista.get(0);

            em.getTransaction().begin();
            em.remove(funcionario);
            em.getTransaction().commit();

            System.out.println("Funcionário removido com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            JPAUtil.fechar();
        }
    }
}