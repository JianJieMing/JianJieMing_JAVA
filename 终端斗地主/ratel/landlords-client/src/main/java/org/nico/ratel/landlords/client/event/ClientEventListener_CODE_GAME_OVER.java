package org.nico.ratel.landlords.client.event;

import java.util.Map;

import org.nico.ratel.landlords.enums.ServerEventCode;
import org.nico.ratel.landlords.helper.MapHelper;
import org.nico.ratel.landlords.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_OVER extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		Map<String, Object> map = MapHelper.parser(data);
		SimplePrinter.printNotice(map.get("winnerNickname") + " wins");
		SimplePrinter.printNotice("Game over");
		pushToServer(channel, ServerEventCode.CODE_CLIENT_EXIT);
	}

}
