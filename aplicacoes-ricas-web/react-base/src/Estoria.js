import React, { Component } from 'react';

class Estoria extends Component {
    constructor() {
      super();

      this.state = {
        exibirEstoria: false
      }
    }

    _handleClick(event) {
      event.preventDefault();

      this.setState({
        exibirEstoria: !this.state.exibirEstoria
      });
    }

    render() {
        let descricao;
        let textoBotao = "Exibir estória";

        if (this.state.exibirEstoria) {
          descricao = <p>{this.props.descricao}<span className="badge white">{this.props.pontos}</span></p>;
          textoBotao = "Ocultar estória";
        }

        return (
        <div>
          <div className="row">
            <div className="col s12 m12">
              <div className="card indigo darken-3">
                <div className="card-content white-text"> 
                  <span className="card-title">{this.props.titulo}</span>
                  {descricao}
                </div>
                <div className="card-action">
                  <a className="right" href="#" onClick={this._handleClick.bind(this)}>
                      {textoBotao}
                  </a>
                  <br/>
                </div>
              </div>
            </div>
          </div>
        </div>
        );
    }//fim do render
}
export default Estoria;

