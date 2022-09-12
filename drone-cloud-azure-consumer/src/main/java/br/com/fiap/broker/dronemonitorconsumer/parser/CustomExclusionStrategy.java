package br.com.fiap.broker.dronemonitorconsumer.parser;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CustomExclusionStrategy implements ExclusionStrategy {

    private Class clazz;
    private String field;

    public CustomExclusionStrategy(Class clazz, String field) {
        this.clazz = clazz;
        this.field = field;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        if (f.getDeclaringClass() == clazz) {
            return (f.getName().equals(field));
        }
        return false;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

    public static CustomExclusionStrategy[] listCustomExclusionFields(Class clazz, String ... fields) throws Exception {

        if (clazz == null)
            throw new NullPointerException("Classe nao informada para lista de exclusao Json !");

        if (fields == null)
            throw new NullPointerException("Campos nao informados para lista de exclusao Json !");

        CustomExclusionStrategy[] customExclusionStrategies = new CustomExclusionStrategy[fields.length];

        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].isEmpty())
                customExclusionStrategies[i] = new CustomExclusionStrategy(clazz, fields[i]);
        }

        return customExclusionStrategies;
    }

}
