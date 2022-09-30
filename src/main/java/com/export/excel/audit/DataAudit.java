package com.export.excel.audit;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataAudit {

    @CreatedDate
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm")
    Date createdDate;
}
