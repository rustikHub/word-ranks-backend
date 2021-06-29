package com.example.worldranksfullstack.db.entity;

import com.example.worldranksfullstack.db.entity.template.AbsIntegerEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Info extends AbsIntegerEntity {
    Date requestDate;
}
