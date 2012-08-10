(ns au.com.permeance.clojure.portlet)

(defn set-render-parameter [response name value]
  (. response setRenderParameter name value))

(defn set-render-attribute [request name value]
  (. request setAttribute name value))

(defn get-request-paramater [request name]
  (. request getParameter name))

(defn dispatch [portlet path request response]
  (let [dispatcher (.. portlet (getPortletContext) (getRequestDispatcher path))]
   (. dispatcher include request response)))
