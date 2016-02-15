package com.andreiruse.jdmengine.domain;

import com.andreiruse.jdmengine.domain.status.TaskStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphTask implements GraphObject {
    private final Node taskId;
    private final Node taskTitle;
    private final TaskStatus status = null;
    private final List<String> incomingLinkNames = new ArrayList<>();
    private final List<String> outgoingLinkNames = new ArrayList<>();

    public GraphTask(NamedNodeMap map, NodeList nodeList) {
        this.taskId = map.getNamedItem("id");
        this.taskTitle = map.getNamedItem("name");
        List<Node> edges = IntStream.range(0, nodeList.getLength()).boxed().map(nodeList::item).collect(Collectors.toList());
        edges.stream().map(Node::getNodeName).filter("bpmn:incoming"::equals).forEach(incomingLinkNames::add);
        edges.stream().map(Node::getNodeName).filter("bpmn:outgoing"::equals).forEach(outgoingLinkNames::add);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("taskId", taskId)
                .append("taskTitle", taskTitle)
                .append("status", status)
                .append("incomingLinkNames", incomingLinkNames)
                .append("outgoingLinkNames", outgoingLinkNames)
                .toString();
    }
}
