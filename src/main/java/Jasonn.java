import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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

        // 3. JSON in Java-Objekt mappen
        Pokemon pokemon = mapper.readValue(response.body(), Pokemon.class);

        // 4. Werte ausgeben
        System.out.println("Name: " + pokemon.getName());
        System.out.println("ID: " + pokemon.getId());
        System.out.println("Height: " + pokemon.getHeight());

    }
}