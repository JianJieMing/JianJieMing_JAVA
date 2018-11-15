package org.nico.ratel.landlords.client.event;

import org.nico.ratel.landlords.enums.ServerEventCode;
import org.nico.ratel.landlords.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_POKER_PLAY_INVALID extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		
		SimplePrinter.printNotice("Out pokers' format is invalid");
		pushToServer(channel, ServerEventCode.CODE_GAME_POKER_PLAY_REDIRECT);
	}

}
