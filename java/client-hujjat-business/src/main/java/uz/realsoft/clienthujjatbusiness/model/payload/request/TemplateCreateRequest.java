package uz.realsoft.clienthujjatbusiness.model.payload.request;

import lombok.Data;

import java.util.Map;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 09.11.2023
 */

@Data
public class TemplateCreateRequest {
    private String type;
    private String name;
    private String template;
    private Map<String, Object> locale;
}
