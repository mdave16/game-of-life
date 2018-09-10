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



(defn swap-cell
  [cell]
  (if (= cell :empty)
    :alive
    :empty))

(defn swap-row
  [row]
  (mapv swap-cell row))

(defn count-alive-neighbors
  [neighbors]
  (count (filter #(= :alive %) neighbors)))

(defn update-cell
  "Takes a cell and its neighbors, and returns the updated state of the cell"
  [cell neighbors]
  (if (> 2 (count-alive-neighbors neighbors))
    :alive
    :empty))

(defn get-neighbors
  "Gets the list of neighbors"
  [board row-index col-index]
  (remove nil?
    [(nth (nth board (- row-index 1) []) (- col-index 1) nil)
     (nth (nth board row-index []) (- col-index 1) nil)
     (nth (nth board (+ row-index 1) []) (- col-index 1) nil)
     (nth (nth board (- row-index 1) []) col-index nil)
     (nth (nth board (+ row-index 1) []) col-index nil)
     (nth (nth board (- row-index 1) []) (+ col-index 1) nil)
     (nth (nth board row-index []) (+ col-index 1) nil)
     (nth (nth board (+ row-index 1) []) (+ col-index 1) nil)]))

(defn update-grid
  "Applies the rules of life"
  [grid]
  (as-> grid $$
    (mapv swap-row $$)
    ())
  )
