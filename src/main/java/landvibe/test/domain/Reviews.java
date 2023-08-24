package landvibe.test.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long reviewId;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board targetBoard;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENTS")
    private String contents;

    @Builder
    public Reviews(Board targetBoard, String title, String contents) {
        this.targetBoard = targetBoard;
        this.title = title;
        this.contents = contents;
    }
}
