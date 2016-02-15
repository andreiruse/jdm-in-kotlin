package com.andreiruse.jdmengine.domain;

import com.andreiruse.jdmengine.domain.status.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public interface BpmnTask extends BpmnObject {
    TaskStatus status = null;
    String title = "";
    List<BpmnTask> incomingLinks = new ArrayList<>();
    List<BpmnTask> outgoingLinks = new ArrayList<>();

}
