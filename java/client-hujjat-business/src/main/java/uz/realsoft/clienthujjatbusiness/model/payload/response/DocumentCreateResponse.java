package uz.realsoft.clienthujjatbusiness.model.payload.response;

import lombok.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 09.11.2023
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentCreateResponse {
    private UUID requestId;
    private String shortId;
    private UUID id;
    private String pin;
    private String documentUrl;
    private String shortLink;
    private String linkExpiredAt;
    private Date expireAt;
}
