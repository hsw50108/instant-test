package com.example.instanttest.api.favorite.response;

import com.example.instanttest.domain.favorite.FavoriteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FavoriteResponseDTO {

    private Long id;
    private String chargerName;
    private String chargerAddress;
    private String chargerPower;
    private String chargerType;

    public static FavoriteResponseDTO favoriteResponseDTO(FavoriteEntity favoriteEntity) {
        FavoriteResponseDTO favoriteResponseDTO = new FavoriteResponseDTO();
        favoriteResponseDTO.setId(favoriteEntity.getId());
        favoriteResponseDTO.setChargerName(favoriteEntity.getChargerName());
        favoriteResponseDTO.setChargerAddress(favoriteEntity.getChargerAddress());
        favoriteResponseDTO.setChargerPower(favoriteEntity.getChargerPower());
        favoriteResponseDTO.setChargerType(favoriteEntity.getChargerType());
        return favoriteResponseDTO;
    }
}