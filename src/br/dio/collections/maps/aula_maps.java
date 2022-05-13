package br.dio.collections.maps;

import java.util.*;

public class aula_maps {
    public static void main(String[] args) {

        System.out.println("Crie um dicionário e relacione com os respectivos consumos:  ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{ //hashmap mostra os resultados em ordem aleatoria
            put("gol", 14.4); // maps não tem add, substitui pelo put
            put("uno", 15.6); // maps não permite chaves duplicadas
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);
    // não é possível alterar o valor da chave (ex: "gol"), pq ela já existe. somente substituir.

        System.out.println("Confira se o modelo Tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
        // exibe o objeto da chave (ex:uno - objeto: 15.6)

        // System.out.println("Exiba o terceiro modelo do dicionário: "); - não há metódo em maps para isso

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais economico: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());// values retorna uma collection com todos os consumos
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();//para verificar o modelo mais economico, é preciso verificar o objeto. o método
// 'entrySet' verifica o objeto.
        String modeloMaisEficiente = ""; // variável de controle;
        for (Map.Entry<String, Double> entry : entries) {
            if(entry.getValue().equals(consumoMaisEficiente))
                modeloMaisEficiente = entry.getKey();
            System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
        }

        System.out.println("Exiba o modelo menos economico e seu consumo: "); //trabalhar com chave e valor separadamente
        // valeus retona uma collection de valores e o método KeySet retorna os modelos(chaves).
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet() ) {
            if(entry.getValue().equals(consumoMenosEficiente))
                modeloMenosEficiente = entry.getKey();
            System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
        }
        //Metodo EntrySet permite manipular chaves e valores separadamente.

        System.out.println("Exiba as somas dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Soma dos consumos é igual: " + soma);


        System.out.println("Exiba a media dos consumo deste dicionário de carros: " + (soma/carrosPopulares.size()));


        System.out.println("Remova os modelos com consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);


        System.out.println("Exiba todos os carros na ordem que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());

        System.out.println("Exiba o dicionário ordenado pelo modelo: "); // modelo = a chave (key)
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1); //como argumento, o carrospopulares1
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());


    }
}
