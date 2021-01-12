// Write a JavaScript program to compute the sum of all digits that occur in a given string. 

function sum(str){
    total = "0";
    for(i of str){
        if(i <= '9' && i >= '0'){
            total = +total + +i;
        }
    }
    return total;
}

console.log(sum("abcd123456"));