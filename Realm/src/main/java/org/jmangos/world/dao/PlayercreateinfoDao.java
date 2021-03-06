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
package org.jmangos.world.dao;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.domain.PlayercreateinfoPK;
import org.jmangos.world.entities.Playercreateinfo;

public interface PlayercreateinfoDao {
    
    public Playercreateinfo readPlayercreateinfo(PlayercreateinfoPK pk);
    
    public List<Playercreateinfo> readPlayercreateinfos(final Criterion... criterions);
    
    public PlayercreateinfoPK createOrUpdatePlayercreateinfo(Playercreateinfo playercreateinfo);
    
    public void deletePlayercreateinfo(Playercreateinfo playercreateinfo);
    
}
