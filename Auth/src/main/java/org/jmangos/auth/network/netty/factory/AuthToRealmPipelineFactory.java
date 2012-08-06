/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
/**
 * 
 */
package org.jmangos.auth.network.netty.factory;

import static org.jboss.netty.channel.Channels.*;

import org.jboss.netty.channel.ChannelPipeline;
import org.jmangos.auth.network.netty.handler.EventLogHandler;
import org.jmangos.auth.network.netty.handler.AuthToClientChannelHandler;
import org.jmangos.commons.network.handlers.PacketHandlerFactory;
import org.jmangos.commons.network.model.ConnectHandler;
import org.jmangos.commons.network.netty.factory.BasicPipelineFactory;
import org.jmangos.commons.network.netty.receiver.NettyPacketReceiver;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * A factory for creating Auth-Realm Pipeline objects.
 * 
 * @author MinimaJack
 */
public class AuthToRealmPipelineFactory extends BasicPipelineFactory {

	/** The connection handler. */
	@Inject
	@Named("AuthToClient")
	private ConnectHandler connectionHandler;

	/** The packet service. */
	@Inject
	@Named("AuthToRealm")
	private PacketHandlerFactory packetService;

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
	 */
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = pipeline();

		pipeline.addLast("executor", getExecutorHandler());

		pipeline.addLast("eventlog", new EventLogHandler());

		pipeline.addLast("handler", new AuthToClientChannelHandler(
				packetService, connectionHandler, new NettyPacketReceiver()));

		return pipeline;
	}
}
