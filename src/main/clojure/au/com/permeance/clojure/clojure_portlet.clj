(ns au.com.permeance.clojure.clojure-portlet
  (:use au.com.permeance.clojure.portlet))

(gen-class
  :name au.com.permeance.clojure.ClojurePortlet
        :extends javax.portlet.GenericPortlet
        :main false
        :methods [[^{javax.portlet.ProcessAction {:name "clojure-action"}}
                   processClojureAction [javax.portlet.ActionRequest javax.portlet.ActionResponse] void]

                  [^{javax.portlet.RenderMode {:name "view"}}
                   processClojureRender [javax.portlet.RenderRequest javax.portlet.RenderResponse] void]])

(defn -processClojureAction [portlet request response]
  (set-render-parameter response "message" "An action occurred"))

(defn -processClojureRender [portlet request response]
  (set-render-attribute request "message"
    (or (get-request-paramater request "message") "Nothing happened"))
  (dispatch portlet "/view.jsp" request response))
