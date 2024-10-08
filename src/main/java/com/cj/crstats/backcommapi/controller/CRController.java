package com.cj.crstats.backcommapi.controller;

import com.cj.crstats.backcommapi.utils.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@RestController
@RequestMapping("/api/clashroyale")
public class CRController {

    private static final Log LOGGING = LogFactory.getLog(CRController.class);

    private final RestTemplate restTemplate;

    public CRController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/players/{playerTag}")
    public ResponseEntity<String> getPlayerInfo(@PathVariable String playerTag) {
        String encodedPlayerTag = playerTag.startsWith("%23") ? playerTag.replace("%23", "#")
                : !playerTag.startsWith("#") ? "#" + playerTag : playerTag;

        String url = Utils.BASE_URL + "players/" + encodedPlayerTag;

        LOGGING.info("player tag " + encodedPlayerTag);
        LOGGING.info("url " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + Utils.API_TOKEN);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            /*ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return ResponseEntity.status(response.getStatusCode()).headers(headers).body(response.getBody());*/

            WebClient client = WebClient.builder().baseUrl(Utils.BASE_URL).defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + Utils.API_TOKEN).build();

            String response = client.get()
                    .uri(uriBuilder ->
                            uriBuilder.path("players/{playerTag}").build(encodedPlayerTag))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);

        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("Player not found with tag: " + playerTag + " - " + e.getResponseBodyAsString());
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).headers(headers).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(Arrays.toString(e.getStackTrace()));
        }
    }
}
