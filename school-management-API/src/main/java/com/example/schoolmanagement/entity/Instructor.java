package com.example.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    @ToString.Exclude
    private List<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Instructor that = (Instructor) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1241250265;
    }
}
