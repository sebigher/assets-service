package com.affinion.gce.model.asset.type;

import com.affinion.gce.annotation.Validator;
import com.affinion.gce.jpa.entity.AssetAttributeEntity;
import com.affinion.gce.model.asset.Asset;
import com.affinion.gce.model.asset.AssetId;
import com.affinion.gce.validator.PassportValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Validator(PassportValidator.class)
public class Passport extends Asset {
    @JsonProperty("passport_number")
    private String passport;

    @Builder
    public Passport(AssetId id, Long memberId, Long tenantId, Boolean active, String passport){
        super(id, memberId, tenantId, active);
        this.passport = passport;
    }

    @Override
    public String hash() {
        return null;
    }

    @Override
    public List<AssetAttributeEntity> attributes() {
        return Collections.singletonList(new AssetAttributeEntity(type().id(), getPassport()));
    }
}