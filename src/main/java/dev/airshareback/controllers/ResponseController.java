package dev.airshareback.controllers;

import dev.airshareback.controllers.dto.ResponseDto;
import dev.airshareback.entities.Response;
import dev.airshareback.services.ResponseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class ResponseController {

    private ResponseService  responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }


    @GetMapping("topic/{id}/responses")
    public List<Response> getResponseByTopic(@PathVariable String id) {
        return this.responseService.listByTopic(Long.valueOf(id));
    }

    @PostMapping("topic/{id}/newpost")
    public void create(@PathVariable Long id, @RequestBody ResponseDto responseDto) {
        this.responseService.create(responseDto);
    }

    /*@PostMapping("topic/{id}/editResponse/{responseId}")
    public void edit(@PathVariable int responseId, @RequestBody String newContent) {

    }*/


}
