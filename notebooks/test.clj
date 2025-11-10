(ns test
  (:require [tablecloth.column.api :as tcc]))
;;=> nil

(tcc/+ [1 2 3] [4 5 6])
;;=> #tech.v3.dataset.column<int64>[3]
;;   null
;;   [5, 7, 9]

![desired output](test-output.png)

