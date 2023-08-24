package landvibe.test.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "REGION")
    private String region;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "DEADLINE")
    private String deadline;
    @Column(name = "WORK_TERM")
    private String workTerm;
    @Column(name = "WORK_DAY")
    private String workDay;
    @Column(name = "WORK_HOUR")
    private String workHour;
    @Column(name = "PAY")
    private Long pay;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "ROOM")
    private Boolean room;
    @Column(name = "MEAL")
    private Boolean meal;
    @Column(name = "CREATOR_NUMBER")
    private String creatorNumber;

    @Builder
    public Board(String title, String region, String location, String deadline, String workTerm, String workDay, String workHour,
                 Long pay, String type, Boolean room, Boolean meal, String creatorNumber) {
        this.title = title;
        this.region = region;
        this.location = location;
        this.deadline = deadline;
        this.workTerm = workTerm;
        this.workDay = workDay;
        this.workHour = workHour;
        this.pay = pay;
        this.type = type;
        this.room = room;
        this.meal = meal;
        this.creatorNumber = creatorNumber;
    }
}
