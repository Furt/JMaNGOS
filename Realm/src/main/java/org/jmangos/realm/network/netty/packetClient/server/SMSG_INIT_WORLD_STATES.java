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

import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_INIT_WORLD_STATES.
 */
public class SMSG_INIT_WORLD_STATES extends AbstractWoWServerPacket {
    
    /** The player. */
    private Player player;
    
    /**
     * Instantiates a new sMS g_ ini t_ worl d_ states.
     */
    public SMSG_INIT_WORLD_STATES() {
    
    }
    
    /**
     * Instantiates a new sMS g_ ini t_ worl d_ states.
     * 
     * @param player
     *            the player
     */
    public SMSG_INIT_WORLD_STATES(final Player player) {
    
        this.player = player;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {
    
        writeD(this.player.GetMapId());
        writeD(0xD7);
        writeD(0xDD);
        writeD(0x12);
        writeB(new byte[] { 0x12, 0x00, (byte) 0xD8, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xD7, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                (byte) 0xD6, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xD5, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xD4, 0x08, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, (byte) 0xD3, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x77, 0xC, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x3D, 0x0F, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x14, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x13, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x12, 0x09, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x15, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0x95, 0x07, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00,
                (byte) 0x96, 0x07, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0x97, 0x07, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x23, 0x0B, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x6F, 0xE, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xB1, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
        
    }
}
