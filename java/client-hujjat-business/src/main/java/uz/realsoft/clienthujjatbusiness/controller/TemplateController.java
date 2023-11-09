package uz.realsoft.clienthujjatbusiness.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.realsoft.clienthujjatbusiness.model.payload.request.TemplateCreateRequest;
import uz.realsoft.clienthujjatbusiness.service.TemplateService;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 08.11.2023
 */

@RestController
@RequestMapping("/template")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping("/create")
    public ResponseEntity<?> createTemplate(@RequestBody TemplateCreateRequest request) throws Exception {
        return new ResponseEntity<>(templateService.createTemplate(request), HttpStatus.CREATED);
    }
}
