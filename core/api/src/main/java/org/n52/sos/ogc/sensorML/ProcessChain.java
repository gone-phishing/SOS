/**
 * Copyright (C) 2012-2016 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.sos.ogc.sensorML;

import java.util.ArrayList;
import java.util.List;

import org.n52.sos.ogc.sensorML.elements.SmlComponent;

public class ProcessChain extends AbstractProcess implements HasComponents<ProcessChain> {

    private static final long serialVersionUID = -3101809476636384049L;
    
    private final List<SmlComponent> components = new ArrayList<SmlComponent>(0);

    @Override
    public List<SmlComponent> getComponents() {
        return components;
    }
    
    @Override
    public ProcessChain addComponents(final List<SmlComponent> components) {
        if (components != null) {
            checkAndSetChildProcedures(components);
            this.components.addAll(components);
        }
        return this;
    }
    
    @Override
    public ProcessChain addComponent(final SmlComponent component) {
        if (component != null) {
            checkAndSetChildProcedures(component);
            components.add(component);
        }
        return this;
    }
    
    @Override
    public boolean isSetComponents() {
        return components != null && !components.isEmpty();
    }

    @Override
    public boolean isAggragation() {
        return true;
    }
    
}
