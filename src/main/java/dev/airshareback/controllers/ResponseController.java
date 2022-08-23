package dev.airshareback.controllers;

import dev.airshareback.controllers.dto.ResponseDto;
import dev.airshareback.entities.Response;
import dev.airshareback.services.ResponseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class ResponseController {

    private ResponseService  responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping ("topic/responses")
    public List<Response> getResponses() {
        return this.responseService.list();
    }

    @GetMapping("topic/{id}/responses")
    public List<Response> getResponseByTopic(@PathVariable String id) {
        return this.responseService.listByTopic(Long.valueOf(id));
    }

    @PostMapping("topic/{id}/newpost")
    public void create(@RequestBody ResponseDto responseDto) {
        this.responseService.create(responseDto);
    }

    @PostMapping("topic/{id}/editResponse/{responseId}")
    public void edit(@PathVariable String responseId, @RequestBody ResponseDto responseDto) {
        this.responseService.edit(Long.valueOf(responseId), responseDto);
    }

    @DeleteMapping("topic/{topicId}/response/{respId}")
    void deleteTopic(@PathVariable Long respId) {
        responseService.deleteResponse(respId);
    }

}