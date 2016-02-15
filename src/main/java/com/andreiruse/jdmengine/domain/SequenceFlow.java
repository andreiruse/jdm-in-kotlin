package com.andreiruse.jdmengine.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.w3c.dom.NamedNodeMap;

public class SequenceFlow implements GraphEdge {

    private final String sourceRef;
    private final String targetRef;
    private final String id;

    public SequenceFlow(NamedNodeMap map) {
        id = map.getNamedItem("id").getNodeName();
        sourceRef = map.getNamedItem("sourceRef").getNodeName();
        targetRef = map.getNamedItem("targetRef").getNodeName();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sourceRef", sourceRef)
                .append("targetRef", targetRef)
                .toString();
    }
}
