package com.affinion.gce.model.asset.type;

import com.affinion.gce.annotation.Validator;
import com.affinion.gce.jpa.entity.AssetAttributeEntity;
import com.affinion.gce.jpa.entity.AssetEntity;
import com.affinion.gce.model.asset.Asset;
import com.affinion.gce.model.asset.AssetId;
import com.affinion.gce.validator.IdentityCardValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Validator(IdentityCardValidator.class)
public class IdentityCard extends Asset {
    @JsonProperty("identity_card")
    private String identifier;

    public IdentityCard(AssetEntity entity) {
        super(entity);
        this.identifier = entity.attributeValue(type().id());
    }

    public IdentityCard(AssetId id, Long memberId, Long tenantId, Boolean active, String identifier) {
        super(id, memberId, tenantId, active);
        this.identifier = identifier;
    }

    @Override
    public List<AssetAttributeEntity> attributes() {
        return Collections.singletonList(new AssetAttributeEntity(type().id(), getIdentifier()));
    }
}
