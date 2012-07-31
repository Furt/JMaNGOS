/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.network.netty.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.JMANGOS.realm.network.netty.packet.server.SMSG_AUTH_CHALLENGE;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandler;
import org.JMANGOS.common.network.model.ConnectHandler;
import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.network.model.State;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
/**
 * The Class R2CConnectHandler.
 */
public class R2CConnectHandler implements ConnectHandler {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(R2CConnectHandler.class);
	
	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ConnectHandler#onConnect(org.wowemu.common.network.model.NettyNetworkChannel, org.jboss.netty.channel.ChannelHandler)
	 */
	@Override
	public void onConnect(NettyNetworkChannel networkChannel,
			ChannelHandler handler) {
		networkChannel.setChannelState(State.CONNECTED);
		log.info("Accepting connection from: "
				+ networkChannel.getAddress());
		sender.send(networkChannel, new SMSG_AUTH_CHALLENGE());
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ConnectHandler#onDisconnect(org.wowemu.common.network.model.NettyNetworkChannel)
	 */
	@Override
	public void onDisconnect(NettyNetworkChannel networkChannel) {
		log
				.info("Disconnection : "
						+ networkChannel.getAddress().getHostName());

	}

}
