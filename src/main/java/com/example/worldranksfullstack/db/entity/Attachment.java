package com.example.worldranksfullstack.db.entity;

import com.example.worldranksfullstack.db.entity.template.AbsUUIDEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Attachment extends AbsUUIDEntity {

    String name;

    String extension;

    Long size;

    @OneToOne(mappedBy = "attachment")
    Flag flag;

    @OneToOne(fetch = FetchType.LAZY)
    AttachmentContent attachmentContent;
}
