package com.backend.gatewayservice.communication.handler;

import com.backend.domain.model.type.CommunicationEventType;

public interface CommunicationHandler {
	<T> Boolean processCommunicationEvent(CommunicationEventType communicationEventType, T object);
}
