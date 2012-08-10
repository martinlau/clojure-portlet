(ns au.com.permeance.clojure.portlet)

(defn- do-with-map [f m]
  (doseq [kv m]
    (let [k (name (key kv))
          v (val kv)]
      (f k v))))

(defn- set-render-attributes [request attributes]
  (do-with-map #(. request setAttribute %1 %2) attributes))

(defn dispatch
  ([portlet path request response]
   (let [dispatcher (.. portlet (getPortletContext) (getRequestDispatcher path))]
     (. dispatcher include request response)))
  ([portlet path attributes request response]
   (set-render-attributes request attributes)
   (dispatch portlet path request response)))

(defn get-request-parameters [request]
  (let [parameters (. request getParameterMap)]
    (into {} (for [[k v] parameters] [(keyword k) v]))))

(defn set-render-parameters [response parameters]
  (do-with-map #(. response setRenderParameter %1 %2) parameters))

