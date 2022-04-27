package com.example.webnews.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NewsDto implements Serializable {
    private final int id;
    private final String title;
    private final String author;
    private final String content;
    private final Date timecreated;
    private final Date timeupdate;
}
