/**
 * Licensed under the GPL License. You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE.
 */
package psiprobe.controllers.apps;

import org.apache.catalina.Context;
import org.springframework.web.servlet.ModelAndView;

import psiprobe.controllers.AbstractContextHandlerController;
import psiprobe.tools.ApplicationUtils;
import psiprobe.tools.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Retrieves a list of context initialization parameters for a web application.
 */
public class ListAppInitParamsController extends AbstractContextHandlerController {

  @Override
  protected ModelAndView handleContext(String contextName, Context context,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    ModelAndView mv =
        new ModelAndView(getViewName(), "appInitParams", ApplicationUtils.getApplicationInitParams(
            context, getContainerWrapper()));
    if (SecurityUtils.hasAttributeValueRole(getServletContext(), request)) {
      mv.addObject("allowedToViewValues", Boolean.TRUE);
    }
    return mv;
  }

}
