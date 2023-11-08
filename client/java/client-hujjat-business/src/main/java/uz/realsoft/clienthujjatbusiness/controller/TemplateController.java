package uz.realsoft.clienthujjatbusiness.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 08.11.2023
 */

@RestController
@RequestMapping("client/api/template")
@RequiredArgsConstructor
public class TemplateController {

    @PostMapping("/create")
    public ResponseEntity<?> createTemplate() {
        return ResponseEntity.ok("");
    }
}
