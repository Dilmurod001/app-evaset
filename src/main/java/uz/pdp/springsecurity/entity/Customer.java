package uz.pdp.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.pdp.springsecurity.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer extends AbsEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String telegram;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Business business;

    private Double debt;

    public Customer( String name, String phoneNumber, String telegram, Business business) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.telegram = telegram;
        this.business = business;
    }
}
