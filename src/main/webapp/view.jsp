<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<portlet:defineObjects />

<p>
    Hello from Clojure
</p>

<p>
    <%= renderRequest.getAttribute("message") %>
</p>

<portlet:actionURL var="actionURL">
    <portlet:param name="javax.portlet.action" value="clojure-action" />
</portlet:actionURL>

<p>
    <a href="${actionURL}">Run an action</a>
</p>
