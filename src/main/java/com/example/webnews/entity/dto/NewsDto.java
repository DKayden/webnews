package com.example.webnews.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NewsDto implements Serializable {
    private int id;
    private String title;
    private String author;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date timecreated;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date timeupdate;
}
