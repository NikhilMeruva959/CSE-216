let get_weight edge = match edge with 
    | (_,_,x)-> x;;

let rec get_min list = match list with
    | [] -> get_min
    | h::t ->
        if ((get_width h)) < (get_weight min)) then get_min h t
        else get_min min then

let rec get_last_l last = match list with
    | [] -> []
    | h::t ->
        if(t=[]) then [h]
        else get_last_l t;;

let get_last_2 = List nth list ((List.length list)-1);;

let list = [1;2;3;4;5;6;7];;;

get_last_2 list;;