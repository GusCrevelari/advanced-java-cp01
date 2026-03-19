package br.com.fiap.reflection;

import br.com.fiap.anotacoes.Coluna;
import br.com.fiap.anotacoes.Descricao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GeradorSQL {

    public static String gerarSelectTodos(Object obj) {
        Class<?> clazz = obj.getClass();
        String nomeTabela = obterNomeTabela(clazz);

        return "SELECT * FROM " + nomeTabela;
    }

    public static String gerarInsert(Object obj) {
        Class<?> clazz = obj.getClass();
        String nomeTabela = obterNomeTabela(clazz);

        List<Field> campos = obterTodosOsCampos(clazz);
        List<String> nomesColunas = new ArrayList<>();
        List<String> valoresColunas = new ArrayList<>();

        try {
            for (Field campo : campos) {
                if (campo.isAnnotationPresent(Coluna.class)) {
                    campo.setAccessible(true);

                    Coluna coluna = campo.getAnnotation(Coluna.class);
                    Object valor = campo.get(obj);

                    nomesColunas.add(coluna.nome());
                    valoresColunas.add(formatarValor(valor));
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Erro ao acessar os campos do objeto.", e);
        }

        return "INSERT INTO " + nomeTabela +
                " (" + String.join(", ", nomesColunas) + ")" +
                " VALUES (" + String.join(", ", valoresColunas) + ")";
    }

    private static String obterNomeTabela(Class<?> clazz) {
        Class<?> classeAtual = clazz;

        while (classeAtual != null) {
            if (classeAtual.isAnnotationPresent(Descricao.class)) {
                Descricao descricao = classeAtual.getAnnotation(Descricao.class);
                return descricao.descricao();
            }
            classeAtual = classeAtual.getSuperclass();
        }

        throw new IllegalArgumentException("A classe não possui a anotação @Descricao.");
    }

    private static List<Field> obterTodosOsCampos(Class<?> clazz) {
        List<Field> campos = new ArrayList<>();
        Class<?> classeAtual = clazz;

        while (classeAtual != null) {
            Field[] camposDeclarados = classeAtual.getDeclaredFields();

            for (Field campo : camposDeclarados) {
                campos.add(campo);
            }

            classeAtual = classeAtual.getSuperclass();
        }

        return campos;
    }

    private static String formatarValor(Object valor) {
        if (valor == null) {
            return "NULL";
        }

        if (valor instanceof String) {
            return "'" + valor + "'";
        }

        return valor.toString();
    }
}