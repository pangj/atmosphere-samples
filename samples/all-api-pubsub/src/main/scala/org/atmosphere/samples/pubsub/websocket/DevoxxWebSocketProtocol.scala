/*
 * Copyright 2015 Async-IO.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.atmosphere.samples.pubsub.websocket

import java.io.Serializable
import org.atmosphere.websocket.WebSocket
import org.atmosphere.cpr.AtmosphereRequest
import org.atmosphere.websocket.protocol.SimpleHttpProtocol

class DevoxxWebSocketProtocol extends SimpleHttpProtocol with Serializable {

  override def onMessage(webSocket: WebSocket, message: String): java.util.List[AtmosphereRequest] = {
    if (message.startsWith("message=devoxx:")) {
      webSocket.write(webSocket.resource.getResponse, message.substring("message=".length()))
      null
    } else super.onMessage(webSocket, message)
  }
}