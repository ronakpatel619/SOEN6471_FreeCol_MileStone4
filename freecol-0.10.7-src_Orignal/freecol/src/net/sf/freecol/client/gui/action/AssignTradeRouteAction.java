/**
 *  Copyright (C) 2002-2012   The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  FreeCol is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FreeCol.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.freecol.client.gui.action;

import java.awt.event.ActionEvent;

import net.sf.freecol.client.FreeColClient;
import net.sf.freecol.client.control.InGameController;
import net.sf.freecol.client.gui.GUI;
import net.sf.freecol.common.model.Unit;

/**
 * An action for assigning a trade route to the currently selected unit.
 */
public class AssignTradeRouteAction extends UnitAction {

    public static final String id = "assignTradeRouteAction";
    private final InGameController inGameController;


    /**
     * Creates this action.
     *
     * @param freeColClient The main controller object for the client.
     * @param inGameController 
     * @param gui 
     */
    AssignTradeRouteAction(FreeColClient freeColClient, InGameController inGameController, GUI gui) {
        super(freeColClient, gui, id);
        this.inGameController = inGameController; 
    }

    /**
     * Checks if this action should be enabled.
     *
     * @return <code>true</code> if there is a carrier active
     */
    @Override
    protected boolean shouldBeEnabled() {
        if (super.shouldBeEnabled()) {
            Unit unit = gui.getActiveUnit();
            return (unit != null && unit.isCarrier());
        }
        return false;
    }

    /**
     * Applies this action.
     *
     * @param e The <code>ActionEvent</code>.
     */
    public void actionPerformed(ActionEvent e) {
        Unit unit = gui.getActiveUnit();
        if (unit != null) {
            inGameController.assignTradeRoute(unit);
        }
    }
}
