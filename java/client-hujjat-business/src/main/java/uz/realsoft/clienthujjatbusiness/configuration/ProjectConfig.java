package uz.realsoft.clienthujjatbusiness.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ozod Tagoev (ozod.tagoev@gmail.com) created on 09.11.2023
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {
    private String templateCreateUrl;
    private String documentCreateUrl;
    private String docKey;
}
