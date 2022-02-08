

let f list = 
  let rec aux acc = function
    |[]->acc
    |h::t->aux (h::acc) t
  in aux [] list;;

let rec remove_nth list n = function
  |[]->[]
  |h::t-> if n = 0 then t else h::(remove_nth t (n-1));;

let rec getLast list = function
  |[]->[]
  |h::t->if t=[] then [h;] else getLast t;;


let getVal x = function
  |(_,_,x) ->x;;

let minWeight list =
  let rec aux min list = function
    |[]->min
    |h::t-> if (getVal min) > (getVal h) then aux h min else aux min t
  in aux List.hd list;;

type ('a,'b) tree =
  |Leaf of 'a
  |Tree of ('a,'b) node
and 
  ('a,'b) node ={
  operator: 'b;
  left: ('a,'b) tree;
  right: ('a,'b) tree;
};;

let rec nodeLeaves = function
  |Leaf x -> {[],[x]}
  |Tree {operator y; left = i; right = j}->
      let (leftNode, leftLeaves) = (nodeLeaves i) and (rightNode, rightLeaves) (= nodeLeaves j) 
      in (y::leftNode @ rightNode, leftLeaves @ rightLeaves);;

let rec numLeaves = function
  |Empty->0
  |Node(_,Empty,Empty)-> 1
  |Node(_,x,y)->numLeaves x + numLeaves y;;
let getAll list =
  let rec aux t acc =function
    |Empty->acc
    |Node(x,Empty,Empty)-> x::acc
    |Node(x,l,r)->aux l (aux r acc)
  in
  aux list [];;
  
let rec sum list = function
  |[]->0
  |h::t->h+sum t;;

let rec sum acc s list = function
  |[]->s
  |h::t-> acc (x+s) t;;

let sum lst = acc 0 lst;;

let rec succes x = function
  |[]->[]
  |(i,j)::t->if i = x then j::succes x t else succes x t;;
         
         





