package com.cj.crstats.backcommapi.controller;

import com.cj.crstats.backcommapi.utils.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/clashroyale")
public class CRController {

    private static final Log LOGGING = LogFactory.getLog(CRController.class);

    private final RestTemplate restTemplate;

    public CRController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/players/{playerTag}")
    @ResponseBody
    public ResponseEntity<String> getPlayerInfo(@PathVariable String playerTag) {
        String encodedPlayerTag = playerTag.contains("#") ? playerTag.replace("#", "%23") : playerTag;

        String url = Utils.BASE_URL + "players/" + encodedPlayerTag;

        LOGGING.info("player tag " + encodedPlayerTag);
        LOGGING.info("url " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + Utils.API_TOKEN);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return ResponseEntity.ok(response.getBody());
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found with tag: " + playerTag + " - " + e.getResponseBodyAsString());
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        }
    }
}
