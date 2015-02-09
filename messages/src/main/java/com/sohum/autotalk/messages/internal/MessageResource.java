package com.sohum.autotalk.messages.internal;

import com.google.common.collect.Lists;
import com.sohum.autotalk.communication.ICommunicationResource;
import com.sohum.autotalk.messages.IMessageResource;
import com.sohum.autotalk.messages.request.MessageRequest;
import com.sohum.autotalk.traffic.INeighbourResource;
import com.sohum.autotalk.traffic.response.NeighbourResponse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class MessageResource implements IMessageResource {

  private INeighbourResource neighbourResource;
  private ICommunicationResource communicationResource;

  @Inject
  public MessageResource(INeighbourResource neighbourResource,
                         ICommunicationResource communicationResource) {
    this.neighbourResource = neighbourResource;
    this.communicationResource = communicationResource;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public String doBroadcast(MessageRequest request) {
    // Find neighbours
    List<NeighbourResponse.Neighbour> neighbourList = neighbourResource.getNeighbours(request.getUserId()).getUserList();

    List<Integer> userIdList = Lists.newArrayList();
    for (NeighbourResponse.Neighbour n : neighbourList) {
      userIdList.add(n.getUserId());
    }

    // Send messages
    communicationResource.sendBulkMessage(userIdList, request.getMessage());

    return "Send to " + userIdList.size() + " people";
  }
}
