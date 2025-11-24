import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Jasonn {
    public static void main(String[] args) throws Exception {
        // 1. HTTP Client
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/1"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 2. ObjectMapper zum Parsen
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        // 3. JSON in Java-Objekt mappen
        Pokemon pokemon = mapper.readValue(response.body(), Pokemon.class);

        // 4. Werte ausgeben
        System.out.println("Name: " + pokemon.getName());
        System.out.println("ID: " + pokemon.getId());
        System.out.println("Height: " + pokemon.getHeight());

        AutoList list = new AutoList(new ArrayList<>());

        CarList liste = mapper.readValue(new File ("autos.json"), CarList.class);

        CarList neue_liste = mapper.readValue(new File ("auto2.json"), CarList.class);


        for (Auto a : neue_liste.getAutos()) {
            System.out.println("*****************************");
            System.out.println("Marke:      " + a.marke());
            System.out.println("Farbe:      " + a.farbe());
            System.out.println("Leistung:   " + a.ps()+"PS");
            System.out.println("Preis:      " + a.preis()+"€");
            System.out.println();
        }

        mapper.writeValue(new File("king_autos.json"), neue_liste);

        Student student1 = new Student("Paula", 10, "Saarland");
        Student student2 = new Student("Nemesis", 4221, "Saarland");

        String student1_as_json = mapper.writeValueAsString(student1);
        System.out.println(student1_as_json);

        Student p3 = mapper.readValue(student1_as_json, Student.class);
        System.out.println(p3.name());

    }
}