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
package org.jmangos.realm.model.base.update;
import static org.jmangos.realm.model.base.update.ObjectFields.OBJECT_END;
// TODO: Auto-generated Javadoc
/**
 * The Class CorpseFields.
 */
public enum CorpseFields implements UpdateField {
    
    /** The CORPS e_ fiel d_ owner. */
    CORPSE_FIELD_OWNER( OBJECT_END + 0x0000 ), 		 // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The CORPS e_ fiel d_ party. */
    CORPSE_FIELD_PARTY( OBJECT_END + 0x0002 ), 		 // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The CORPS e_ fiel d_ displa y_ id. */
    CORPSE_FIELD_DISPLAY_ID( OBJECT_END + 0x0004 ), 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The CORPS e_ fiel d_ item. */
    CORPSE_FIELD_ITEM( OBJECT_END + 0x0005 ), 		 // Size: 19, Type: INT, Flags: PUBLIC
    
    /** The CORPS e_ fiel d_ byte s_1. */
    CORPSE_FIELD_BYTES_1( OBJECT_END + 0x0018 ), 		 // Size: 1, Type: BYTES, Flags: PUBLIC
    
    /** The CORPS e_ fiel d_ byte s_2. */
    CORPSE_FIELD_BYTES_2( OBJECT_END + 0x0019 ), 		 // Size: 1, Type: BYTES, Flags: PUBLIC
    
    /** The CORPS e_ fiel d_ guild. */
    CORPSE_FIELD_GUILD( OBJECT_END + 0x001A ), 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The CORPS e_ fiel d_ flags. */
    CORPSE_FIELD_FLAGS( OBJECT_END + 0x001B ), 		 // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The CORPS e_ fiel d_ dynami c_ flags. */
    CORPSE_FIELD_DYNAMIC_FLAGS( OBJECT_END + 0x001C ), 		 // Size: 1, Type: INT, Flags: DYNAMIC
    
    /** The CORPS e_ fiel d_ pad. */
    CORPSE_FIELD_PAD( OBJECT_END + 0x001D ); 		 // Size: 1, Type: INT, Flags: NONE
    
    /** The CORPS e_ end. */
    public static int CORPSE_END = OBJECT_END + 0x001E;

    int value;
    CorpseFields( int value ) {
        this.value = value;
    }

    @Override
    public UpdateFieldType getType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getSize() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
