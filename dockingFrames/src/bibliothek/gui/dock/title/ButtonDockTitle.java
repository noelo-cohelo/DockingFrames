/**
 * Bibliothek - DockingFrames
 * Library built on Java/Swing, allows the user to "drag and drop"
 * panels containing any Swing-Component the developer likes to add.
 * 
 * Copyright (C) 2007 Benjamin Sigg
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * Benjamin Sigg
 * benjamin_sigg@gmx.ch
 * 
 * Wunderklingerstr. 59
 * 8215 Hallau
 * CH - Switzerland
 */


package bibliothek.gui.dock.title;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

import bibliothek.gui.dock.Dockable;
import bibliothek.gui.dock.event.DockTitleEvent;

/**
 * This title changes its border whenever the active-state changes.
 * @author Benjamin Sigg
 */
public class ButtonDockTitle extends AbstractDockTitle {
    /**
     * Constructs a new title
     * @param dockable the {@link Dockable} for which this title is created
     * @param origin the version which was used to create this title
     */
    public ButtonDockTitle( Dockable dockable, DockTitleVersion origin ) {
        super(dockable, origin);
        setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED ));
    }
    
    @Override
    public void setActive( boolean active ) {
        if( active != isActive() ){
            super.setActive(active);
            changeBorder( active );
        }
    }
    
    @Override
    public void changed( DockTitleEvent event ) {
        super.setActive( event.isActive() );
        changeBorder( event.isActive() || event.isPreferred() );
    }
    
    /**
     * Exchanges the current border.
     * @param selected whether the title is selected (active) or not
     */
    protected void changeBorder( boolean selected ){
        if( selected )
            setBorder( BorderFactory.createBevelBorder( BevelBorder.LOWERED ));
        else
            setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED ));
    }
}