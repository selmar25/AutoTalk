package com.sohum.autotalk.messages;

import com.sohum.autotalk.messages.request.MessageRequest;

public interface IMessageResource {
  void doBroadcast(MessageRequest request);
}
