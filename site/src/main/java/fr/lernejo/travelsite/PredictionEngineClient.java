package fr.lernejo.travelsite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.time.LocalDate;
import java.util.List;

public interface PredictionEngineClient {
    @GET("/api/temperature?country={country}")
    Call<List<List_temperatures>> getlistRepos(@Path("Country") String country);

    public record List_temperatures(Double temperature, LocalDate date){

    }
}
