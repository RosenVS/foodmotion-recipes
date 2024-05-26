package com.individual.foodmotionrecipes.dto;

import com.individual.foodmotionrecipes.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusUpdateRequest {
    private Long recipe_id;
    private Status status;
}