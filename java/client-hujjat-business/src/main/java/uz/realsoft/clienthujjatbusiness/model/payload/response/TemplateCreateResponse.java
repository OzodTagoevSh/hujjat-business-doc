package uz.realsoft.clienthujjatbusiness.model.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 09.11.2023
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemplateCreateResponse {
    private String id;
    private String clientId;
    private String state;
    private String templateType;
    private String title;
    private String linkType;
    private Integer linkExpireDays;
    private String originalFileName;
    private Long version;
    private String createdAt;
    private String updatedAt;
    private Boolean deleted;
}
