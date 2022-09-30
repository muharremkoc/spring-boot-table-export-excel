package com.export.excel.model;


import com.export.excel.audit.DataAudit;
import com.export.excel.enums.SocialMedia;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;


@Document(value = "user_excel_table")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class User extends DataAudit {

    @Id
    String id;

    String username;

    @Email
    String email;

    String password;


    @Enumerated(EnumType.STRING)
    SocialMedia socialMedia;

}
