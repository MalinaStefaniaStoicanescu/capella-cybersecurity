/*******************************************************************************
 * Copyright (c) 2019, 2020 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;
import org.polarsys.kitalpha.massactions.core.painter.cell.TextAndLabelImagePainter;

public class InvolvedActorsByThreatColumn extends AbstractCybersecurityColumn {
  public InvolvedActorsByThreatColumn() {
    id = getClass().getCanonicalName();
    label = Messages.ThreatColumns_Label_InvolvedActors;
    name = Messages.ThreatColumns_Name_InvolvedActors;
  }
  @Override
  public Object getDataValue(EObject rowObject) {
    return 
        Stream.concat(
            CybersecurityQueries.getInvolvedActors((Threat)rowObject),
            CybersecurityQueries.getInvolvedThreatSources((Threat) rowObject))
        .collect(Collectors.toList());
  }
  
  @Override
  protected ICellPainter createCellPainter() {    
    return new TextAndLabelImagePainter();
  }
 
}