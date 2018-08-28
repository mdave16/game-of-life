(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(deftest generates-a-grid-test
  (testing "generates a grid with 4x4 cells"
    (is (= [[:empty :empty :empty :empty ]
            [:empty :empty :empty :empty ]
            [:empty :empty :empty :empty ]
            [:empty :empty :empty :empty ]
            ]
            (generate-grid 4)))))
