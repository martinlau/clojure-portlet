package au.com.permeance.clojure;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

public class ClojurePortlet extends GenericPortlet {

    @ProcessAction(name = "clojure-action")
    public void processClojureAction(ActionRequest request, ActionResponse response) {
        response.setRenderParameter("message", "An action occurred");
    }

    @RenderMode(name = "view")
    public void processClojureRender(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        String message = request.getParameter("message");
        if (message == null) {
            message = "Nothing happened";
        }
        request.setAttribute("message", message);

        PortletContext context = getPortletContext();
        PortletRequestDispatcher dispatcher = context.getRequestDispatcher("/view.jsp");
        dispatcher.include(request, response);
    }

}
