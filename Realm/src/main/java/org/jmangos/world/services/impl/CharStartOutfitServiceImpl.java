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
package org.jmangos.world.services.impl;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.criteria4jpa.criterion.Restrictions;
import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.commons.entities.pk.CharStartOutfitEntityPk;
import org.jmangos.realm.model.enums.Classes;
import org.jmangos.realm.model.enums.Races;
import org.jmangos.world.dao.CharStartOutfitDao;
import org.jmangos.world.services.CharStartOutfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("charStartOutfitService")
public class CharStartOutfitServiceImpl implements CharStartOutfitService {
    
    @Autowired
    private CharStartOutfitDao charStartOutfitDao;
    
    @Override
    public CharStartOutfitEntity readCharStartOutfitEntity(final CharStartOutfitEntityPk pk) {
    
        return this.charStartOutfitDao.readCharStartOutfit(pk);
    }
    
    @Override
    public List<CharStartOutfitEntity> readCharStartOutfitEntities(final Criterion... criterions) {
    
        return this.charStartOutfitDao.readCharStartOutfits(criterions);
    }
    
    @Override
    public CharStartOutfitEntityPk createOrUpdateCharStartOutfitEntity(final CharStartOutfitEntity charStartOutfitEntity) {
    
        return this.charStartOutfitDao.createOrUpdateCharStartOutfitEntity(charStartOutfitEntity);
    }
    
    @Override
    public void deleteCharStartOutfitEntity(final CharStartOutfitEntity charStartOutfitEntity) {
    
        this.charStartOutfitDao.deleteCharStartOutfitEntity(charStartOutfitEntity);
    }
    
    @Override
    public List<CharStartOutfitEntity> readCharStartOutfitEntities(final Races charRace, final Classes charClass, final Byte gender) {
    
        final Criterion[] criter = new Criterion[3];
        criter[0] = Restrictions.eq("charStartOutfitEntityPk.clazz", (byte) charClass.getValue());
        criter[1] = Restrictions.eq("charStartOutfitEntityPk.race", (byte) charRace.getValue());
        criter[2] = Restrictions.eq("charStartOutfitEntityPk.gender", gender);
        
        return this.charStartOutfitDao.readCharStartOutfits(criter);
    }
    
}
