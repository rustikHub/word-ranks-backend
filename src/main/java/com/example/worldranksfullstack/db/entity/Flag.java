package com.example.worldranksfullstack.db.entity;

import com.example.worldranksfullstack.db.entity.template.AbsIntegerEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Flag extends AbsIntegerEntity {

    @OneToOne(mappedBy = "flag")
    Country country;

    @OneToOne
    Attachment attachment;

}
