// 1.Write a JavaScript program to find all distinct prime factors of a given integer.

function prime_factors(n){
    factors = [];
    for(let i = 2; i <= Math.floor(n/2); i++){
        if(n % i === 0){
            factors.push(i);
        }    
    }
    factors.push(n);
    // console.log(factors);
    answer = [];
    for(let i of factors){
        let flag = true;
        for(let j = 2; j<=Math.floor(Math.sqrt(i)); j++){
            if(i % j === 0){
                flag = false;
                break;
            }
        }
        if(flag === true){
            answer.push(i);
        }
    }

    // console.log(answer);
    return answer;
}

console.log(prime_factors(7235));