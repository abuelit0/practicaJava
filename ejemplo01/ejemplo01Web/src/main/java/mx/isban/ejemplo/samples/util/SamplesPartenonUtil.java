package mx.isban.ejemplo.samples.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.resource.cci.ResourceWarning;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.ejemplo.samples.beans.PartenonBean;
import mx.isban.ejemplo.samples.beans.PartenonMetadataBean;
import mx.isban.ejemplo.samples.controller.SamplesController;

public class SamplesPartenonUtil {

    public static void obtenerResultados(Map<String, Object[]> mapaRes, PartenonBean partenonBean) {
        List<List<String>> resultado = new ArrayList<>();
        List<String> registros = new ArrayList<>();
        List<String> scalars = new ArrayList<>();

        Architech.debug("Se agregan cabeceras de Registros", SamplesController.class);

        int tamanoResultado = 0;
        for (Entry<String, Object[]> entrySet : mapaRes.entrySet()) {
            if (entrySet.getValue().length > 1) {
                registros.add(entrySet.getKey());
                tamanoResultado = entrySet.getValue().length;
            } else {
                scalars.add(entrySet.getKey());
            }
        }
        
        if(!registros.isEmpty()){
            resultado.add(registros);
           
            Architech.debug("Se agregan listas por cada registro obtenido", SamplesController.class);
            for (int i = 0; i < tamanoResultado; i++) {
                resultado.add(new ArrayList<String>());
            }
            
            Architech.debug("Se ordena la informacion en los registros", SamplesController.class);
            for (String columna : resultado.get(0)) {
                Object campo;
                for (int i = 0; i < mapaRes.get(columna).length; i++) {
                    campo = mapaRes.get(columna)[i];
                    resultado.get(i + 1).add(String.valueOf(campo));
                }
            }
            partenonBean.setListaResultados(resultado);
            Architech.debug("Resultado: " + Arrays.toString(partenonBean.getListaResultados().toArray()), SamplesController.class);
        } else {
            Architech.debug("No se obtuvieron registros el resultado", SamplesController.class);
        }


        Map<String, String> mapaEscalars = new HashMap<>();

        Architech.debug("Se agregan los registros de Escalars", SamplesController.class);
        for (String campo : scalars) {
            if (mapaRes.get(campo) != null && mapaRes.get(campo).length > 0) {
                mapaEscalars.put(campo, String.valueOf(mapaRes.get(campo)[0]));
            }
        }

        partenonBean.setMapaScalars(mapaEscalars);
    }

    public static Object[] getValues(PartenonMetadataBean metadataBean) {
        String type = metadataBean.getDataType();
        Object[] arr;
        if ("MULTIVALUED".equals(metadataBean.getCardinality())) {
            arr = metadataBean.getValue().split(",");
        } else {
            arr = toArr(metadataBean.getValue());
        }

        convertTypes(type, arr);
        return arr;
    }

    private static Object[] toArr(Object... objects) {
        return objects;
    }

    private static void convertTypes(String type, Object[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = convertType(type, arr[i]);
    }

    private static Object convertType(String type, Object object) {
        if (type.equals("DATE")) {
            return convert_DATE(object);
        } else if (type.equals("TIME")) {
            return convert_TIME(object);

        } else if (type.equals("TIMESTAMP")) {
            return convert_TIMESTAMP(object);
        }
        return object;
    }

    private static Object convert_DATE(Object object) {
        String s = object.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            Architech.error("La fecha no se pudo parsear", SamplesPartenonUtil.class);
            return null;
        }
    }

    private static Object convert_TIME(Object object) {
        String s = object.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            Architech.error("La fecha TIME no se pudo parsear", SamplesPartenonUtil.class);
            return null;
        }
    }

    private static Object convert_TIMESTAMP(Object object) {
        String s = object.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Date d = sdf.parse(s);
            return new Timestamp(d.getTime());
        } catch (ParseException e) {
            Architech.error("La fecha Timestamp no se pudo parsear", SamplesPartenonUtil.class);
            return null;
        }
    }

    public static void metadataToMap(String metadata, PartenonBean partenonBean) {
        String[] lines = metadata.toString().trim().split("\n");

        partenonBean.setListaMetadataSend(new ArrayList<PartenonMetadataBean>());
        partenonBean.setListaMetadataRcve(new ArrayList<PartenonMetadataBean>());
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            List<PartenonMetadataBean> definitions;
            if (line.startsWith("(SEND ")) {
                definitions = partenonBean.getListaMetadataSend();
            } else {
                definitions = partenonBean.getListaMetadataRcve();

            }
            definitions.add(lineToDefinition(line));
        }
    }

    private static PartenonMetadataBean lineToDefinition(String line) {

        List<Object> result = new ArrayList<Object>();
        boolean flag = true;
        line = line.trim();
        line = line.substring(1, line.length() - 1).trim();
        String[] toks = line.split("-");
        for (String tok : toks) {
            tok = tok.trim();
            String[] toks2 = tok.split(",");
            for (String tok2 : toks2) {
                tok2 = tok2.trim();
                if (flag) {
                    flag = false;
                    continue;
                }
                if (Character.isDigit(tok2.charAt(0))) {
                    result.add(Integer.parseInt(tok2));
                } else {
                    result.add(tok2);
                }
            }
        }
        PartenonMetadataBean metadataBean = new PartenonMetadataBean();
        metadataBean.setFieldName((String) result.get(0));
        metadataBean.setDataType((String) result.get(1));
        metadataBean.setLength((int) result.get(3));
        metadataBean.setDecimals((int) result.get(4));
        metadataBean.setCardinality((String) result.get(5));
        return metadataBean;
    }

    @SuppressWarnings("deprecation")
    public static void logWarnings(ResourceWarning warn) {
        while (warn != null) {
            logWarning(warn);
            warn = warn.getLinkedWarning();
        }
    }

    private static void logWarning(ResourceWarning warn) {
        if (warn.getCause() == null) {
            if ("A8001".equals(warn.getErrorCode()))
                Architech.debug("ResourceWarning de 'HAY MAS DATOS'", SamplesController.class);
            else
                Architech.warn("ResourceWarning 'functional': " + warn.getMessage(), SamplesController.class);
        } else {
            Architech.warn("ResourceWarning with 'Exception Cause', Message : " + warn.getMessage(), SamplesController.class);
        }
    }

}
