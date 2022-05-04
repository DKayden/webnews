package com.example.webnews.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Valid
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    @Column(name = "timepost")
    private Date timepost;

    @JoinColumn(name = "newsid", referencedColumnName = "id")
    private int newsid;

    @JoinColumn(name = "user_name")
    private String user_name;
}
