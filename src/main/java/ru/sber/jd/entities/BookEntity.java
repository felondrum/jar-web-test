package ru.sber.jd.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class BookEntity {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer year;
}
