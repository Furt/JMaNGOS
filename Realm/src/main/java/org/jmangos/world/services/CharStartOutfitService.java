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
package org.jmangos.world.services;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.commons.entities.pk.CharStartOutfitEntityPk;
import org.jmangos.realm.model.enums.Classes;
import org.jmangos.realm.model.enums.Races;

/**
 * @author MinimaJack
 * 
 */
public interface CharStartOutfitService {
    
    CharStartOutfitEntity readCharStartOutfitEntity(CharStartOutfitEntityPk pk);
    
    List<CharStartOutfitEntity> readCharStartOutfitEntities(final Criterion... criterions);
    
    CharStartOutfitEntityPk createOrUpdateCharStartOutfitEntity(CharStartOutfitEntity charStartOutfitEntity);
    
    void deleteCharStartOutfitEntity(CharStartOutfitEntity charStartOutfitEntity);
    
    List<CharStartOutfitEntity> readCharStartOutfitEntities(Races charRace, Classes charClass, Byte gender);
    
}
