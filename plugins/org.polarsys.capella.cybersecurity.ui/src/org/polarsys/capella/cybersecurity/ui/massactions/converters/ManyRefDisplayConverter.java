/*******************************************************************************
 * Copyright (c) 2018, 2019 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui.massactions.converters;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.kitalpha.massactions.core.data.convert.MADisplayConverter;

// copied from capella, since package isn't exported..
// TODO Export the package and delete this class
public class ManyRefDisplayConverter extends MADisplayConverter {

  @Override
  @SuppressWarnings("unchecked")
  public String canonicalToDisplayValue(Object canonicalValue) {

    if (canonicalValue instanceof Collection<?>) {
      Collection<EObject> valueList = (Collection<EObject>) canonicalValue;
      return valueList.stream().map(EObjectLabelProviderHelper::getText).collect(Collectors.joining(", ")); //$NON-NLS-1$
    }

    // default behavior
    return EObjectLabelProviderHelper.getText(canonicalValue);
  }
}
