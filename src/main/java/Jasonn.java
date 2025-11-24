import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;


public class Jasonn {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/1"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());


        JsonObject obj = JsonParser.parseString(response.body()).getAsJsonObject();

        System.out.println("Name: " + obj.get("name").getAsString());
        System.out.println("ID: " + obj.get("id").getAsInt());
        System.out.println("Height: " + obj.get("height").getAsInt());

        JsonArray obj2 = obj.getAsJsonArray("types");

        for (JsonElement o : obj2) {

            JsonObject ob = o.getAsJsonObject();
            int slot = ob.get("slot").getAsInt();
            if(slot == 1) {
                System.out.println("Slot 1 gefunden!");
                String slotText = ob.get("type").toString();
                System.out.println("Typ: " + slotText);
                JsonObject neu = ob.get("type").getAsJsonObject();
                String name = neu.get("name").getAsString();
                System.out.println(name);

            }

        }

    }

}