package landvibe.test.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "LOCAL") //외국인 내국인
    private Boolean local;
    @Column(name = "APPROVE") //승인여부
    private Boolean approve;
    @Column(name = "REGISTRATION_NUMBER") //외국인 등록번호
    private String registrationNumber;
    @Column(name = "ISSUE_DATE") //발급일자
    private String issueDate;


    @Builder
    public Member(String name, String email, String password,
                  Boolean local, Boolean approve, String registrationNumber, String issueDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.local = local;
        this.approve = approve;
        this.registrationNumber = registrationNumber;
        this.issueDate = issueDate;
    }

}
