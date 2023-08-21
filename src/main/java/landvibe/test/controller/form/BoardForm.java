package landvibe.test.controller.form;

import lombok.*;

@Data
public class BoardForm {
    private String title;
    private String region;
    private String location;
    private String deadline;
    private String workTerm;
    private String workDay;
    private String workHour;
    private Long pay;
    private String type;
    private Boolean room;
    private Boolean meal;
    private String creatorNumber;
}
