import {Component, React} from 'react';

export class Todo extends Component{
    constructor() {
        super();
        this.state = {
            title:"",
            description:"",
            date:""
        }
    }

    setTitle = (event) => {
        this.setState({title: event.target.value});
    }

    setDescription = (event) => {
        this.setState({description: event.target.value});
    }

    setDate = (event) => {
        this.setState({date: event.target.value});
    }

    submit = (event) => {
        event.preventDefault();
        let toDoList = JSON.parse(localStorage.getItem("item"));
        if (toDoList === null) {
            toDoList = [{
                id: 0,
                todo: this.state,
            }]
        }
        else {
            if (this.state.title!=="" && this.state.description!=="" && this.state.date!==""){
            toDoList.push({
                id: toDoList.length,
                todo: this.state,
            })
            localStorage.setItem("item", JSON.stringify(toDoList));
            this.goBackToMainPage();
            } else {
                alert('Please fill up all fields!');
            }
        }        
    }

    goBackToMainPage = () => {
        this.props.history.goBack();
    }

    render(){
    return(
        <div style={{textAlign: "center"}}>
            <h1>Add a ToDo</h1>
            <form onSubmit={this.submit}>
            <label><b>Add the ToDo title</b></label><br></br>
            <input type="text" placeholder="Add the title" onChange = {this.setTitle}></input><br></br><br></br>
            <label><b>Decribe your task</b></label><br></br>
            <input type="text" placeholder="Add the description" onChange = {this.setDescription}></input><br></br><br></br>
            <label><b>Date</b></label><br></br>
            <input type="date" placeholder="Add the date" onChange = {this.setDate}></input><br></br><br></br>
            <button type="submit" style={{backgroundColor: "green", color: "white", cursor: "pointer"}}>Add a ToDo</button>
            </form>
            <button onClick={this.goBackToMainPage} style={{backgroundColor: "yellow", color: "black", cursor: "pointer"}}>Go Back</button>

        </div>
    );
}
}
