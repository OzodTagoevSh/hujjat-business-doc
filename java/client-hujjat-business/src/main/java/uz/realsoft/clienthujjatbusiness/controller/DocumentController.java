package uz.realsoft.clienthujjatbusiness.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.realsoft.clienthujjatbusiness.model.payload.request.DocumentCreateRequest;
import uz.realsoft.clienthujjatbusiness.service.DocumentService;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 08.11.2023
 */

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/create")
    public ResponseEntity<?> createDocument(@RequestBody DocumentCreateRequest request) throws Exception {
        return new ResponseEntity<>(documentService.createDocument(request), HttpStatus.CREATED);
    }
}
