package com.andreiruse.jdmengine.domain;

import com.andreiruse.jdmengine.domain.status.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public interface GraphTask extends GraphObject {
    TaskStatus status = null;
    String title = "";
    List<GraphTask> incomingLinks = new ArrayList<>();
    List<GraphTask> outgoingLinks = new ArrayList<>();

}
