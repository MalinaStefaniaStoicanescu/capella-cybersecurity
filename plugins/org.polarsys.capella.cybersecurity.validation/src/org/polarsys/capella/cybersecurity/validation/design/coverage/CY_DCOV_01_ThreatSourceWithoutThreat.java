/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.validation.design.coverage;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;

/**
 * A threat source component must be involved in a Threat
 */
public class CY_DCOV_01_ThreatSourceWithoutThreat extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    Component c = (Component) ctx.getTarget();
    if (CybersecurityQueries.isThreatSource(c) && !CybersecurityQueries.getInvolvingThreats(c).findAny().isPresent()) {
      return ctx.createFailureStatus(c, NamingHelper.getTitleLabel(c));
    }
    return ctx.createSuccessStatus();
  }

}
