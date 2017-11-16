package com.kpi.sft.core;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

public class CollectionsComplementor<T> {

    private Collection<? extends T> commonPart;

    public CollectionsComplementor(Collection<? extends T> commonPart) {
        this.commonPart = commonPart;
    }

    public Collection<T> findComplementFor(Collection<? extends T> part) {
        return CollectionUtils.subtract(part, commonPart);
    }
}
