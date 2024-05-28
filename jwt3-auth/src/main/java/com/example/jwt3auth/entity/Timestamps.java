package com.example.jwt3auth.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Timestamps {
    LocalDateTime created_at;
    LocalDateTime updated_at;
}
