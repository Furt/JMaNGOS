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
package org.jmangos.realm.network.netty.packetClient.server;

import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_MOTD.
 */
public class SMSG_MOTD extends AbstractWoWServerPacket {

	/** The motd. */
	private String[] motd; 
	
	/**
	 * Instantiates a new sMS g_ motd.
	 */
	public SMSG_MOTD() {
	}

	/**
	 * Instantiates a new sMS g_ motd.
	 *
	 * @param motd the motd
	 */
	public SMSG_MOTD(String[] motd) {
		this.motd  = motd;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeD(motd.length);
		for (int i = 0; i < motd.length; i++) {
			writeS(motd[i]);	
		}
		
	}

}