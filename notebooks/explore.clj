(ns explore
  (:require [tablecloth.api :as tc]
            [scicloj.tableplot.v1.plotly :as plotly]
            [java-time :as jt]))

;;; Import the data ;;;

(def workshop-data
  (tc/dataset "data/clt-311-workshop.csv"
              {:key-fn keyword}))

;;; Some Helpers ;;;

(def src-fmt
  (jt/formatter "yyyy/MM/dd HH:mm:ssX"))

(defn ->first-day-of_month [date-str]
  (->> date-str
       (jt/local-date src-fmt)
       (#(jt/adjust % :first-day-of-month))))

(defn ->month [date-str]
  (->> date-str
       (jt/local-date src-fmt)
       (jt/month)))

(def top-five-requests
  (-> workshop-data
      (tc/group-by :REQUEST_TYPE)
      (tc/aggregate {:count tc/row-count})
      (tc/order-by :count :desc)
      (tc/head 5)
      :$group-name
      set))

;;; End Helpers ;;;

