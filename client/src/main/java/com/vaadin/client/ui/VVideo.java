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

package com.vaadin.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.VideoElement;
import com.vaadin.client.Util;

/**
 * Widget class for the Video component.
 *
 * @author Vaadin Ltd
 *
 */
public class VVideo extends VMediaBase {

    /** Default classname for this widget. */
    public static String CLASSNAME = "v-video";

    private VideoElement video;

    /**
     * Constructs a widget for the Video component.
     */
    public VVideo() {
        video = Document.get().createVideoElement();
        setMediaElement(video);
        setStyleName(CLASSNAME);

        updateDimensionsWhenMetadataLoaded(getElement());
    }

    /**
     * Registers a listener that updates the dimensions of the widget when the
     * video metadata has been loaded.
     *
     * @param el
     *            the root element of this widget
     */
    private native void updateDimensionsWhenMetadataLoaded(Element el)
    /*-{
              var self = this;
              el.addEventListener('loadedmetadata', $entry(function(e) {
                  self.@com.vaadin.client.ui.VVideo::updateElementDynamicSize(II)(el.videoWidth, el.videoHeight);
              }), false);
    
    }-*/;

    /**
     * Updates the dimensions of the widget.
     *
     * @param width
     *            width to set (in pixels)
     * @param height
     *            height to set (in pixels)
     */
    @SuppressWarnings("deprecation")
    private void updateElementDynamicSize(int width, int height) {
        video.getStyle().setWidth(width, Unit.PX);
        video.getStyle().setHeight(height, Unit.PX);
        Util.notifyParentOfSizeChange(this, true);
    }

    /**
     * Sets the poster URL.
     *
     * @param poster
     *            the poster image URL
     */
    public void setPoster(String poster) {
        video.setPoster(poster);
    }

}
