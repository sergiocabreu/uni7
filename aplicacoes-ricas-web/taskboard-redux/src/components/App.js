import React, { Component } from 'react';
import Topo from './common/Topo';
import Taskboard from './taskboard/Taskboard';
import Rodape from './common/Rodape';
import { Switch, Route } from 'react-router-dom';
import AboutPage from './about/AboutPage';
import DevsPage from './devs/DevsPage';

class App extends Component {
  render() {
    return (
      <div>
        <Topo />
        <Switch>
          <Route exact path='/' component={Taskboard}/>
          <Route path='/about' component={AboutPage}/>
          <Route path='/devs' component={DevsPage}/>
        </Switch>
        <Rodape />
    </div>
    );

  }

}

export default App;
