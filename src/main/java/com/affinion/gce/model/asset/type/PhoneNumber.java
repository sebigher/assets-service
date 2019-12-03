package com.affinion.gce.model.asset.type;

import com.affinion.gce.annotation.Validator;
import com.affinion.gce.jpa.entity.AssetAttributeEntity;
import com.affinion.gce.model.asset.Asset;
import com.affinion.gce.model.asset.AssetId;
import com.affinion.gce.validator.PhoneNumberValidator;
import lombok.*;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Validator(PhoneNumberValidator.class)
public class PhoneNumber extends Asset {
    private String number;

    public PhoneNumber(AssetId id, Long memberId, Long tenantId, Boolean active, String number){
        super(id, memberId, tenantId, active);
        this.number = number;
    }

    @Override
    public String hash() {
        return null;
    }

    @Override
    public List<AssetAttributeEntity> attributes() {
        return Collections.singletonList(new AssetAttributeEntity(type().id(), getNumber()));
    }
}