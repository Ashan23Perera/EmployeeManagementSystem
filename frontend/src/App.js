import './App.css';
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Header from './components/Header';
import ListEmployee from './components/ListEmployee';
import AddEmployee from './components/AddEmployee';

function App() {
  return (
    <div>
      <Router>
        <Header/>
        <div className= "container">
          <Switch>
              <Route exact path = "/" component = {ListEmployee}></Route>
              <Route path = "/employees" component = {ListEmployee}></Route>
              <Route path = "/add-employee" component = {AddEmployee} ></Route>
              <Route path = "/edit-employee/:id" component = {AddEmployee}></Route>
            </Switch>
        </div>
        </Router>
    </div>
  );
}

export default App;
