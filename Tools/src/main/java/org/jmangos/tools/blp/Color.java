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
package org.jmangos.tools.blp;

// Yanked from http://forum.worldwindcentral.com/showthread.php?p=71605
public class Color {
    
    public int r, g, b;
    
    public Color() {
    
        this.r = this.g = this.b = 0;
    }
    
    public Color(final int r, final int g, final int b) {
    
        this.r = r;
        this.g = g;
        this.b = b;
        
        if (this.r < 0) {
            this.r = 256 + r;
        }
        if (this.g < 0) {
            this.g = 256 + g;
        }
        if (this.b < 0) {
            this.b = 256 + b;
        }
    }
    
    @Override
    public boolean equals(final Object o) {
    
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        
        final Color color = (Color) o;
        
        if (this.b != color.b) {
            return false;
        }
        if (this.g != color.g) {
            return false;
        }
        // noinspection RedundantIfStatement
        if (this.r != color.r) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
    
        int result;
        result = this.r;
        result = (29 * result) + this.g;
        result = (29 * result) + this.b;
        return result;
    }
    
    public int asInt() {
    
        return (this.r << 16) + (this.g << 8) + this.b;
    }
    
    @Override
    public String toString() {
    
        return "(" + this.r + "," + this.g + "," + this.b + ")";
    }
}
