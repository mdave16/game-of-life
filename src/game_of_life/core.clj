(ns game-of-life.core)

(defn generate-grid
  "Generates a grid of size squared"
  [size]
  (repeat size (repeat size :empty)))
