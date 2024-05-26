package com.individual.foodmotionrecipes.rabbitMQ.consumer;


import com.individual.foodmotionrecipes.dto.StatusUpdateRequest;
import com.individual.foodmotionrecipes.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class RabbitMQJsonConsumer {
    @Autowired
    private  RecipeService recipeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);


    @RabbitListener(queues = "${rabbitmq.update.recipe.status.queue.json.name}")
    public void recieveAccountDeletionMessage(StatusUpdateRequest statusUpdateRequest) throws ExecutionException, InterruptedException {
        LOGGER.info(String.format("Update Recipe Status: -> %s", statusUpdateRequest));
        if(recipeService.getRecipeById(statusUpdateRequest.getRecipe_id()).isPresent()) {
        recipeService.updateRecipeStatus(statusUpdateRequest.getRecipe_id(),statusUpdateRequest.getStatus());
        }else
            LOGGER.info("Recipe not found");



    }


}
