package www.com.websocket;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketServer extends TextWebSocketHandler{

	private static final Map<WebSocketSession, String> connections = new ConcurrentHashMap<>();
	
	private static String getDatetime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String uri = session.getUri().toString();
		String userName = uri.substring(uri.lastIndexOf("/") + 1);
		
		String nickname = URLDecoder.decode(userName, "utf-8");

		connections.put(session, nickname);
		String message = String.format("* %s %s", nickname, "加入聊天！");

		broadcast(new TextMessage(message));
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String msg = "【" + connections.get(session) + "】" + getDatetime(new Date()) + " : " + message.getPayload();
		broadcast(new TextMessage(msg));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String nickname = connections.remove(session);
		String message = String.format("* %s %s", nickname, "退出聊天！");
		broadcast(new TextMessage(message));
	}

	private static void broadcast(TextMessage msg) {
		// 广播形式发送消息
		for (WebSocketSession session : connections.keySet()) {
			try {
				synchronized (session) {
					session.sendMessage(msg);
				}
			} catch (Exception e) {
				connections.remove(session);
				try {
					session.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				String message = String.format("* %s %s", connections.get(session), "断开连接");
				broadcast(new TextMessage(message));
			}
		}
	}
	
}
