package com.cj.crstats.backcommapi.repository;

import com.cj.crstats.backcommapi.config.ApiUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class PlayerDataRepository {
    private final WebClient webClient;

    public PlayerDataRepository() {
        this.webClient = WebClient.builder().baseUrl(ApiUtils.BASE_URL).defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + ApiUtils.API_TOKEN).build();
    }

    public ResponseEntity<String> getPlayerData(String playerTag) {
        String response = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("players/{playerTag}").build(ApiUtils.encodedPlayerTag(playerTag)))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    public ResponseEntity<String> getPlayerUpcomingChestData(String playerTag) {
        String response = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("players/{playerTag}/upcomingchests").build(ApiUtils.encodedPlayerTag(playerTag)))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
