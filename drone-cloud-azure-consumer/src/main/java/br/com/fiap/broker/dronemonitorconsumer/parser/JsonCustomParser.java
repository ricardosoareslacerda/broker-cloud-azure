package br.com.fiap.broker.dronemonitorconsumer.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.ArrayUtils;

public class JsonCustomParser {

    public static String parseObjectToJson(Class clazz, Object object, final String ... exclusionFields) {
        try {
            if (object == null)
                throw new NullPointerException("Objeto nao informado para parse Json !");

            if (ArrayUtils.isEmpty(exclusionFields)
                    || ArrayUtils.contains(exclusionFields,""))
                return ((Gson) new GsonBuilder().setPrettyPrinting().create()).toJson(object);

            return ((Gson) new GsonBuilder()
                                .setPrettyPrinting()
                                .setExclusionStrategies(CustomExclusionStrategy.listCustomExclusionFields(clazz, exclusionFields)).create())
                                .toJson(object);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
