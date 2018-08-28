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

(deftest can-randomly-generate-with-life
  (testing "the grid will have at least one alive cell"
    (is (map #(contains? % :alive) (generate-seed 4)))))
