import React, { Component } from 'react';
import Topo from './Topo';
import Rodape from './Rodape';
import Estoria from './Estoria';

class Taskboard extends Component {
    render() {
        const estorias = this._getEstorias();

        return (
        <div>
            <Topo/>
            <div className="section no-pad-bot" id="index-banner">
                <div className="container">
                    <h1 className="header center orange-text">Estórias</h1>
                    <h3>2 estórias</h3>            
                    {estorias}
                </div>
            </div>            
            <Rodape/>
        </div>
        );
    }//fim do render

    _getEstorias() {
        const estorias = [
            {id: 1, titulo: 'Contratar Seguro', descricao: 'Como usuario...', pontos: 10},
            {id: 2, titulo: 'Cancelar Seguro', descricao: 'Como usuario...', pontos: 30},
            {id: 3, titulo: 'Cancelar Seguro', descricao: 'Como usuario...', pontos: 40},
        ];

        return estorias.map(estoria => 
            <Estoria 
                titulo={estoria.titulo}
                descricao={estoria.descricao}
                pontos={estoria.pontos}
                key={estoria.id}
                />);
    }
}
export default Taskboard;

