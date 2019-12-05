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
package org.polarsys.capella.cybersecurity.test.common;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class StatusMatcher {

  public static Matcher<IStatus> okStatus(){
    return new TypeSafeMatcher<IStatus>() {
      @Override
      public void describeTo(Description description) {
        description.appendText(Status.OK_STATUS.toString());
      }
  
      @Override
      protected boolean matchesSafely(IStatus item) {
        return item.isOK();
      }
    };
  }

  public static FeatureMatcher<IStatus, Integer> severity(Matcher<? super Integer> matcher){
    return new FeatureMatcher<IStatus, Integer>(matcher, "validation result severity", "severity") { //$NON-NLS-1$ //$NON-NLS-2$
      @Override
      protected Integer featureValueOf(IStatus actual) {
        return actual.getSeverity();
      }
    };
  }

}
