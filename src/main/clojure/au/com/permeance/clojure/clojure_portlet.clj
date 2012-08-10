(ns au.com.permeance.clojure.clojure-portlet)

(gen-class
  :name au.com.permeance.clojure.ClojurePortlet
        :extends javax.portlet.GenericPortlet
        :main false
        :methods [[^{javax.portlet.ProcessAction {:name "clojure-action"}}
                   processClojureAction [javax.portlet.ActionRequest javax.portlet.ActionResponse] void]

                  [^{javax.portlet.RenderMode {:name "view"}}
                   processClojureRender [javax.portlet.RenderRequest javax.portlet.RenderResponse] void]])

(defn -processClojureAction [portlet request response]
  (. response setRenderParameter "message" "An action occurred"))

(defn -processClojureRender [portlet request response]
  (let [message (or (. request getParameter "message") "Nothing happened")]
    (. request setAttribute "message" message))
  (let [context (. portlet getPortletContext)
        dispatcher (. context getRequestDispatcher "/view.jsp")]
    (. dispatcher include request response)))
