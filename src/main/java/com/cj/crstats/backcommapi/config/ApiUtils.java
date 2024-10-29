package com.cj.crstats.backcommapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.clashroyale")
public class ApiUtils {

    public static final String BASE_URL = "https://api.clashroyale.com/v1/";
    public static final String API_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjdiOWJmNGMyLTZkODItNGUzZC04OGM1LWZmNDA4OTFiMGUyZCIsImlhdCI6MTcyOTg4MzA1Mywic3ViIjoiZGV2ZWxvcGVyLzBhOTYyNGE5LTc0NzItN2NjMC0xZWY0LTFlNTFkNDhiZDlmNyIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIxOTAuOTAuMjUyLjIxMiIsIjE1LjIwNC4xNjEuMTE1IiwiNDQuMjI2LjEyMi4zIl0sInR5cGUiOiJjbGllbnQifV19.nYtraduuasXci2Z9i1U2v7xGKMzi5oGQQE3PVXSbu5OXDEadQ2qruK13DV-XuhlkkBKLezFGe5pe8xMpnpH6WQ";

    public static String encodedPlayerTag(String playerTag) {
        return playerTag.startsWith("%23") ? playerTag.replace("%23", "#") : !playerTag.startsWith("#") ? "#" + playerTag : playerTag;
    }
}
