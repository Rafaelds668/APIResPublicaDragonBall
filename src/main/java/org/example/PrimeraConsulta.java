package org.example;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrimeraConsulta {

    // Consulta: Cuantas series de Dragon Ball hay registradas.

    public static void main(String[] args) throws IOException, InterruptedException {
        // Construir la solicitud HTTP para obtener información sobre las series de Dragon Ball
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/idbyTitle/Dragon%20ball/"))
                .header("X-RapidAPI-Key", APIConfig.API_KEY)
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // Realizar la solicitud HTTP y obtener la respuesta en formato JSON
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // El objeto JSON principal contiene un campo "results" que es un arreglo de series
        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray resultsArray = jsonResponse.getJSONArray("results");

        // Mostrar la cantidad de series de Dragon Ball registradas
        System.out.println("Cantidad de series de Dragon Ball registradas: " + resultsArray.length());
        // Mostrar la respuesta JSON formateada
        System.out.println(jsonResponse.toString(2)); // El 2 es el num de espacios para usar como sangría
    }
}
