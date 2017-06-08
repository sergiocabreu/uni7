import React, { Component } from 'react';
import Topo from './Topo';
import Rodape from './Rodape';
import Estoria from './Estoria';
import EstoriaForm from './EstoriaForm.js'
import jQuery from 'jquery';

class TaskBoard extends Component {

    constructor() {
        super();

        this.state = {
            estorias : [
            ]
        }
    }

    render() {
        const estorias = this._getEstorias();
        const titulo = this._getTitulo(estorias.length);

        return (
        <div>
            <div className="section no-pad-bot" id="index-banner">
                <div className="container">
                    <h1 className="header center orange-text">Estórias</h1>
                    <h3>{titulo}</h3>            
                    {estorias}
                </div>
            </div>
            <EstoriaForm adicionarEstoria={this._adicionarEstoria.bind(this)}/>
        </div>
        );
    }//fim do render


    componentWillMount() {
        this._buscarEstorias();
    }

    _buscarEstorias() {
        jQuery.ajax({
            method: 'GET',
            url: 'http://10.54.1.13:3001/estorias',
            success: (estorias) => {
                this.setState({estorias})
            }
        });
    }

    _adicionarEstoria(titulo, pontos, descricao) {
        const estoria = {
            titulo,
            pontos,
            descricao,
            id: this.state.estorias.length + 1
        };

        this.setState({
            estorias: this.state.estorias.concat([estoria])
        });
    }

    _getEstorias() {
        return this.state.estorias.map( estoria => 

            <Estoria 
                titulo={estoria.titulo}
                descricao={estoria.descricao}
                pontos={estoria.pontos}
                key={estoria.id}
                />
        );
    }

    _getTitulo(totalDeEstorias) {
        if (totalDeEstorias === 0 ) {
            return "Sem Estórias cadastradas.";
        } else if (totalDeEstorias === 1) {
            return "1 estórias";
        } else {
        return `${totalDeEstorias} estórias`;
        }
    }

}
export default TaskBoard;

