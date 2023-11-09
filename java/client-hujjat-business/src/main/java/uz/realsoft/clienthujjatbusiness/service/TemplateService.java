package uz.realsoft.clienthujjatbusiness.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import uz.realsoft.clienthujjatbusiness.configuration.ProjectConfig;
import uz.realsoft.clienthujjatbusiness.model.payload.request.TemplateCreateRequest;
import uz.realsoft.clienthujjatbusiness.model.payload.response.TemplateCreateResponse;

import java.util.Map;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 09.11.2023
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class TemplateService {
    private final ProjectConfig config;

    private final RestTemplate restTemplate;
    public TemplateCreateResponse createTemplate(TemplateCreateRequest request) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("docKey", config.getDocKey());
        HttpEntity<TemplateCreateRequest> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<TemplateCreateResponse> response = restTemplate.exchange(config.getTemplateCreateUrl(), HttpMethod.POST, entity, TemplateCreateResponse.class);
            return response.getBody();
        } catch (HttpStatusCodeException e) {
            Map<?, ?> errorResponse = e.getResponseBodyAs(Map.class);

            if (errorResponse == null || errorResponse.isEmpty())
                throw new Exception("Could not Connect to host : " + config.getTemplateCreateUrl());

            String message;

            if (errorResponse.get("error_code") != null) {
                message = errorResponse.get("error_code").toString();
            } else message = errorResponse.get("message").toString();

            throw new Exception(message);
        } catch (Throwable e) {
            log.error("Error occurred in exchange to host : {}", config.getTemplateCreateUrl(), e);
            throw new Exception(e.getMessage());
        }
    }
}
