package com.example.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    @ToString.Exclude
    private Set<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;

        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return 1128121276;
    }
}
