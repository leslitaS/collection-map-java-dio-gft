package br.com.dio.collection.map;

import java.util.*;

public class ExemploMap {

    public static void main(String[] args) {
        /* Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
        modelo = gol - consumo = 14.4 km/l
        modelo = uno - consumo = 15.5 km/l
        modelo = mobi - consumo = 16.1 km/l
        modelo = hb20 - consumo = 14.5 km/l
        modelo = kwid - consumo = 15.6 km/l
        * */

        System.out.println("Crie um diccionario que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.5 );
            put("mobi", 16.1);
            put("hb20", 14.5 );
            put("kwid", 15.6);
        }};

        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o consumo do gol por 15.2 km/l: ");
        carrosPopulares.put("gol",15.2);

        System.out.println("Confira se o modelo tucsion esta no dicionario: " + carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
        System.out.println("Exiba os modelos");

        Set<String> modelos = carrosPopulares.keySet();
        System.out.println("os modelos sao: " + modelos);

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println("os consumos são: " + consumos);

        System.out.println("Exiba o modelo mais economico e seu cosumo");

        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMasEficiente = "";

        for (Map.Entry<String, Double> entry: entries){
            if (entry.getValue().equals(consumoMaisEficiente)){
                modeloMasEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMasEficiente + " - " + consumoMaisEficiente);
            }
        }


        System.out.println("Exiba o modelo menos economico e seu consumo: ");

        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry: carrosPopulares.entrySet()){
            if (entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " " + consumoMenosEficiente);
            }
        }

        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;

        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Soma dos consumos: " + soma);


        System.out.println("Exiba a media dos consumos: " + (soma/carrosPopulares.size()));
        System.out.println("Remova os modelos com o consumo igual a 15.6 km/l");
        System.out.println(carrosPopulares);
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
         while (iterator1.hasNext()){
             if (iterator1.next().equals(15.6)) {
                 iterator1.remove();
             }
         }
        System.out.println("Carros removidos: " + carrosPopulares);


        System.out.println("Exiba os carros na ordem que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.5 );
            put("mobi", 16.1);
            put("hb20", 14.5 );
            put("kwid", 15.6);
        }};

        System.out.println("Carros Populares :" + carrosPopulares1.toString());

        System.out.println("Exiba o diccionario ordenado pelo modelo:===");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o Dicionario de carros:");
        carrosPopulares1.clear();
        System.out.println("Confira se o dicionario esta vazio:" + carrosPopulares1.isEmpty());

        System.out.println("Exiba por ordem de pagina: ====");






    }



}
