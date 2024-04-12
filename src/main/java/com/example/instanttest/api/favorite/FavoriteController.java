package com.example.instanttest.api.favorite;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/babap/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/save")
    public String saveChargerInfoByName(@RequestParam("충전소명") String chargerName) {
        return favoriteService.saveChargerInfoByName(chargerName);
    }



}