(ns game-of-life.core)

(defn generate-grid
  "Generates a grid of size squared"
  [size]
  (repeat size (repeat size :empty)))

(defn generate-seed
  "Generates a grid with some cells alive"
  [size]
  (let [grid (generate-grid size)]
    (for [row grid cell row]
      (if ( = (rand-int 7) 0) :alive :empty))))
