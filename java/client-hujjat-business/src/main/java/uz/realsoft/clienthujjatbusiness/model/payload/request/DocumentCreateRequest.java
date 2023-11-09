package uz.realsoft.clienthujjatbusiness.model.payload.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 09.11.2023
 */

@Data
public class DocumentCreateRequest {
    private String id;
    private String pin;
    private String requestId;
    private String documentType;
    private Map<String, Object> documentParams;
    private List<String> additionalDocuments;
    private String signType;
    private Map<String, Object> signParams;
    private List<?> attachments = new ArrayList<>();
    private Object attributes;
    private String oldId;
    private String oldPin;
    private Object notice;
    private Object actionBar;
    private Boolean pdfView;
    private String title;
}
