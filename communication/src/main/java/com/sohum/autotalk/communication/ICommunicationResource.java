package com.sohum.autotalk.communication;

import java.util.List;

public interface ICommunicationResource {
  void sendMessage(Integer userId, String message);
  void sendBulkMessage(List<Integer> userList, String message);
}
