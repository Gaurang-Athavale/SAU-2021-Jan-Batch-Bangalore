import React, { Component } from 'react';

export class ShowAllTodo extends Component {
    constructor() {
        super();
        this.state = {
            allTodo: JSON.parse(localStorage.getItem("item"))
        }
        var Date_sort = this.state.allTodo.slice(0);
        console.log(Date_sort);
        Date_sort.sort(function (todo1, todo2) {
            return todo1.todo.date.toLowerCase() < todo2.todo.date.toLowerCase() ? -1 : todo1.todo.date.toLowerCase() > todo2.todo.date.toLowerCase() ? 1 : 0;
        })
        this.state.allTodo = Date_sort;
        // console.log(Date_sort);
    }

    addNewToDo = () => {
        this.props.history.push('/add-todo');
    }

    deleteToDo = (id) => {
        let lists = this.state.allTodo;
        var Date_sort = lists.slice(0);
        Date_sort.sort(function (todo1, todo2) {
            return todo1.todo.date.toLowerCase() < todo2.todo.date.toLowerCase() ? -1 : todo1.todo.date.toLowerCase() > todo2.todo.date.toLowerCase() ? 1 : 0;
        })

        lists = Date_sort.slice(0);
        lists.splice(id, 1); //To Remove the todo
        localStorage.setItem("item", JSON.stringify(lists));
        this.setState({ allTodo: lists });
    }

    render() {
        return (
            <div style={{textAlign: "center"}}>
                {
                    this.state.allTodo === null || this.state.allTodo.length === 0 ? <h1>Woohoo! Your ToDo List is Empty :)</h1> : this.state.allTodo.map((individualToDo, ToDoId) => {
                            return (
                                    <div style={{textAlign: "center"}}>
                                        <h3>Title: {individualToDo.todo.title}</h3> 
                                        <div>
                                            <span><b>Description:</b> {individualToDo.todo.description}</span><br></br>
                                            <span><b>Due Date:</b> {individualToDo.todo.date}</span>
                                            <br></br>
                                            <button style={{ backgroundColor: "red", cursor: "pointer", color: "white" }} onClick={() => { this.deleteToDo(ToDoId) }}>Delete</button>

                                            <hr></hr>
                                        </div>
                                    </div>
                            )
                        })
                }
                <button onClick={this.addNewToDo} style={{backgroundColor: "green", color: "white", cursor: "pointer"}}>Add a ToDo</button>
            </div>
        )
    }
}