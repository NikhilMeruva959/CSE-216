type ('a, 'b) tree = 
    |Leaf of 'a
    |Tree of ('a, 'b) node
and
    ('a, 'b) node = (operator : 'b; left: ('a,'b) tree; right: ('a, 'b) tree);;

let rec node_and_leaves james = match james with
    |Leaf x -> ([],[x])
    |Tree {operator = o;left = 1;right = r;} ->
        let (left_nodes, left_leaves) = node_and_leaves 1 and (right_nodes, right_leaves) = node_and_leaves r in (o::(left_nodes@right_nodes), left_leaves @ right_leaves);;

let temp = Tree {operator = "*"; left = Leaf 4; right = Tree {operator = "+"; left = Leaf 9; right = Leaf 2}};;
