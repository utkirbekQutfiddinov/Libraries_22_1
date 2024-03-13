package org.example;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Data
public class Joke {


    @SerializedName("categories")
    private List<Object> kategoriyalar;

    private Date created_at;
    private String icon_url;
    private String id;
    private String value;

}
