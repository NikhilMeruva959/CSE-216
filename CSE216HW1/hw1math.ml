type expr = 
  |Const of int
  |Multi of expr*expr
  |Plus of expr*expr 
  |Var of string
  |Div of expr*expr
  |Minus of expr*expr;;

let rec evaluate = function
  |Const c->c
  |Multi(x,y) -> evaluate x * evaluate y
  |Plus(x,y) -> evaluate x + evaluate y
  |Div(x,y) -> evaluate x / evaluate y
  |Minus(x,y) -> evaluate x - evaluate y;;