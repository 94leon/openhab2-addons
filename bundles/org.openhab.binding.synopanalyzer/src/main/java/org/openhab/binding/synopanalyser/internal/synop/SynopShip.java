/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.synopanalyser.internal.synop;

import java.util.ArrayList;

/**
 * The {@link SynopMobile} is responsible for analyzing Mobile station
 * specifics Synop messages
 *
 * @author Jonarzz - Initial contribution
 */
public class SynopShip extends SynopMobile {

    public SynopShip(ArrayList<String> stringArray) {
        super(stringArray);
    }

    @Override
    protected void setPressureString() {
        String temp;
        if (stringArray.size() < 10 || !isValidString((temp = stringArray.get(9))) || temp.charAt(0) != '4'
                || temp.charAt(1) != '0' || temp.charAt(1) != '9') {
            return;
        }

        pressureString = temp;
    }
}
