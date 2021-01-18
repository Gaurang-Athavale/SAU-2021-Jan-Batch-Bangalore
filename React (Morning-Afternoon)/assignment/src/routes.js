import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import React from 'react';
import { ShowAllTodo } from './Show_all_todo/showAllTodo';
import { Todo } from './Todo/todo';
const Routes = () => {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={ShowAllTodo} />
                <Route path="/add-todo" component={Todo} />
            </Switch>
        </Router>
    );
}

export default Routes;