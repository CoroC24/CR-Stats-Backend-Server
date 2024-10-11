package com.cj.crstats.backcommapi.controller;

import com.cj.crstats.backcommapi.service.PlayerDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clashroyale")
public class PlayerDataController {

    private final PlayerDataService playerInfService;

    public PlayerDataController(PlayerDataService playerInfService) {
        this.playerInfService = playerInfService;
    }

    @GetMapping("/players/{playerTag}")
    public ResponseEntity<String> getPlayerData(@PathVariable String playerTag) {
        return playerInfService.getPlayerData(playerTag);
    }

    @GetMapping("/players/{playerTag}/upcomingchests")
    public ResponseEntity<String> getPlayerUpcomingChestData(@PathVariable String playerTag) {
        return playerInfService.getPlayerUpcomingChestData(playerTag);
    }
}
