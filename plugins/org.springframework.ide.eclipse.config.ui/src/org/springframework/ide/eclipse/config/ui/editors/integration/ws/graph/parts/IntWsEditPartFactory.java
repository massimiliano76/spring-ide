/*******************************************************************************
 *  Copyright (c) 2012 VMware, Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      VMware, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.config.ui.editors.integration.ws.graph.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.springframework.ide.eclipse.config.ui.editors.integration.ws.graph.model.HeaderEnricherModelElement;
import org.springframework.ide.eclipse.config.ui.editors.integration.ws.graph.model.InboundGatewayModelElement;
import org.springframework.ide.eclipse.config.ui.editors.integration.ws.graph.model.OutboundGatewayModelElement;


/**
 * @author Leo Dos Santos
 */
public class IntWsEditPartFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if (model instanceof HeaderEnricherModelElement) {
			part = new HeaderEnricherGraphicalEditPart((HeaderEnricherModelElement) model);
		}
		else if (model instanceof InboundGatewayModelElement) {
			part = new InboundGatewayGraphicalEditPart((InboundGatewayModelElement) model);
		}
		else if (model instanceof OutboundGatewayModelElement) {
			part = new OutboundGatewayGraphicalEditPart((OutboundGatewayModelElement) model);
		}
		return part;
	}

}
