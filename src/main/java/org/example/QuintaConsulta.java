package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class QuintaConsulta {
    // Consulta: Del año en que nació el actor anterior, ¿Cuántas películas hay registradas en la base de datos?
    public static void main(String[] args) throws IOException, InterruptedException {
        // Realizar una solicitud HTTP para obtener la información sobre las películas registradas en un año específico
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/movie/byYear/1982/"))
                .header("X-RapidAPI-Key", APIConfig.API_KEY)
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Convertir la respuesta JSON a un objeto JSONObject
        JSONObject objetoJson = new JSONObject(response.body());

        // Obtener la cantidad de objetos en la respuesta
        int cantidadDePeliculas = objetoJson.getJSONArray("results").length();

        System.out.println("Cantidad de películas registradas en el año 1982: " + cantidadDePeliculas);
    }
}
