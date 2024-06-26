/*
 * Copyright 2000-2022 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.client.ui.dd;

import com.vaadin.client.UIDL;
import com.vaadin.event.dd.acceptcriteria.TargetDetailIs;
import com.vaadin.shared.ui.dd.AcceptCriterion;
import com.vaadin.ui.dnd.DropTargetExtension;

/**
 *
 * @author Vaadin Ltd
 * @deprecated Replaced in 8.1 with
 *             {@link DropTargetExtension#setDropCriteria(String)}
 */
@Deprecated
@AcceptCriterion(TargetDetailIs.class)
public final class VTargetDetailIs extends VAcceptCriterion {

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        String name = configuration.getStringAttribute("p");
        String t = configuration.hasAttribute("t")
                ? configuration.getStringAttribute("t").intern()
                : "s";
        Object value = null;
        if (t == "s") {
            value = configuration.getStringAttribute("v");
        } else if (t == "b") {
            value = configuration.getBooleanAttribute("v");
        }
        if (value != null) {
            Object object = drag.getDropDetails().get(name);
            if (object instanceof Enum) {
                return ((Enum<?>) object).name().equals(value);
            } else {
                return value.equals(object);
            }
        } else {
            return false;
        }

    }
}
