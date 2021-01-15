
class input {
    constructor(param) {
        this.input = param;
        if(this.input === ""){
            alert("Input field Empty");
        }
    }

    calculateLength() {
        return this.input.length;
    };

    getUpperCase() {
        return this.input.toUpperCase();
    };

    getLowerCase() {
        return this.input.toLowerCase();
    };

    seperateVowels() {
        let vowels = "";
        let consonants = "";
        for(let letter of this.input){
            if(/[aeiouAEIOU]/.test(letter)) {
                vowels += letter;
            } else if(/[a-zA-z]/.test(letter)) {
                consonants += letter;
            }
        }
        return `Vowels: ${vowels} <br> Consonants: ${consonants}`;
    };

    isNumber() {
        let error = false;
        for (let letter of this.input) {
            if(letter<="9" && letter>=0){
                error = true;
                break;
            }
        }

        if(error){
            alert('Error: There is a number in the input');
            return "Yes, there is a number in the input";
        } else {
            return "No, there is no number in the input";

        }
    }

}

function callFunction() {
    var inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    document.getElementById("lengthOp").innerHTML = inputObject.calculateLength();
    document.getElementById("ucOp").innerHTML = inputObject.getUpperCase();
    document.getElementById("lcOp").innerHTML = inputObject.getLowerCase();
    document.getElementById("V-C").innerHTML = inputObject.seperateVowels();
    document.getElementById("number_error").innerHTML = inputObject.isNumber();
}