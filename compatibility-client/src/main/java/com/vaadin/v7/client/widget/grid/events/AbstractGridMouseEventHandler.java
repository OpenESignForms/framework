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
package com.vaadin.v7.client.widget.grid.events;

import com.google.gwt.event.shared.EventHandler;
import com.vaadin.v7.client.widgets.Grid.AbstractGridMouseEvent;

/**
 * Base interface of all handlers for {@link AbstractGridMouseEvent}s.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public abstract interface AbstractGridMouseEventHandler extends EventHandler {

    public abstract interface GridClickHandler
            extends AbstractGridMouseEventHandler {
        public void onClick(GridClickEvent event);
    }

    public abstract interface GridDoubleClickHandler
            extends AbstractGridMouseEventHandler {
        public void onDoubleClick(GridDoubleClickEvent event);
    }

}
