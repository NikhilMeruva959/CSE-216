  let rec pow x n = 
    if n<1 then 1 
    else x * pow x (n-1);;
  
  let rec float_pow x n =
    if n<1.0 then 1.0
    else x *. float_pow x (n -. 1.0);;
    
  let rec compress = function
    | a :: (b :: _ as t) -> if a = b then compress t else a :: compress t
    | smaller -> smaller;;
    
  let rec remove_if x y = match x with
    |[]->[]
    |h::t -> if(y h) = true then remove_if t y 
        else h::remove_if t y;;
                 
  let slice list x y = 
    let rec get n = function 
      |[]->[]
      |h::t -> if x>y then [] else if n=0 then [] else h::get (n-1)t
    in
    let rec remove n = function 
      |[]->[]
      |h::t as i -> if n=0 then i else remove (n-1)t
    in 
    get(y-x)(remove x list);;

  
  let rec equivsHelper func list = match list with
    |[]->[]
    |h::t -> if (func h) then h::(equivsHelper func t)
        else(equivsHelper func t);;
  
  let rec listCompare list1 list2 = match list1 with
    |[]->list2
    |h::t-> let x = (remove_if list2((=)h)) in (listCompare t x);;
  
  let rec equivs func list = match list with
    |[]->[[]]
    |h::t -> let x = (equivsHelper (func h) list) in
        let y=(listCompare x t) in
        match y with
        |[]->[x]
        |h::t -> x::(equivs func y);;
  
  let primeCheck input = 
    let input = max input (-input) in
    let rec divideCheck div =
      div*div > input || (input mod div <> 0 && divideCheck (div +1)) in
    divideCheck 2;;
  
  let rec possiblePrimeNumbers num1 num2 = 
    if num1 > num2 then [] else
      let remainder = possiblePrimeNumbers (num1 +1) num2 in
      if primeCheck num1 then num1::remainder else remainder;;
  
  let goldbachpair mainInput = 
    let rec aux x = 
      if primeCheck x && primeCheck(mainInput - x) then (x, mainInput-x)
      else aux(x+1) in aux 2;;
    
  let rec equiv_on f g lst = match lst with
    |[]->true
    |h::t->if(f h)=(g h) then equiv_on f g t else false;;
  
  let rec pairwisefilter cmp given_list = 
    match given_list with
    |[]->[] 
    |h::snd::t->let new_tail = pairwisefilter cmp t in
        (cmp h snd)::new_tail
    |h::[]->[h];;
    
  let rec polynomial a = fun n ->
    match a with
    |[]->0
    |(b,c)::tail->let remaining = polynomial tail in
        let x =(float_of_int n)**(float_of_int c)|>int_of_float in
        (b*x)+(remaining n);;
  
let rec powerSetHelper fn list = match list with
  |[]->[]
  |h::t->(fn h)::(powerSetHelper fn t);;
let rec powerset = function
  |[]->[[]]
  |h::t-> 
      let finalList = powerset t in
      finalList @ powerSetHelper(fun s ->h::s)finalList;;