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
package org.JMANGOS.login.network.handler;

import org.JMANGOS.common.network.handlers.AbstractPacketHandlerFactory;
import org.JMANGOS.common.network.netty.model.PacketData;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating L2RPacketHandler objects.
 */
/**
 * @author MinimaJack
 *
 */
public class L2RPacketHandlerFactory extends AbstractPacketHandlerFactory {

	/**
	 * Instantiates a new l2 r packet handler factory.
	 */
	public L2RPacketHandlerFactory() {
		addList(loadStaticData(PacketData.class,
				"./data/packetData/packets.xsd",
				"./data/packetData/lr-packets.xml"));
	}
}
