package companies.middle.queries;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table
@Builder
public class Request {
    @Id @GeneratedValue
    private int id;
    private String domain;
    private String name;
    private String twitter;
    private String facebook;
    private String logo;
    private String icon;
    private String employees;
    private String address;

}
