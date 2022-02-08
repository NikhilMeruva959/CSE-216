type 'a binary_tree =
  | Empty
  | Node of 'a * 'a binary_tree * 'a binary_tree;;

let rec num_of_leaves tree = match tree with
  |Empty-> 0
  |Node(_, Empty, Empty) -> 1
  |Node(_,left,right) -> (num_of_leaves left) + (num_of_leaves right);;

let tree = Node("a", Node("b", Node("f", Empty, Empty),Empty), Node("c", Node("d", Empty, Empty), Empty));;

num_of_leaves tree;;

let rec get_all_leaves tree = match tree with
  |Empty -> [] 
  |Node (x, Empty, Empty) -> [x]
  |Node (_,left,right) -> (get_all_leaves left)@(get_all_leaves right);;


get_all_leaves tree;;
