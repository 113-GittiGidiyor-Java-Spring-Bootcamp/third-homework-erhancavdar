package com.example.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = Instructor.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructor.class),
        @JsonSubTypes.Type(value = VisitingResearcher.class)
})
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phoneNumber;
    @OneToMany(mappedBy = "instructor")
    @JsonIgnore
    private List<Course> courses;
}
