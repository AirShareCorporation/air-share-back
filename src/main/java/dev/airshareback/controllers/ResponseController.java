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

    public ResponseController(ResponseService userService) {
        this.responseService = userService;
    }


    @GetMapping("topic/{id}")
    public Optional<Response> getResponseByTopic(@PathVariable int id) {
        return this.responseService.listByTopic(id);
    }

    @PostMapping("topic/{id}/newPost")
    public void create(@PathVariable int id, @RequestBody ResponseDto responseDto) {
        this.responseService.create(responseDto);
    }

    @PostMapping("topic/{id}/editResponse/{id}")
    public void edit(@PathVariable int id, @RequestBody String newContent) {

    }


}
