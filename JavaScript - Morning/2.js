// 2.Write a JavaScript program to change the capitalization (case) of all letters in a given string. 

function change_case(str){
    let answer = ""
    for(let i of str){
        if(i<='z' && i>='a'){
            answer += i.toUpperCase();
        }
        else if(i<='Z' && i>='A'){
            answer += i.toLowerCase();
        }
        else{
            answer += i;
        }
    }
    return answer;
}

console.log(change_case("QwErTy12"));