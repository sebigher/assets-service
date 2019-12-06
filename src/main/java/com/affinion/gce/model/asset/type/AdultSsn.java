package com.affinion.gce.model.asset.type;

import com.affinion.gce.annotation.Validator;
import com.affinion.gce.jpa.entity.AssetAttributeEntity;
import com.affinion.gce.jpa.entity.AssetEntity;
import com.affinion.gce.model.asset.Asset;
import com.affinion.gce.model.asset.AssetId;
import com.affinion.gce.validator.AdultSsnValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Validator(AdultSsnValidator.class)
public class AdultSsn extends Asset {
    private String ssn;

    public AdultSsn(AssetEntity entity) {
        super(entity);
        this.ssn = entity.attributeValue(type().id());
    }

    public AdultSsn(AssetId id, Long memberId, Long tenantId, Boolean active, String ssn) {
        super(id, memberId, tenantId, active);
        this.ssn = ssn;
    }

    @Override
    public List<AssetAttributeEntity> attributes() {
        return Collections.singletonList(new AssetAttributeEntity(type().id(), getSsn()));
    }
}
