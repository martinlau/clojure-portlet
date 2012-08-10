(ns au.com.permeance.clojure.clojure-portlet
  (:use au.com.permeance.clojure.portlet))

(defn
  ^{:action "clojure-action"}
  processClojureAction [portlet request response]
  (set-render-parameters response {:message "An action occurred"}))

(defn
  ^{:render "view"}
  processClojureRender [portlet request response]
  (let [param (first (:message (get-request-parameters request)))
        message (or param "Nothing happened")]
    (dispatch portlet "/view.jsp" {:message message} request response)))

(gen-portlet-class au.com.permeance.clojure.ClojurePortlet)
