import React, { Component } from 'react';
import Topo from './Topo';
import Rodape from './Rodape';
import Estoria from './Estoria';
import Taskboard from './TaskBoard';

class App extends Component {
    render() {
        return (
            <div>
                <Topo/>
                <Taskboard/>
                <Rodape/>
            </div>
        );
    }//fim do render
}
export default App;

