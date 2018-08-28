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

(deftest update-grid-test
  (testing "Apply the rules of life"
    (let [initial-grid [[:empty :empty]
                        [:alive :alive]]
          modified-grid (update-grid initial-grid)]
      (is (= modified-grid [[:alive :alive]
                            [:empty :empty]])))))
