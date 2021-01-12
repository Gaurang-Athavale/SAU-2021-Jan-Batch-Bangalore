// 3.Write a JavaScript program to check whether all the digits in a given number are the same or not.

function same_digits(n){
    if(n < 10){
        return true;
    }
    else if(n < 100){
        if(n%10 === (Math.floor(n/10))%10)
            return true;
        else
            return false;
    }
    else{
        flag = true;

        while(n>9){
            if(n%10 !== (Math.floor(n/10))%10){
                flag = false;
                break;
            }
            n = Math.floor(n/10);
        }
        
        return flag;
    }
}

console.log(55556);
console.log(same_digits(55556));