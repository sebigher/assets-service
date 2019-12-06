package com.affinion.gce.model.asset.type;

import com.affinion.gce.annotation.Validator;
import com.affinion.gce.jpa.entity.AssetAttributeEntity;
import com.affinion.gce.jpa.entity.AssetEntity;
import com.affinion.gce.model.asset.Asset;
import com.affinion.gce.model.asset.AssetId;
import com.affinion.gce.validator.OtherIdValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Validator(OtherIdValidator.class)
public class OtherIdentifier extends Asset {
    @JsonProperty("online_id")
    private String identifier;

    public OtherIdentifier(AssetEntity entity) {
        super(entity);
        this.identifier = entity.attributeValue(type().id());
    }

    public OtherIdentifier(AssetId id, Long memberId, Long tenantId, Boolean active, String identifier) {
        super(id, memberId, tenantId, active);
        this.identifier = identifier;
    }

    @Override
    public List<AssetAttributeEntity> attributes() {
        return Collections.singletonList(new AssetAttributeEntity(type().id(), getIdentifier()));
    }
}
