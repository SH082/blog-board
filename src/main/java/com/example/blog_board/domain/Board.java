package com.example.blog_board.domain;

import lombok.*;
import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createDate;
    private int read;
    private Long memberId;
}
