package com.andreiruse.jdmengine.domain.status;

import java.time.LocalDateTime;

/**
 * Created by andreiruse on 13/02/16.
 */
public interface TaskStatus {
    public LocalDateTime stateEnteringTime = LocalDateTime.now();
    public LocalDateTime stateExitingTime = null;

}
