package com.cj.crstats.backcommapi.service;

import com.cj.crstats.backcommapi.repository.PlayerDataRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerDataService {

    private final PlayerDataRepository playerDataRepository;

    public PlayerDataService(PlayerDataRepository playerDataRepository) {
        this.playerDataRepository = playerDataRepository;
    }

    public ResponseEntity<String> getPlayerData(String playerTag) {
        return playerDataRepository.getPlayerData(playerTag);
    }

    public ResponseEntity<String> getPlayerUpcomingChestData(String playerTag) {
        return playerDataRepository.getPlayerUpcomingChestData(playerTag);
    }
}
