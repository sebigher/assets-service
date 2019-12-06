package com.affinion.gce.model.asset.type;

import com.affinion.gce.annotation.Validator;
import com.affinion.gce.jpa.entity.AssetAttributeEntity;
import com.affinion.gce.jpa.entity.AssetEntity;
import com.affinion.gce.model.asset.Asset;
import com.affinion.gce.model.asset.AssetId;
import com.affinion.gce.validator.DriversLicenseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Validator(DriversLicenseValidator.class)
public class DriversLicense extends Asset {
    @JsonProperty("license_number")
    private String number;

    public DriversLicense(AssetEntity entity) {
        super(entity);
        this.number = entity.attributeValue(type().id());
    }

    public DriversLicense(AssetId id, Long memberId, Long tenantId, Boolean active, String number) {
        super(id, memberId, tenantId, active);
        this.number = number;
    }

    @Override
    public List<AssetAttributeEntity> attributes() {
        return Collections.singletonList(new AssetAttributeEntity(type().id(), getNumber()));
    }
}
