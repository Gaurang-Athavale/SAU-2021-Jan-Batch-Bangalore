class student {
    constructor(fname, lname, age, email, branch, gender, roll, occupation) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.email = email;
        this.branch = branch;
        this.gender = gender;
        this.roll = roll;
        this.occupation = occupation;
    }
}

function displayOutputDetails(obj) {
    // console.log(obj);
    // console.log(obj.fname);

    document.getElementById("fname_Output").innerHTML = (obj.fname);
    document.getElementById("lname_Output").innerHTML = (obj.lname);
    document.getElementById("age_Output").innerHTML = (obj.age);
    document.getElementById("email_Output").innerHTML = (obj.email);
    document.getElementById("gender_Output").innerHTML = (obj.gender);
    document.getElementById("roll_Output").innerHTML = (obj.roll);
    document.getElementById("branch_Output").innerHTML = (obj.branch);
    document.getElementById("occupation_Output").innerHTML = (obj.occupation);
}

function verify(fname, lname, age, email, branch, gender, roll, occupation) {
    // event.preventDefault();
    if(fname === "" || lname === "" || age === "" || email === "" || branch === "" || gender === "" || roll === "" || occupation === ""){
        alert("Please fill up all the details as all are mandatory!!");
        return false;
    }

    if(!/[a-zA-Z0-9]+@[a-zA-Z]+.[com|edu]/.test(email)){
        alert("Please enter the correct Email Address!!");
        return false;
    }

    return true;
}

function validate(event){
    // event.preventDefault()
    // console.log("weguywegifg")
    document.getElementById("printDetails").style.display = "inline-block";

    fname = document.getElementById('Fname').value;
    lname = document.getElementById('Lname').value;
    email = document.getElementById('email').value
    age = document.getElementById('age').value
    roll = document.getElementById('roll').value;
    // gender = "male";
    branch = document.getElementById('branch').value;
    

    for (i = 0; i < document.getElementsByName('gender').length; i++) {
        if (document.getElementsByName('gender')[i].checked) {
            gender = document.getElementsByName('gender')[i].value;
            break;
        }
    }

    occupation = document.getElementById("Occupation").value;
    // console.log("weguywegifg")

    // console.log("weguywegifg")
    let verification = verify(fname, lname, age, email, branch, gender, roll, occupation);
  
    if(verification === true)
        var obj = new student(fname, lname, age, email, branch, gender, roll, occupation);

    displayOutputDetails(obj);

}

function add_Occupation(event) {
    event.preventDefault();
    var occupation = (() => {
        document.getElementById("Occupation").style.display = "inline-block";
        document.getElementById("Occupation_input").style.display = "inline-block";
        document.getElementById("finalizeDetails").style.display = "inline-block";
    })();
}

