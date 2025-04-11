package ch.training.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TutorialDTO {

    private UUID id;

    private String title;

    private String description;

    private String content;

    private LocalDate creationDate;
}
